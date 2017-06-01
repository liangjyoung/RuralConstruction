package com.rural.expertselect.service;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.rural.bean.ExpertMajorCatg;
import com.rural.tool.Criterion;



public interface IAllExpertService {
 
	public abstract List<ExpertMajorCatg> getAllExpertMajor();
	public int queryResultsCount(List<Criterion> criteria);
	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria, int from,int length);
	public abstract void delEvalExpert(String expertID);
	
	
}
