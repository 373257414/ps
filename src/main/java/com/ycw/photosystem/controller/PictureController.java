package com.ycw.photosystem.controller;

import com.ycw.photosystem.bean.page.Page;
import com.ycw.photosystem.service.PictureService;
import com.ycw.photosystem.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PictureController {

    @Autowired
    PictureService pictureService;
    @Autowired
    SearchService searchService;

    @RequestMapping("simpleSearchAction")
    @ResponseBody
    public List simpleSearch(String field, String condition) {
        if (field.equals(null)) {
            return null;
        } else {
            List result;
            if (field.equals("pictureCategory") || field.equals("pictureDepartment")) {
                result = searchService.singleSQLSearch(field, Integer.valueOf(condition));
            } else {
                result = searchService.singleSQLSearch(field, condition);
            }
            return result;
        }
    }

    // TODO: 精确查找和模糊查找，与前端的配合
    /*@RequestMapping("complexSearchAction")
    @ResponseBody
    public List complexSearch(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> fields = parameterMap.keySet();
        Map<String, Object> conditionMap = new HashMap<>();
        for (String field : fields) {
            String condition = StringUtils.trimWhitespace(request.getParameter(field));
            if (StringUtils.isEmpty(condition)) {
                continue;
            }
            if (field.equals("pictureDepartment") ||field.equals("pictureCategory")){
                conditionMap.put(field, Integer.valueOf(condition));
            }else {
                conditionMap.put(field, condition);
            }
        }
        conditionMap.remove("currentPage");
        Page page = new Page();
        page.setCurrentPage(Integer.valueOf(request.getParameter("currentPage")));
        page.setConditionMap(conditionMap);
        List result = searchService.searchByPage(page);
        return result;
    }*/

    @RequestMapping("complexSearchAction")
    @ResponseBody
    public List complexSearch(HttpServletRequest request) {
        Map<String, Object> conditionMap = new HashMap<>();
        if (!StringUtils.isEmpty(request.getParameter("description"))) {
            conditionMap.put("description", request.getParameter("description"));
        }
        if (!StringUtils.isEmpty(request.getParameter("fileNumber"))) {
            conditionMap.put("fileNumber", request.getParameter("fileNumber"));
        }
        if (!StringUtils.isEmpty(request.getParameter("keyPerson"))) {
            conditionMap.put("keyPerson", request.getParameter("keyPerson"));
        }
        if (!StringUtils.isEmpty(request.getParameter("author"))) {
            conditionMap.put("author", request.getParameter("author"));
        }
        if (!StringUtils.isEmpty(request.getParameter("place"))) {
            conditionMap.put("place", request.getParameter("place"));
        }
        Page page = new Page();
        if (!StringUtils.isEmpty(request.getParameter("currentPage"))) {
            page.setCurrentPage(Integer.valueOf(request.getParameter("currentPage")));
        }
        if (!StringUtils.isEmpty(request.getParameter("pictureCategory"))) {
            page.setCategoryId(Integer.parseInt(request.getParameter("pictureCategory")));
        }
        if (!StringUtils.isEmpty(request.getParameter("pictureDepartment"))) {
            page.setDepartmentId(Integer.parseInt(request.getParameter("pictureDepartment")));
        }
        page.setConditionMap(conditionMap);
        List result = searchService.unionSearch(page);
        return result;
    }


    @RequestMapping("getPicInCat")
    @ResponseBody
    public List getPicInCategory(int currentPage, int categoryId) {
        Page page = new Page();
        page.setCategoryId(categoryId);
        page.setCurrentPage(currentPage);
        return searchService.searchByPage(page);
    }


    @RequestMapping("uploadAction")
    @ResponseBody
    public void upload(MultipartHttpServletRequest request) {
        Map fileMap = request.getFileMap();
        Map<String, String[]> parameterMap = request.getParameterMap();
        try {
            pictureService.addPic(fileMap, parameterMap);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        return;
    }
/*
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
