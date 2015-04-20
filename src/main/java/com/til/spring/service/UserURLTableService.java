package com.til.spring.service;

import com.til.spring.model.UserURLTable;

public interface UserURLTableService {

	public void addUserUrl(UserURLTable p);
	public void updateUserUrl(UserURLTable p);
	public UserURLTable getUserUrlById(int id);	
}
