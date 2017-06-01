package com.rural.invgat.service;

import java.util.List;

import com.rural.dao.DataCollDataDicDAO;
import com.rural.dao.InvgatDAO;





public class SelinvgatService {
private InvgatDAO invgatDAO;
	
	public List<?>findAll(){
		return invgatDAO.findAll();
	}

	public InvgatDAO getInvgatDAO() {
		return invgatDAO;
	}

	public void setInvgatDAO(InvgatDAO invgatDAO) {
		this.invgatDAO = invgatDAO;
	}



	

	

}
