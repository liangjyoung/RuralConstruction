package com.rural.select.service;

import java.util.List;

import com.rural.dao.EduDAO;

public class SelEduService {

	private EduDAO eduDAO;
	
	public List<?>findAll(){
		return eduDAO.findAll();
	}

	public EduDAO getEduDAO() {
		return eduDAO;
	}

	public void setEduDAO(EduDAO eduDAO) {
		this.eduDAO = eduDAO;
	}
}
