package com.ycw.photosystem.dao.mysql;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.omg.CORBA.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RequestDAO {
    private static final Logger log = LoggerFactory.getLogger(RequestDAO.class);

    public static final String REQUEST_MSG = "requestMsg";
    public static final String IS_CHECKED = "isChecked";
    @Autowired
    private SessionFactory sessionFactory;

    public void save(Request transientInstance) {
        try {
            sessionFactory.getCurrentSession().save(transientInstance);
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public void delete(Request persistentInstance) {
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public Request findById(java.lang.Integer id) {
        try {
            Request instance = (Request) sessionFactory.getCurrentSession().get("com.ycw.photosystem.bean.mysql.Request", id);
            return instance;
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public List findByProperty(String propertyName, Object value) {
        try {
            String queryString = "from Request as model where model."
                    + propertyName + "=" + value;
            Query query = sessionFactory.getCurrentSession().createQuery(queryString);
            return query.list();
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public List findByRequestMsg(Object requestMsg) {
        return findByProperty(REQUEST_MSG, requestMsg);
    }

    public List findByIsChecked(Object isChecked) {
        return findByProperty(IS_CHECKED, isChecked);
    }

    public List findAll() {
        try {
            String queryString = "from Request";
            Query query = sessionFactory.getCurrentSession().createQuery(queryString);
            return query.list();
        } catch (RuntimeException re) {
            throw re;
        }
    }
}