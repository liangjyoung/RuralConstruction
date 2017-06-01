package com.rural.datacolldatadic.service;

import java.util.List;

import com.rural.dao.DataCollDataDicDAO;
import com.rural.dao.DataCollDicEntryDAO;





public class SelDataCollDataEntryService {
private DataCollDicEntryDAO dataCollDicEntryDAO;
	
	public List<?> findByDataCollDataDicId(int a){
		return dataCollDicEntryDAO.findByDataCollDataDicId(a);
	}

	public DataCollDicEntryDAO getDataCollDicEntryDAO() {
		return dataCollDicEntryDAO;
	}

	public void setDataCollDicEntryDAO(DataCollDicEntryDAO dataCollDicEntryDAO) {
		this.dataCollDicEntryDAO = dataCollDicEntryDAO;
	}

	

	

	

}
