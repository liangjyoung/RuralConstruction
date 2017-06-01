package com.rural.select.service;

import java.util.List;

import com.rural.dao.PolDAO;

public class SelPolService {
	private PolDAO polDAO;
	
	public List<?>findAll(){
		return polDAO.findAll();
	}

	public PolDAO getPolDAO() {
		return polDAO;
	}

	public void setPolDAO(PolDAO polDAO) {
		this.polDAO = polDAO;
	}
}
