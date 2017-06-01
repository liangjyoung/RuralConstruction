package com.rural.invgatdwork.service;

import java.util.HashMap;
import java.util.List;

import com.rural.bean.CityBasicInfo;
import com.rural.bean.CountryBasicInfo;
import com.rural.bean.ProBasicInfo;
import com.rural.bean.TownBasicInfo;
import com.rural.bean.VilBasicInfo;
import com.rural.tool.Criterion;

public interface IDistrictService {
	
	public int getProID(String proNum);
	
	public int getCityID(String cityNum);
	
	public int getCountryID(String countryNum);
	
	public int getTownID(String townNum);

	List<CityBasicInfo> getCities(String proNum);

	List<CountryBasicInfo> getCountries(int cityBasicInfoID);
	
    List<TownBasicInfo> getTowns(int countryBasicInfoID);
	
	List<VilBasicInfo> getVils(int VilBasicInfoID);
	
	public  CityBasicInfo getCity(String cityNum);
	
	public CountryBasicInfo getCountry(String countryNum);
	
	public TownBasicInfo getTown(String townNum);
	

	
	
	

}
