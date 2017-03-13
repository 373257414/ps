package com.ycw.photosystem.dao.mysql;

import com.ycw.photosystem.bean.mysql.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAO {

    public static final String USER_NAME = "name";
    @Autowired
    private SessionFactory sessionFactory;

    public void save(User transientInstance) {
        sessionFactory.getCurrentSession().save(transientInstance);
    }

    public void update(User transientInstance) {
        sessionFactory.getCurrentSession().update(transientInstance);
    }

    public void delete(User persistentInstance) {
        sessionFactory.getCurrentSession().delete(persistentInstance);
    }

    public User findById(java.lang.Integer id) {
        return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }

    public List findByProperty(String propertyName, Object condition) {
        return sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq(propertyName, condition)).list();
    }

    public List findByUserName(Object userName) {
        return findByProperty(USER_NAME, userName);
    }

    public List findAll() {
        return sessionFactory.getCurrentSession().createCriteria(User.class).list();
    }
    public List findAllBySQL(){
        String queryString = "from User";
        Query query= sessionFactory.getCurrentSession().createQuery(queryString);
        return query.list();
    }
}