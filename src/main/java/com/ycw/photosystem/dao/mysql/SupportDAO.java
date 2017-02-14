package com.ycw.photosystem.dao.mysql;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class SupportDAO {
    @Autowired
    private SessionFactory sessionFactory;
    private static final String SCHEMA = "ps";

    public Integer getSerialNumber() {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("SELECT serial_number FROM "+SCHEMA+".support;");
        List<Integer> list = query.list();
        return list.get(0);
    }

    public Integer getYear() {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("SELECT year FROM "+SCHEMA+".support;");
        List<Integer> list = query.list();
        return list.get(0);
    }

    public void updateSerialNumber(int num) {
        sessionFactory.getCurrentSession().createSQLQuery("UPDATE "+SCHEMA+".support SET serial_number =" + num + " WHERE id = 1;").executeUpdate();
    }

    public void updateYear(int year) {
        sessionFactory.getCurrentSession().createSQLQuery("UPDATE "+SCHEMA+".support SET year =" + year + " WHERE id = 1;").executeUpdate();
    }
}
