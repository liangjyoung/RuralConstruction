package com.rural.datacolldatadic.service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import com.rural.tool.Criterion;


public interface IDataCollDicEntryService {
	
	public int queryResultsCount(List<Criterion> criteria);
	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria, int from,int length);
	public abstract String addDataCollDicEntry(String dicEntryCode,String dataCollDataDicId,String dicEntryName);
	public abstract void updateDataCollDicEntry(int dataCollDicEntryId,String dicEntryCode, String dicEntryName);
	public abstract String delDataCollDicEntry(int dataCollDicEntryId);
	
	public abstract boolean checkEntryCode(String dicEntryCode,String dataCollDicEntryId);
	
	public InputStream exportToExcel();
	
	public InputStream exportToExcelNow();

}
