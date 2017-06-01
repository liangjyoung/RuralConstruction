package com.rural.govfile.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.rural.bean.GoveFilClfy;
import com.rural.tool.Criterion;

public interface ITownFilService {
 
	public abstract List<GoveFilClfy> getChildPrivance(  );
	public int queryResultsCount(List<Criterion> criteria);
	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria, int from,int length);
	
	public abstract void addTownFil(String GoveFilClfyID,Integer TownBasicInfoID,String TownFilNum,String TownFilName,String TownFilIdef,Date TownFilMadTim,String TownFilPubComp,String TownFilExpl);
	public abstract void updateTownFil(String GoveFilClfyID,Integer TownBasicInfoID,String TownFilID,String TownFilNum,String TownFilName,String TownFilIdef,Date TownFilMadTim,String TownFilPubComp,String TownFilExpl);
	public abstract void delTownFil(String TownFilID);
	public abstract boolean checkTownFilNum(String TownFilNum,String TownFilID);
	public boolean addGoveFilClfy(String GoveFilClfyNum, String GoveFilClfyName);
	public boolean checkGoveFilClfyNumCode1(String GoveFilClfyNum);
	public String delGoveFilClfy1(String GoveFilClfyNum);
}