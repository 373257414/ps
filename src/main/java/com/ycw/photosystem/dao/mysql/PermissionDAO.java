package com.ycw.photosystem.dao.mysql;

import com.ycw.photosystem.bean.mysql.Permission;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PermissionDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public Permission findById(int id) {
        try {
            return (Permission) sessionFactory.getCurrentSession().get(Permission.class, id);
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public List findAll() {
        try {
            return sessionFactory.getCurrentSession().createCriteria(Permission.class).list();
        } catch (RuntimeException re) {
            throw re;
        }
    }


}