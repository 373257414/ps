package com.ycw.photosystem.service;

import com.ycw.photosystem.bean.Picture;
import com.ycw.photosystem.dao.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@Service
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

    private static final Logger log = LoggerFactory.getLogger(PictureService.class);


    private static final String DEPARTMENT = "departmentId";
    private static final String CATEGORY = "categoryId";
    private static final String AUTHOR = "author";
    private static final String DESCRIPTION = "description";
    private static final String KEY_PERSON = "keyPerson";
    private static final String PIC_LOADER = "picLoader";
    private static final Integer VISIT_COUNT = 0;
    private static final Integer DOWNLOADD_COUNT = 0;
    private static final String FILE_NUMBER = "fileNumber";
    private static final Integer HEIGHT = 0;
    private static final Integer WIDTH = 0;
    private static final String PATH = "e:\\picture\\";
    private static final String WARTEMARK_PATH = "e:\\picture_wm\\";


    public String generateExtension(String fileName) {
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


    private boolean uploadPic(String fileName, MultipartFile file) {
        File saveFile = new File(PATH, fileName);
        File saveFlieWM = new File(WARTEMARK_PATH, fileName);
        try {
            file.transferTo(saveFile);
            file.transferTo(saveFlieWM);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private void parameterSetter(Picture picture, String key, String[] values) {
        if (values.length==0){
            return;
        }
        String value = values[0];
        if (key.equals(DEPARTMENT)) {
            picture.setPictureDepartment(Integer.valueOf(value));
        } else if (key.equals(CATEGORY)){
            picture.setPictureCategory(Integer.valueOf(value));
        }else if (key.equals(AUTHOR)){
            picture.setAuthor(value);
        }else if (key.equals(PIC_LOADER)){
            picture.setPictureLoader(Integer.valueOf(value));
        }else if (key.equals(DESCRIPTION)){
            picture.setDescription(value);
        }
    }

    public boolean addPic(Map<String, MultipartFile> fileMap, Map<String, String[]> parameterMap) throws IOException {
        if (parameterMap.get("departmentId").length == 0) {
            return false;
        }
        Integer departmentId = Integer.valueOf(parameterMap.get("departmentId")[0]);
        MultipartFile file = fileMap.get("file");
        String name = file.getOriginalFilename();
        String fileNumber = generateFileNumber(departmentId);//生成档案号
        String extension = generateExtension(name);//生成扩展名
        String fileName = fileNumber + extension;//文件名=档案号+扩展名
        BufferedImage image = ImageIO.read(file.getInputStream());
        boolean up = uploadPic(fileName, file);
        if (up == false) {
            return false;
        }

        try {
            Picture picture = new Picture();
            Set<Entry<String, String[]>> set =parameterMap.entrySet();
            for (Entry<String,String[]> parameter:set){
                parameterSetter(picture,parameter.getKey(),parameter.getValue());
            }
            picture.setCreateTime(new Timestamp(System.currentTimeMillis()));//创建时间
            picture.setDownloadCount(0);//下载量
            picture.setFileNumber(fileNumber);//档案号
            picture.setHeight(image.getHeight());//图片高度
            picture.setName(name);//图片名
            picture.setPath(PATH + fileName);//图片路径
            picture.setPictureDepartment(departmentId);//图片部门
            picture.setVisitCount(0);//访问数
            picture.setWatermarkPath(WARTEMARK_PATH + fileName);//水印图片路径
            picture.setWidth(image.getWidth());//图片宽度
            pictureDAO.save(picture);
            log.info("添加图片成功，档案号：" + fileNumber);
            return true;
        } catch (Exception e) {
            log.info("添加图片错误:" + e);
            return false;
        }
    }


    public boolean deletePic(int id) {
        Picture picture = pictureDAO.findById(id);
        pictureDAO.delete(picture);
        return true;
    }

    public Picture updatePic(int id, String author, String decription, String keyPerson, String name, int categoryId, int departmentId) {
        Picture picture = pictureDAO.findById(id);
        picture.setDescription(decription);
        picture.setKeyPerson(keyPerson);
        picture.setPictureDepartment(departmentId);
        picture.setPictureCategory(categoryId);
        pictureDAO.update(picture);
        return picture;
    }
}