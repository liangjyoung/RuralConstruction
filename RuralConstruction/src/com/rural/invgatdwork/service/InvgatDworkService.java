package com.rural.invgatdwork.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONArray;

import com.rural.bean.Invgat;
import com.rural.bean.InvgatDwork;
import com.rural.bean.TownBasicInfo;
import com.rural.bean.VilBasicInfo;
import com.rural.dao.InvgatDAO;
import com.rural.dao.InvgatDworkDAO;
import com.rural.dao.VilBasicInfoDAO;
import com.rural.tool.Criterion;



public class InvgatDworkService implements IInvgatDworkService{
	
	private InvgatDworkDAO invgatDworkDAO = new InvgatDworkDAO();
	private InvgatDAO invgatDAO = new InvgatDAO();
	private VilBasicInfoDAO basicInfoDAO = new VilBasicInfoDAO();
	public InvgatDworkDAO getInvgatDworkDAO() {
		return invgatDworkDAO;
	}

	public void setInvgatDworkDAO(InvgatDworkDAO invgatDworkDAO) {
		this.invgatDworkDAO = invgatDworkDAO;
	}

	
	public InvgatDAO getInvgatDAO() {
		return invgatDAO;
	}

	public void setInvgatDAO(InvgatDAO invgatDAO) {
		this.invgatDAO = invgatDAO;
	}



/**
	public String addInvgatDwork(String invgatNum,String vilNum) {
		// TODO Auto-generated method stub
		InvgatDwork invgatDwork = null;
		VilBasicInfo vilBasicInfo = new VilBasicInfo();
		Invgat invgat = new Invgat();
		String message = "";
		//invgatDwork=null;
		List<?> serList = invgatDworkDAO.findByVilNum(vilNum);
		if (serList != null && serList.size() > 0) {
			invgatDwork = (InvgatDwork)serList.get(0);
		//System.out.println("--------->"+JSONArray.fromObject(invgatDwork));
			message = "该村已被分配，不能重复分配！";
		}else{
		invgatDwork = new InvgatDwork();
		vilBasicInfo = basicInfoDAO.findById(vilNum);
		invgat = invgatDAO.findById(invgatNum);
		invgatDwork.setVilBasicInfo(vilBasicInfo);
		invgatDwork.setInvgat(invgat);
		
		invgatDworkDAO.save(invgatDwork);
		message = "分配成功!";
		}
		return message;
		
	}
**/
	public String addInvgatDwork( int invgatID,int vilBasicInfoID){
		
		InvgatDwork invgatDwork  = new InvgatDwork();
		VilBasicInfo vilBasicInfo = new VilBasicInfo();
		Invgat invgat = new Invgat();
		String message = "";
		vilBasicInfo = basicInfoDAO.findById(vilBasicInfoID);
		invgat = invgatDAO.findById(invgatID);
		invgatDwork.setVilBasicInfo(vilBasicInfo);
		invgatDwork.setInvgat(invgat);
		invgatDworkDAO.save(invgatDwork);
		message = "分配成功!";
	  return message;
	}
	/**
	public List<HashMap<String, Object>> queryByName(List<Criterion> criteria,
			int from, int length ,String vilNum) {
		// TODO Auto-generated method stub
		String sql = null;
		List<Object> values = null;
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
		// List<DepartmentAdmin> list = new ArrayList<DepartmentAdmin>();
		//List<Invgat> list1 = new ArrayList<Invgat>();
		List<VilBasicInfo> list2 = new ArrayList<VilBasicInfo>();
		//list1 = this.invgatDworkDAO.findByConditionAndPager1(sql, values, from,length);
		list2 = this.invgatDworkDAO.findByVilName(vilNum);
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		
		for (VilBasicInfo v : list2) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("vilName", v.getVilName());
			result.add(map);	 
	  }
		 return result;
  
    }
    **/
	
	
	
