package com.ycw.photosystem.service;

import com.ycw.photosystem.bean.Picture;
import com.ycw.photosystem.dao.*;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;

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


    static final String PATH = "e:\\picture\\";
    static final String WARTEMARK_PATH = "e:\\picture_wm\\";


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

    private boolean uploadPic(String fileName, File file) {
        File saveFile = new File(PATH, fileName);
        File saveFlieWM = new File(WARTEMARK_PATH, fileName);
        try {
            FileUtils.copyFile(file, saveFile);
            FileUtils.copyFile(file, saveFlieWM);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public Picture addPic(BufferedImage file, String author, Timestamp createTime, String description, String keyPerson, int categoryId, int departmentId, int pictureLoader) {

        String name = file.getName();
        file.g
        String fileNumber = generateFileNumber(departmentId);//生成档案号
        String extension = generateExtension(name);//生成扩展名
        String fileName = fileNumber + extension;//文件名=档案号+扩展名
        boolean up = uploadPic(fileName, file);
        if (up == false) {
            return null;
        }
        Picture picture = new Picture();
        picture.setAuthor(author);
        picture.setCreateTime(createTime);
        picture.setDescription(description);
        picture.setDownloadCount(0);
        picture.setFileNumber(fileNumber);
        picture.setHeight(height);
        picture.setKeyPerson(keyPerson);
        picture.setName(name);
        picture.setPath(PATH + fileName);
        picture.setPictureCategory(categoryId);
        picture.setPictureDepartment(departmentId);
        picture.setPictureLoader(pictureLoader);
        picture.setVisitCount(0);
        picture.setWatermarkPath(WARTEMARK_PATH + fileName);
        picture.setWidth(width);
        pictureDAO.save(picture);
        return picture;
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