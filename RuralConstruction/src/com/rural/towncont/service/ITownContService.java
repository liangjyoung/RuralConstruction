package com.rural.towncont.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rural.tool.Criterion;


public interface ITownContService {
	
	public abstract ArrayList<HashMap<String, Object>> findAll();
	public int queryResultsCount(List<Criterion> criteria);
	public int queryResultsCount(int townBasicInfoID,List<Criterion> criteria);
	//public int queryResultsCount(int townBasicInfoID,List<Criterion> criteria);
	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria, int from,int length);
	public List<HashMap<String, Object>> queryByPage(int townContIDtownBasicInfoID,List<Criterion> criteria, int from,int length);
	public abstract void addTownCont(int townBasicInfoID,String townContNum,String townContName,String townContWorkTel,String townContMobTel,String townComp, String townPost, String townNote);
	public abstract void updateTownCont(int townContID,String townContNum,String townContName,String townContWorkTel,String townContMobTel,String townComp, String townPost, String townNote);
	public abstract void delTownCont(int townContID);
	
	public int getTownID(String townNum);
	
	public abstract boolean checkTownContNum(String townContNum,String townContID);


}
