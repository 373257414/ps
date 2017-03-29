package com.ycw.photosystem.service;

import com.ycw.photosystem.bean.mysql.User;
import com.ycw.photosystem.bean.page.Page;
import com.ycw.photosystem.dao.mysql.DepartmentDAO;
import com.ycw.photosystem.dao.mysql.PermissionDAO;
import com.ycw.photosystem.dao.mysql.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
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


    public List getUserByPage(Page page) {
        return userDAO.findByPage(page);
    }

    public User addUser(Map infoMap) {
        User user = new User();
        user.setName((String) infoMap.get("name"));
        user.setPassword((String) infoMap.get("password"));
        user.setUserPermission((Integer) infoMap.get("permissionId"));
        Integer departmentId = (Integer) infoMap.get("departmentId");
        if (departmentId != null) {
            user.setUserDepartment(departmentDAO.findById(departmentId));
        }
        user.setNickname((String) infoMap.get("nickname"));
        user.setCreateTime(new Timestamp(System.currentTimeMillis()));
        userDAO.save(user);
        return user;
    }

    public User updateUser(Map infoMap) {
        User user = userDAO.findById((Integer) infoMap.get("id"));
        if (!StringUtils.isEmpty(infoMap.get("name"))) {
            user.setName((String) infoMap.get("name"));
        }
        if (!StringUtils.isEmpty(infoMap.get("password"))) {
            user.setPassword((String) infoMap.get("password"));
        }
        if (infoMap.get("permissionId") != null) {
            user.setUserPermission((Integer) infoMap.get("permissionId"));
        }
        if (infoMap.get("departmentId") != null) {
            user.setUserDepartment(departmentDAO.findById((Integer) infoMap.get("departmentId")));
        }
        if (!StringUtils.isEmpty(infoMap.get("nickname"))) {
            user.setNickname((String) infoMap.get("nickname"));
        }
        userDAO.update(user);
        return user;
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


    public List getAll() {
        return userDAO.findAll();
    }


    /*private UserInfo user2UserInfo(User user) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(user.getId());
        userInfo.setName(user.getName());
        userInfo.setNickname(user.getNickname());
        userInfo.setCreateTime(user.getCreateTime());
        userInfo.setDepartment(user.getUserDepartment().getName());
        userInfo.setPermission(permissionDAO.findById(user.getUserPermission()).getName());
        return userInfo;
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
    }*/
}