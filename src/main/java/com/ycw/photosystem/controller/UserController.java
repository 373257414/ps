package com.ycw.photosystem.controller;

import com.ycw.photosystem.bean.User;
import com.ycw.photosystem.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    final String SUCCESS = null;
    final String ERROR = null;
    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    public void test() {
        log.warn("test here");
        System.out.println("test/here");
    }

    @RequestMapping("/update")
    public String update(String userName, int departmentId, int permissionId, String password) throws Exception {
        User user = userService.isUserExisted(userName);
        if ((user) != null) {
            userService.updateUser(user, departmentId, permissionId, password);
            return SUCCESS;
        } else {
            //errorMsg = "�û�������";
        }
        return ERROR;
    }
    /*public String execute() throws Exception {
        String result;
		result = userService.deleteUser(userName) ? SUCCESS : ERROR;
		return result;
	}*/



	/*public String execute() throws Exception {
        if (userService.isUserExisted(userName)==null) {
			userService.addUser(departmentId, permissionId, userName, password);
			return SUCCESS;
		}else{
			errorMsg="�û����Ѵ���";
			return ERROR;
		}
	}*/

	/*public String execute() throws Exception {
		user = userService.isUserExisted(userName);
		if ((user) != null) {
			userService.updateUser(user, departmentId, permissionId, password);
			return SUCCESS;
		} else {
			errorMsg = "�û�������";
		}
		return ERROR;
	}*/

    @RequestMapping("/login")
    public String login(String userName, String password, HttpServletRequest request) throws Exception {
        System.out.println(userName);
        String message = new String("");
        if (userService == null) {
            System.out.print("userService为空");
            return SUCCESS;
        }
        User user = userService.isUserExisted(userName);
        if (user == null) {
            message = "用户不存在";
            System.out.println(message);
            return ERROR;
        }
        if (user != null) {
            String pw = user.getPassword();
            String un = user.getName();
            int userId = user.getId();
            int permissionId = user.getUserPermission();
            if (!pw.equals(password)) {
                System.out.println(message);
                message = "密码错误";
                return ERROR;
            } else if (userName.equals(un) && password.equals(pw)) {
                message = "密码：" + pw + " 用户名：" + un;
                HttpSession session = request.getSession();
                session.setAttribute("userId", userId);
                session.setAttribute("userName", un);
                session.setAttribute("permissionId", permissionId);
                System.out.println(message);
                if (permissionId == 1) {
                    return "system";
                } else if (permissionId == 2) {
                    return "department";
                } else {
                    return "normal";
                }
            }
        }
        return null;
    }


}
