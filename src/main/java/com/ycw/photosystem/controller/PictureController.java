package com.ycw.photosystem.controller;

import com.ycw.photosystem.dao.mysql.PictureDAO;
import com.ycw.photosystem.service.PictureService;
import com.ycw.photosystem.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.Map.Entry;

@Controller
public class PictureController {


    @Autowired
    PictureService pictureService;
    @Autowired
    SearchService searchService;


    //// TODO:  
    @RequestMapping("simpleSearchAction")
    public String simpleSearch(String searchKeys, String keyWords, HttpServletRequest request) {
        List result =searchService.simpleSearch(searchKeys,keyWords);
        return "/jsp/system";
    }

    // TODO: 精确查找和模糊查找，与前端的配合
    @RequestMapping("complexSearchAction")
    public String complexSearch(String check, HttpServletRequest request){
        Map<String,String[]> parameterMap=request.getParameterMap();
        parameterMap.remove("check");
        Set<String> fields=parameterMap.keySet();
        Map<String,String> conditionMap = new HashMap<>();
        for (String field:fields) {
            String condition=StringUtils.trimWhitespace(request.getParameter(field));
            if (StringUtils.isEmpty(condition)){
                continue;
            }
            conditionMap.put(field,condition);
        }
        List result =searchService.complexSearch(conditionMap);
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
