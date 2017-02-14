package com.ycw.photosystem.dao.mysql;

import com.ycw.photosystem.bean.Department;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DepartmentDAO{
	private static final Logger log = LoggerFactory.getLogger(DepartmentDAO.class);

	public static final String DEPARTMENT_NAME = "name";
	public static final String ADDRESS = "address";
	public static final String CHARGER = "charger";
	public static final String EMAIL = "email";

	@Autowired
	private SessionFactory sessionFactory;


	public void save(Department transientInstance) {
		log.debug("saving Department instance");
		try {
			sessionFactory.getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void update(Department department){
		try{
			sessionFactory.getCurrentSession().update(department);
		}catch (RuntimeException re){
			throw re;
		}
	}

	public void delete(Department persistentInstance) {
		log.debug("deleting Department instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Department findById(java.lang.Integer id) {
		log.debug("getting Department instance with id: " + id);
		try {
			Department instance = (Department) sessionFactory.getCurrentSession().get(
					"com.ycw.photosystem.bean.Department", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}


	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Department instance with property: " + propertyName+ ", value: " + value);
		try {
			String queryString = "from Department as model where model."+ propertyName + "= "+value;
			Query query= sessionFactory.getCurrentSession().createQuery(queryString);
			return query.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDepartmentName(Object departmentName) {
		return findByProperty(DEPARTMENT_NAME, departmentName);
	}

	public List findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List findByCharger(Object charger) {
		return findByProperty(CHARGER, charger);
	}

	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List findAll() {
		log.debug("finding all Department instances");
		try {
			String queryString = "from Department";
			Query query= sessionFactory.getCurrentSession().createQuery(queryString);
			return query.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}