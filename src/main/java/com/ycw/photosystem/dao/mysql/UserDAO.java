package com.ycw.photosystem.dao.mysql;

import com.ycw.photosystem.bean.mysql.Picture;
import com.ycw.photosystem.bean.mysql.User;
import com.ycw.photosystem.bean.page.Page;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(User transientInstance) {
        try {
        sessionFactory.getCurrentSession().save(transientInstance);
        }catch (RuntimeException re){
            throw re;
        }
    }

    public void update(User transientInstance) {
        try {
        sessionFactory.getCurrentSession().update(transientInstance);
        }catch (RuntimeException re){
            throw re;
        }
    }

    public void delete(User persistentInstance) {
        try {
        sessionFactory.getCurrentSession().delete(persistentInstance);
        }catch (RuntimeException re){
            throw re;
        }
    }

    public User findById(int id) {
        try {
        return (User) sessionFactory.getCurrentSession().get(User.class, id);
        }catch (RuntimeException re){
            throw re;
        }
    }

    public List findByProperty(String propertyName, Object condition) {
        try {
        return sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq(propertyName, condition)).list();
        }catch (RuntimeException re){
            throw re;
        }
    }

    public List findByUserName(Object userName) {
        try {
        return findByProperty("name", userName);
        }catch (RuntimeException re){
            throw re;
        }
    }

    public List findAll() {
        try {
        return sessionFactory.getCurrentSession().createCriteria(User.class).list();
        }catch (RuntimeException re){
            throw re;
        }
    }

    public List findByPage(Page page){
        try {
            Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
            int from = (page.getCurrentPage() - 1) * page.getPageSize();
            int count = page.getPageSize();
            if (page.getDepartmentId() > 0) {
                criteria.add(Restrictions.eq("userDepartment", page.getDepartmentId()));
            }
            if (page.isDescOrder() == true) {
                criteria.addOrder(Order.desc("id"));
            }
            return criteria.setFirstResult(from).setMaxResults(count).list();
        } catch (RuntimeException re) {
            throw re;
        }
    }
}