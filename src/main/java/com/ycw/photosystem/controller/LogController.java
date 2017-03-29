package com.ycw.photosystem.controller;

import com.ycw.photosystem.bean.mysql.Event;
import com.ycw.photosystem.bean.mysql.User;
import com.ycw.photosystem.service.LogService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

@Aspect
@Component
public class LogController {

    @Autowired
    private LogService logService;

    @Pointcut("execution(* com.ycw.photosystem.controller.UserController.login(..))")
    private void userLogin() {
    }

    @After("userLogin()&&args(request)")
    public void doAfterLogin(HttpServletRequest request) {
        Event event = new Event();
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        event.setEventTime(new Timestamp(System.currentTimeMillis()));
        event.setEventUser(currentUser.getId());
        event.setEventMsg("用户<" + currentUser.getName() + ">登录,时间：" + event.getEventTime());
        logService.save(event);
    }

    @Pointcut("execution(* com.ycw.photosystem.controller.UserController.update*(..))")
    private void userUpdate() {
    }

    @After("userUpdate()&&args(request)")
    public void doAfterUserUpdate(HttpServletRequest request) {
        Event event = new Event();
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        event.setEventTime(new Timestamp(System.currentTimeMillis()));
        event.setEventUser(currentUser.getId());
        event.setEventMsg("用户<" + currentUser.getName() + ">修改个人信息,时间：" + event.getEventTime());
        logService.save(event);
    }

}
