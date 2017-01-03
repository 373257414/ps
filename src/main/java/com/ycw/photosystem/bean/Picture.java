package com.ycw.photosystem.bean;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
public class Picture {
    private int id;
    private String name;
    private Timestamp createTime;
    private String path;
    private String watermarkPath;
    private Integer pictureLoader;
    private Integer pictureDepartment;
    private Integer pictureCategory;
    private Integer height;
    private Integer width;
    private String keyPerson;
    private String author;
    private String description;
    private Integer visitCount;
    private Integer downloadCount;
    private String fileNumber;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "create_time", nullable = true)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Column(name = "path", nullable = true, length = 255)
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Column(name = "watermark_path", nullable = true, length = 255)
    public String getWatermarkPath() {
        return watermarkPath;
    }

    public void setWatermarkPath(String watermarkPath) {
        this.watermarkPath = watermarkPath;
    }

    @Column(name = "picture_loader", nullable = true)
    public Integer getPictureLoader() {
        return pictureLoader;
    }

    public void setPictureLoader(Integer pictureLoader) {
        this.pictureLoader = pictureLoader;
    }

    @Column(name = "picture_department", nullable = true)
    public Integer getPictureDepartment() {
        return pictureDepartment;
    }

    public void setPictureDepartment(Integer pictureDepartment) {
        this.pictureDepartment = pictureDepartment;
    }

    @Column(name = "picture_category", nullable = true)
    public Integer getPictureCategory() {
        return pictureCategory;
    }

    public void setPictureCategory(Integer pictureCategory) {
        this.pictureCategory = pictureCategory;
    }

    @Column(name = "height", nullable = true)
    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Column(name = "width", nullable = true)
    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    @Column(name = "key_person", nullable = true, length = 45)
    public String getKeyPerson() {
        return keyPerson;
    }

    public void setKeyPerson(String keyPerson) {
        this.keyPerson = keyPerson;
    }

    @Column(name = "author", nullable = true, length = 45)
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Column(name = "description", nullable = true, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "visit_count", nullable = true)
    public Integer getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(Integer visitCount) {
        this.visitCount = visitCount;
    }

    @Column(name = "download_count", nullable = true)
    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }

    @Column(name = "file_number", nullable = true, length = 45)
    public String getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(String fileNumber) {
        this.fileNumber = fileNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Picture picture = (Picture) o;

        if (id != picture.id) return false;
        if (name != null ? !name.equals(picture.name) : picture.name != null) return false;
        if (createTime != null ? !createTime.equals(picture.createTime) : picture.createTime != null) return false;
        if (path != null ? !path.equals(picture.path) : picture.path != null) return false;
        if (watermarkPath != null ? !watermarkPath.equals(picture.watermarkPath) : picture.watermarkPath != null)
            return false;
        if (pictureLoader != null ? !pictureLoader.equals(picture.pictureLoader) : picture.pictureLoader != null)
            return false;
        if (pictureDepartment != null ? !pictureDepartment.equals(picture.pictureDepartment) : picture.pictureDepartment != null)
            return false;
        if (pictureCategory != null ? !pictureCategory.equals(picture.pictureCategory) : picture.pictureCategory != null)
            return false;
        if (height != null ? !height.equals(picture.height) : picture.height != null) return false;
        if (width != null ? !width.equals(picture.width) : picture.width != null) return false;
        if (keyPerson != null ? !keyPerson.equals(picture.keyPerson) : picture.keyPerson != null) return false;
        if (author != null ? !author.equals(picture.author) : picture.author != null) return false;
        if (description != null ? !description.equals(picture.description) : picture.description != null) return false;
        if (visitCount != null ? !visitCount.equals(picture.visitCount) : picture.visitCount != null) return false;
        if (downloadCount != null ? !downloadCount.equals(picture.downloadCount) : picture.downloadCount != null)
            return false;
        if (fileNumber != null ? !fileNumber.equals(picture.fileNumber) : picture.fileNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (path != null ? path.hashCode() : 0);
        result = 31 * result + (watermarkPath != null ? watermarkPath.hashCode() : 0);
        result = 31 * result + (pictureLoader != null ? pictureLoader.hashCode() : 0);
        result = 31 * result + (pictureDepartment != null ? pictureDepartment.hashCode() : 0);
        result = 31 * result + (pictureCategory != null ? pictureCategory.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (width != null ? width.hashCode() : 0);
        result = 31 * result + (keyPerson != null ? keyPerson.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (visitCount != null ? visitCount.hashCode() : 0);
        result = 31 * result + (downloadCount != null ? downloadCount.hashCode() : 0);
        result = 31 * result + (fileNumber != null ? fileNumber.hashCode() : 0);
        return result;
    }
}
