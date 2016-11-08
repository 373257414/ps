package com.ycw.photosystem.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class SupportDAO{
	@Autowired
	private SessionFactory sessionFactory;
	public Integer getSerialNumber() {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction =session.beginTransaction();
		Query query=session.createSQLQuery("SELECT serial_number FROM photodb.support;");
		List<Integer> list=query.list();
		transaction.commit();
		session.close();
		return list.get(0);
	}

	public Integer getYear() {
		Session session =sessionFactory.getCurrentSession();
		Transaction transaction =session.beginTransaction();
		Query query=session.createSQLQuery("SELECT year FROM photodb.support;");
		List<Integer> list=query.list();
		transaction.commit();
		session.close();
		return list.get(0);
	}

	public void updateSerialNumber(int num){
		Session session =sessionFactory.getCurrentSession();
		Transaction transaction =session.beginTransaction();
		session.createSQLQuery("UPDATE photodb.support SET serial_number ="+num+" WHERE id = 0;").executeUpdate();
		transaction.commit();
		session.close();
	}
	public void updateYear(int year){
		Session session =sessionFactory.getCurrentSession();
		Transaction transaction =session.beginTransaction();
		session.createSQLQuery("UPDATE photodb.support SET year ="+year+" WHERE id = 0;").executeUpdate();
		transaction.commit();
		session.close();
	}
}
