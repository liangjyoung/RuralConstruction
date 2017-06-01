package com.rural.villagecompartment.service;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rural.tool.Criterion;

public interface IVillageCompartmentService {
	public abstract ArrayList<HashMap<String, Object>> findAll();
	public int queryResultsCount(List<Criterion> criteria);
	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria, int from,int length);	
	public abstract String delVilBasicInfo(Integer vilBasicInfoId);
	public void addVillage(String vilNum,Integer townNum,String vilName,String vilLongi,
			String vilLati,String vilMeas,String vilPop,String vilHholds,String vilNatural,byte[] vilIntro );
	public abstract void updateVillage(Integer Integer,Integer townBasicInfoId,String vilNum, String vilName,
			String vilLongi, String vilLati, String vilMeas, String vilPop,
			String vilHholds, String vilNatural, byte[] vilIntro); 
	public boolean checkVilNum(String vilNum,String id);
	
	public InputStream exportToExcel();
	public InputStream exportToExcelNow();
}
