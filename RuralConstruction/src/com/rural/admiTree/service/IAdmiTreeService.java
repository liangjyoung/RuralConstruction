package com.rural.admiTree.service;

import java.util.HashMap;
import java.util.List;

import com.rural.bean.CityBasicInfo;
import com.rural.bean.CountryBasicInfo;
import com.rural.bean.TownBasicInfo;
import com.rural.bean.VilBasicInfo;
import com.rural.tool.Criterion;

public interface IAdmiTreeService {
	
public int getProID(String proNum);
	
	public int getCityID(String cityNum);

	List<CityBasicInfo> getCities(String proNum);
	
	public abstract CityBasicInfo getCity(String cityNum);

	List<CountryBasicInfo> getCountries(int cityBasicInfoID);
	
	public CountryBasicInfo getCountry(String countryNum);
	
	public int getCountryID(String countryNum);

	List<TownBasicInfo> getTowns(int countryBasicInfoID);
	
	public int getTownID(String townNum);
	
	public TownBasicInfo getTown(String townNum);
	
	List<VilBasicInfo> getVils(int VilBasicInfoID);
	
	public int getVilID(String vilNum);

	

}
