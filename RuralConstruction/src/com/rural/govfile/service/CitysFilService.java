package com.rural.govfile.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.rural.bean.CityBasicInfo;
import com.rural.bean.CitysFil;
import com.rural.bean.Expert;
import com.rural.bean.ExpertMajorCatg;
import com.rural.bean.GoveFilClfy;
import com.rural.bean.Sex;
import com.rural.bean.VilBasicInfo;
import com.rural.bean.VilFil;

import com.rural.dao.CitysFilDAO;
import com.rural.dao.GoveFilClfyDAO;
import com.rural.dao.CityBasicInfoDAO;
import com.rural.tool.Criterion;

public class CitysFilService implements ICitysFilService{

	private CityBasicInfoDAO cityBasicInfoDAO = new CityBasicInfoDAO();
	private GoveFilClfyDAO govefilclfyDAO = new GoveFilClfyDAO();
	private CitysFilDAO citysfilDAO = new CitysFilDAO(); 
	

	public GoveFilClfyDAO getGovefilclfyDAO() {
		return govefilclfyDAO;
	}



	public void setGovefilclfyDAO(GoveFilClfyDAO govefilclfyDAO) {
		this.govefilclfyDAO = govefilclfyDAO;
	}



	public CitysFilDAO getCitysfilDAO() {
		return citysfilDAO;
	}



	public void setCitysfilDAO(CitysFilDAO citysfilDAO) {
		this.citysfilDAO = citysfilDAO;
	}


	
	
	
	public CityBasicInfoDAO getCityBasicInfoDAO() {
		return cityBasicInfoDAO;
	}



	public void setCityBasicInfoDAO(CityBasicInfoDAO cityBasicInfoDAO) {
		this.cityBasicInfoDAO = cityBasicInfoDAO;
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
		List vf= citysfilDAO.findByProperty("goveFilClfy.goveFilClfyId", a);
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
		int rows = this.citysfilDAO.getCounts(sql, values);
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
		List<CitysFil> list2 = new ArrayList<CitysFil>();
		list2 = this.citysfilDAO.findByConditionAndPager(sql, values, from,length);
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for (CitysFil b : list2) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("CitysFilID", b.getCitysFilId());
			
			if(b.getGoveFilClfy()== null){
				map.put("GoveFilClfyID",null);
			}else{
				map.put("GoveFilClfyID", b.getGoveFilClfy().getGoveFilClfyId());
			}
			
			if (b.getCityBasicInfo() == null) {
				map.put("CityBasicInfoID",null);
			} else {
				map.put("CityBasicInfoID", b.getCityBasicInfo().getCityName());
			}
			
			if (b.getCitysFilNum() == null) {
				map.put("CitysFilNum",null);
			} else {
				map.put("CitysFilNum", b.getCitysFilNum());
			}
			
			if (b.getCitysFilName() == null) {
				map.put("CitysFilName",null);
			} else {
				map.put("CitysFilName", b.getCitysFilName());
			}
		
			
			if (b.getCitysFilIdef() == null) {
				map.put("CitysFilIdef",null);
			} else {
				map.put("CitysFilIdef", b.getCitysFilIdef());
			}
			if (b.getCitysFilMadTim() == null) {
				map.put("CitysFilMadTim",null);
			} else {
				map.put("CitysFilMadTim", b.getCitysFilMadTim().toString().substring(0, 11));
			}
			
			if (b.getCitysFilPubComp() == null) {
				map.put("CitysFilPubComp", null);
			} else {
				map.put("CitysFilPubComp", b.getCitysFilPubComp());
			}
			
			if (b.getCitysFilExpl() == null) {
				map.put("CitysFilExpl", null);
			} else {
				map.put("CitysFilExpl", b.getCitysFilExpl());
			}
			
			
			
			
			result.add(map);
		}

