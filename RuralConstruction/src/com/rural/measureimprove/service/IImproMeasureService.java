package com.rural.measureimprove.service;

import java.util.HashMap;
import java.util.List;

import com.rural.tool.Criterion;

public interface IImproMeasureService {
	public int queryResultsCount(List<Criterion> criteria);
	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria, int from,int length) ;
	public abstract String addImproMeas(String PrmtMeasID,String PrmtMeas,String PrmtMeasComp,String PrmtMeasValue,String ExpectPrmtSco,String PrmtMeasNote);
	public abstract String editImproMeas(String PrmtMeasID,String PrmtMeas,String PrmtMeasComp,String PrmtMeasValue,String ExpectPrmtSco,String PrmtMeasNote);
	public abstract String delImproMeas(String PrmtMeasID);
	
}
