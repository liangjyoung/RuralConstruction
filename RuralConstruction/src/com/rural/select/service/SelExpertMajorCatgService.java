package com.rural.select.service;

import java.util.List;

import com.rural.dao.ExpertMajorCatgDAO;

public class SelExpertMajorCatgService {
	private ExpertMajorCatgDAO expertMajorCatgDAO;
	
	public List<?>findAll(){
		return expertMajorCatgDAO.findAll();
	}

	public ExpertMajorCatgDAO getExpertMajorCatgDAO() {
		return expertMajorCatgDAO;
	}

	public void setExpertMajorCatgDAO(ExpertMajorCatgDAO expertMajorCatgDAO) {
		this.expertMajorCatgDAO = expertMajorCatgDAO;
	}
}
