package com.rural.datacolldatadic.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rural.tool.Criterion;


public interface IDataCollDataDicService {
	
	public abstract ArrayList<HashMap<String, Object>> findAll();
	public int queryResultsCount(List<Criterion> criteria);
	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria, int from,int length);
	public abstract void addDataCollDataDic(String dataDicCode, String dataDicName,boolean isdChoDic);
	public abstract void updateDataCollDataDic(int dataCollDataDicId,String dataDicCode, String dataDicName,boolean isdChoDic);
	public abstract String delDataCollDataDic(int dataCollDataDicId);
	
	
	public abstract boolean checkDicCode(String dataDicCode,String dataCollDataDicId);
	public abstract boolean checkDicCode(String dataDicCode,String dataCollDataDicId,String oper);
	
	public InputStream exportToExcel();
	public InputStream exportToExcelNow();

}
