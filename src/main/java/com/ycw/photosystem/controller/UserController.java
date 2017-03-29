package com.ycw.photosystem.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ycw.photosystem.bean.mysql.User;
import com.ycw.photosystem.bean.page.Page;
import com.ycw.photosystem.service.DepartmentService;
import com.ycw.photosystem.service.PermissionService;
import com.ycw.photosystem.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    private static String message = "";
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private PermissionService permissionService;


    @RequestMapping("getAllUser")
    @ResponseBody
    public List getAllUser() {
        return userService.getAll();
    }

    @RequestMapping("getUserData")
    @ResponseBody
    public List getUserByPage(int currentPage) {
        Page page = new Page();
        page.setCurrentPage(currentPage);
        page.setPageSize(20);
        return userService.getUserByPage(page);
    }

    @RequestMapping("addUser")
    @ResponseBody
    public String addUser(HttpServletRequest request) {
        if (userService.isUserExisted(request.getParameter("username")) != null) {
            return "username is not available";
        }
        Map infoMap = new HashMap();
        infoMap.put("name", request.getParameter("username"));
        infoMap.put("password", request.getParameter("password"));
        infoMap.put("departmentId", request.getParameter("department"));
        infoMap.put("permissionId", request.getParameter("permission"));
        infoMap.put("nickname", request.getParameter("nickname"));
        infoMap.put("email", request.getParameter("email"));
        User user = userService.addUser(infoMap);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "error";
        }
    }
    @RequestMapping("editUser")
    @ResponseBody
    public String updateUser(HttpServletRequest request) {
        Map infoMap = new HashMap();
        infoMap.put("id",request.getParameter("userId"));
        infoMap.put("departmentId", request.getParameter("department"));
        infoMap.put("permissionId", request.getParameter("permission"));
        User user = userService.updateUser(infoMap);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "error";
        }
    }



    @RequestMapping("editSelfUserInfo")
    public String updateSelfUser(HttpServletRequest request) {
        String oldPassword = request.getParameter("oldPassword");
        String newPassword1 = request.getParameter("newPassword1");
        String newPassword2 = request.getParameter("newPassword2");
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        if (currentUser.equals(null)) {
            message = "当前用户错误";
        }
        if (!newPassword1.equals(newPassword2)) {
            message = "新密码不匹配";
        } else {
            message = userService.changePassword(currentUser, oldPassword, newPassword1);
        }
        return "/jsp/functions/userInformation";
    }


    @RequestMapping("updateEmailAction")
    public String updateEmail(HttpServletRequest request) {
        String password = request.getParameter("password");
        String newEmail = request.getParameter("newEmail");
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        if (currentUser.equals(null)) {
            message = "当前用户错误";
        }
        if (!currentUser.getPassword().equals(password)) {
            message = "密码错误";
        } else {
            message = userService.changeEmail(currentUser, newEmail);
        }
        return "/jsp/functions/userInformation";
    }

    @RequestMapping("loginAction")
    public String login(HttpServletRequest request) throws Exception {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        message = new String("");
        User user = userService.isUserExisted(userName);
        if (user == null) {
            message = "用户不存在";
            return "/test/fail";
        } else {
            String pw = user.getPassword();
            String un = user.getName();
            if (!pw.equals(password)) {
                message = "密码错误";
                return "/test/fail";
            } else if (userName.equals(un) && password.equals(pw)) {
                HttpSession session = request.getSession();
                session.setAttribute("currentUser", user);
                if (user.getUserPermission() == 1) {
                    return "/jsp/users/system";
                } else if (user.getUserPermission() == 2) {
                    return "/jsp/users/department";
                } else {
                    return "/jsp/users/normal";
                }
            } else {
                return "/test/fail";
            }
        }
    }

    /*@RequestMapping("mainUserJsp")
    public ModelAndView mainJsp() {
        ModelAndView modelAndView = new ModelAndView("/user/main");
        modelAndView.addObject("users", userService.getUsersInfo());
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
        Map userMap = request.getParameterMap();
        userService.addUser(userMap);
        return null;
    }*/


}
