package com.rural.usermanager.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.rural.bean.CityBasicInfo;
import com.rural.bean.CountryBasicInfo;
import com.rural.bean.ProBasicInfo;
import com.rural.bean.SysRole;
import com.rural.bean.TownBasicInfo;
import com.rural.bean.VilBasicInfo;
import com.rural.tool.Criterion;



public interface ISysUserService {
 
//	public abstract ArrayList<HashMap<String, Object>> findAll();
	public abstract List<SysRole> getChildPrivance(  );
	public int queryResultsCount(List<Criterion> criteria);
	public abstract String resetPassword(String sysUserID);
	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria, int from,int length);
	public abstract String addSysRoleUser(String UserName,String UserNote,String UserBeloDiviCode);
	public abstract String updateSysUser(int SysUserID,String UserName, String UserNote,String UserBeloDiviCode);
	public abstract String delSysRoleUser(Integer SysRoleUserID);
	public abstract boolean checkUserName(String UserName,String SysUserID);
	public abstract Integer secrchCity( String UserBeloDiviCode);
	List<String> chooseDivi(String diviCode);
	List<List<TownBasicInfo>> chooseTown(String diviCode);
	List<CountryBasicInfo> chooseCountry(String diviCode);
	List<CityBasicInfo> chooseCity(String diviCode);
	List<ProBasicInfo> choosePro(String diviCode);
	
	  List<CityBasicInfo> AllCity();
	  List<CountryBasicInfo> AllCountry();	
	  List<TownBasicInfo> Alltown();	
}
