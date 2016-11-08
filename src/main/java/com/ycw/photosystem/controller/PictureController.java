package com.ycw.photosystem.controller;

import com.ycw.photosystem.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Timestamp;

@Controller
@RequestMapping("/picture")
public class PictureController {


    @Autowired
    PictureService pictureService;

    @RequestMapping("/upload")
    public String upload(MultipartHttpServletRequest request, @RequestParam("file") MultipartFile file) throws Exception {
        File image=null;
        file.transferTo(image);
        BufferedImage picture = ImageIO.read(image);
        request.getMultiFileMap();
        int departmentId = Integer.parseInt(request.getParameter("departmentId"));
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        String description = request.getParameter("description");
        String keyPerson = request.getParameter("keyPerson");
        String pictureLoader = request.getParameter("pictureLoader");
        String author=request.getParameter("author");

        System.out.println(departmentId);
        if (!file.isEmpty()) {
            System.out.println("file is not empty.");
            return "";
        }
        pictureService.addPic(picture, author, new Timestamp(System.currentTimeMillis()), description, keyPerson, categoryId, departmentId, pictureLoader);
        return null;
    }
}
