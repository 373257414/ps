package com.ycw.photosystem.controller.href;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JspHref {

    @RequestMapping("classifyScanJsp")
    public ModelAndView classifyScanJsp() { return new ModelAndView("/jsp/functions/classifyScan"); }

    @RequestMapping("uploadPictureJsp")
    public ModelAndView uploadPictureJsp() { return new ModelAndView("/jsp/functions/uploadPicture"); }

    @RequestMapping("departmentJsp")
    public ModelAndView departmentJsp() { return new ModelAndView("/jsp/users/department"); }

    @RequestMapping("checkPictureJsp")
    public ModelAndView checkPictureJsp() { return new ModelAndView("/jsp/functions/checkPicture"); }

    @RequestMapping("depManageJsp")
    public ModelAndView depManageJsp() { return new ModelAndView("/jsp/functions/depManage"); }

    @RequestMapping("loginJsp")
    public ModelAndView loginJsp() { return new ModelAndView("/jsp/users/login"); }

    @RequestMapping("normalJsp")
    public ModelAndView normalJsp() { return new ModelAndView("/jsp/users/normal"); }

    @RequestMapping("systemJsp")
    public ModelAndView systemJsp() { return new ModelAndView("/jsp/users/system"); }

    @RequestMapping("testJsp")
    public ModelAndView testJsp() { return new ModelAndView("/jsp/functions/test"); }

    @RequestMapping("userInformationJsp")
    public ModelAndView userInformationJsp() { return new ModelAndView("/jsp/functions/userInformation"); }

    @RequestMapping("userManageJsp")
    public ModelAndView userManageJsp() { return new ModelAndView("/jsp/functions/userManage"); }
}
