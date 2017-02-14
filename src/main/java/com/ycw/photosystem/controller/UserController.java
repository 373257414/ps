package com.ycw.photosystem.controller;

import com.ycw.photosystem.bean.User;
import com.ycw.photosystem.service.DepartmentService;
import com.ycw.photosystem.service.PermissionService;
import com.ycw.photosystem.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private PermissionService permissionService;

    @RequestMapping("mainUserJsp")
    public ModelAndView mainJsp() {
        ModelAndView modelAndView = new ModelAndView("/user/main");
        modelAndView.addObject("users",userService.getUsersInfo());
        return modelAndView;
    }

    @RequestMapping("addUserJsp")
    public ModelAndView addJsp() {
        ModelAndView modelAndView = new ModelAndView("/user/add");
        modelAndView.addObject("departments", departmentService.getNamesMap());
        modelAndView.addObject("permissions", permissionService.getPermissionMap());
        return modelAndView;
    }
    @RequestMapping("addUserAction")
    public String addUser(HttpServletRequest request) {
        Map userMap=request.getParameterMap();
        userService.addUser(userMap);
        return null;
    }

    @RequestMapping("loginAction")
    public String login(String userName, String password, HttpServletRequest request) throws Exception {
        String message = new String("");
        User user = userService.isUserExisted(userName);
        if (user == null) {
            message = "用户不存在";
            return "/test/fail";
        }else{
            String pw = user.getPassword();
            String un = user.getName();
            if (!pw.equals(password)) {
                message = "密码错误";
                return "/test/fail";
            } else if (userName.equals(un) && password.equals(pw)) {
                HttpSession session = request.getSession();
                session.setAttribute("currentUser",user);
                if (user.getUserPermission() == 1) {
                    return "/jsp/system.jsp";
                } else if (user.getUserPermission() == 2) {
                    return "/jsp/department";
                } else {
                    return "/jsp/normal";
                }
            }else{
                return "/test/fail";
            }
        }
    }


}
