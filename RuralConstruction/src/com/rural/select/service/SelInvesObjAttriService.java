package com.rural.select.service;

import java.util.List;

import com.rural.dao.InvesObjAttriDAO;

public class SelInvesObjAttriService {
	private InvesObjAttriDAO invesObjAttriDAO;
	
	public List<?>findAll(){
		return invesObjAttriDAO.findAll();
	}

	public InvesObjAttriDAO getInvesObjAttriDAO() {
		return invesObjAttriDAO;
	}

	public void setInvesObjAttriDAO(InvesObjAttriDAO invesObjAttriDAO) {
		this.invesObjAttriDAO = invesObjAttriDAO;
	}
}
