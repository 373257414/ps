package com.ycw.photosystem.service;

import com.ycw.photosystem.bean.mysql.Department;
import com.ycw.photosystem.bean.mysql.User;
import com.ycw.photosystem.dao.mysql.DepartmentDAO;
import com.ycw.photosystem.dao.mysql.PermissionDAO;
import com.ycw.photosystem.dao.mysql.UserDAO;
import com.ycw.photosystem.info.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private PermissionDAO permissionDAO;
    @Autowired
    private DepartmentDAO departmentDAO;

    public int getUserPermission(int userId) {
        return userDAO.findById(userId).getUserPermission();
    }

    private UserInfo user2UserInfo(User user) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(user.getId());
        userInfo.setName(user.getName());
        userInfo.setNickname(user.getNickname());
        userInfo.setCreateTime(user.getCreateTime());
        userInfo.setDepartment(user.getUserDepartment().getName());
        userInfo.setPermission(permissionDAO.findById(user.getUserPermission()).getName());
        return userInfo;
    }

    public List getUsersInfo() {
        List<User> list = userDAO.findAll();
        List<UserInfo> infoList = new ArrayList<>();
        for (User user : list) {
            UserInfo userInfo = user2UserInfo(user);
            infoList.add(userInfo);
        }
        return infoList;
    }

    public List getUsersInfo(Integer departmentId) {
        Department department = departmentDAO.findById(departmentId);
        List<User> list = (List) department.getUsers();
        List<UserInfo> infoList = new ArrayList<>();
        for (User user : list) {
            UserInfo userInfo = user2UserInfo(user);
            infoList.add(userInfo);
        }
        return infoList;
    }

    public void addUser(Map<String, String[]> userMap) {
        String userName = userMap.get("userName")[0];
        String password = userMap.get("password")[0];
        Integer departmentId = Integer.valueOf(userMap.get("departmentId")[0]);
        Integer permissionId = Integer.valueOf(userMap.get("permissionId")[0]);
        if (userName.isEmpty() || password.isEmpty() || departmentId.equals(null) || permissionId.equals(null)) {
            return;
        }
        User user = new User();
        user.setName(userName);
        user.setPassword(password);
        user.setUserPermission(permissionId);
        user.setUserDepartment(departmentDAO.findById(departmentId));
        user.setNickname(userMap.get("nickname")[0]);
        user.setCreateTime(new Timestamp(System.currentTimeMillis()));
        userDAO.save(user);
    }

    public void changeNickname(int id, String nickname) {
        User user = userDAO.findById(id);
        user.setNickname(nickname);
        userDAO.update(user);
    }

    public String changePassword(User user, String oldPassword, String newPassword) {
        if (oldPassword.equals(user.getPassword())) {
            user.setPassword(newPassword);
            userDAO.update(user);
            return "密码修改成功";
        } else {
            return "密码错误";
        }
    }

    public String changeEmail(User user, String newEmail) {
        user.setEmail(newEmail);
        userDAO.update(user);
        return "邮箱修改成功";
    }


    public boolean deleteUser(int id) {
        User user = userDAO.findById(id);
        if (user == null) {
            return false;
        } else {
            userDAO.delete(user);
            return true;
        }
    }

    public User isUserExisted(String userName) {
        List users = userDAO.findByUserName(userName);
        if (users.isEmpty()) {
            return null;
        } else {
            return (User) users.get(0);
        }
    }
    //省略成员方法


    public List findAll() {
        return userDAO.findAll();
    }
}