package com.ycw.photosystem.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.util.List;

@Transactional
@Repository
public class EventDAO{
	private static final Logger log = LoggerFactory.getLogger(EventDAO.class);
	public static final String EVENT_MSG = "eventMsg";
	@Autowired
	private SessionFactory sessionFactory;

	public void save(Event transientInstance) {
		log.debug("saving Event instance");
		try {
			sessionFactory.getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Event persistentInstance) {
		log.debug("deleting Event instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Event findById(java.lang.Integer id) {
		log.debug("getting Event instance with id: " + id);
		try {
			Event instance = (Event) sessionFactory.getCurrentSession().get("com.ycw.photosystem.bean.Event", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Event instance with property: " + propertyName+ ", value: " + value);
		try {
			String queryString = "from Event as model where model."+ propertyName + "= "+value;
			Query query= sessionFactory.getCurrentSession().createQuery(queryString);
			return query.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByEventMsg(Object eventMsg) {
		return findByProperty(EVENT_MSG, eventMsg);
	}

	public List findAll() {
		log.debug("finding all Event instances");
		try {
			String queryString = "from Event";
			Query query= sessionFactory.getCurrentSession().createQuery(queryString);
			return query.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}


}