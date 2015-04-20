package com.til.spring.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.til.spring.dao.UserURLTableDAO;
import com.til.spring.model.UserURLTable;

@Service
public class UserURLTableServiceImpl implements UserURLTableService {
	
	private UserURLTableDAO userURLTableDAO;
	

	public void setUserURLTableDAO(UserURLTableDAO userURLTableDAO) {
		this.userURLTableDAO = userURLTableDAO;
	}

	@Override
	@Transactional
	public void addUserUrl(UserURLTable p) {
		this.userURLTableDAO.addUserUrl(p);
	}

	@Override
	@Transactional
	public void updateUserUrl(UserURLTable p) {
		this.userURLTableDAO.updateUserUrl(p);
	}


	@Override
	@Transactional
	public UserURLTable getUserUrlById(int id) {
		return this.userURLTableDAO.getUserUrlById(id);
	}



}