		return result;
	}
	

	public void addCitysFil(String GoveFilClfyID,Integer CityBasicInfoID,String CitysFilNum,
			String CitysFilName,String CitysFilIdef,Date CitysFilMadTim,
			String CitysFilPubComp,String CitysFilExpl) {
		// TODO Auto-generated method stub
		CitysFil citysfil = new CitysFil();
		GoveFilClfy govefilclfy = new GoveFilClfy();
		govefilclfy= govefilclfyDAO.findById(Integer.parseInt(GoveFilClfyID));
		
	
		CityBasicInfo cityBasicInfo = new CityBasicInfo();
		cityBasicInfo = cityBasicInfoDAO.findById(CityBasicInfoID);
		/*//String cityBasicInfoId= (String) ServletActionContext.getRequest().getSession().getAttribute("sysUserBeloDiviCode");
		String cityBasicInfoId="371200000000";
		List<CityBasicInfo> city1=cityBasicInfoDAO.findByCityNum(cityBasicInfoId);
		CityBasicInfo city = city1.get(0);*/
	
		citysfil.setCityBasicInfo(cityBasicInfo);
		citysfil.setCitysFilNum(CitysFilNum);
		citysfil.setCitysFilName(CitysFilName);
		citysfil.setCitysFilIdef(CitysFilIdef);
		citysfil.setCitysFilMadTim(CitysFilMadTim);
		citysfil.setCitysFilPubComp(CitysFilPubComp);
		citysfil.setCitysFilExpl(CitysFilExpl);
		//citysfil.setCityBasicInfo(city);
		citysfil.setGoveFilClfy(govefilclfy);
		citysfilDAO.save(citysfil);
		
		
	}

	public boolean checkCitysFilNum(String CitysFilNum) {
		// TODO Auto-generated method stub
		if(citysfilDAO.findByCitysFilNum(CitysFilNum)==null){
			return false;
		}else{
			return true;
		}
	}

	public void delCitysFil(String CitysFilID) {
		// TODO Auto-generated method stub
		CitysFil citysfil = new CitysFil();
		citysfil = citysfilDAO.findById(Integer.parseInt(CitysFilID));
		
		citysfilDAO.delete(citysfil);
		
	}
	
	//表格的编辑功能
	public void updateCitysFil(String GoveFilClfyID,Integer CityBasicInfoID,String CitysFilID,
			String CitysFilNum,String CitysFilName,String CitysFilIdef,Date CitysFilMadTim,
			String CitysFilPubComp,String CitysFilExpl) {
		// TODO Auto-generated method stub
		CitysFil citysfil = new CitysFil();
		citysfil= citysfilDAO.findById(Integer.parseInt(CitysFilID));
		
		CityBasicInfo cityBasicInfo = new CityBasicInfo();
		cityBasicInfo = cityBasicInfoDAO.findById(CityBasicInfoID);
		
		
		citysfil.setCityBasicInfo(cityBasicInfo);
		citysfil.setCitysFilNum(CitysFilNum);
		citysfil.setCitysFilName(CitysFilName);
		citysfil.setCitysFilIdef(CitysFilIdef);
		citysfil.setCitysFilMadTim(CitysFilMadTim);
		citysfil.setCitysFilPubComp(CitysFilPubComp);
		citysfil.setCitysFilExpl(CitysFilExpl);
		
		citysfilDAO.attachDirty(citysfil);
	}
	
	//检查专家编码是否重复
	public boolean checkCitysFilNum(String CitysFilNum, String CitysFilID) {
		//id=-1表示为增加一条记录,否则表示编辑
		//flag==true表示提示错误，flag==false表示没有重复，不提示错误
		if(CitysFilID==null){
			if(citysfilDAO.findByCitysFilNum(CitysFilNum).isEmpty()){
				return false;
			}else{
				return true;
			}
		}else{
			if(citysfilDAO.findById(Integer.parseInt(CitysFilID)).getCitysFilNum().equals(CitysFilNum)){
				return false;
			}else{
				if(citysfilDAO.findByCitysFilNum(CitysFilNum).isEmpty()){
					return false;
				}else{
					return true;
				}
			}
		}
	}





}
