package com.ycw.photosystem.service;

import com.ycw.photosystem.bean.Permission;
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

    public Map getPermissionMap() {
        List<Permission> list = permissionDAO.findAll();
        if (list.isEmpty()) {
            return null;
        }
        HashMap map = new HashMap();
        for (Permission p : list) {
            map.put(p.getId(), p.getName());
        }
        return map;
    }

}
