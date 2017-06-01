package com.rural.budgetpro.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rural.bean.BudgProCatg;
import com.rural.bean.BudgProUprice;


import com.rural.budgetpro.action.BudgetProAction;
import com.rural.dao.BudgProCatgDAO;
import com.rural.dao.BudgProUpriceDAO;
import com.rural.tool.Criterion;

public class BudgetProService implements IBudgetProService {
	
	private BudgProCatgDAO budgProCatgDAO = new BudgProCatgDAO();
	private BudgProUpriceDAO budgProUpriceDAO = new BudgProUpriceDAO();
	
	public BudgProCatgDAO getBudgProCatgDAO() {
		return budgProCatgDAO;
	}

	public void setBudgProCatgDAO(BudgProCatgDAO budgProCatgDAO) {
		this.budgProCatgDAO = budgProCatgDAO;
	}

	public BudgProUpriceDAO getBudgProUpriceDAO() {
		return budgProUpriceDAO;
	}

	public void setBudgProUpriceDAO(BudgProUpriceDAO budgProUpriceDAO) {
		this.budgProUpriceDAO = budgProUpriceDAO;
	}

	public ArrayList<HashMap<String, Object>> findAll() {
		// TODO Auto-generated method stub
		List<BudgProCatg> list = new ArrayList<BudgProCatg>();
		String s = "asd";
		list = this.budgProCatgDAO.findByProperty("UpBudgProCatgNum", s);
		ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for (BudgProCatg a : list) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			
			map.put("passwordModify",a.getBudgProCatgNum());

			result.add(map);
		}
		return result;
	}

	public List<BudgProCatg> getChildPermissions(String parentId) {
		// TODO Auto-generated method stub
		List<BudgProCatg> list = new ArrayList<BudgProCatg>();
		if (parentId==null) {
			list = this.budgProCatgDAO.findFather();
		}else{
			list = this.budgProCatgDAO.findChild(parentId);
		}
		return list;
	}
	public int queryResultsCount(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		/*String sql = null;
		List<Object> values = null;
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
		int rows = this.budgProUpriceDAO.getCounts(sql, values);
		// int rows = this.departmentadmindao.getCounts(sql, values);
		return rows;*/
		
		String sql = null;
		int rows ;
		List<Object> values = null;
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
		String Fss = BudgetProAction.getPropIDs().trim();
		String ss =  BudgetProAction.getProIDs().trim();
		if(Fss.equals("hh")){
		sql = " BudgProCatgNum = '"+BudgetProAction.getProIDs()+"'";
		//getSingleList(sql,criteria,from,length,result);
		}else if(ss.equals("hh")){
		String sBudgProUpriceID = "";
		List<BudgProCatg> fflist = this.budgProCatgDAO.findByProperty("budgProCatg.budgProCatgNum", BudgetProAction.getPropIDs().trim());//根据点击的父节点ID查询Up为ID的List
	
		if (fflist.size() > 0) {
			for (BudgProCatg budgProCatg : fflist) {
				sBudgProUpriceID = sBudgProUpriceID +getBudgProUpriceNums(budgProCatg.getBudgProCatgNum());
			}
			System.out.println("--------->"+sBudgProUpriceID);
		} else {
			//直接查找
			sBudgProUpriceID = Fss;
		}
		sBudgProUpriceID= sBudgProUpriceID.substring(0, sBudgProUpriceID.lastIndexOf(","));
		sql = " BudgProCatgNum in ("+sBudgProUpriceID+")";
	
	}
	 rows = this.budgProUpriceDAO.getEvalmethCounts(sql, values);
			return rows;

		
		
	}
	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria, int from, int length) {
		// TODO Auto-generated method stub
		String sql = null;
		
		
		//展开根节点
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		String Fss = BudgetProAction.getPropIDs().trim();
		String ss = BudgetProAction.getProIDs().trim();
		
		
		
		if(Fss.equals("hh")){
			sql = " BudgProCatgNum = '"+BudgetProAction.getProIDs()+"'";
			//getSingleList(sql,criteria,from,length,result);
		}else if(ss.equals("hh")){
			String sBudgProUpriceID = "";
			List<BudgProCatg> fflist = this.budgProCatgDAO.findByProperty("budgProCatg.budgProCatgNum",BudgetProAction.getPropIDs().trim());
			
			if (fflist.size() > 0) {
				for (BudgProCatg budgProCatg : fflist) {
					sBudgProUpriceID = sBudgProUpriceID +getBudgProUpriceNums(budgProCatg.getBudgProCatgNum());
				}
				System.out.println("--------->"+sBudgProUpriceID);
			} else {
				//直接查找
				sBudgProUpriceID = Fss;
			}
			sBudgProUpriceID= sBudgProUpriceID.substring(0, sBudgProUpriceID.lastIndexOf(","));
			sql = " BudgProCatgNum in ("+sBudgProUpriceID+")";
		
		}
		//展开失败
		
		
		
		
		List<Object> values = null;
		int from1 =0;
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
		// List<DepartmentAdmin> list = new ArrayList<DepartmentAdmin>();
		List<BudgProUprice> list2 = new ArrayList<BudgProUprice>();
		list2 = this.budgProUpriceDAO.findByConditionAndPager(sql, values, from,length);
		//List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for (BudgProUprice b : list2) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			
			map.put("budgProUpriceID", b.getBudgProUpriceId());
			if(b.getBudgProUpriceNum()==null){
				map.put("budgProUpriceNum",null);
			}else{
				map.put("budgProUpriceNum", b.getBudgProUpriceNum());
			}
			if(b.getBudgProName()==null){
				map.put("budgProName", null);
			}else{
				map.put("budgProName",b.getBudgProName());
			}
			if((Double)b.getBudgProUprice()==null){
				map.put("budgProUprice", null);

			}else{
				map.put("budgProUprice", b.getBudgProUprice());

			}
			if(b.getBudgProUpriceComp()==null){
				map.put("budgProUpriceComp", null);
			}else{
				map.put("budgProUpriceComp", b.getBudgProUpriceComp());
			}
			if(b.getBudgProUpriceExpl()==null){
				map.put("budgProUpriceExpl",null );
			}else{
				map.put("budgProUpriceExpl", b.getBudgProUpriceExpl());
			}
			if (b.getBudgProCatg() != null) {
				map.put("budgProCatg", b.getBudgProCatg().getBudgProCatgDes());
			}
			result.add(map);
		}
		return result;
	}

	
	
	

	private String getBudgProUpriceNums(String budgProCatgNum) {
		// TODO Auto-generated method stub
		String ssBudgProUpriceID = "";
		List<BudgProCatg> fflist = this.budgProCatgDAO.findByProperty("budgProCatg.budgProCatgNum", budgProCatgNum.trim());//根据点击的父节点ID查询Up为ID的List
		if (fflist.size() > 0) {//
			for (BudgProCatg budgProCatg : fflist) {
				ssBudgProUpriceID =ssBudgProUpriceID+ getBudgProUpriceNums(budgProCatg.getBudgProCatgNum());
			}
		} else {
			ssBudgProUpriceID =ssBudgProUpriceID+ "'"+budgProCatgNum+"',";
		}
		
		return ssBudgProUpriceID;
	}

	public void addBudgProUprice(String BudgProCatgNum,
			String budgProUpriceNum, String budgProName, double budgProUprice,
			String budgProUpriceComp, String budgProUpriceExpl) {
		// TODO Auto-generated method stub
		BudgProUprice budgetProUprice = new BudgProUprice();
		
		BudgProCatg budgProCatg = new BudgProCatg();
		budgProCatg = budgProCatgDAO.findById(BudgProCatgNum);
		//budgProCatg = budgProCatgDAO.findById(id);
		
		budgetProUprice.setBudgProUpriceNum(budgProUpriceNum);
		budgetProUprice.setBudgProName(budgProName);
		budgetProUprice.setBudgProUprice(budgProUprice);
		budgetProUprice.setBudgProUpriceComp(budgProUpriceComp);
		budgetProUprice.setBudgProUpriceExpl(budgProUpriceExpl);
		budgetProUprice.setBudgProCatg(budgProCatg);
		budgProUpriceDAO.save(budgetProUprice);
		
	}

	public void delBudgProUprice(Integer budgProUpriceID) {
		// TODO Auto-generated method stub
		BudgProUprice budgetProUprice = new BudgProUprice();
		//budgetProUprice = budgProUpriceDAO.findById(Integer.parseInt(budgProUpriceID));
		budgetProUprice = budgProUpriceDAO.findById(budgProUpriceID);
		
		budgProUpriceDAO.delete(budgetProUprice);
	}

	public void updateBudgProUprice(String BudgProCatgNum,String budgProUpriceID,
			String budgProUpriceNum, String budgProName, double budgProUprice,
			String budgProUpriceComp, String budgProUpriceExpl) {
		// TODO Auto-generated method stub
		BudgProUprice budgetProUprice = new BudgProUprice();
		budgetProUprice = budgProUpriceDAO.findById(Integer.parseInt(budgProUpriceID));
		//budgProUpriceDAO.delete(budgetProUprice);
		
	//	BudgProCatg budgProCatg = new BudgProCatg();
	//	budgProCatg = budgProCatgDAO.findById(BudgProCatgNum);
		budgetProUprice.setBudgProUpriceNum(budgProUpriceNum);
		budgetProUprice.setBudgProName(budgProName);
		budgetProUprice.setBudgProUprice(budgProUprice);
		budgetProUprice.setBudgProUpriceComp(budgProUpriceComp);
		budgetProUprice.setBudgProUpriceExpl(budgProUpriceExpl);
		budgProUpriceDAO.merge(budgetProUprice);
		
	}

	public boolean checkBudgProUpriceNum(String budgProUpriceNum,
			String budgProUpriceID) {
		// TODO Auto-generated method stub
		//id=-1表示为增加一条记录,否则表示编辑
		//flag==true表示提示错误，flag==false表示没有重复，不提示错误
		if(budgProUpriceID==null){
			if(budgProUpriceDAO.findByBudgProUpriceNum(budgProUpriceNum).isEmpty()){
				return false;
			}else{
				return true;
			}
		}else{
			if(budgProUpriceDAO.findById(Integer.parseInt(budgProUpriceID)).getBudgProUpriceNum().equals(budgProUpriceNum)){
				return false;
			}else{
				if(budgProUpriceDAO.findByBudgProUpriceNum(budgProUpriceNum).isEmpty()){
					return false;
				}else{
					return true;
				}
			}
		}
	}
}
