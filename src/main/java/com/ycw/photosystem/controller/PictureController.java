package com.ycw.photosystem.controller;

import com.ycw.photosystem.service.PictureService;
import com.ycw.photosystem.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PictureController {


    @Autowired
    PictureService pictureService;
    @Autowired
    SearchService searchService;


    @RequestMapping("simpleSearchAction")
    public String simpleSearch(String searchKeys, String keyWords, HttpServletRequest request) {
        List result =searchService.simpleSearch(searchKeys,keyWords);
        return "/jsp/system";
    }



    /*@RequestMapping("uploadAction")
    public String upload(MultipartHttpServletRequest request) {
        Map fileMap = request.getFileMap();
        Map<String, String[]> parameterMap = request.getParameterMap();
        try {
            pictureService.addPic(fileMap, parameterMap);
        } catch (IOException e) {
            e.printStackTrace();
            return "settings/fail";
        }
        return "settings/fail";
    }

    @RequestMapping("searchAction")
    @ResponseBody
    public ModelAndView search(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        List<Picture> list = new ArrayList();
        if (null != id) {
            list.add( pictureService.searchPic(id));
        }else if (!StringUtils.isEmpty(name)) {
            list = pictureService.searchPic(name);
        }
        ModelAndView mav = new ModelAndView("/settings/success");
        mav.addObject("pictures",list);
        return mav;
    }*/

}
