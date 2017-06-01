package com.rural.usermanager.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.apache.struts2.ServletActionContext;

import com.rural.bean.CityBasicInfo;
import com.rural.bean.CountryBasicInfo;
import com.rural.bean.ProBasicInfo;
import com.rural.bean.SysRole;
import com.rural.bean.SysRoleUser;
import com.rural.bean.SysUser;
import com.rural.bean.TownBasicInfo;
import com.rural.bean.VilBasicInfo;


import com.rural.dao.SysRoleDAO;
import com.rural.dao.SysRoleUserDAO;
import com.rural.dao.SysUserDAO;
import com.rural.dao.VilBasicInfoDAO;
import com.rural.dao.CityBasicInfoDAO;
import com.rural.dao.CountryBasicInfoDAO;
import com.rural.dao.ProBasicInfoDAO;
import com.rural.dao.TownBasicInfoDAO;
import com.rural.tool.Criterion;
import com.rural.tool.EncoderHandler;
import com.rural.usermanager.action.SysUserAction;


public class SysUserService implements ISysUserService{

	
	private TownBasicInfoDAO towndao = new TownBasicInfoDAO();
	private VilBasicInfoDAO vildao = new VilBasicInfoDAO();
	private ProBasicInfoDAO prodao = new ProBasicInfoDAO();
	private CityBasicInfoDAO citydao = new CityBasicInfoDAO();
	private CountryBasicInfoDAO countrydao = new CountryBasicInfoDAO();
	
	private SysRoleDAO sysroleDAO = new SysRoleDAO();
	private SysUserDAO sysuserDAO = new SysUserDAO(); 
	private SysRoleUserDAO sysroleuserDAO = new SysRoleUserDAO(); 
	
	public TownBasicInfoDAO getTowndao() {
		return towndao;
	}

	public void setTowndao(TownBasicInfoDAO towndao) {
		this.towndao = towndao;
	}

	public VilBasicInfoDAO getVildao() {
		return vildao;
	}

	public void setVildao(VilBasicInfoDAO vildao) {
		this.vildao = vildao;
	}

	public ProBasicInfoDAO getProdao() {
		return prodao;
	}

	public void setProdao(ProBasicInfoDAO prodao) {
		this.prodao = prodao;
	}

	public CityBasicInfoDAO getCitydao() {
		return citydao;
	}

	public void setCitydao(CityBasicInfoDAO citydao) {
		this.citydao = citydao;
	}

	public CountryBasicInfoDAO getCountrydao() {
		return countrydao;
	}

	public void setCountrydao(CountryBasicInfoDAO countrydao) {
		this.countrydao = countrydao;
	}

	public SysUserDAO getSysuserDAO() {
		return sysuserDAO;
	}

	public void setSysuserDAO(SysUserDAO sysuserDAO) {
		this.sysuserDAO = sysuserDAO;
	}

	public SysRoleDAO getSysroleDAO() {
		return sysroleDAO;
	}

	public void setSysroleDAO(SysRoleDAO sysroleDAO) {
		this.sysroleDAO = sysroleDAO;
	}

	
	public SysRoleUserDAO getSysroleuserDAO() {
		return sysroleuserDAO;
	}

	public void setSysroleuserDAO(SysRoleUserDAO sysroleuserDAO) {
		this.sysroleuserDAO = sysroleuserDAO;
	}

	public List<SysRole> getChildPrivance() {
		List<SysRole> list = new ArrayList<SysRole>();
		list = this.sysroleDAO.findAll();
		return list;
	}
	
	
	//表格检查用户名称是否重复 功能
	public boolean checkUserName(String UserName,String SysUserID) {
		// TODO Auto-generated method stub
		//id=-1表示为增加一条记录,否则表示编辑
		//flag==true表示提示错误，flag==false表示没有重复，不提示错误
		if(SysUserID==null){
			if(sysuserDAO.findByUserName(UserName).isEmpty()){
				return false;
			}else{
				return true;
			}
		}else{
			if(sysuserDAO.findById(Integer.parseInt(SysUserID)).getUserName().equals(UserName)){
				return false;
			}else{
				if(sysuserDAO.findByUserName(UserName).isEmpty()){
					return false;
				}else{
					return true;
				}
			}
		}
	}
	
	
    //重置密码
	public String resetPassword(String SysRoleUserID) {
		// TODO Auto-generated method stub
		String message = "";
		SysRoleUser sr = sysroleuserDAO.findById(Integer.parseInt(SysRoleUserID));
		Integer userid =sr.getSysUser().getSysUserId();
		SysUser syu=sysuserDAO.findById(userid);
		syu.setUserPas(EncoderHandler.doubleEncode("123456"));
		sysuserDAO.merge(syu);
		message = "重置密码为123456";
		return message;
	}

