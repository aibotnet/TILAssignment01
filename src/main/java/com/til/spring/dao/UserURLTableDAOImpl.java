package com.til.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.til.spring.model.UserURLTable;

@Repository
public class UserURLTableDAOImpl implements UserURLTableDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(UserURLTableDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addUserUrl(UserURLTable p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Person saved successfully, Person Details="+p);
	}

	@Override
	public void updateUserUrl(UserURLTable p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Person updated successfully, Person Details="+p);
	}


	@Override
	public UserURLTable getUserUrlById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		UserURLTable p = (UserURLTable) session.load(UserURLTable.class, new Integer(id));
		logger.info("Person loaded successfully, Person details="+p);
		return p;
	}

}
