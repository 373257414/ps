package com.ycw.photosystem.controller.JspJump;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by liuyang on 2016/12/15 0015.
 */
@Controller
public class SystemJump {

    @RequestMapping("loginJsp")
    public ModelAndView index() {
        return new ModelAndView("/jsp/login");
    }

    @RequestMapping("systemJsp")
    public ModelAndView systemJsp() {
        return new ModelAndView("/jsp/system");
    }
    @RequestMapping("departmentJsp")
    public ModelAndView departmentJsp() {
        return new ModelAndView("/jsp/deparment");
    }

    @RequestMapping("normal")
    public ModelAndView userManageJsp() {
        return new ModelAndView("/jsp/normal");
    }

    @RequestMapping("classifyScan")
    public ModelAndView Jsp() {
        return new ModelAndView("/jsp/classifyScan");
    }
}
