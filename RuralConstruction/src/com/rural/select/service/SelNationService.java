package com.rural.select.service;

import java.util.List;

import com.rural.dao.NationDAO;

public class SelNationService {

	private NationDAO nationDAO;
	
	public List<?>findAll(){
		return nationDAO.findAll();
	}

	public NationDAO getNationDAO() {
		return nationDAO;
	}

	public void setNationDAO(NationDAO nationDAO) {
		this.nationDAO = nationDAO;
	}
}
