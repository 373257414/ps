package com.ycw.photosystem.dao;

import com.ycw.photosystem.bean.Permission;
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
public class PermissionDAO{
	private static final Logger log = LoggerFactory
			.getLogger(PermissionDAO.class);
	@Autowired
	private SessionFactory sessionFactory;

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