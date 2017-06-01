package com.rural.budgetpro.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.rural.bean.BudgProCatg;
import com.rural.tool.Criterion;

public interface IBudgetProService {

	public abstract ArrayList<HashMap<String, Object>> findAll();
	public abstract List<BudgProCatg> getChildPermissions( String parentId ); 
	public int queryResultsCount(List<Criterion> criteria);
	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria, int from,int length);

	public abstract void addBudgProUprice( String BudgProCatgNum ,String budgProUpriceNum,String budgProName,double budgProUprice,String budgProUpriceComp,String budgProUpriceExpl);
	public abstract void updateBudgProUprice(String BudgProCatgNum ,String budgProUpriceID,String budgProUpriceNum,String budgProName,double budgProUprice,String budgProUpriceComp,String budgProUpriceExpl);
	public abstract void delBudgProUprice(Integer budgProUpriceID);
	public abstract boolean checkBudgProUpriceNum(String budgProUpriceNum,String budgProUpriceID);
	

}
