package com.til.spring.dao;

import java.util.List;

import com.til.spring.model.SystemURLTable;

public interface SystemURLTableDAO {

	public void addSystemUrl(SystemURLTable p);
	public void updateSystemUrl(SystemURLTable p);
	public SystemURLTable getSystemUrlById(int id);
	
	public List<SystemURLTable> listUrls();
}
