package com.rural.colldatatemplet.service;

import java.util.HashMap;
import java.util.List;

import com.rural.tool.Criterion;

public interface IInvesObjService {

	int queryResultsCount(List<Criterion> criteria);

	List<HashMap<String, Object>> queryByPage(List<Criterion> criteria,
			int from, int length);
	public void updateInvesObj(Integer invesObjID,Integer dataCollDataDicId, Integer invesObjAttriId, String invesProNum, String invesObjCode,String invesObjName, 
			String invesObjComp,String  invesObjLengt,boolean isMus,String invesObjNote);


	public boolean addInvesObj( Integer dataCollDataDicId, Integer invesObjAttriId, String invesProNum, String invesObjCode,String invesObjName, 
			String invesObjComp,String  invesObjLengt,boolean isMus,String invesObjNote);
	public String delInvesObj(Integer invesObjID);
	public boolean objCodeCheck(String invesObjCode,String id);
}
