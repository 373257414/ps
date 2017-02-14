package com.ycw.photosystem.dao.mysql;

import com.ycw.photosystem.bean.Picture;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PictureDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Picture transientInstance) {
        sessionFactory.getCurrentSession().save(transientInstance);
    }

    public void update(Picture transientInstance) {
        sessionFactory.getCurrentSession().update(transientInstance);
    }

    public void delete(Picture persistentInstance) {
        sessionFactory.getCurrentSession().delete(persistentInstance);
    }

    public Picture findById(Long id) {
        return (Picture) sessionFactory.getCurrentSession().get(Picture.class, id);
    }


    public Long getTotalCount(){
        return (Long) sessionFactory.getCurrentSession().createCriteria(Picture.class).setProjection(Projections.rowCount()).uniqueResult();
    }

    public Long getMinId(){
        return (Long) sessionFactory.getCurrentSession().createCriteria(Picture.class).setProjection(Projections.min("id")).uniqueResult();
    }

    public Long getMaxId(){
        return (Long) sessionFactory.getCurrentSession().createCriteria(Picture.class).setProjection(Projections.max("id")).uniqueResult();
    }

    public List findFromTO(Long fromId,Long toId){
        return sessionFactory.getCurrentSession().createCriteria(Picture.class)
                .add(Restrictions.between("id",fromId,toId)).list();
    }

    public List findByIds(Long[] ids) {
        return sessionFactory.getCurrentSession().createCriteria(Picture.class).add(Restrictions.in("id", ids)).list();
    }

    public List findByIds(Long[] ids, Boolean ascOrder) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Picture.class).add(Restrictions.in("id", ids));
        if (ascOrder == true) {
            criteria.addOrder(Order.asc("id"));
        } else {
            criteria.addOrder(Order.desc("id"));
        }
        return criteria.list();
    }
    public List findByCategory(int cid, int from, int count){
        return sessionFactory.getCurrentSession().createCriteria(Picture.class)
                .add(Restrictions.eq("pictureCategory", cid))
                .setFirstResult(from)
                .setMaxResults(count).list();
    }

}