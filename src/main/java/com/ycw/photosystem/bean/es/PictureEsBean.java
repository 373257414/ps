package com.ycw.photosystem.bean.es;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class PictureEsBean {
    private Long id;
    private String name;
    private Timestamp createTime;
    private Timestamp photoDate;
    private String pictureLoader;
    private String pictureDepartment;
    private String pictureCategory;
    private String keyPerson;
    private String author;
    private String description;
    private String fileNumber;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getPhotoDate() {
        return photoDate;
    }

    public void setPhotoDate(Timestamp photoDate) {
        this.photoDate = photoDate;
    }

    public String getPictureLoader() {
        return pictureLoader;
    }

    public void setPictureLoader(String pictureLoader) {
        this.pictureLoader = pictureLoader;
    }

    public String getPictureDepartment() {
        return pictureDepartment;
    }

    public void setPictureDepartment(String pictureDepartment) {
        this.pictureDepartment = pictureDepartment;
    }

    public String getPictureCategory() {
        return pictureCategory;
    }

    public void setPictureCategory(String pictureCategory) {
        this.pictureCategory = pictureCategory;
    }

    public String getKeyPerson() {
        return keyPerson;
    }

    public void setKeyPerson(String keyPerson) {
        this.keyPerson = keyPerson;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(String fileNumber) {
        this.fileNumber = fileNumber;
    }
}
