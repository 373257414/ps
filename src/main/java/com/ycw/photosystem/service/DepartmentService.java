package com.ycw.photosystem.service;

import com.ycw.photosystem.bean.Department;
import com.ycw.photosystem.dao.DepartmentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class DepartmentService {
    @Autowired
    private DepartmentDAO departmentDAO;

    public void add(Department department) {
        if (department.equals(null)) {
            return;
        }
        departmentDAO.save(department);
    }
    public void update(Department department){
    }

    public List<Department> getDepartments() {
        return departmentDAO.findAll();
    }

    public Map getNamesMap() {
        List<Department> list = departmentDAO.findAll();
        if (list.isEmpty()) {
            return null;
        }
        HashMap map = new HashMap();
        for (Department d : list) {
            map.put(d.getId(), d.getName());
        }
        return map;
    }
}
