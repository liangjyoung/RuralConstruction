package com.rural.basicdata.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rural.tool.Criterion;

public interface IEvalSystStateService {

	public abstract ArrayList<HashMap<String, Object>> findAll();
	public int queryResultsCount(List<Criterion> criteria);
	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria, int from,int length);
	public abstract void addEvalSystState(String evalSystStateNum, String evalSystStateDes);
	public abstract void updateEvalSystState(Integer id,String evalSystStateNum, String evalSystStateDes);
	public abstract String delEvalSystState(Integer id);
	public abstract boolean checkEvalSystStateNum(String evalSystStateNum, String id);
}
