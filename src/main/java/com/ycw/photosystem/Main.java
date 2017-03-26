package com.ycw.photosystem;

import com.ycw.photosystem.bean.mysql.Event;
import com.ycw.photosystem.bean.mysql.Picture;
import com.ycw.photosystem.dao.es.PictureEsDAO;
import com.ycw.photosystem.dao.mysql.UserDAO;
import com.ycw.photosystem.dao.tranform.PictureTransform;
import com.ycw.photosystem.service.LogService;
import com.ycw.photosystem.service.SearchService;
import com.ycw.photosystem.service.TestService;
import com.ycw.photosystem.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {

    private static TestService testService;
    private static SearchService searchService;
    private static UserService userService;
    private static UserDAO userDAO;
    private static PictureEsDAO pictureEsDAO;
    private static PictureTransform pictureTransform;
    private static LogService logService;

    static {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        testService = (TestService) context.getBean("testService");
        searchService = (SearchService) context.getBean("searchService");
        userService = (UserService) context.getBean("userService");
        logService = (LogService) context.getBean("logService");
    }

    public static void main(String[] args) {
        Event event = new Event();
        event.setEventUser(1);
        event.setEventTime(new Timestamp(System.currentTimeMillis()));
        logService.save(event);
        userService.getAll();
        /*
        Picture picture=generate1("特殊测试图片4","北京师范大学");
        testService.oneUpdate(picture);*/
        /*double start = System.currentTimeMillis();
        searchService.esSearch("description", "教四");
        //searchService.singleSQLSearch("description", "教四");
        double end = System.currentTimeMillis();
        System.out.println(end - start);*/
        //searchService.totalUpdate();
       /* List list =userService.findAll();
        System.out.print(list.size());
*/

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

    private static void generate1000000(Long startId, Long endId) {
        for (Long i = startId; i < endId; i++) {
            String NAME = "测试图片名称";
            Picture picture = new Picture();
            picture.setName(NAME + "_" + i);
            picture.setPictureCategory(1);
            picture.setDescription("test");
            picture.setPictureDepartment(1);
            testService.save(picture);
            testService.oneUpdate(picture);
        }
    }

    private static Picture generate1(String name, String description) {
        Random random = new Random();
        Picture picture = new Picture();
        picture.setName(name);
        picture.setCreateTime(new Timestamp(System.currentTimeMillis()));
        picture.setPictureCategory(random.nextInt(3) + 1);
        picture.setDescription(description);
        picture.setPictureDepartment(1);
        picture.setWidth(random.nextInt(1000));
        picture.setHeight(random.nextInt(1000));
        testService.save(picture);
        return picture;
    }


    private static void totalUpdate() {
        int threadCount = 20;
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        Long MaxId = 5L;
        Long MinId = 0L;
        Long threadRange = (MaxId - MinId) / threadCount;
        if (threadRange < 1) {
            threadRange = MaxId - MinId;
            threadCount = 1;
        }
        final Long innerRange = threadRange;
        for (int i = 0; i < threadCount; i++) {
            int innerI = i;//thisThreadNum在内部，传值
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    Long startId = MinId + innerRange * innerI;
                    Long endId = startId + innerRange;
                    searchService.index(startId, endId, 10);
                }
            });
        }
        executorService.shutdown();
    }

}