	//添加
	public String  addSysRoleUser(String UserName,String UserNote,String UserBeloDiviCode){
		// TODO Auto-generated method stub
		String message = "";
		List sysuserlist= sysuserDAO.findByUserName(UserName);
		
		if(sysuserlist.size()>0){
			SysUser sysuser = new SysUser();
			
			List<SysUser> syulist = sysuserDAO.findByUserName(UserName);  
			int sysuserID = 0;
			for (SysUser object : syulist) {
				sysuserID = object.getSysUserId();
			}
			String JSID  = SysUserAction.getJQS(); //角色ID
			
			//List syslist = sysroleuserDAO.findDoiubleSearch(sysuserID, Integer.parseInt(JSID));
			/*if (syslist.size() > 0) {
				message = "该用户已存在";
			} else {*/
				SysRole sysRole = new SysRole();
				sysRole = this.sysroleDAO.findById(Integer.parseInt(JSID));
				SysRoleUser sysRoleUser = new SysRoleUser();
				sysuser = sysuserDAO.findById(sysuserID);
				sysRoleUser.setSysRole(sysRole);
				sysRoleUser.setSysUser(sysuser);				
				sysroleuserDAO.save(sysRoleUser);
				message = "添加成功";
			//}
			
		}else{
			
			SysUser sysuser = new SysUser();
			sysuser.setUserName(UserName);
			sysuser.setUserNote(UserNote);
			sysuser.setUserBeloDiviCode(UserBeloDiviCode);
			String userPas="123456";
			sysuser.setUserPas(EncoderHandler.doubleEncode(userPas));
			sysuserDAO.save(sysuser);
			SysUser syu = new SysUser();
			List<SysUser> syulist = sysuserDAO.findByUserName(UserName);
			int sysuserID = 0;
			for (SysUser object : syulist) {
				sysuserID = object.getSysUserId();
			}
			syu = sysuserDAO.findById(sysuserID);
			String JSID  = SysUserAction.getJQS();
			SysRole sysRole = new SysRole();
			sysRole = this.sysroleDAO.findById(Integer.parseInt(JSID));
			SysRoleUser sysRoleUser = new SysRoleUser();
			sysRoleUser.setSysRole(sysRole);
			sysRoleUser.setSysUser(syu);
			sysroleuserDAO.save(sysRoleUser);
			message = "添加成功";
		}
		
		
		return message;
	}
	
