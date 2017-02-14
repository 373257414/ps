package com.ycw.photosystem.dao.mysql.page;

import org.hibernate.SessionFactory;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.metamodel.SingularAttribute;

/**
 * 封装了与页面大小以及当前正在浏览的页面有关的详情
 * 简单模型类，
 * 抽象超类
 */
public abstract class Page {
    public enum SortDirection {
        ASC,
        DESC
    }

    protected int size = -1;
    protected long totalRecords;
    protected SingularAttribute sortAttribute;
    protected SortDirection sortDirection;
    protected SingularAttribute[] allowedAttributes;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public SingularAttribute getSortAttribute() {
        return sortAttribute;
    }

    public void setSortAttribute(SingularAttribute sortAttribute) {
        this.sortAttribute = sortAttribute;
    }

    public SortDirection getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(SortDirection sortDirection) {
        this.sortDirection = sortDirection;
    }

    public SingularAttribute[] getAllowedAttributes() {
        return allowedAttributes;
    }

    public void setAllowedAttributes(SingularAttribute[] allowedAttributes) {
        this.allowedAttributes = allowedAttributes;
    }

    abstract public <T> TypedQuery<T> createQuery(SessionFactory sessionFactory, CriteriaQuery<T> criteriaQuery, Path attributePath);
}
