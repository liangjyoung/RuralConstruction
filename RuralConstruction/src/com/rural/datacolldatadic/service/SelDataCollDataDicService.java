package com.rural.datacolldatadic.service;

import java.util.List;

import com.rural.dao.DataCollDataDicDAO;





public class SelDataCollDataDicService {
private DataCollDataDicDAO dataCollDataDicDAO;
	
	public List<?>findAll(){
		return dataCollDataDicDAO.findAll();
	}

	public DataCollDataDicDAO getDataCollDataDicDAO() {
		return dataCollDataDicDAO;
	}

	public void setDataCollDataDicDAO(DataCollDataDicDAO dataCollDataDicDAO) {
		this.dataCollDataDicDAO = dataCollDataDicDAO;
	}

	

	

}