	//表格的编辑功能
	public String updateSysUser(int SysUserID,String UserName, String UserNote,String UserBeloDiviCode) {
		String message = "";
		// TODO Auto-generated method stub
	/*	String message = "";
		List sysuserlist= sysuserDAO.findByUserName(UserName);
		if(sysuserlist.size()>1){
			message = "该用户名已被使用";
		}else{*/
			SysUser sysuser = new SysUser();
			sysuser= sysuserDAO.findById(SysUserID);
			sysuser.setUserName(UserName);
			sysuser.setUserNote(UserNote);
			sysuser.setUserBeloDiviCode(UserBeloDiviCode);
			sysuserDAO.attachDirty(sysuser);
			message = "修改成功";
			return message;
	//	}
		
		
		
	}
	public String delSysRoleUser(Integer SysRoleUserID){
		String message = "";
		SysRoleUser sr= sysroleuserDAO.findById(SysRoleUserID);
		//根据角色用户的id找到该用户
		//SysRoleUser sysroleuser = new SysRoleUser();
		//Integer a=sysroleuser.getSysUser().getSysUserId();
		SysUser su1 = sysuserDAO.findById(sr.getSysUser().getSysUserId());
		List<SysRoleUser> vf= sysroleuserDAO.findByProperty("sysUser.sysUserId", sr.getSysUser().getSysUserId());
		if(vf.size()>1){
			sysroleuserDAO.delete(sr);
			message = "删除成功！\n";
			
		}else{
			sysroleuserDAO.delete(sr);
			sysuserDAO.delete(su1);
			message = "用户名称为"+su1.getUserName()+"的对象，删除成功！\n";
		}
		return message;
	}
	

	
	public int queryResultsCount(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		String sql = null;
		List<Object> values = null;
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
		int rows = this.sysroleuserDAO.getCounts(sql, values);
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
		List<SysRoleUser> list2 = new ArrayList<SysRoleUser>();
		/*//获取用户所属区划编码
		String cityBasicInfoNum= (String) ServletActionContext.getRequest().getSession().getAttribute("sysUserBeloDiviCode");
		//String cityBasicInfoNum="371200000000";
		List<CityBasicInfo> city1=citydao.findByCityNum(cityBasicInfoNum);
		int cityBasicInfoId = city1.get(0).getCityBasicInfoId();*/
		list2 = this.sysroleuserDAO.findByConditionAndPager(sql, values, from,length);
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for (SysRoleUser b : list2) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("SysRoleUserID", b.getSysRoleUserId());
			if (b.getSysUser() == null) {
				map.put("SysUserID",null);
			} else {
				map.put("SysUserID", b.getSysUser().getSysUserId());
			}
			
			if (b.getSysUser() == null) {
				map.put("UserName",null);
			} else {
				map.put("UserName", b.getSysUser().getUserName());
			}
			
			if (b.getSysUser() == null) {
				map.put("UserNote",null);
			} else {
				map.put("UserNote", b.getSysUser().getUserNote());
			}
			
			if (b.getSysUser() == null) {
				map.put("UserBeloDiviCode",null);
			} else {
				map.put("UserBeloDiviCode", b.getSysUser().getUserBeloDiviCode());
			}
		
			result.add(map);
		}

		return result;
	}
	
	public List<List<TownBasicInfo>> chooseTown(String diviCode) {//由市的编码找到县下面所有的镇
		List<CountryBasicInfo> country= countrydao.findByProperty("cityBasicInfo.cityBasicInfoId", secrchCity(diviCode));//找到所有的县		
		List<List<TownBasicInfo>> town= new ArrayList<List<TownBasicInfo>>();
		for (CountryBasicInfo countryBasicInfo : country) {
			Integer aa = countryBasicInfo.getCountryBasicInfoId();
		
			
			List<TownBasicInfo> town1 = towndao.findByProperty("countryBasicInfo.countryBasicInfoId",aa);
			town.add(town1);

			
		}
		return town;	
	} 
	
	public List<CountryBasicInfo> chooseCountry(String diviCode) {
		
		List<CountryBasicInfo> country= countrydao.findByProperty("cityBasicInfo.cityBasicInfoId", secrchCity(diviCode));
		return country;
	}

	public List<CityBasicInfo> chooseCity(String diviCode) {
		List<CityBasicInfo> city=citydao.findByCityNum(diviCode);
		return city;
	}

	public List<ProBasicInfo> choosePro(String diviCode) {
		List<ProBasicInfo> pro=prodao.findByProNum(diviCode);
		return pro;
	}

	public List<String> chooseDivi(String diviCode) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer secrchCity(String UserBeloDiviCode) {
		// TODO Auto-generated method stub
		Integer b = null;
	 List<CityBasicInfo> cc = citydao.findByCityNum(UserBeloDiviCode);
	 for (CityBasicInfo cityBasicInfo : cc) {
		 
		 b = cityBasicInfo.getCityBasicInfoId();
	 }
	 
	   return b;
	}
	
	

	public List<CityBasicInfo> AllCity(){
		return citydao.findAll();
	}
	
	public List<CountryBasicInfo> AllCountry(){
		return countrydao.findAll();
	}
	
	public List<TownBasicInfo> Alltown(){
		return towndao.findAll();
	}
	
	
}
