package com.rural.villageColldData.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.rural.bean.VilDataCollRec;
import com.rural.tool.Criterion;

public interface IColldDataJILUService {
	public abstract void addColldDataJILU( int VilBasicInfoID,int InvgatID,String CollEqptCode,Date CollTim,String CilDataCollRecNote);
	public abstract void delColldDataJILU(int VilDataCollRecId);
	public abstract void ediColldDataJILU(int VilDataCollRecId,  int VilBasicInfoID, int InvgatID,String CollEqptCode,Date CollTim,String CilDataCollRecNote);
	public int queryResultsCount(List<Criterion> criteria);
	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria, int from,int length);
	//public abstract ArrayList<HashMap<String, Object>> findAll();
	public abstract List<VilDataCollRec> getChildPrivance(  );
	
	
	 
	//public abstract List<InvesPro> getChildInvesPro( String parentId );  
	//public abstract List<InvesPro> getChildInvesPro(  );
}