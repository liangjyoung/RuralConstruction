package com.rural.admiDivisions.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rural.tool.Criterion;

public interface ICityBasicInfoService {
	
	
	public abstract ArrayList<HashMap<String, Object>> findAll();
	public int queryResultsCount(List<Criterion> criteria);
	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria, int from,int length);
	public abstract String addCityBasicInfo(String cityNum,String cityName,int proBasicInfoID, String cityLongi,String cityLati,String cityMeas,String cityPop,String cityHholds,byte[] cityIntro);
	public abstract String updateCityBasicInfo(int cityBasicInfoID,String cityNum,String cityName, String cityLongi,String cityLati,String cityMeas,String cityPop,String cityHholds,byte[]cityIntro);
	public abstract String delCityBasicInfo(int cityBasicInfoID);
	
	public abstract boolean checkCityNum(String cityNum,String cityBasicInfoID); 
	
	public abstract int getProID(String proNum);
	
	public InputStream exportToExcel();
	public InputStream exportToExcelNow();

}
