package com.rural.govfile.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.rural.bean.CityBasicInfo;
import com.rural.bean.CitysFil;
import com.rural.bean.TownBasicInfo;
import com.rural.bean.TownFil;
import com.rural.bean.GoveFilClfy;
import com.rural.bean.VilBasicInfo;
import com.rural.bean.VilFil;

import com.rural.dao.TownBasicInfoDAO;
import com.rural.dao.TownFilDAO;
import com.rural.dao.GoveFilClfyDAO;
import com.rural.tool.Criterion;

public class TownFilService implements ITownFilService{

	private TownBasicInfoDAO townBasicInfoDAO = new TownBasicInfoDAO();
	private GoveFilClfyDAO govefilclfyDAO = new GoveFilClfyDAO();
	private TownFilDAO townfilDAO = new TownFilDAO(); 
	
	
	
	

	public GoveFilClfyDAO getGovefilclfyDAO() {
		return govefilclfyDAO;
	}



	public void setGovefilclfyDAO(GoveFilClfyDAO govefilclfyDAO) {
		this.govefilclfyDAO = govefilclfyDAO;
	}

	
	

	


	public TownBasicInfoDAO getTownBasicInfoDAO() {
		return townBasicInfoDAO;
	}



	public void setTownBasicInfoDAO(TownBasicInfoDAO townBasicInfoDAO) {
		this.townBasicInfoDAO = townBasicInfoDAO;
	}



	public TownFilDAO getTownfilDAO() {
		return townfilDAO;
	}



	public void setTownfilDAO(TownFilDAO townfilDAO) {
		this.townfilDAO = townfilDAO;
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
		List vf= townfilDAO.findByProperty("goveFilClfy.goveFilClfyId", a);
		if(vf.size()>0){
			message = "文件已引用编号为"+govefilclfy.getGoveFilClfyNum()+"的对象，无法删除！\n";
		}
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
		int rows = this.townfilDAO.getCounts(sql, values);
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
		List<TownFil> list2 = new ArrayList<TownFil>();
		list2 = this.townfilDAO.findByConditionAndPager(sql, values, from,length);
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for (TownFil b : list2) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("TownFilID", b.getTownFilId());
			
			if(b.getGoveFilClfy()== null){
				map.put("GoveFilClfyID", null);
			}else{
				map.put("GoveFilClfyID", b.getGoveFilClfy().getGoveFilClfyId());
			}
			
			if (b.getTownBasicInfo() == null) {
				map.put("TownBasicInfoID",null);
			} else {
				map.put("TownBasicInfoID", b.getTownBasicInfo().getTownName());
			}
		
			if (b.getTownFilNum() == null) {
				map.put("TownFilNum",null);
			} else {
				map.put("TownFilNum", b.getTownFilNum());
			}
			
			
			if (b.getTownFilName() == null) {
				map.put("TownFilName",null);
			} else {
				map.put("TownFilName", b.getTownFilName());
			}
		
			
			if (b.getTownFilIdef() == null) {
				map.put("TownFilIdef",null);
			} else {
				map.put("TownFilIdef", b.getTownFilIdef());
			}
			if (b.getTownFilMadTim() == null) {
				map.put("TownFilMadTim",null);
			} else {
				map.put("TownFilMadTim", b.getTownFilMadTim().toString().substring(0, 11));
			}
			
			if (b.getTownFilPubComp() == null) {
				map.put("TownFilPubComp", null);
			} else {
				map.put("TownFilPubComp", b.getTownFilPubComp());
			}
			
			if (b.getTownFilExpl() == null) {
				map.put("TownFilExpl", null);
			} else {
				map.put("TownFilExpl", b.getTownFilExpl());
			}
			
			
			
			
			result.add(map);
		}

		return result;
	}

	//表格检查编号是否重复 功能
	public boolean checkTownFilNum(String TownFilNum, String TownFilID) {
		// TODO Auto-generated method stub
		//id=-1表示为增加一条记录,否则表示编辑
		//flag==true表示提示错误，flag==false表示没有重复，不提示错误
		if(TownFilID==null){
			if(townfilDAO.findByTownFilNum(TownFilNum).isEmpty()){
				return false;
			}else{
				return true;
			}
		}else{
			if(townfilDAO.findById(Integer.parseInt(TownFilID)).getTownFilNum().equals(TownFilNum)){
				return false;
			}else{
				if(townfilDAO.findByTownFilNum(TownFilNum).isEmpty()){
					return false;
				}else{
					return true;
				}
			}
		}
	}
	
	public void addTownFil(String GoveFilClfyID,Integer TownBasicInfoID,String TownFilNum,
			String TownFilName,String TownFilIdef,Date TownFilMadTim,
			String TownFilPubComp,String TownFilExpl) {
		// TODO Auto-generated method stub
		TownFil townfil = new TownFil();
		GoveFilClfy govefilclfy = new GoveFilClfy();
		govefilclfy= govefilclfyDAO.findById(Integer.parseInt(GoveFilClfyID));
		
		
		TownBasicInfo townBasicInfo = new TownBasicInfo();
		townBasicInfo = townBasicInfoDAO.findById(TownBasicInfoID);
		/*//String townBasicInfoId= (String) ServletActionContext.getRequest().getSession().getAttribute("sysUserBeloDiviCode");
		String townBasicInfoId="371202106000";
		List<TownBasicInfo> town1=townBasicInfoDAO.findByTownNum(townBasicInfoId);
		TownBasicInfo town = town1.get(0);*/
	
		townfil.setTownBasicInfo(townBasicInfo);
		townfil.setTownFilNum(TownFilNum);
		townfil.setTownFilName(TownFilName);
		townfil.setTownFilIdef(TownFilIdef);
		townfil.setTownFilMadTim(TownFilMadTim);
		townfil.setTownFilPubComp(TownFilPubComp);
		townfil.setTownFilExpl(TownFilExpl);
		//townfil.setTownBasicInfo(town);
		townfil.setGoveFilClfy(govefilclfy);
		townfilDAO.save(townfil);
		
		
	}
	
	public void delTownFil(String TownFilID) {
		// TODO Auto-generated method stub
		TownFil townfil = new TownFil();
		townfil = townfilDAO.findById(Integer.parseInt(TownFilID));
		
		townfilDAO.delete(townfil);
		
	}
	
	//表格的编辑功能
	public void updateTownFil(String GoveFilClfyID,Integer TownBasicInfoID,
			String TownFilID,String TownFilNum,String TownFilName,
			String TownFilIdef,Date TownFilMadTim,String TownFilPubComp,
			String TownFilExpl) {
		// TODO Auto-generated method stub
		TownFil townfil = new TownFil();
		townfil= townfilDAO.findById(Integer.parseInt(TownFilID));
		
		TownBasicInfo townBasicInfo = new TownBasicInfo();
		townBasicInfo = townBasicInfoDAO.findById(TownBasicInfoID);
	
		townfil.setTownBasicInfo(townBasicInfo);
		townfil.setTownFilNum(TownFilNum);
		townfil.setTownFilName(TownFilName);
		townfil.setTownFilIdef(TownFilIdef);
		townfil.setTownFilMadTim(TownFilMadTim);
		townfil.setTownFilPubComp(TownFilPubComp);
		townfil.setTownFilExpl(TownFilExpl);
		
		townfilDAO.attachDirty(townfil);
	}
}
