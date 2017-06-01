package com.rural.admiDivisions.service;

import java.util.List;

import com.rural.dao.TownBasicInfoDAO;

public class SelTownBasicInfoService {
private TownBasicInfoDAO townBasicInfoDAO;
	
	public List<?>findAll(){
		return townBasicInfoDAO.findAll();
	}

	public TownBasicInfoDAO getTownBasicInfoDAO() {
		return townBasicInfoDAO;
	}

	public void setTownBasicInfoDAO(TownBasicInfoDAO townBasicInfoDAO) {
		this.townBasicInfoDAO = townBasicInfoDAO;
	}

}
