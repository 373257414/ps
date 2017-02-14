package com.ycw.photosystem;

import com.ycw.photosystem.bean.Picture;
import com.ycw.photosystem.service.TestService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.util.List;
import java.util.Random;


public class Main {

    private static TestService testService;

    static {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        testService = (TestService) context.getBean("testService");
    }

    public static void main(String[] args) {

        //testService.totalUpdate();
        testService.esSearch("name", "猫");
        //testService.esSearch("pictureCategory", "测试", 0, 10);
        System.out.println("--------------");
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

