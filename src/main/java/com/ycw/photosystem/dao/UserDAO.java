package com.ycw.photosystem.dao;

import com.ycw.photosystem.bean.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class UserDAO {
    private static final Logger log = LoggerFactory.getLogger(UserDAO.class);

    public static final String USER_NAME = "name";
    public static final String PASSWORD = "password";
    @Autowired
    private SessionFactory sessionFactory;

    public void save(User transientInstance) {
        log.debug("saving User instance");
        try {
            sessionFactory.getCurrentSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void update(User transientInstance) {
        log.debug("updating User instance");
        try {
            sessionFactory.getCurrentSession().update(transientInstance);
            log.debug("update successful");
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public void delete(User persistentInstance) {
        log.debug("deleting User instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public User findById(java.lang.Integer id) {
        log.debug("getting User instance with id: " + id);
        try {
            User instance = (User) sessionFactory.getCurrentSession().get(
                    "com.ycw.photosystem.bean.User", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    public List findByProperty(String propertyName, Object value) {
        log.debug("finding User instance with property: " + propertyName
                + ", value: " + value);
        try {
            String queryString = "from User as model where model."
                    + propertyName + "= \'" + value + "\'";
            Query query = sessionFactory.getCurrentSession().createQuery(queryString);
            return query.list();
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }
    }

    public List findByUserName(Object userName) {
        return findByProperty(USER_NAME, userName);
    }

    public List findByPassword(Object password) {
        return findByProperty(PASSWORD, password);
    }

    public List findAll() {
        log.debug("finding all User instances");
        try {
            String queryString = "from User";
            Query query = sessionFactory.getCurrentSession().createQuery(queryString);
            return query.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }
}