package com.rural.select.service;

import java.util.List;

import com.rural.dao.VilBasicInfoDAO;
import com.rural.dao.TownBasicInfoDAO;
import com.rural.dao.CityBasicInfoDAO;
import com.rural.dao.CountryBasicInfoDAO;

public class SelBeloDiviService {

	private VilBasicInfoDAO vilBasicInfoDAO;
	private TownBasicInfoDAO townBasicInfoDAO;
	private CountryBasicInfoDAO countryBasicInfoDAO;
	private CityBasicInfoDAO cityBasicInfoDAO;
	
	public List<?>findAll1(){
		return vilBasicInfoDAO.findAll();
	}
	
	public List<?>findAll2(){
		return townBasicInfoDAO.findAll();
	}
	
	public List<?>findAll3(){
		return countryBasicInfoDAO.findAll();
	}
	
	public List<?>findAll4(){
		return cityBasicInfoDAO.findAll();
	}

	public VilBasicInfoDAO getVilBasicInfoDAO() {
		return vilBasicInfoDAO;
	}

	public void setVilBasicInfoDAO(VilBasicInfoDAO vilBasicInfoDAO) {
		this.vilBasicInfoDAO = vilBasicInfoDAO;
	}

	public TownBasicInfoDAO getTownBasicInfoDAO() {
		return townBasicInfoDAO;
	}

	public void setTownBasicInfoDAO(TownBasicInfoDAO townBasicInfoDAO) {
		this.townBasicInfoDAO = townBasicInfoDAO;
	}

	public CountryBasicInfoDAO getCountryBasicInfoDAO() {
		return countryBasicInfoDAO;
	}

	public void setCountryBasicInfoDAO(CountryBasicInfoDAO countryBasicInfoDAO) {
		this.countryBasicInfoDAO = countryBasicInfoDAO;
	}

	public CityBasicInfoDAO getCityBasicInfoDAO() {
		return cityBasicInfoDAO;
	}

	public void setCityBasicInfoDAO(CityBasicInfoDAO cityBasicInfoDAO) {
		this.cityBasicInfoDAO = cityBasicInfoDAO;
	}

	
	
}
