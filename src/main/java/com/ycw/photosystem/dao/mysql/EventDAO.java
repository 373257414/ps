package com.ycw.photosystem.dao.mysql;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.util.List;

@Repository
public class EventDAO{

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

	public Event findById(java.lang.Integer id) {
		try {
			Event instance = (Event) sessionFactory.getCurrentSession().get("com.ycw.photosystem.bean.mysql.Event", id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from Event as model where model."+ propertyName + "= "+value;
			Query query= sessionFactory.getCurrentSession().createQuery(queryString);
			return query.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List findAll() {
		try {
			String queryString = "from Event";
			Query query= sessionFactory.getCurrentSession().createQuery(queryString);
			return query.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}


}