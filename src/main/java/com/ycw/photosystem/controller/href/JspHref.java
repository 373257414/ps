package com.ycw.photosystem.controller.href;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JspHref {

    @RequestMapping("classifyScanJsp")
    public ModelAndView classifyScanJsp() { return new ModelAndView("/jsp/classifyScan"); }

    @RequestMapping("departmentJsp")
    public ModelAndView departmentJsp() { return new ModelAndView("/jsp/deparment"); }

    @RequestMapping("depManageJsp")
    public ModelAndView depManageJsp() { return new ModelAndView("/jsp/depManage"); }

    @RequestMapping("loginJsp")
    public ModelAndView loginJsp() { return new ModelAndView("/jsp/login"); }

    @RequestMapping("normalJsp")
    public ModelAndView normalJsp() { return new ModelAndView("/jsp/normal"); }

    @RequestMapping("systemJsp")
    public ModelAndView systemJsp() { return new ModelAndView("/jsp/system"); }

    @RequestMapping("testJsp")
    public ModelAndView testJsp() { return new ModelAndView("/jsp/test"); }

    @RequestMapping("userInformationJsp")
    public ModelAndView userInformationJsp() { return new ModelAndView("/jsp/userInformation"); }

    @RequestMapping("userManageJsp")
    public ModelAndView userManageJsp() { return new ModelAndView("/jsp/userManage"); }
}
