package com.ycw.photosystem.service;

import com.ycw.photosystem.dao.mysql.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@Transactional
public class CategoryService {
    @Autowired
    CategoryDAO categoryDAO;

    public List findAll() {
        return categoryDAO.findAll();
    }
}
