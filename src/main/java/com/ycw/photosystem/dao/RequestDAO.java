package com.ycw.photosystem.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.omg.CORBA.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class RequestDAO{
	private static final Logger log = LoggerFactory.getLogger(RequestDAO.class);

	public static final String REQUEST_MSG = "requestMsg";
	public static final String IS_CHECKED = "isChecked";
	@Autowired
	private SessionFactory sessionFactory;

	public void save(Request transientInstance) {
		log.debug("saving Request instance");
		try {
			sessionFactory.getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Request persistentInstance) {
		log.debug("deleting Request instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Request findById(java.lang.Integer id) {
		log.debug("getting Request instance with id: " + id);
		try {
			Request instance = (Request) sessionFactory.getCurrentSession().get("com.ycw.photosystem.bean.Request", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Request instance with property: " + propertyName+ ", value: " + value);
		try {
			String queryString = "from Request as model where model."
					+ propertyName + "="+value;
			Query query= sessionFactory.getCurrentSession().createQuery(queryString);
			return query.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
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
		log.debug("finding all Request instances");
		try {
			String queryString = "from Request";
			Query query= sessionFactory.getCurrentSession().createQuery(queryString);
			return query.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}