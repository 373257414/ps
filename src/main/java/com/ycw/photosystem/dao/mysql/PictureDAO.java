package com.ycw.photosystem.dao.mysql;

import com.ycw.photosystem.bean.mysql.Picture;
import com.ycw.photosystem.bean.paper.Paper;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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
    public Integer getPicSumInCategory(int categoryId){
        return (Integer) sessionFactory.getCurrentSession().createCriteria(Picture.class).add(Restrictions.eq("PictureCategory",categoryId)).setProjection(Projections.rowCount()).uniqueResult();
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


    public List findByPaper(Paper paper) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Picture.class);
        int from = (paper.getCurrentPaper() - 1) * paper.getPaperSize();
        int count = from + paper.getPaperSize();
        if (paper.getCategoryId() > 0) {
            criteria.add(Restrictions.eq("PictureCategory", paper.getCategoryId()));
        }
        if (paper.getDepartmentId() > 0) {
            criteria.add(Restrictions.eq("PictureDepartment", paper.getDepartmentId()));
        }
        if (paper.getIds() != null) {
            criteria.add(Restrictions.in("id", paper.getIds()));
        }
        if (paper.isDescOrder() == true) {
            criteria.addOrder(Order.desc("id"));
        }
        return criteria.setFirstResult(from).setMaxResults(count).list();
    }

    public List findByProperty(String propertyName, Object condition) {
        return sessionFactory.getCurrentSession().createCriteria(Picture.class).add(Restrictions.eq(propertyName, condition)).list();
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
}
