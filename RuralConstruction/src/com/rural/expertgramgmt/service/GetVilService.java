package com.rural.expertgramgmt.service;

import java.util.List;

import com.rural.bean.CityBasicInfo;
import com.rural.bean.CountryBasicInfo;
import com.rural.bean.TownBasicInfo;
import com.rural.bean.VilBasicInfo;
import com.rural.dao.CityBasicInfoDAO;
import com.rural.dao.CountryBasicInfoDAO;
import com.rural.dao.TownBasicInfoDAO;
import com.rural.dao.VilBasicInfoDAO;

public class GetVilService implements IGetVilService {
	private CityBasicInfoDAO cityBasicInfoDAO = new CityBasicInfoDAO();
	private CountryBasicInfoDAO countryBasicInfoDAO = new CountryBasicInfoDAO();
	private TownBasicInfoDAO townBasicInfoDAO = new TownBasicInfoDAO();
	private VilBasicInfoDAO vilBasicInfoDAO = new VilBasicInfoDAO();

	@SuppressWarnings("unchecked")
	public List<CountryBasicInfo> getCountriesByCityId(Integer cityBasicInfoId) {
		// TODO Auto-generated method stub
		return countryBasicInfoDAO.findByProperty("cityBasicInfo.cityBasicInfoId", cityBasicInfoId);
	}

	@SuppressWarnings("unchecked")
	public List<TownBasicInfo> getTownsByCountryId(Integer countryBasicInfoId) {
		// TODO Auto-generated method stub
		return townBasicInfoDAO.findByProperty("countryBasicInfo.countryBasicInfoId", countryBasicInfoId);
	}

	@SuppressWarnings("unchecked")
	public List<VilBasicInfo> getVilsByTownId(Integer townBasicInfoId) {
		// TODO Auto-generated method stub
		return vilBasicInfoDAO.findByProperty("townBasicInfo.townBasicInfoId", townBasicInfoId);
	}

	@SuppressWarnings("unchecked")
	public List<CityBasicInfo> getCitiesByProId(int proid) {
		// TODO Auto-generated method stub
		return cityBasicInfoDAO.findByProperty("proBasicInfo.proBasicInfoId", proid);
	}

	public Integer getCityIdByCityNum(String diviCode) {
		// TODO Auto-generated method stub
		return ((CityBasicInfo)cityBasicInfoDAO.findByCityNum("'"+diviCode+"'").get(0)).getCityBasicInfoId();
	}

	public Integer getCountryIdByCountryNum(String diviCode) {
		// TODO Auto-generated method stub
		return ((CountryBasicInfo)countryBasicInfoDAO.findByCountryNum("'"+diviCode+"'").get(0)).getCountryBasicInfoId();
	}

	public Integer getTownIdByTownNum(String diviCode) {
		// TODO Auto-generated method stub
		return ((TownBasicInfo)townBasicInfoDAO.findByTownNum("'"+diviCode+"'").get(0)).getTownBasicInfoId();
	}

	public CityBasicInfoDAO getCityBasicInfoDAO() {
		return cityBasicInfoDAO;
	}

	public void setCityBasicInfoDAO(CityBasicInfoDAO cityBasicInfoDAO) {
		this.cityBasicInfoDAO = cityBasicInfoDAO;
	}

	public CountryBasicInfoDAO getCountryBasicInfoDAO() {
		return countryBasicInfoDAO;
	}

	public void setCountryBasicInfoDAO(CountryBasicInfoDAO countryBasicInfoDAO) {
		this.countryBasicInfoDAO = countryBasicInfoDAO;
	}

	public TownBasicInfoDAO getTownBasicInfoDAO() {
		return townBasicInfoDAO;
	}

	public void setTownBasicInfoDAO(TownBasicInfoDAO townBasicInfoDAO) {
		this.townBasicInfoDAO = townBasicInfoDAO;
	}

	public VilBasicInfoDAO getVilBasicInfoDAO() {
		return vilBasicInfoDAO;
	}

	public void setVilBasicInfoDAO(VilBasicInfoDAO vilBasicInfoDAO) {
		this.vilBasicInfoDAO = vilBasicInfoDAO;
	}


}
