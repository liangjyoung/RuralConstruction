package com.rural.admiDivisions.service;
import java.util.ArrayList;
import java.util.List;

import com.rural.bean.CountryBasicInfo;
import com.rural.bean.VilBasicInfo;
import com.rural.dao.CityBasicInfoDAO;
import com.rural.dao.CountryBasicInfoDAO;
import com.rural.dao.CountryContDAO;
import com.rural.dao.CountryFilDAO;
import com.rural.dao.TownBasicInfoDAO;

public class CountrytreeService {
	
	private CountryBasicInfoDAO countryBasicInfoDAO = new CountryBasicInfoDAO();
	
	

	public List<CountryBasicInfo> getChildPrivance() {
		// TODO Auto-generated method stub
		List<CountryBasicInfo> list = new ArrayList<CountryBasicInfo>();
		list = this.countryBasicInfoDAO.findAll();
		return list;
	}

	

	public CountryBasicInfoDAO getCountryBasicInfoDAO() {
		return countryBasicInfoDAO;
	}

	public void setCountryBasicInfoDAO(CountryBasicInfoDAO countryBasicInfoDAO) {
		this.countryBasicInfoDAO = countryBasicInfoDAO;
	}
	
	
	
	
	
	


}
