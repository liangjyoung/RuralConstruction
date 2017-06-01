package com.rural.govfile.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.rural.bean.CountryFil;
import com.rural.bean.GoveFilClfy;
import com.rural.bean.CountryBasicInfo;
import com.rural.bean.VilBasicInfo;
import com.rural.bean.VilFil;

import com.rural.dao.CountryBasicInfoDAO;
import com.rural.dao.CountryFilDAO;
import com.rural.dao.GoveFilClfyDAO;
import com.rural.tool.Criterion;

public class CountryFilService implements ICountryFilService{

	private GoveFilClfyDAO govefilclfyDAO = new GoveFilClfyDAO();
	private CountryFilDAO countryfilDAO = new CountryFilDAO(); 
	private CountryBasicInfoDAO countryBasicInfoDAO = new CountryBasicInfoDAO();
	
	

	
	
	
	public CountryBasicInfoDAO getCountryBasicInfoDAO() {
		return countryBasicInfoDAO;
	}



	public void setCountryBasicInfoDAO(CountryBasicInfoDAO countryBasicInfoDAO) {
		this.countryBasicInfoDAO = countryBasicInfoDAO;
	}



	public GoveFilClfyDAO getGovefilclfyDAO() {
		return govefilclfyDAO;
	}



	public void setGovefilclfyDAO(GoveFilClfyDAO govefilclfyDAO) {
		this.govefilclfyDAO = govefilclfyDAO;
	}



	public CountryFilDAO getCountryfilDAO() {
		return countryfilDAO;
	}



	public void setCountryfilDAO(CountryFilDAO countryfilDAO) {
		this.countryfilDAO = countryfilDAO;
	}


	
	//检查节点编码是否重复
	public boolean checkGoveFilClfyNumCode1(String GoveFilClfyNum) {
		// TODO Auto-generated method stub
		//flag==true表示提示错误，flag==false表示没有重复，不提示错误
		List<GoveFilClfy> gf= govefilclfyDAO.findByProperty("goveFilClfyNum", GoveFilClfyNum);
		if(gf.size()>0){
			return true;//标识有重复
		}else{
			return false;
		}
				
		
	}
	
	
	//添加节点
	public boolean addGoveFilClfy(String GoveFilClfyNum, String GoveFilClfyName) {
		// TODO Auto-generated method stub
	
		GoveFilClfy gfc = new GoveFilClfy();
		gfc.setGoveFilClfyNum(GoveFilClfyNum);
		gfc.setGoveFilClfyName(GoveFilClfyName);
		govefilclfyDAO.save(gfc);
	
		return true;
		
	}
	
	public String delGoveFilClfy1(String GoveFilClfyNum) {
		// TODO Auto-generated method stub
		String message = "";
		GoveFilClfy govefilclfy = new GoveFilClfy(); 
		Integer a = Integer.parseInt(GoveFilClfyNum);
		govefilclfy = govefilclfyDAO.findById(a);
		
		//List<GoveFilClfy> gf= govefilclfyDAO.findByProperty("goveFilClfyId", a);
		List vf= countryfilDAO.findByProperty("goveFilClfy.goveFilClfyId", a);
		if(vf.size()>0){
			message = "文件已引用编号为"+govefilclfy.getGoveFilClfyNum()+"的对象，无法删除！\n";
		}/*else if(vf.size()>0){
			message = "文件已引用编号为"+govefilclfy.getGoveFilClfyNum()+"的对象，无法删除！\n";
		}*/
		else{
		govefilclfyDAO.delete(govefilclfy);
			message = "删除成功！\n";
		}
		
		return message;
	}

	public List<GoveFilClfy> getChildPrivance() {
		// TODO Auto-generated method stub
		List<GoveFilClfy> list = new ArrayList<GoveFilClfy>();
		list = this.govefilclfyDAO.findAll();
		return list;
	}



	public int queryResultsCount(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		String sql = null;
		List<Object> values = null;
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
		int rows = this.countryfilDAO.getCounts(sql, values);
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
		List<CountryFil> list2 = new ArrayList<CountryFil>();
		list2 = this.countryfilDAO.findByConditionAndPager(sql, values, from,length);
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for (CountryFil b : list2) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("CountryFilID", b.getCountryFilId());
			
			if(b.getGoveFilClfy()== null){
				map.put("GoveFilClfyID",null);
			}else{
				map.put("GoveFilClfyID", b.getGoveFilClfy().getGoveFilClfyId());
			}
			
			if (b.getCountryBasicInfo() == null) {
				map.put("CountryBasicInfoID",null);
			} else {
				map.put("CountryBasicInfoID", b.getCountryBasicInfo().getCountryName());
			}
			
			if (b.getCountryFilNum() == null) {
				map.put("CountryFilNum",null);
			} else {
				map.put("CountryFilNum", b.getCountryFilNum());
			}
		
			if (b.getCountryFilName() == null) {
				map.put("CountryFilName",null);
			} else {
				map.put("CountryFilName", b.getCountryFilName());
			}
		
			
			if (b.getCountryFilIdef() == null) {
				map.put("CountryFilIdef",null);
			} else {
				map.put("CountryFilIdef", b.getCountryFilIdef());
			}
			if (b.getCountryFilMadTim() == null) {
				map.put("CountryFilMadTim",null);
			} else {
				map.put("CountryFilMadTim", b.getCountryFilMadTim().toString().substring(0, 11));
			}
			
			if (b.getCountryFilPubComp() == null) {
				map.put("CountryFilPubComp",null);
			} else {
				map.put("CountryFilPubComp", b.getCountryFilPubComp());
			}
			
			if (b.getCountryFilExpl() == null) {
				map.put("CountryFilExpl",null);
			} else {
				map.put("CitysFilExpl", b.getCountryFilExpl());
			}
			
			
			
			
			result.add(map);
		}

