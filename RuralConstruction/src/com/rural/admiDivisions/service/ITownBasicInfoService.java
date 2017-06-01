package com.rural.admiDivisions.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rural.tool.Criterion;

public interface ITownBasicInfoService {

	public abstract ArrayList<HashMap<String, Object>> findAll();
	public int queryResultsCount(List<Criterion> criteria);
	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria, int from,int length);
	public abstract String addTownBasicInfo(String townNum,String townName,int countryBasicInfoID ,String townLongi,String townLati,String townMeas,String townPop,String townHholds,byte[] townIntro);
	public abstract String updateTownBasicInfo(int townBasicInfoID,String townNum,String townName,String townLongi,String townLati,String townMeas,String townPop,String townHholds,byte[]townIntro);
	public abstract String delTownBasicInfo(int townBasicInfoID);
	public abstract boolean checkTownNum(String townNum,String townBasicInfoID);
	
	public InputStream exportToExcel();
	public InputStream exportToExcelNow();

}
