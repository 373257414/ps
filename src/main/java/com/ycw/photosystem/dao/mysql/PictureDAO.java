package com.ycw.photosystem.dao.mysql;

import com.ycw.photosystem.bean.Picture;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

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


    public Long getTotalCount() {
        return (Long) sessionFactory.getCurrentSession().createCriteria(Picture.class).setProjection(Projections.rowCount()).uniqueResult();
    }

    public Long getMinId() {
        return (Long) sessionFactory.getCurrentSession().createCriteria(Picture.class).setProjection(Projections.min("id")).uniqueResult();
    }

    public Long getMaxId() {
        return (Long) sessionFactory.getCurrentSession().createCriteria(Picture.class).setProjection(Projections.max("id")).uniqueResult();
    }

    public List findFromTO(Long fromId, Long toId) {
        return sessionFactory.getCurrentSession().createCriteria(Picture.class)
                .add(Restrictions.between("id", fromId, toId)).list();
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

    public List findByPropertiesAnd(Map<String, String> propertiesMap) {
        return sessionFactory.getCurrentSession().createCriteria(Picture.class).add(Restrictions.allEq(propertiesMap)).list();
    }

    public List findByPropertiesOr(Map<String, String> propertiesMap) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Picture.class);
        Set<Map.Entry<String, String>> propertiesEntrySet = propertiesMap.entrySet();
        Disjunction disjunction = Restrictions.disjunction();
        for (Map.Entry<String, String> entry : propertiesEntrySet) {
            disjunction.add(Restrictions.eq(entry.getKey(), entry.getValue()));
        }
        return criteria.add(disjunction).list();
    }

    public List findByCategory(int cid, int from, int count) {
        return sessionFactory.getCurrentSession().createCriteria(Picture.class)
                .add(Restrictions.eq("pictureCategory", cid))
                .setFirstResult(from)
                .setMaxResults(count).list();
    }

    public List findByProperty(String propertyName, String condition) {
        return sessionFactory.getCurrentSession().createCriteria(Picture.class).add(Restrictions.eq(propertyName, condition)).list();
    }

    public List findByFileNumber(String fileNumber) {
        return sessionFactory.getCurrentSession().createCriteria(Picture.class).add(Restrictions.eq("fileNumber", fileNumber)).list();
    }

}