		return result;
	}

	//表格检查编号是否重复 功能
	public boolean checkCountryFilNum(String CountryFilNum, String CountryFilID) {
		// TODO Auto-generated method stub
		//id=-1表示为增加一条记录,否则表示编辑
		//flag==true表示提示错误，flag==false表示没有重复，不提示错误
		if(CountryFilID==null){
			if(countryfilDAO.findByCountryFilNum(CountryFilNum).isEmpty()){
				return false;
			}else{
				return true;
			}
		}else{
			if(countryfilDAO.findById(Integer.parseInt(CountryFilID)).getCountryFilNum().equals(CountryFilNum)){
				return false;
			}else{
				if(countryfilDAO.findByCountryFilNum(CountryFilNum).isEmpty()){
					return false;
				}else{
					return true;
				}
			}
		}
	}
	
	
	public void addCountryFil(String GoveFilClfyID,Integer CountryBasicInfoID,String CountryFilNum,
			String CountryFilName,String CountryFilIdef,Date CountryFilMadTim,
			String CountryFilPubComp,String CountryFilExpl) {
		// TODO Auto-generated method stub
		CountryFil countryfil = new CountryFil();
		GoveFilClfy govefilclfy = new GoveFilClfy();
		govefilclfy= govefilclfyDAO.findById(Integer.parseInt(GoveFilClfyID));
		
		
		CountryBasicInfo countryBasicInfo = new CountryBasicInfo();
		countryBasicInfo = countryBasicInfoDAO.findById(CountryBasicInfoID);
		/*//String townBasicInfoId= (String) ServletActionContext.getRequest().getSession().getAttribute("sysUserBeloDiviCode");
		String countryBasicInfoId="371202000000";
		List<CountryBasicInfo> country1=countryBasicInfoDAO.findByCountryNum(countryBasicInfoId);
		CountryBasicInfo country = country1.get(0);*/
		
		countryfil.setCountryBasicInfo(countryBasicInfo);
		countryfil.setCountryFilNum(CountryFilNum);
		countryfil.setCountryFilName(CountryFilName);
		countryfil.setCountryFilIdef(CountryFilIdef);
		countryfil.setCountryFilMadTim(CountryFilMadTim);
		countryfil.setCountryFilPubComp(CountryFilPubComp);
		countryfil.setCountryFilExpl(CountryFilExpl);
		//countryfil.setCountryBasicInfo(country);
		countryfil.setGoveFilClfy(govefilclfy);
		countryfilDAO.save(countryfil);
		
		
	}
	
	//表格删除 功能
	public void delCountryFil(String CountryFilID) {
		// TODO Auto-generated method stub
		CountryFil countryfil = new CountryFil();
		countryfil = countryfilDAO.findById(Integer.parseInt(CountryFilID));
		
		countryfilDAO.delete(countryfil);
	}


	//表格编辑 功能
	public void updateCountryFil(String GoveFilClfyID,Integer CountryBasicInfoID,String CountryFilID,
			String CountryFilNum,String CountryFilName,String CountryFilIdef,Date CountryFilMadTim,
			String CountryFilPubComp,String CountryFilExpl) {
		// TODO Auto-generated method stub
		CountryFil countryfil = new CountryFil();
		countryfil= countryfilDAO.findById(Integer.parseInt(CountryFilID));
		
		CountryBasicInfo countryBasicInfo = new CountryBasicInfo();
		countryBasicInfo = countryBasicInfoDAO.findById(CountryBasicInfoID);
	
		countryfil.setCountryBasicInfo(countryBasicInfo);
		countryfil.setCountryFilNum(CountryFilNum);
		countryfil.setCountryFilName(CountryFilName);
		countryfil.setCountryFilIdef(CountryFilIdef);
		countryfil.setCountryFilMadTim(CountryFilMadTim);
		countryfil.setCountryFilPubComp(CountryFilPubComp);
		countryfil.setCountryFilExpl(CountryFilExpl);
		
		countryfilDAO.attachDirty(countryfil);
	}
}
