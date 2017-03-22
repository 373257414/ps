package com.ycw.photosystem.dao.mysql;

import com.ycw.photosystem.bean.mysql.Picture;
import com.ycw.photosystem.bean.page.Page;
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
        try {
            sessionFactory.getCurrentSession().save(transientInstance);
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public void update(Picture transientInstance) {
        try {
            sessionFactory.getCurrentSession().update(transientInstance);
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public void delete(Picture persistentInstance) {
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public Picture findById(Long id) {
        try {
            return (Picture) sessionFactory.getCurrentSession().get(Picture.class, id);
        } catch (RuntimeException re) {
            throw re;
        }
    }


    public Long findSum() {
        try {
            return (Long) sessionFactory.getCurrentSession().createCriteria(Picture.class).setProjection(Projections.rowCount()).uniqueResult();
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public Long findSumByCategoryId(int categoryId) {
        try {
            return (Long) sessionFactory.getCurrentSession().createCriteria(Picture.class).add(Restrictions.eq("pictureCategory", categoryId)).setProjection(Projections.rowCount()).uniqueResult();
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public Long findMinId() {
        try {
            return (Long) sessionFactory.getCurrentSession().createCriteria(Picture.class).setProjection(Projections.min("id")).uniqueResult();
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public Long findMaxId() {
        try {
            return (Long) sessionFactory.getCurrentSession().createCriteria(Picture.class).setProjection(Projections.max("id")).uniqueResult();
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public List findFromTO(Long fromId, Long toId) {
        try {
            return sessionFactory.getCurrentSession().createCriteria(Picture.class)
                    .add(Restrictions.between("id", fromId, toId)).list();
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public List findByIds(Long[] ids) {
        try {
            return sessionFactory.getCurrentSession().createCriteria(Picture.class).add(Restrictions.in("id", ids)).list();
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public List findByIds(Long[] ids, Boolean ascOrder) {
        try {
            Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Picture.class).add(Restrictions.in("id", ids));
            if (ascOrder == true) {
                criteria.addOrder(Order.asc("id"));
            } else {
                criteria.addOrder(Order.desc("id"));
            }
            return criteria.list();
        } catch (RuntimeException re) {
            throw re;
        }
    }


    public List findByPage(Page page) {
        try {
            Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Picture.class);
            int from = (page.getCurrentPage() - 1) * page.getPageSize();
            int count = page.getPageSize();
            if (page.getCategoryId() > 0) {
                criteria.add(Restrictions.eq("pictureCategory", page.getCategoryId()));
            }
            if (page.getDepartmentId() > 0) {
                criteria.add(Restrictions.eq("pictureDepartment", page.getDepartmentId()));
            }
            if (page.getIds() != null) {
                criteria.add(Restrictions.in("id", page.getIds()));
            }
            if (page.isDescOrder() == true) {
                criteria.addOrder(Order.desc("id"));
            }
            return criteria.setFirstResult(from).setMaxResults(count).list();
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public List findByProperty(String propertyName, Object condition) {
        try {
            return sessionFactory.getCurrentSession().createCriteria(Picture.class).add(Restrictions.eq(propertyName, condition)).list();
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public List findByPropertiesAnd(Map<String, String> propertiesMap) {
        try {
        return sessionFactory.getCurrentSession().createCriteria(Picture.class).add(Restrictions.allEq(propertiesMap)).list();
        }catch (RuntimeException re){
            throw re;
        }
    }

    public List findByPropertiesOr(Map<String, String> propertiesMap) {
        try {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Picture.class);
            Set<Map.Entry<String, String>> propertiesEntrySet = propertiesMap.entrySet();
            Disjunction disjunction = Restrictions.disjunction();
            for (Map.Entry<String, String> entry : propertiesEntrySet) {
                disjunction.add(Restrictions.eq(entry.getKey(), entry.getValue()));
            }
            return criteria.add(disjunction).list();
        }catch (RuntimeException re){
            throw re;
        }
    }
}
