package com.rural.basicdata.service;

import java.util.HashMap;
import java.util.List;

import com.rural.tool.Criterion;

public interface IInvesObjAttriService {

	public abstract void addInvesObjAttri(String invesObjAttriNum, String invesObjAttriName);

	public abstract String delInvesObjAttri(Integer id);

	public abstract void updateInvesObjAttri(Integer id,String invesObjAttriNum, String invesObjAttriName);

	public abstract int queryResultsCount(List<Criterion> criteria);

	public abstract List<HashMap<String, Object>> queryByPage(List<Criterion> criteria,int from, int length);
	
	public abstract boolean checkInvesObjAttriNum(String invesObjAttriNum, String id);
}
