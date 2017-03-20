package com.ycw.photosystem.service;

import com.ycw.photosystem.bean.mysql.Picture;
import com.ycw.photosystem.dao.mysql.*;
import com.ycw.photosystem.tool.WaterMark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@Service
@Transactional
public class PictureService {

    @Autowired
    private DepartmentDAO departmentDAO;
    @Autowired
    private CategoryDAO categoryDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private PictureDAO pictureDAO;
    @Autowired
    private SupportDAO supportDAO;


    private static final String CHECK_DIC = "/checkpicture/";
    private static final String PATH_DIC = "/picture/";
    private static final String WATERMARK_PATH_DIC = "/watermarkpicture/";


    /*上传到待审核库*/
    public boolean addPic(Map<String, MultipartFile> fileMap, Map<String, String[]> parameterMap) throws IOException {
        if (parameterMap.get("department").length == 0) {
            return false;
        }
        MultipartFile file = fileMap.get("picture");
        //上传文件，名字为原名称
        try {
            BufferedImage image = ImageIO.read(file.getInputStream());
            Picture picture = new Picture();
            Set<Entry<String, String[]>> set = parameterMap.entrySet();
            for (Entry<String, String[]> parameter : set) {
                parameterSetter(picture, parameter.getKey(), parameter.getValue());
            }
            picture.setName(file.getOriginalFilename());//图片名
            picture.setCreateTime(new Timestamp(System.currentTimeMillis()));//创建时间
            picture.setHeight(image.getHeight());//图片高度
            picture.setWidth(image.getWidth());//图片宽度
            picture.setDownloadCount(0);//下载量
            picture.setVisitCount(0);//访问数
            picture.setStatus((short) 1);//审核状态
            File saveFile = uploadPicFile(file);//上传图片文件
            if (saveFile == null) {
                return false;
            }
            pictureDAO.save(picture);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    /*审核图片*/
    public boolean checkPic(Picture picture, boolean approved) {

        if (approved == true) {
            String fileNumber = generateFileNumber(picture.getPictureDepartment());//生成档案号
            String extension = generateExtension(picture.getName());//生成扩展名
            String fileName = fileNumber + extension;//文件名=档案号+扩展名
            if (generatePicFile(picture, fileName) == true && generateWmPicFile(picture, fileName) == true) {
                picture.setName(fileName);
                picture.setStatus((short) 2);//审核状态
                pictureDAO.save(picture);
            }
        } else {

        }
        return true;
    }

    /*编辑图片*/
    public Picture updatePic(long id, String author, String decription, String keyPerson, String name, int categoryId, int department) {
        Picture picture = pictureDAO.findById(id);
        picture.setDescription(decription);
        picture.setKeyPerson(keyPerson);
        picture.setPictureDepartment(department);
        picture.setPictureCategory(categoryId);
        pictureDAO.update(picture);
        return picture;
    }

    /*删除图片*/
    public boolean deletePic(long id) {
        Picture picture = pictureDAO.findById(id);
        pictureDAO.delete(picture);
        return true;
    }

    private File uploadPicFile(MultipartFile file) {
        System.out.print(System.getProperty("user.dir"));
        File pictureDic = new File(CHECK_DIC);
        if (!pictureDic.exists() && !pictureDic.isDirectory()) {
            pictureDic.mkdir();
        }
        File saveFile = new File(pictureDic, file.getOriginalFilename());
        try {
            file.transferTo(saveFile);
            return saveFile;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    private String generateExtension(String fileName) {
        int pos = fileName.lastIndexOf(".");
        return fileName.substring(pos);
    }

    private String generateFileNumber(int departmentId) {
        Calendar c = Calendar.getInstance();
        int currentYear = c.get(Calendar.YEAR);
        int mysqlYear = supportDAO.getYear();
        int serialNumber = supportDAO.getSerialNumber();
        if (currentYear > mysqlYear) {
            supportDAO.updateYear(currentYear);
            supportDAO.updateSerialNumber(1);
        } else if (currentYear == mysqlYear) {
            supportDAO.updateSerialNumber(serialNumber + 1);
        } else {
            supportDAO.updateYear(currentYear);
        }
        serialNumber = supportDAO.getSerialNumber();
        return "ZP" + currentYear + "_" + departmentId + "_" + serialNumber;
    }

    private boolean generatePicFile(Picture picture, String fileName) {
        File oldFile = new File(CHECK_DIC + picture.getName());
        if (!oldFile.exists()) {
            return false;
        }
        File picDic = new File(PATH_DIC);
        if (!picDic.exists() && !picDic.isDirectory()) {
            picDic.mkdir();
        }
        File newFile = new File(PATH_DIC + fileName);
        if (newFile.exists()) {
            return false;
        } else {
            oldFile.renameTo(newFile);
            picture.setName(fileName);
            return true;
        }
    }

    private boolean generateWmPicFile(Picture picture, String fileName) {
        File wmPicDic = new File(WATERMARK_PATH_DIC);
        if (!wmPicDic.exists() && !wmPicDic.isDirectory()) {
            wmPicDic.mkdir();
        }
        File sourcePicFile = new File(PATH_DIC + picture.getName());
        File wmPicFile = new File(WATERMARK_PATH_DIC + picture.getName());
        try {
            Image image = ImageIO.read(sourcePicFile);
            BufferedImage bufferedImage = ImageIO.read(sourcePicFile);
            String format = "JPEG";
            WaterMark.printText(image, bufferedImage, "北邮档案", image.getWidth(null) / 4, image.getHeight(null) / 2);
            ImageIO.write(bufferedImage, format, wmPicFile);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private void parameterSetter(Picture picture, String key, String[] values) {
        if (values.length == 0) {
            return;
        }
        String value = values[0];
        if (StringUtils.isEmpty(value)) {
            return;
        }
        if (key.equals("department")) {
            picture.setPictureDepartment(Integer.valueOf(value));
        } else if (key.equals("category")) {
            picture.setPictureCategory(Integer.valueOf(value));
        } else if (key.equals("author")) {
            picture.setAuthor(value);
        } else if (key.equals("picLoader")) {
            picture.setPictureLoader(Integer.valueOf(value));
        } else if (key.equals("description")) {
            picture.setDescription(value);
        } else if (key.equals("keyPerson")) {
            picture.setKeyPerson(value);
        } else if (key.equals("photoDate")) {
            picture.setPhotoDate(Timestamp.valueOf(value));
        }
    }

}