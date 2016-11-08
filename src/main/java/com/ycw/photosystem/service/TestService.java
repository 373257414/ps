package com.ycw.photosystem.service;

import com.ycw.photosystem.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
public class TestService {
    @Autowired
    private PermissionDAO permissionDAO;
    @Autowired
    private CategoryDAO categoryDAO;
    @Autowired
    private DepartmentDAO departmentDAO;
    @Autowired
    private EventDAO eventDAO;
    @Autowired
    private PictureDAO pictureDAO;
    @Autowired
    private RequestDAO requestDAO;
    @Autowired
    private UserDAO userDAO;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        TestService testService = (TestService) context.getBean("testService");
        testService.categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
        List list = testService.categoryDAO.findAll();
        System.out.println(Arrays.toString(list.toArray()));
        testService.departmentDAO = (DepartmentDAO) context.getBean("departmentDAO");
        list=testService.departmentDAO.findAll();
        System.out.println(Arrays.toString(list.toArray()));
        testService.eventDAO = (EventDAO) context.getBean("eventDAO");
        list=testService.eventDAO.findAll();
        System.out.println(Arrays.toString(list.toArray()));
        testService.permissionDAO = (PermissionDAO) context.getBean("permissionDAO");
        list=testService.permissionDAO.findAll();
        System.out.println(Arrays.toString(list.toArray()));
        testService.pictureDAO = (PictureDAO) context.getBean("pictureDAO");
        list=testService.pictureDAO.findAll();
        System.out.println(Arrays.toString(list.toArray()));
        testService.userDAO = (UserDAO) context.getBean("userDAO");
        list=testService.userDAO.findAll();
        System.out.println(Arrays.toString(list.toArray()));
        testService.requestDAO = (RequestDAO) context.getBean("requestDAO");
        list=testService.requestDAO.findAll();
        System.out.println(Arrays.toString(list.toArray()));
    }

    public void test() {
        System.out.println("Test in testService!");
        permissionDAO.test();
    }
}
