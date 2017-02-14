package com.ycw.photosystem.dao.mysql;

import com.ycw.photosystem.bean.Category;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CategoryDAO {
    private static final Logger log = LoggerFactory.getLogger(CategoryDAO.class);
    public static final String CATEGORY_NAME = "categoryName";
    @Autowired
    private SessionFactory sessionFactory;

    public void save(Category transientInstance) {
        sessionFactory.getCurrentSession().save(transientInstance);
    }

    public void delete(Category persistentInstance) {
        sessionFactory.getCurrentSession().delete(persistentInstance);
    }

    public Category findById(java.lang.Integer id) {
        Category instance = (Category) sessionFactory.getCurrentSession().get(Category.class, id);
        return instance;
    }

    public List findByProperty(String propertyName, Object value) {

        String queryString = "from Category as model where model." + propertyName + "= " + value;
        Query query = sessionFactory.getCurrentSession().createQuery(queryString);
        return query.list();
    }

    public List findByCategoryName(Object categoryName) {
        return findByProperty(CATEGORY_NAME, categoryName);
    }

    public List findAll() {
        String queryString = "from Category";
        Query query = sessionFactory.getCurrentSession().createQuery(queryString);
        return query.list();
    }
}