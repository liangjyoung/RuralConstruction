package com.rural.invgatdwork.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rural.bean.Invgat;
import com.rural.bean.VilBasicInfo;
import com.rural.tool.Criterion;


public interface IInvgatDworkService {
	//public abstract ArrayList<HashMap<String, Object>> findAll();
	public int queryResultsCount(List<Criterion> criteria);
	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria, int from,int length);
	public abstract String addInvgatDwork( int invgatID,int vilBasicInfoID);
	public abstract boolean isAdd(int vilBasicInfoID);
	//public abstract void updateInvgatDwork( int invgatID,int vilID);
	public abstract void delInvgatDwork(int invgatDworkID);
	//public abstract boolean checkInvgatNum(String invgatNum);
	
	
	public int getVilID(String vilNum);
	
	
	public abstract VilBasicInfo getVil(int vilBasicInfoID);


}
