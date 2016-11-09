package com.ycw.photosystem.controller;

import com.ycw.photosystem.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/picture")
public class PictureController {


    @Autowired
    PictureService pictureService;

    @RequestMapping("/upload")
    public String upload(MultipartHttpServletRequest request) throws Exception {
        Map fileMap = request.getFileMap();
        Map<String,String[]> parameterMap=request.getParameterMap();
        pictureService.addPic(fileMap,parameterMap);
        return null;
    }
}
