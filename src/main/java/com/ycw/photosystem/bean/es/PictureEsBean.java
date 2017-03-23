package com.ycw.photosystem.bean.es;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class PictureEsBean {
    private Long id;
    private String name;
    private Timestamp createTime;
    private Timestamp photoDate;
    private String keyPerson;
    private String author;
    private String description;
    private String fileNumber;
    private String place;


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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
