package com.ycw.photosystem.dao.mysql;

import com.ycw.photosystem.bean.mysql.Event;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Event transientInstance) {
        try {
            sessionFactory.getCurrentSession().save(transientInstance);
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public void delete(Event persistentInstance) {
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public Event findById(Integer id) {
        try {
            Event instance = (Event) sessionFactory.getCurrentSession().get(Event.class, id);
            return instance;
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public List findByUserId(Long userId) {
        try {
            return sessionFactory.getCurrentSession().createCriteria(Event.class).add(Restrictions.eq("eventUser", userId)).list();
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public List findAll() {
        try {
            return sessionFactory.getCurrentSession().createCriteria(Event.class).list();
        } catch (RuntimeException re) {
            throw re;
        }
    }


}