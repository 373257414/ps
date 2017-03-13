package com.ycw.photosystem;

import com.ycw.photosystem.bean.mysql.Picture;
import com.ycw.photosystem.dao.mysql.UserDAO;
import com.ycw.photosystem.service.SearchService;
import com.ycw.photosystem.service.TestService;
import com.ycw.photosystem.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.util.List;
import java.util.Random;


public class Main {

    private static TestService testService;
    private static SearchService searchService;
    private static UserService userService;
    private static UserDAO userDAO;

    static {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        testService = (TestService) context.getBean("testService");
        searchService = (SearchService) context.getBean("searchService");
        userService = (UserService) context.getBean("userService");
    }

    public static void main(String[] args) {
        List list =userService.findAll();
        System.out.print(list.size());


        /*Map<String, String> conditionMap = new HashMap<>();
        conditionMap.put("fileNumber", "testFileNumber");
        conditionMap.put("description", "testDescription");
        conditionMap.put("keyPerson", "testKeyPerson");
        conditionMap.put("author", "testFake");
        List resultAnd = searchService.complexSearch(conditionMap, true);
        List resultOr = searchService.complexSearch(conditionMap, false);
        System.out.print("使用数据之前\n");
        if (resultAnd != null && resultAnd.size() > 0) {
            Picture picture1 = (Picture) resultAnd.get(0);
            System.out.print(picture1.getId());
        }
        if (resultOr != null && resultOr.size() > 0) {
            Picture picture2 = (Picture) resultOr.get(0);
            System.out.print(picture2.getId());
        }
        System.out.print("使用数据之后\n");*/


        //testService.totalUpdate();
        //testService.esSearch("name", "猫");
        //testService.esSearch("pictureCategory", "测试", 0, 10);
        //System.out.println("--------------");
        //testService.esSearch("pictureCategory", "测试", 0, 5);

    }

    private void orderTest() {
        Long[] ids = new Long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L};
        List list1 = testService.findByIds(ids);
        List list2 = testService.findByIdsDecs(ids);
        for (Object o : list1) {
            Picture picture = (Picture) o;
            System.out.println(picture.getName());
        }
        for (Object o : list2) {
            Picture picture = (Picture) o;
            System.out.println(picture.getName());
        }
    }

    private static void generate1000() {
        Random random = new Random();
        for (int i = 1; i < 1001; i++) {
            String NAME = "测试图片名称";
            Picture picture = new Picture();
            picture.setName(NAME + "_" + i);
            picture.setCreateTime(new Timestamp(System.currentTimeMillis()));
            picture.setPictureCategory(random.nextInt(3) + 1);
            picture.setPictureDepartment(1);
            picture.setWidth(random.nextInt(1000));
            picture.setHeight(random.nextInt(1000));
            testService.save(picture);
        }
    }

    private static void generate1() {
        Random random = new Random();
        String NAME = "火猫";
        Picture picture = new Picture();
        picture.setName(NAME);
        picture.setCreateTime(new Timestamp(System.currentTimeMillis()));
        picture.setPictureCategory(random.nextInt(3) + 1);
        picture.setPictureDepartment(1);
        picture.setWidth(random.nextInt(1000));
        picture.setHeight(random.nextInt(1000));
        testService.save(picture);
    }

}

