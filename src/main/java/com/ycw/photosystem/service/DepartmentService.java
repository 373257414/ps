package com.ycw.photosystem.service;

import com.ycw.photosystem.bean.mysql.Department;
import com.ycw.photosystem.dao.mysql.DepartmentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class DepartmentService {
    @Autowired
    private DepartmentDAO departmentDAO;

    public Department add(Map parametersMap) {
        Department department = new Department();
        departmentDAO.save(parametersSetter(parametersMap, department));
        return department;
    }

    public Department update(Map parametersMap) {
        int id = (int) parametersMap.get("id");
        Department department = departmentDAO.findById(id);
        if (department != null) {
            departmentDAO.save(parametersSetter(parametersMap, department));
            return department;
        } else {
            return null;
        }
    }

    public List getAll() {
        return departmentDAO.findAll();
    }

    public List getUsersByDepartmentId(int departmentId) {
        Department department = departmentDAO.findById(departmentId);
        if (department != null) {
            return (List) department.getUsers();
        } else {
            return null;
        }
    }

    private Department parametersSetter(Map parametersMap, Department department) {
        String name = (String) parametersMap.get("name");
        if (StringUtils.isEmpty(name)) {
            department.setName(name);
        }
        String address = (String) parametersMap.get("address");
        if (StringUtils.isEmpty(address)) {
            department.setAddress(address);
        }
        String charger = (String) parametersMap.get("charger");
        if (StringUtils.isEmpty(charger)) {
            department.setCharger(charger);
        }
        String email = (String) parametersMap.get("email");
        if (StringUtils.isEmpty(email)) {
            department.setEmail(email);
        }
        return department;
    }
}
