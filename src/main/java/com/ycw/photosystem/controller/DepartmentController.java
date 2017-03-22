package com.ycw.photosystem.controller;

import com.ycw.photosystem.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;


@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("mainDepartmentJsp")
    public ModelAndView mainJsp() {
        ModelAndView modelAndView = new ModelAndView("/department/main");
        modelAndView.addObject("departments", departmentService.getAll());
        return modelAndView;
    }

    @RequestMapping("addDepartmentJsp")
    public ModelAndView addJsp() {
        return new ModelAndView("/department/add");
    }

    @RequestMapping("addDepartmentAction")
    public void add(Map parametersMap) {
        departmentService.add(parametersMap);
    }

    @RequestMapping("updateDepartmentAction")
    public void update(Map parametersMap) {
        departmentService.update(parametersMap);
    }
}
