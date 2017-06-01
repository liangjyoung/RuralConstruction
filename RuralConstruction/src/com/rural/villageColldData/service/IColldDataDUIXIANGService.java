package com.rural.villageColldData.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.rural.bean.InvesPro;
import com.rural.tool.Criterion;
import com.rural.villageColldData.action.ColldDataDUIXIANGAction;

public interface IColldDataDUIXIANGService {
	public abstract String addColldDataDUIXIANG(int VilDataCollRecId);
	public abstract String addColldDataDUIXIANG1(int InvesObjDataId,int InvesObjId,int VilDataCollRecId,String DataCollDicEntryId,String old1);
	public abstract String addColldDataDUIXIANG3(int InvesObjDataId,int InvesObjId,int VilDataCollRecId,String old2,String old1);
	public abstract boolean isAdd(int DataCollDicEntryId);
	public abstract void delColldDataDUIXIANG(int InvesObjDataId);
	public abstract void ediColldDataDUIXIANG(int InvesObjDataId,String InvesObjDataValu,String InvesObjNote);
	//public abstract void ediColldDataDUIXIANG1(int InvesObjDataId,int InvesObjId,int VilDataCollRecId,int DataCollDicEntryId);
	public int queryResultsCount(List<Criterion> criteria);
	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria, int from,int length);
	//public abstract ArrayList<HashMap<String, Object>> findAll();
	//public abstract List<VilBasicInfo> getChildPrivance(  );
	public abstract boolean isAdd1(int VilDataCollRecId);
	//public abstract List<InvesObj> getObj(String parentId);
	public abstract String DDD(String sss);
	public abstract String UploadApps(String Apps1);
	public abstract List<InvesPro> getChildPermissions(String parentId );  
	//public abstract List<InvesPro> getChildInvesPro( String parentId );  
	//public abstract List<InvesPro> getChildInvesPro(  );
	public String UploadData(String filed) throws SQLException;
	public abstract String UploadFile(String vfile1, int InvesObjId, int VilDataCollRecId);
}