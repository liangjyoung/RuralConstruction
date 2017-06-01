package com.rural.govfile.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.rural.bean.CityBasicInfo;
import com.rural.bean.CitysFil;
import com.rural.bean.InvesPro;
import com.rural.bean.Sex;
import com.rural.bean.SysUser;
import com.rural.bean.VilBasicInfo;
import com.rural.bean.VilFil;
import com.rural.bean.GoveFilClfy;

import com.rural.dao.SexDAO;
import com.rural.dao.VilBasicInfoDAO;
import com.rural.dao.VilFilDAO;
import com.rural.dao.GoveFilClfyDAO;
import com.rural.tool.Criterion;

public class VilFilService implements IVilFilService{

	private GoveFilClfyDAO govefilclfyDAO = new GoveFilClfyDAO();
	private VilFilDAO vilfilDAO = new VilFilDAO(); 
	private VilBasicInfoDAO vilBasicInfoDAO=new VilBasicInfoDAO();
	private VilBasicInfo vilBasicInfo;
	
	

	public VilBasicInfoDAO getVilBasicInfoDAO() {
		return vilBasicInfoDAO;
	}



	public void setVilBasicInfoDAO(VilBasicInfoDAO vilBasicInfoDAO) {
		this.vilBasicInfoDAO = vilBasicInfoDAO;
	}



	public GoveFilClfyDAO getGovefilclfyDAO() {
		return govefilclfyDAO;
	}



	public void setGovefilclfyDAO(GoveFilClfyDAO govefilclfyDAO) {
		this.govefilclfyDAO = govefilclfyDAO;
	}

	


	public VilFilDAO getVilfilDAO() {
		return vilfilDAO;
	}



	public void setVilfilDAO(VilFilDAO vilfilDAO) {
		this.vilfilDAO = vilfilDAO;
	}
	
	
	
	//表格添加 功能
	public void addVilFil(String GoveFilClfyID,Integer VilBasicInfoID,String VilFilNum,
			String VilFilName, String VilFilIdef, Date VilFilMadTim,
			String VilFilPubComp, String VilFilExpl) {
		// TODO Auto-generated method stub
		VilFil vilfil = new VilFil();
		GoveFilClfy govefilclfy = new GoveFilClfy();
		govefilclfy= govefilclfyDAO.findById(Integer.parseInt(GoveFilClfyID));
		
		
		VilBasicInfo vilBasicInfo = new VilBasicInfo();
		vilBasicInfo = vilBasicInfoDAO.findById(VilBasicInfoID);
		/*String vilBasicInfoId= (String) ServletActionContext.getRequest().getSession().getAttribute("sysUserBeloDiviCode");
		//String vilBasicInfoId="371202106219";
		List<VilBasicInfo> vil1=vilBasicInfoDAO.findByVilNum(vilBasicInfoId);
		VilBasicInfo vil = vil1.get(0);*/
	
		vilfil.setVilBasicInfo(vilBasicInfo);
		vilfil.setVilFilNum(VilFilNum);
		vilfil.setVilFilName(VilFilName);
		vilfil.setVilFilIdef(VilFilIdef);
		vilfil.setVilFilMadTim(VilFilMadTim);
		vilfil.setVilFilPubComp(VilFilPubComp);
		vilfil.setVilFilExpl(VilFilExpl);
		//vilfil.setVilBasicInfo(vil);
		vilfil.setGoveFilClfy(govefilclfy);
		vilfilDAO.save(vilfil);
	}


	//表格检查编号是否重复 功能
	public boolean checkVilFilNum(String VilFilNum, String VilFilID) {
		// TODO Auto-generated method stub
		//id=-1表示为增加一条记录,否则表示编辑
		//flag==true表示提示错误，flag==false表示没有重复，不提示错误
		if(VilFilID==null){
			if(vilfilDAO.findByVilFilNum(VilFilNum).isEmpty()){
				return false;
			}else{
				return true;
			}
		}else{
			if(vilfilDAO.findById(Integer.parseInt(VilFilID)).getVilFilNum().equals(VilFilNum)){
				return false;
			}else{
				if(vilfilDAO.findByVilFilNum(VilFilNum).isEmpty()){
					return false;
				}else{
					return true;
				}
			}
		}
	}


