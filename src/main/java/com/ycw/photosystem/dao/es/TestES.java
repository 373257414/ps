package com.ycw.photosystem.dao.es;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class TestES {

    public static void main(String[] args) throws IOException {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");





        /*Picture picture = new Picture();
        picture.setAuthor("刘润泽");
        picture.setCreateTime(new Timestamp(System.currentTimeMillis()));
        picture.setDescription("这是测试数据");
        picture.setDownloadCount(0);
        picture.setFileNumber("000000");
        picture.setHeight(0000);
        picture.setKeyPerson("关键人物");
        picture.setName("test");
        picture.setPath("e:/test/picture");
        picture.setPictureCategory(1);
        picture.setPictureDepartment(1);
        picture.setPictureLoader(1);
        picture.setVisitCount(0);
        picture.setWatermarkPath("e:/test/wmpicture");
        picture.setWidth(1111);
        picture.setId(300000);


        Logger log = LoggerFactory.getLogger(TestES.class);
        PictureDAO pictureDAO = (PictureDAO) context.getBean("pictureDAO");
        PictureTransform pictureTransform = (PictureTransform) context.getBean("pictureTransform");
        PictureEsDAO pictureEsDAO = (PictureEsDAO) context.getBean("pictureEsDAO");
        pictureDAO.save(picture);
        PictureEsBean pictureEsBean = pictureTransform.transform(picture);
        try {
            pictureEsDAO.index(pictureEsBean);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }*/




        /*ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    Picture picture = new Picture();
                    picture.setAuthor("刘润泽");
                    picture.setCreateTime(new Timestamp(System.currentTimeMillis()));
                    picture.setDescription("这是测试数据");
                    picture.setDownloadCount(0);
                    picture.setFileNumber("000000");
                    picture.setHeight(0000);
                    picture.setKeyPerson("关键人物");
                    picture.setName("测试图片名称");
                    picture.setPath("e:/test/picture");
                    picture.setPictureCategory(1);
                    picture.setPictureDepartment(1);
                    picture.setPictureLoader(1);
                    picture.setVisitCount(0);
                    picture.setWatermarkPath("e:/test/wmpicture");
                    picture.setWidth(1111);
                    picture.setId(120500 + i);
                    pictureDAO.save(picture);
                    PictureEsBean pictureEsBean = pictureTransform.transform(picture);
                    try {
                        pictureEsDAO.index(pictureEsBean);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    Picture picture = new Picture();
                    picture.setAuthor("刘润泽");
                    picture.setCreateTime(new Timestamp(System.currentTimeMillis()));
                    picture.setDescription("这是测试数据");
                    picture.setDownloadCount(0);
                    picture.setFileNumber("000000");
                    picture.setHeight(0000);
                    picture.setKeyPerson("关键人物");
                    picture.setName("测试图片名称");
                    picture.setPath("e:/test/picture");
                    picture.setPictureCategory(1);
                    picture.setPictureDepartment(1);
                    picture.setPictureLoader(1);
                    picture.setVisitCount(0);
                    picture.setWatermarkPath("e:/test/wmpicture");
                    picture.setWidth(1111);
                    picture.setId(130000 + i);
                    pictureDAO.save(picture);
                    PictureEsBean pictureEsBean = pictureTransform.transform(picture);
                    try {
                        pictureEsDAO.index(pictureEsBean);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    Picture picture = new Picture();
                    picture.setAuthor("刘润泽");
                    picture.setCreateTime(new Timestamp(System.currentTimeMillis()));
                    picture.setDescription("这是测试数据");
                    picture.setDownloadCount(0);
                    picture.setFileNumber("000000");
                    picture.setHeight(0000);
                    picture.setKeyPerson("关键人物");
                    picture.setName("测试图片名称");
                    picture.setPath("e:/test/picture");
                    picture.setPictureCategory(1);
                    picture.setPictureDepartment(1);
                    picture.setPictureLoader(1);
                    picture.setVisitCount(0);
                    picture.setWatermarkPath("e:/test/wmpicture");
                    picture.setWidth(1111);
                    picture.setId(140000 + i);
                    pictureDAO.save(picture);
                    PictureEsBean pictureEsBean = pictureTransform.transform(picture);
                    try {
                        pictureEsDAO.index(pictureEsBean);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    Picture picture = new Picture();
                    picture.setAuthor("刘润泽");
                    picture.setCreateTime(new Timestamp(System.currentTimeMillis()));
                    picture.setDescription("这是测试数据");
                    picture.setDownloadCount(0);
                    picture.setFileNumber("000000");
                    picture.setHeight(0000);
                    picture.setKeyPerson("关键人物");
                    picture.setName("测试图片名称");
                    picture.setPath("e:/test/picture");
                    picture.setPictureCategory(1);
                    picture.setPictureDepartment(1);
                    picture.setPictureLoader(1);
                    picture.setVisitCount(0);
                    picture.setWatermarkPath("e:/test/wmpicture");
                    picture.setWidth(1111);
                    picture.setId(150000 + i);
                    pictureDAO.save(picture);
                    PictureEsBean pictureEsBean = pictureTransform.transform(picture);
                    try {
                        pictureEsDAO.index(pictureEsBean);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    Picture picture = new Picture();
                    picture.setAuthor("刘润泽");
                    picture.setCreateTime(new Timestamp(System.currentTimeMillis()));
                    picture.setDescription("这是测试数据");
                    picture.setDownloadCount(0);
                    picture.setFileNumber("000000");
                    picture.setHeight(0000);
                    picture.setKeyPerson("关键人物");
                    picture.setName("测试图片名称");
                    picture.setPath("e:/test/picture");
                    picture.setPictureCategory(1);
                    picture.setPictureDepartment(1);
                    picture.setPictureLoader(1);
                    picture.setVisitCount(0);
                    picture.setWatermarkPath("e:/test/wmpicture");
                    picture.setWidth(1111);
                    picture.setId(160068 + i);
                    pictureDAO.save(picture);
                    PictureEsBean pictureEsBean = pictureTransform.transform(picture);
                    try {
                        pictureEsDAO.index(pictureEsBean);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    Picture picture = new Picture();
                    picture.setAuthor("刘润泽");
                    picture.setCreateTime(new Timestamp(System.currentTimeMillis()));
                    picture.setDescription("这是测试数据");
                    picture.setDownloadCount(0);
                    picture.setFileNumber("000000");
                    picture.setHeight(0000);
                    picture.setKeyPerson("关键人物");
                    picture.setName("测试图片名称");
                    picture.setPath("e:/test/picture");
                    picture.setPictureCategory(1);
                    picture.setPictureDepartment(1);
                    picture.setPictureLoader(1);
                    picture.setVisitCount(0);
                    picture.setWatermarkPath("e:/test/wmpicture");
                    picture.setWidth(1111);
                    picture.setId(170000 + i);
                    pictureDAO.save(picture);
                    PictureEsBean pictureEsBean = pictureTransform.transform(picture);
                    try {
                        pictureEsDAO.index(pictureEsBean);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    Picture picture = new Picture();
                    picture.setAuthor("刘润泽");
                    picture.setCreateTime(new Timestamp(System.currentTimeMillis()));
                    picture.setDescription("这是测试数据");
                    picture.setDownloadCount(0);
                    picture.setFileNumber("000000");
                    picture.setHeight(0000);
                    picture.setKeyPerson("关键人物");
                    picture.setName("测试图片名称");
                    picture.setPath("e:/test/picture");
                    picture.setPictureCategory(1);
                    picture.setPictureDepartment(1);
                    picture.setPictureLoader(1);
                    picture.setVisitCount(0);
                    picture.setWatermarkPath("e:/test/wmpicture");
                    picture.setWidth(1111);
                    picture.setId(180000 + i);
                    pictureDAO.save(picture);
                    PictureEsBean pictureEsBean = pictureTransform.transform(picture);
                    try {
                        pictureEsDAO.index(pictureEsBean);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    Picture picture = new Picture();
                    picture.setAuthor("刘润泽");
                    picture.setCreateTime(new Timestamp(System.currentTimeMillis()));
                    picture.setDescription("这是测试数据");
                    picture.setDownloadCount(0);
                    picture.setFileNumber("000000");
                    picture.setHeight(0000);
                    picture.setKeyPerson("关键人物");
                    picture.setName("测试图片名称");
                    picture.setPath("e:/test/picture");
                    picture.setPictureCategory(1);
                    picture.setPictureDepartment(1);
                    picture.setPictureLoader(1);
                    picture.setVisitCount(0);
                    picture.setWatermarkPath("e:/test/wmpicture");
                    picture.setWidth(1111);
                    picture.setId(190000 + i);
                    pictureDAO.save(picture);
                    PictureEsBean pictureEsBean = pictureTransform.transform(picture);
                    try {
                        pictureEsDAO.index(pictureEsBean);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        executorService.shutdown();*/

    }
}
