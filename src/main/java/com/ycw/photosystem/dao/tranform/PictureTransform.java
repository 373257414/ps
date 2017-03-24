package com.ycw.photosystem.dao.tranform;

import com.ycw.photosystem.bean.es.PictureEsBean;
import com.ycw.photosystem.bean.mysql.Picture;
import org.springframework.stereotype.Component;

@Component
public class PictureTransform {

    public PictureEsBean transform(Picture picture) {
        PictureEsBean bean = new PictureEsBean();
        bean.setId(picture.getId());
        bean.setName(picture.getName());
        bean.setCreateTime(picture.getCreateTime());
        bean.setPhotoDate(picture.getPhotoDate());
        bean.setKeyPerson(picture.getKeyPerson());
        bean.setAuthor(picture.getAuthor());
        bean.setDescription(picture.getDescription());
        bean.setFileNumber(picture.getFileNumber());
        bean.setPlace(picture.getPlace());
        return bean;
    }
}
