package com.rural.invgat.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.rural.tool.Criterion;

public interface IInvgatService {

	public abstract ArrayList<HashMap<String, Object>> findAll();
	public int queryResultsCount(List<Criterion> criteria);
	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria, int from,int length);
	public abstract void addInvgat(String invgatNum, Integer eduID,String invgatMajor,Integer sexID,Integer nationID,Integer polID,String invgatName,Date invgatBirth,String invgatComp,String invgatTel);
	public abstract void updateInvgat(Integer id,String invgatNum, Integer eduID,String invgatMajor,Integer sexID,Integer nationID,Integer polID,String invgatName,Date invgatBirth,String invgatComp,String invgatTel);
	public abstract String delInvgat(Integer id);
	public abstract boolean checkInvgatNum(String invgatNum, String id);
}
