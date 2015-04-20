package com.til.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.til.spring.dao.SystemURLTableDAO;
import com.til.spring.model.SystemURLTable;

@Service
public class SystemURLTableServiceImpl implements SystemURLTableService{
	
	private SystemURLTableDAO systemURLTableDAO;

	
	public void setSystemURLTableDAO(SystemURLTableDAO systemURLTableDAO) {
		this.systemURLTableDAO = systemURLTableDAO;
	}

	@Override
	@Transactional
	public void addSystemUrl(SystemURLTable p) {
		this.systemURLTableDAO.addSystemUrl(p);
	}

	@Override
	@Transactional
	public void updateSystemUrl(SystemURLTable p) {
		this.systemURLTableDAO.updateSystemUrl(p);
	}


	@Override
	@Transactional
	public SystemURLTable getSystemUrlById(int id) {
		return this.systemURLTableDAO.getSystemUrlById(id);
	}

	@Override
	@Transactional
	public List<SystemURLTable> listUrls() {
		return this.systemURLTableDAO.listUrls();
	}

	
}
