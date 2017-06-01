package com.rural.expertselect.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.rural.bean.CityBasicInfo;
import com.rural.bean.CountryBasicInfo;
import com.rural.bean.ProBasicInfo;
import com.rural.bean.SysRole;
import com.rural.bean.TownBasicInfo;
import com.rural.bean.VilBasicInfo;
import com.rural.tool.Criterion;



public interface IExpertSelectService {
 
int queryResultsCount(List<Criterion> criteria);

List<HashMap<String, Object>> queryByPage(List<Criterion> criteria,
		int from, int length);
public abstract String modify(Integer dfid,String alid);
public abstract String delexpertsel(String EvalExpertDistID);
	
}
