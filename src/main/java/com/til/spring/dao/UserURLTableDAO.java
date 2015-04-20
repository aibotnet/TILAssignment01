package com.til.spring.dao;


import com.til.spring.model.UserURLTable;

public interface UserURLTableDAO {

	public void addUserUrl(UserURLTable p);
	public void updateUserUrl(UserURLTable p);
	public UserURLTable getUserUrlById(int id);
}