	public boolean isAdd(int vilBasicInfoID){
		InvgatDwork invgatDwork  = new InvgatDwork();
		//String message = "";
		//invgatDwork=null;
		List<?> serList = invgatDworkDAO.findByVilBasicInfoID(vilBasicInfoID);
		if (serList != null && serList.size() > 0) {
			invgatDwork = (InvgatDwork)serList.get(0);
		//System.out.println("--------->"+JSONArray.fromObject(invgatDwork));
			//message = "该村已被分配，不能重复分配!";
			return false;
		}else{
			//message = "可以成功分配!";
			return true;
		}
		
	}
	public VilBasicInfo getVil(int vilBasicInfoID){
		VilBasicInfo vilBasicInfo = basicInfoDAO.findById(vilBasicInfoID);
		return vilBasicInfo;
		
	}
	
	
	public int getVilID(String vilNum){
		int a =0 ;
		List<VilBasicInfo> li = new ArrayList<VilBasicInfo>();
		li = this.basicInfoDAO.findByProperty("vilNum", vilNum);
		for (VilBasicInfo vilBasicInfo : li) {
			a = vilBasicInfo.getVilBasicInfoId();
		}
		System.out.println("--------->"+a);
		return a;
		
	}
	@SuppressWarnings("unchecked")
	/**
	public void updateInvgatDwork( int invgatID,int vilID) {
		// TODO Auto-generated method stub
		InvgatDwork invgatDwork = new InvgatDwork();
		VilBasicInfo vilBasicInfo = new VilBasicInfo();
		Invgat invgat = new Invgat();
		vilBasicInfo = basicInfoDAO.findById(vilID);
		invgatDwork.setVilBasicInfo(vilBasicInfo);
		invgat = invgatDAO.findById(invgatID);
		invgatDwork.setInvgat(invgat);
		invgatDworkDAO.attachDirty(invgatDwork);
	}
	**/

	public VilBasicInfoDAO getBasicInfoDAO() {
		return basicInfoDAO;
	}

	public void setBasicInfoDAO(VilBasicInfoDAO basicInfoDAO) {
		this.basicInfoDAO = basicInfoDAO;
	}

	@SuppressWarnings("unchecked")
	public void  delInvgatDwork(int invgatDworkID) {
		// TODO Auto-generated method stub
		InvgatDwork invgatDwork = new InvgatDwork();
		invgatDwork = invgatDworkDAO.findById(invgatDworkID);
		invgatDworkDAO.delete(invgatDwork);
	}
	public int queryResultsCount(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		String sql = null;
		List<Object> values = null;
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
		int rows = this.invgatDworkDAO.getCounts(sql, values);
		// int rows = this.departmentadmindao.getCounts(sql, values);
		return rows;
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
		// List<DepartmentAdmin> list = new ArrayList<DepartmentAdmin>();
		//List<Invgat> list1 = new ArrayList<Invgat>();
		List<InvgatDwork> list2 = new ArrayList<InvgatDwork>();
		//list1 = this.invgatDworkDAO.findByConditionAndPager1(sql, values, from,length);
		list2 = this.invgatDworkDAO.findByConditionAndPager(sql, values, from,length);
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		
		for (InvgatDwork v : list2) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			if(v.getInvgatDworkId()==null){
				map.put("invgatDworkID", null);
				
			}else{
			map.put("invgatDworkID", v.getInvgatDworkId());
			}
			if(v.getVilBasicInfo()==null){
				map.put("vilName", null);
				
			}else if(v.getVilBasicInfo().getVilName()==null){
				map.put("vilName", null);
			}else{
			map.put("vilName", v.getVilBasicInfo().getVilName());
			}
			if(v.getInvgat()==null){
				map.put("invgatName",null);
				
			}else if(v.getInvgat().getInvgatName()==null){
				map.put("invgatName",null);
				
			}else{
			map.put("invgatName", v.getInvgat().getInvgatName());
			}
			result.add(map);	 
	  }
		 return result;
  
    }


}

  
