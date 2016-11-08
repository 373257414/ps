package com.ycw.photosystem.dao;

import com.ycw.photosystem.bean.Picture;
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
public class PictureDAO{
	private static final Logger log = LoggerFactory.getLogger(PictureDAO.class);
	public static final String PICTURE_NAME = "pictureName";
	public static final String PATH = "path";
	public static final String WATERMARK_PATH = "watermarkPath";
	@Autowired
	private SessionFactory sessionFactory;

	public void save(Picture transientInstance) {
		log.debug("saving Picture instance");
		try {
			sessionFactory.getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	public void update(Picture transientInstance) {
		log.debug("updating Picture instance");
		try {
			sessionFactory.getCurrentSession().update(transientInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}

	public void delete(Picture persistentInstance) {
		log.debug("deleting Picture instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Picture findById(java.lang.Integer id) {
		log.debug("getting Picture instance with id: " + id);
		try {
			Picture instance = (Picture) sessionFactory.getCurrentSession().get("com.ycw.photosystem.bean.Picture", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}


	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Picture instance with property: " + propertyName+ ", value: " + value);
		try {
			String queryString = "from Picture as model where model."+ propertyName + "= "+value;
			Query query= sessionFactory.getCurrentSession().createQuery(queryString);
			return query.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPictureName(Object pictureName) {
		return findByProperty(PICTURE_NAME, pictureName);
	}

	public List findByPath(Object path) {
		return findByProperty(PATH, path);
	}

	public List findByWatermarkPath(Object watermarkPath) {
		return findByProperty(WATERMARK_PATH, watermarkPath);
	}

	public List findAll() {
		log.debug("finding all Picture instances");
		try {
			String queryString = "from Picture";
			Query query= sessionFactory.getCurrentSession().createQuery(queryString);
			return query.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}


}