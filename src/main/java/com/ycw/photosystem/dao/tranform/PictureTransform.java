package com.ycw.photosystem.dao.tranform;

import com.ycw.photosystem.bean.mysql.Picture;
import com.ycw.photosystem.bean.es.PictureEsBean;
import com.ycw.photosystem.dao.mysql.CategoryDAO;
import com.ycw.photosystem.dao.mysql.DepartmentDAO;
import com.ycw.photosystem.dao.mysql.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PictureTransform {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private DepartmentDAO departmentDAO;
    @Autowired
    private CategoryDAO categoryDAO;

    public PictureEsBean transform(Picture picture) {
        PictureEsBean bean = new PictureEsBean();
        bean.setId(picture.getId());
        bean.setName(picture.getName());
        bean.setCreateTime(picture.getCreateTime());
        if (picture.getPictureLoader() != null) {
            bean.setPictureLoader(userDAO.findById(picture.getPictureLoader()).getName());
        }
        bean.setPictureDepartment(departmentDAO.findById(picture.getPictureDepartment()).getName());
        bean.setPictureCategory(categoryDAO.findById(picture.getPictureCategory()).getName());
        bean.setKeyPerson(picture.getKeyPerson());
        bean.setAuthor(picture.getAuthor());
        bean.setDescription(picture.getDescription());
        bean.setFileNumber(picture.getFileNumber());
        return bean;
    }
}
