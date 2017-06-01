package com.rural.evalsystem.service;

import java.util.HashMap;
import java.util.List;

import com.rural.tool.Criterion;

public interface IEvalMethObjService {
	public int queryResultsCount(List<Criterion> criteria);
	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria, int from,int length) ;
	public abstract String addInvesObj(String EvalMethID, String InvesObjid);
}
