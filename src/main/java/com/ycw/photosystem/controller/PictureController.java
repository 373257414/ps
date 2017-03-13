package com.ycw.photosystem.controller;

import com.ycw.photosystem.bean.page.Page;
import com.ycw.photosystem.service.PictureService;
import com.ycw.photosystem.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class PictureController {

    @Autowired
    PictureService pictureService;
    @Autowired
    SearchService searchService;

    @RequestMapping("simpleSearchAction")
    public ModelAndView simpleSearch(String searchKeys, String keyWords) {
        List result = searchService.simpleSearch(searchKeys, keyWords);
        ModelAndView mav = new ModelAndView("/jsp/system");
        mav.addObject(result);
        return mav;
    }

    // TODO: 精确查找和模糊查找，与前端的配合
    @RequestMapping("complexSearchAction")
    public String complexSearch(String check, HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        parameterMap.remove("check");
        Set<String> fields = parameterMap.keySet();
        Map<String, String> conditionMap = new HashMap<>();
        for (String field : fields) {
            String condition = StringUtils.trimWhitespace(request.getParameter(field));
            if (StringUtils.isEmpty(condition)) {
                continue;
            }
            conditionMap.put(field, condition);
        }
        List result = searchService.complexSearch(conditionMap, true);
        return "/jsp/system";
    }

    @RequestMapping("getPicInCat")
    @ResponseBody
    public List getPicInCategory(int currentPaper, int categoryId){
        Page page = new Page();
        page.setCategoryId(categoryId);
        page.setCurrentPage(currentPaper);
        return searchService.displayByPaper(page);
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
