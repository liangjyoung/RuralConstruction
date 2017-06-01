package com.rural.townAverage.service;

import java.util.HashMap;
import java.util.List;

import com.rural.bean.EvalSystInd;
import com.rural.tool.Criterion;

public interface ITownAverageService {

	public int queryResultsCount(List<Criterion> criteria);
	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria, int from,int length);
	
	public abstract List<EvalSystInd> getChildPermissions( String parentId ); 
	public int getVilDataCollRecId(int year);
	public int getVilEvalScoId(int vilDataCollRecId);
	public String getEvalIndNum(int vilEvalScoId);
	public int getEvalSystId(String evalIndNum);
	public int getEvalSystIndId(int year);
	
	public String getLevelsIndAver(String townNum,int year,String evalIndNum);
	
	public String getLevelsIndLastAver(int  evalContId);
}
