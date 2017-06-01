package com.rural.govfile.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.rural.bean.GoveFilClfy;
import com.rural.tool.Criterion;

public interface IVilFilService {
 
	public abstract List<GoveFilClfy> getChildPrivance(  );
	public int queryResultsCount(List<Criterion> criteria);
	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria, int from,int length);
	public abstract void addVilFil(String GoveFilClfyID,Integer VilBasicInfoID,String VilFilNum,String VilFilName,String VilFilIdef,Date VilFilMadTim,String VilFilPubComp,String VilFilExpl);
	public abstract void updateVilFil(String GoveFilClfyID,Integer VilBasicInfoID,String VilFilID,String VilFilNum,String VilFilName,String VilFilIdef,Date VilFilMadTim,String VilFilPubComp,String VilFilExpl);
	public abstract void delVilFil(String VilFilID);
	public abstract boolean checkVilFilNum(String VilFilNum,String VilFilID);
	public boolean addGoveFilClfy(String GoveFilClfyNum, String GoveFilClfyName);
	public boolean checkGoveFilClfyNumCode1(String GoveFilClfyNum);
	public String delGoveFilClfy1(String GoveFilClfyNum);
}