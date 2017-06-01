package com.rural.admiDivisions.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rural.tool.Criterion;


public interface ICountryBasicInfoService {
	
	public abstract ArrayList<HashMap<String, Object>> findAll();
	public int queryResultsCount(List<Criterion> criteria);
	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria, int from,int length);
	public abstract String addCountryBasicInfo(String countryNum,String countryName,int cityBasicInfoID, String countryLongi,String countryLati,String countryMeas,String countryPop,String countryHholds,byte[] countryIntro);
	public abstract String updateCountryBasicInfo(int countryBasicInfoID,String countryNum,String countryName, String countryLongi,String countryLati,String countryMeas,String countryPop,String countryHholds,byte[]countryIntro);
	public abstract String  delCountryBasicInfo(int countryBasicInfoID);
	
	public abstract boolean checkCountryNum(String countryNum,String countryBasicInfoID);
	
	public InputStream exportToExcel();
	public InputStream exportToExcelNow();

}
