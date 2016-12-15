package com.ycw.photosystem.controller.JspJump;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by liuyang on 2016/12/15 0015.
 */
@Controller
public class SystemJump {
    @RequestMapping("depManageJsp")
    public ModelAndView depManageJsp(){
        return new ModelAndView("/jsp/depManage");
    }

    @RequestMapping("userManageJsp")
    public ModelAndView userManageJsp(){
        return new ModelAndView("/jsp/userManage");
    }
    @RequestMapping("classifyScan")
    public ModelAndView Jsp(){
        return new ModelAndView("/jsp/classifyScan");
    }
}
