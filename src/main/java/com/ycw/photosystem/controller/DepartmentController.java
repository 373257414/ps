package com.ycw.photosystem.controller;

import com.ycw.photosystem.bean.Department;
import com.ycw.photosystem.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("addDepartmentJsp")
    public ModelAndView addJsp(){
        return new ModelAndView("/department/add");
    }
    @RequestMapping("mainDepartmentJsp")
    public ModelAndView mainJsp(){
        ModelAndView modelAndView = new ModelAndView("/department/main");
        modelAndView.addObject("departments",departmentService.getAll());
        return modelAndView;
    }

    @RequestMapping("addDepartment")
    public void add(String name,String charger,String address,String email){
        Department department= new Department();
        department.setName(name);
        department.setCharger(charger);
        department.setAddress(address);
        department.setEmail(email);
        departmentService.add(department);
    }
}
