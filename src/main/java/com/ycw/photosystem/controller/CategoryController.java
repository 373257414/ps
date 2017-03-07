package com.ycw.photosystem.controller;

import com.ycw.photosystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping("getAllCategory")
    public List getAllCategory() {
        return categoryService.findAll();
    }
}
