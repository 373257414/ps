package com.ycw.photosystem.dao;

import com.ycw.photosystem.bean.Category;
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
public class CategoryDAO{
	private static final Logger log = LoggerFactory.getLogger(CategoryDAO.class);
	public static final String CATEGORY_NAME = "categoryName";
	@Autowired
	private SessionFactory sessionFactory;

	public void save(Category transientInstance) {
		log.debug("saving Category instance");
		try {
			sessionFactory.getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Category persistentInstance) {
		log.debug("deleting Category instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Category findById(java.lang.Integer id) {
		log.debug("getting Category instance with id: " + id);
		try {
			Category instance = (Category) sessionFactory.getCurrentSession().get(
					"com.ycw.photosystem.bean.Category", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Category instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Category as model where model."
					+ propertyName + "= "+value;
			Query query= sessionFactory.getCurrentSession().createQuery(queryString);
			return query.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCategoryName(Object categoryName) {
		return findByProperty(CATEGORY_NAME, categoryName);
	}

	public List findAll() {
		log.debug("finding all Category instances");
		try {
			String queryString = "from Category";
			Query query= sessionFactory.getCurrentSession().createQuery(queryString);
			return query.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}