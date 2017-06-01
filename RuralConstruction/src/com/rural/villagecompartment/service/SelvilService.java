package com.rural.villagecompartment.service;

import java.util.List;

import com.rural.dao.DataCollDataDicDAO;
import com.rural.dao.VilBasicInfoDAO;





public class SelvilService {
private VilBasicInfoDAO vilBasicInfoDAO;
	
	public List<?>findAll(){
		return vilBasicInfoDAO.findAll();
	}

	public VilBasicInfoDAO getVilBasicInfoDAO() {
		return vilBasicInfoDAO;
	}

	public void setVilBasicInfoDAO(VilBasicInfoDAO vilBasicInfoDAO) {
		this.vilBasicInfoDAO = vilBasicInfoDAO;
	}

	

	

	

}
