package com.rural.basicdata.service;

import java.util.HashMap;
import java.util.List;

import com.rural.bean.Sex;
import com.rural.tool.Criterion;

public interface ISexService {

	public int queryResultsCount(List<Criterion> criteria);
	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria, int from,int length);
	public abstract void addsex(String sexCode, String sexName);
	public abstract void updateSex(Integer id, String sexCode, String sexName);
	public abstract  String delSex(Integer id);
	public abstract boolean checkSexCode(String sexCode, String id);
	public Sex getSexById(Integer sexid);
}
