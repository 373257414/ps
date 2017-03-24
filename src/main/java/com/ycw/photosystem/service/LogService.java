package com.ycw.photosystem.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Aspect
public class LogService {

    /*@Pointcut("execution(* com.ycw.photosystem.controller.UserController.*(..))")
    private void userMethod(){
    }


    @After("userMethod()&&args(userName,password,request)")
    public void doAfter(String userName, String password, HttpServletRequest request){
        System.out.println("用户登录");
    }
*/

}
