package com.ycw.photosystem.service;

import com.ycw.photosystem.bean.mysql.Permission;
import com.ycw.photosystem.dao.mysql.PermissionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PermissionService {
    @Autowired
    private PermissionDAO permissionDAO;

    public List getPermissionMap() {
        List<Permission> list = permissionDAO.findAll();
        return list;
    }

}
