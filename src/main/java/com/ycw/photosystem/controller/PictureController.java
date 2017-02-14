package com.ycw.photosystem.controller;

import com.ycw.photosystem.bean.Picture;
import com.ycw.photosystem.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class PictureController {


    @Autowired
    PictureService pictureService;

    @RequestMapping("mainPictureJsp")
    public ModelAndView mainJsp(){
        return new ModelAndView("/jsp/recycleBin/main");
    }

    @RequestMapping("/uploadAction")
    public String upload(MultipartHttpServletRequest request) {
        Map fileMap = request.getFileMap();
        Map<String, String[]> parameterMap = request.getParameterMap();
        try {
            pictureService.addPic(fileMap, parameterMap);
        } catch (IOException e) {
            e.printStackTrace();
            return "/settings/fail";
        }
        return "settings/fail";
    }

    @RequestMapping("/searchAction")
    @ResponseBody
    public ModelAndView search(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        List<Picture> list = new ArrayList();
        if (null != id) {
            list.add( pictureService.searchPic(id));
        }else if (!StringUtils.isEmpty(name)) {
//            list = pictureService.searchPic(name);
        }
        ModelAndView mav = new ModelAndView("/settings/success");
        mav.addObject("pictures",list);
        return mav;
    }

}
