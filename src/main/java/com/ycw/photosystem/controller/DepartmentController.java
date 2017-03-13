package com.ycw.photosystem.controller;

import com.ycw.photosystem.bean.mysql.Department;
import com.ycw.photosystem.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("mainDepartmentJsp")
    public ModelAndView mainJsp(){
        ModelAndView modelAndView = new ModelAndView("/department/main");
        modelAndView.addObject("departments",departmentService.getDepartments());
        return modelAndView;
    }
    @RequestMapping("addDepartmentJsp")
    public ModelAndView addJsp(){
        return new ModelAndView("/department/add");
    }

    @RequestMapping("addDepartmentAction")
    public void add(String name,String charger,String address,String email){
        Department department= new Department();
        department.setName(name);
        department.setCharger(charger);
        department.setAddress(address);
        department.setEmail(email);
        departmentService.add(department);
    }

    @RequestMapping("updateDepartmentAction")
    public void update(int id,String name,String charger,String address,String email){

    }
}
