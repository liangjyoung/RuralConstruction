package com.rural.expert.service;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.rural.bean.ExpertMajorCatg;
import com.rural.tool.Criterion;



public interface IExpertService {
 
	public abstract List<ExpertMajorCatg> getAllExpertMajor();
	public int queryResultsCount(List<Criterion> criteria);
	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria, int from,int length);

	public abstract void addEvalExpert( String MajorCatgID ,String expertNum,String expertName,String sexId,String expertTitle,String expertWorkTel,String expertMobTel,Date expertBirth,String expertAddress);
	public abstract void updateEvalExpert(String MajorCatgID ,String expertID,String expertNum,String expertName,String sexId,String expertTitle,String expertWorkTel,String expertMobTel,Date expertBirth,String expertAddress);
	public abstract String delEvalExpert(Integer expertID);
	public abstract boolean checkExpertNum(String expertNum,String expertID);
	
}
