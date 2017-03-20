package com.ycw.photosystem.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.ycw.photosystem.bean.mysql.Picture;
import com.ycw.photosystem.bean.page.Page;
import com.ycw.photosystem.dao.es.PictureEsDAO;
import com.ycw.photosystem.dao.mysql.PictureDAO;
import com.ycw.photosystem.dao.tranform.PictureTransform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service
@Transactional
public class SearchService {
    private final PictureDAO pictureDAO;
    private final PictureEsDAO pictureEsDAO;
    private final PictureTransform pictureTransform;

    @Autowired
    public SearchService(PictureDAO pictureDAO, PictureEsDAO pictureEsDAO, PictureTransform pictureTransform) {
        this.pictureDAO = pictureDAO;
        this.pictureEsDAO = pictureEsDAO;
        this.pictureTransform = pictureTransform;
    }

    public List simpleSearch(String field, String condition) {
        if (field.equals(null)) {
            return null;
        } else {
            return pictureDAO.findByProperty(field, condition);
        }
    }

    public List complexSearch(Map<String, String> conditionMap, Boolean mode) {
        if (mode.equals(true)) {
            return pictureDAO.findByPropertiesAnd(conditionMap);
        } else {
            return pictureDAO.findByPropertiesOr(conditionMap);
        }
    }

    public List displayByPage(Page page) {
        return pictureDAO.findByPage(page);
    }

    public void index(Long startId, Long endId, int perCount) {

        while (startId < endId) {
            List list = pictureDAO.findFromTO(startId, startId + perCount);
            startId = startId + perCount;
            for (Object o : list) {
                Picture p = (Picture) o;
                try {
                    pictureEsDAO.index(pictureTransform.transform(p));
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void esSearch(String field, String text) {
        Object[] resultArray = pictureEsDAO.findIdByMatchQuery(field, text);
        for (Object o : resultArray) {
            String id = o.toString();
            System.out.println(id);
        }
    }

}
