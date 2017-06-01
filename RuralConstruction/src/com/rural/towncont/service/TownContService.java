package com.rural.towncont.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rural.bean.TownBasicInfo;
import com.rural.bean.TownCont;
import com.rural.dao.TownBasicInfoDAO;
import com.rural.dao.TownContDAO;
import com.rural.tool.Criterion;

public class TownContService implements ITownContService {
	private TownContDAO townContDAO = new TownContDAO();
	private TownBasicInfoDAO townBasicInfoDAO = new TownBasicInfoDAO();   

	
	public TownBasicInfoDAO getTownBasicInfoDAO() {
		return townBasicInfoDAO;
	}

	public void setTownBasicInfoDAO(TownBasicInfoDAO townBasicInfoDAO) {
		this.townBasicInfoDAO = townBasicInfoDAO;
	}

	public TownContDAO getTownContDAO() {
		return townContDAO;
	}

	public void setTownContDAO(TownContDAO townContDAO) {
		this.townContDAO = townContDAO;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<HashMap<String, Object>> findAll() {
		// TODO Auto-generated method stub
		List<TownCont> list = new ArrayList<TownCont>();
		list = this.townContDAO.findAll();
		ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for(TownCont s : list){
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("townContID",s.getTownContId());
			map.put("townBasicInfoID",s.getTownBasicInfo().getTownBasicInfoId());
			if(s.getTownContNum()==null){
				map.put("townContNum",null );
			}else{
				map.put("townContNum", s.getTownContNum());
			}
			if(s.getTownContName()==null){
				map.put("townContName",null);
			}else{
				map.put("townContName",s.getTownContName());
			}
			if(s.getTownContWorkTel()==null){
				map.put("townContWorkTel",null);
			}else{
				map.put("townContWorkTel",s.getTownContWorkTel());
			}
			if(s.getTownContMobTel()==null)
			{
				map.put("townContMobTel", null);
			}else{
				map.put("townContMobTel", s.getTownContMobTel());
			}
			if(s.getTownContComp()==null){
				map.put("townComp",null);
			}else{
				map.put("townComp",s.getTownContComp());
			}
			if(s.getTownContPost()==null){
				map.put("townPost",null);
			}else{
				map.put("townPost",s.getTownContPost());
			}
			if(s.getTownContNote()==null){
				map.put("townNote",null);
			}else{
				map.put("townNote",s.getTownContNote());
			}
			
			result.add(map);
		}
		
		return result;
	}

	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		String sql = null;
		List<Object> values = null;
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
		List<TownCont> list2 = new ArrayList<TownCont>();
		list2 = this.townContDAO.findByConditionAndPager(sql, values, from,length);
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for (TownCont xt : list2) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("townContID", xt.getTownContId());
			map.put("townBasicInfoID",xt.getTownBasicInfo().getTownBasicInfoId());
			if( xt.getTownContNum()==null){
				map.put("townContNum",null);
			}else{
				map.put("townContNum", xt.getTownContNum());
			}
			if(xt.getTownContName()==null){
				map.put("townContName",null);
			}else{
				map.put("townContName",xt.getTownContName());
			}
			if(xt.getTownContWorkTel()==null){
				map.put("townContWorkTel",null);
			}else{
				map.put("townContWorkTel",xt.getTownContWorkTel());
			}
			if(xt.getTownContMobTel()==null)
			{
				map.put("townContMobTel", null);
			}else{
				map.put("townContMobTel", xt.getTownContMobTel());
			}
			if(xt.getTownContComp()==null){
				map.put("townComp",null);
			}else{
				map.put("townComp",xt.getTownContComp());
			}
			if(xt.getTownContPost()==null){
				map.put("townPost",null);
			}else{
				map.put("townPost",xt.getTownContPost());
			}
			if(xt.getTownContNote()==null){
				map.put("townNote",null);
			}else{
				map.put("townNote",xt.getTownContNote());
			}
			result.add(map);
		}
		
