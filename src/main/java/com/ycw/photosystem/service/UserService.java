package com.ycw.photosystem.service;


import com.ycw.photosystem.bean.User;
import com.ycw.photosystem.dao.DepartmentDAO;
import com.ycw.photosystem.dao.PermissionDAO;
import com.ycw.photosystem.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public int getUserDepartment(int userId) {
        return userDAO.findById(userId).getUserDepartment().getId();
    }

    public boolean addUser(int departmentId, int permissionId, String userName,String password) {
        User user = new User();
        user.setUserPermission(permissionId);
        user.setUserDepartment(departmentDAO.findById(departmentId));
        user.setName(userName);
        user.setPassword(password);
        userDAO.save(user);
        return true;
    }

    public boolean updateUser(User user, int departmentId, int permissionId, String password) {

        user.setPassword(password);
        user.setUserPermission(permissionId);
        user.setUserDepartment(departmentDAO.findById(departmentId));
        userDAO.update(user);
        return true;
    }

    public boolean deleteUser(String userName) {
        User user = this.isUserExisted(userName);
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
}