	//表格删除 功能
	public void delVilFil(String VilFilID) {
		// TODO Auto-generated method stub
		VilFil vilfil = new VilFil();
		vilfil = vilfilDAO.findById(Integer.parseInt(VilFilID));
		
		vilfilDAO.delete(vilfil);
	}


	//表格编辑 功能
	public void updateVilFil(String GoveFilClfyID, Integer VilBasicInfoID,String VilFilID,
			String VilFilNum, String VilFilName, String VilFilIdef,
			Date VilFilMadTim, String VilFilPubComp, String VilFilExpl){
			
			// TODO Auto-generated method stub
				VilFil vilfil = new VilFil();
				vilfil= vilfilDAO.findById(Integer.parseInt(VilFilID));
				
				VilBasicInfo vilBasicInfo = new VilBasicInfo();
				vilBasicInfo = vilBasicInfoDAO.findById(VilBasicInfoID);
				
				vilfil.setVilBasicInfo(vilBasicInfo);
				vilfil.setVilFilNum(VilFilNum);
				vilfil.setVilFilName(VilFilName);
				vilfil.setVilFilIdef(VilFilIdef);
				vilfil.setVilFilMadTim(VilFilMadTim);
				vilfil.setVilFilPubComp(VilFilPubComp);
				vilfil.setVilFilExpl(VilFilExpl);
				
				vilfilDAO.attachDirty(vilfil);
		
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
		List vf= vilfilDAO.findByProperty("goveFilClfy.goveFilClfyId", a);
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
		int rows = this.vilfilDAO.getCounts(sql, values);
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
		List<VilFil> list2 = new ArrayList<VilFil>();
		
		//String cityBasicInfoNum= (String) ServletActionContext.getRequest().getSession().getAttribute("sysUserBeloDiviCode");
		list2 = this.vilfilDAO.findByConditionAndPager(sql, values, from,length);
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for (VilFil b : list2) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("VilFilID", b.getVilFilId());
			
			if(b.getGoveFilClfy()== null){
				map.put("GoveFilClfyID",null);
			}else{
				map.put("GoveFilClfyID", b.getGoveFilClfy().getGoveFilClfyId());
			}
			
			if (b.getVilBasicInfo() == null) {
				map.put("VilBasicInfoID",null);
			} else {
				map.put("VilBasicInfoID", b.getVilBasicInfo().getVilName());
			}
		
			if (b.getVilFilNum() == null) {
				map.put("VilFilNum",null);
			} else {
				map.put("VilFilNum", b.getVilFilNum());
			}
			
			if (b.getVilFilName() == null) {
				map.put("VilFilName",null);
			} else {
				map.put("VilFilName", b.getVilFilName());
			}
			
			if (b.getVilFilIdef() == null) {
				map.put("VilFilIdef",null);
			} else {
				map.put("VilFilIdef", b.getVilFilIdef());
			}
			if (b.getVilFilMadTim() == null) {
				map.put("VilFilMadTim",null);
			} else {
				map.put("VilFilMadTim", b.getVilFilMadTim().toString().substring(0, 11));
			}
			
			if (b.getVilFilPubComp() == null) {
				map.put("VilFilPubComp", null);
			} else {
				map.put("VilFilPubComp", b.getVilFilPubComp());
			}
			
			if (b.getVilFilExpl() == null) {
				map.put("VilFilExpl", null);
			} else {
				map.put("VilFilExpl", b.getVilFilExpl());
			}
			
			
			
			
			result.add(map);
		}

		return result;
	}



	public boolean checkGoveFilClfyNumCode(String GoveFilClfyNum) {
		// TODO Auto-generated method stub
		return false;
	}



	

	

}
