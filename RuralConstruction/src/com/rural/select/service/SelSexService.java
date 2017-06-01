package com.rural.select.service;

import java.util.List;

import com.rural.dao.SexDAO;

public class SelSexService {
	private SexDAO sexDAO;
	
	public List<?>findAll(){
		return sexDAO.findAll();
	}

	public SexDAO getSexDAO() {
		return sexDAO;
	}

	public void setSexDAO(SexDAO sexDAO) {
		this.sexDAO = sexDAO;
	}
}
