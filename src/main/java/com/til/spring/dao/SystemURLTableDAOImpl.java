package com.til.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.til.spring.dao.SystemURLTableDAO;
import com.til.spring.model.SystemURLTable;

@Repository
public class SystemURLTableDAOImpl implements SystemURLTableDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(UserURLTableDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addSystemUrl(SystemURLTable p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Person saved successfully, Person Details="+p);
	}

	@Override
	public void updateSystemUrl(SystemURLTable p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Person updated successfully, Person Details="+p);
	}


	@Override
	public SystemURLTable getSystemUrlById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		SystemURLTable p = (SystemURLTable) session.load(SystemURLTableDAO.class, new Integer(id));
		logger.info("Person loaded successfully, Person details="+p);
		return p;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SystemURLTable> listUrls() {
		Session session = this.sessionFactory.getCurrentSession();
		List<SystemURLTable> UrlList = session.createQuery("from SystemURLTable").list();
		for(SystemURLTable p : UrlList){
			System.out.println(p);
			logger.info("URL List::"+p);
		}
		return UrlList;
	}

}