		return  result;
	}
	
	public List<HashMap<String, Object>> queryByPage(int townBasicInfoID,List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		String sql = null;
		List<Object> values = null;
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
		List<TownCont> list2 = new ArrayList<TownCont>();
		list2 = this.townContDAO.findByConditionAndPager(townBasicInfoID,sql, values, from,length);
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for (TownCont xt : list2) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("townContID", xt.getTownContId());
			map.put("townBasicInfoID",xt.getTownBasicInfo().getTownBasicInfoId());
			map.put("townContNum", xt.getTownContNum());
			map.put("townContName",xt.getTownContName());
			map.put("townContWorkTel",xt.getTownContWorkTel());
			map.put("townContMobTel", xt.getTownContMobTel());
			map.put("townComp",xt.getTownContComp());
			map.put("townPost",xt.getTownContPost());
			map.put("townNote",xt.getTownContNote());
			result.add(map);
		}
		
		return  result;
	}
	
	
	public int queryResultsCount(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		String sql = null;
		List<Object> values = null;
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
		int rows = this.townContDAO.getCounts(sql, values);
		// int rows = this.departmentadmindao.getCounts(sql, values);
		return rows;
	}
	public int queryResultsCount(int townContIDtownBasicInfoID,List<Criterion> criteria) {
		// TODO Auto-generated method stub
		String sql = null;
		List<Object> values = null;
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
		int rows = this.townContDAO.getContCount(townContIDtownBasicInfoID,sql, values);
		// int rows = this.departmentadmindao.getCounts(sql, values);
		return rows;
	}
	
	

	public void addTownCont(int townBasicInfoID,String townContNum,String townContName,String townContWorkTel,String townContMobTel,String townContComp, String townContPost, String townContNote) {
		// TODO Auto-generated method stub
		TownCont townCont= new TownCont();
		TownBasicInfo  townBasicInfo = new TownBasicInfo();
		townBasicInfo = townBasicInfoDAO.findById(townBasicInfoID);
		 townCont.setTownBasicInfo(townBasicInfo);
		 townCont.setTownContNum(townContNum);
		 townCont.setTownContName(townContName);
		 townCont.setTownContWorkTel(townContWorkTel);
		 townCont.setTownContMobTel(townContMobTel);
		 townCont.setTownContComp(townContComp);
		 townCont.setTownContPost(townContPost);
		 townCont.setTownContNote(townContNote);
		 townContDAO.save(townCont);
	}

	@SuppressWarnings("unchecked")
	public void updateTownCont(int townContID,String townContNum,String townContName,String townContWorkTel,String townContMobTel,String townContComp, String townContPost, String townContNote) {
		// TODO Auto-generated method stub
		TownCont townCont= new TownCont();
		townCont = townContDAO.findById(townContID);
		townCont.setTownContNum(townContNum);
		townCont.setTownContName(townContName);
		townCont.setTownContWorkTel(townContWorkTel);
		townCont.setTownContMobTel(townContMobTel);
		 townCont.setTownContComp(townContComp);
		 townCont.setTownContPost(townContPost);
		 townCont.setTownContNote(townContNote);;
		townContDAO.attachDirty(townCont);
	}

	@SuppressWarnings("unchecked")
	public void delTownCont(int townContID) {
		// TODO Auto-generated method stub
		TownCont townCont= new TownCont();
		townCont = townContDAO.findById(townContID);
		townContDAO.delete(townCont);
	}
	
	
	public int getTownID(String townNum){
		int a =0 ;
		List<TownBasicInfo> li = new ArrayList<TownBasicInfo>();
		li = this.townBasicInfoDAO.findByProperty1("townNum", townNum);
		for (TownBasicInfo townBasicInfo : li) {
			a = townBasicInfo.getTownBasicInfoId();
		}
		System.out.println("--------->"+a);
		return a;
		
	}
	

	//检查编码是否重复
	public boolean checkTownContNum(String townContNum,String townContID) {
		// TODO Auto-generated method stub
		
		//id=-1表示为增加一条记录,否则表示编辑
		//flag==true表示提示错误，flag==false表示没有重复，不提示错误
		if(townContID==null){
			
			if(townContDAO.findByProperty1("townContNum", townContNum).isEmpty()){
				return false;
			}else{
				return true;
			}
		}else{
			if(townContDAO.findById(Integer.parseInt(townContID)).getTownContNum().equals(townContNum)){
				return false;
			}else{
				if(townContDAO.findByProperty1("townContNum", townContNum).isEmpty()){
					return false;
				}else{
					return true;
				}
			}
		}
	}
	
}
