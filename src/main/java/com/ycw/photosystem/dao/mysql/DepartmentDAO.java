package com.ycw.photosystem.dao.mysql;

import com.ycw.photosystem.bean.mysql.Department;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentDAO {

    @Autowired
    private SessionFactory sessionFactory;


    public void save(Department transientInstance) {
        try {
            sessionFactory.getCurrentSession().save(transientInstance);
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public void update(Department department) {
        try {
            sessionFactory.getCurrentSession().update(department);
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public void delete(Department persistentInstance) {
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public Department findById(int id) {
        try {
            return (Department) sessionFactory.getCurrentSession().get(Department.class, id);
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public List findAll() {
        try {
            return sessionFactory.getCurrentSession().createCriteria(Department.class).list();
        } catch (RuntimeException re) {
            throw re;
        }
    }
}