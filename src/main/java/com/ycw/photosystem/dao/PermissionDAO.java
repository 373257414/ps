package com.ycw.photosystem.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.security.acl.Permission;
import java.util.List;

@Transactional
@Repository
public class PermissionDAO{
	private static final Logger log = LoggerFactory
			.getLogger(PermissionDAO.class);
	public static final String PERMISSION_NAME = "permissionName";
	@Autowired
	private SessionFactory sessionFactory;

	public void test() {
		System.out.println("test in PermissionDAO");
	}

	public void save(Permission transientInstance) {
		log.debug("saving Permission instance");
		try {
			sessionFactory.getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Permission persistentInstance) {
		log.debug("deleting Permission instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Permission findById(java.lang.Integer id) {
		log.debug("getting Permission instance with id: " + id);
		try {
			Permission instance = (Permission) sessionFactory.getCurrentSession().get(	"com.ycw.photosystem.bean.Permission", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}



	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Permission instance with property: " + propertyName+ ", value: " + value);
		try {
			String queryString = "from Permission as model where model."+ propertyName + "= "+value;
			Query query= sessionFactory.getCurrentSession().createQuery(queryString);
			return query.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPermissionName(Object permissionName) {
		return findByProperty(PERMISSION_NAME, permissionName);
	}

	public List findAll() {
		log.debug("finding all Permission instances");
		try {
			String queryString = "from Permission";
			Query query= sessionFactory.getCurrentSession().createQuery(queryString);
			return query.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}


}