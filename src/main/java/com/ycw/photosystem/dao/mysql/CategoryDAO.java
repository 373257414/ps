package com.ycw.photosystem.dao.mysql;

import com.ycw.photosystem.bean.mysql.Category;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void save(Category transientInstance) {
        try {
            sessionFactory.getCurrentSession().save(transientInstance);
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public void update(Category transientInstance) {
        try {
            sessionFactory.getCurrentSession().update(transientInstance);
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public void delete(Category persistentInstance) {
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public Category findById(int id) {
        try {
            return (Category) sessionFactory.getCurrentSession().get(Category.class, id);
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public List findAll() {
        try {
            return sessionFactory.getCurrentSession().createCriteria(Category.class).list();
        } catch (RuntimeException re) {
            throw re;
        }
    }
}