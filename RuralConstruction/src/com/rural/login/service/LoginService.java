package com.rural.login.service;

import java.sql.SQLException;
import java.util.List;

import com.rural.bean.CityBasicInfo;
import com.rural.bean.CountryBasicInfo;
import com.rural.bean.ProBasicInfo;
import com.rural.bean.SysUser;
import com.rural.bean.TownBasicInfo;
import com.rural.bean.VilBasicInfo;
import com.rural.dao.CityBasicInfoDAO;
import com.rural.dao.CountryBasicInfoDAO;
import com.rural.dao.ProBasicInfoDAO;
import com.rural.dao.RoleFuncPermDAO;
import com.rural.dao.SysFuncDAO;
import com.rural.dao.SysRoleDAO;
import com.rural.dao.SysRoleUserDAO;
import com.rural.dao.SysUserDAO;
import com.rural.dao.TownBasicInfoDAO;
import com.rural.dao.VilBasicInfoDAO;
import com.rural.tool.EncoderHandler;



public class LoginService implements ILoginService {

	private SysUserDAO userdao;
	private ProBasicInfoDAO prodao;//省
	private CityBasicInfoDAO citydao;//市
	private CountryBasicInfoDAO countrydao;//县
	private TownBasicInfoDAO towndao;//镇
	private VilBasicInfoDAO vildao;//村
	private SysRoleUserDAO roleuserdao;
	private SysRoleDAO roledao;
	private RoleFuncPermDAO rolefuncdao;
	private SysFuncDAO sysfuncdao;



	public boolean updatepassword(String userid, String oldPassword,String newPassword){
		SysUser sysuser=new SysUser();
		sysuser=userdao.findById(Integer.parseInt(userid));
		if(EncoderHandler.check(oldPassword,sysuser.getUserPas())){
			sysuser.setUserPas(EncoderHandler.doubleEncode(newPassword));
			userdao.merge(sysuser);
			return true;
		}else{
			return false;
		}
			
	}	
	

	public List<String> chooseFunc(int roleid) throws SQLException {
		// TODO Auto-generated method stub
		
		return rolefuncdao.chooseFunc(roleid);
	}
	
	public String checkRoleName(int roleid) throws SQLException {
		// TODO Auto-generated method stub
		
		return roledao.checkRoleName(roleid);
	}
	
	public List<String> checkRoleID(int userid) throws SQLException {
		// TODO Auto-generated method stub
		
		return roleuserdao.checkRoleID(userid);
	}
	
	public String chooseDivi(String diviCode){
		//一个for循环，从区划编码的末尾开始数零直到碰到非零数，根据非零数来判断属于哪一级的区划。
		
		String diviName = null;
		if(diviCode==null||diviCode.length()!=14){
			return diviName;
		}
		String diviCode1=diviCode.replace(".","");
		int zeroNum=0;
		for(int i=diviCode1.length();i>0;i--){
			if(diviCode1.charAt(i-1)!='0') break;
			zeroNum++;
		}
//		System.out.println(zeroNum);
		if(zeroNum<3)
		{
//			System.out.println("村级");
			
			
			List<VilBasicInfo>  vil=vildao.findByProperty1("vilNum",diviCode);
			diviName=vil.get(0).getVilName();
			
		}else if(zeroNum<5){
//			System.out.println("镇级");
			List<TownBasicInfo> town= towndao.findByProperty1("townNum",diviCode);
			diviName=town.get(0).getTownName();
		}else if(zeroNum<7){
//			System.out.println("县级");
			List<CountryBasicInfo> country= countrydao.findByProperty1("countryNum",diviCode);
			diviName=country.get(0).getCountryName();
//			System.out.println(diviName);
		}else if(zeroNum<9){
//			System.out.println("市级");
			//List<CityBasicInfo> city=citydao.findByCityNum(diviCode);
			List<CityBasicInfo> city=citydao.findByProperty1("cityNum", diviCode);
			diviName=city.get(0).getCityName();
		}else{
//			System.out.println("省级");
			List<ProBasicInfo> pro=prodao.findByProNum(diviCode);
			//List<ProBasicInfo> pro=prodao.findByProperty1("proNum",diviCode);
			diviName=pro.get(0).getProName();
		}
		return diviName;
	}
	
	public SysUser findById(int sysUserId) {
		// TODO Auto-generated method stub
		return this.userdao.findById(sysUserId);
	}

	public List findByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return this.userdao.findByProperty(propertyName, value);
	}
	
	public String[] NameCheck(String username, String password) throws SQLException{
		// TODO Auto-generated method stub
		return this.userdao.NameCheck(username, password);
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

	public void setUserdao(SysUserDAO userdao) {
		this.userdao = userdao;
	}

	public SysUserDAO getUserdao() {
		return userdao;
	}
	
	public SysRoleUserDAO getRoleuserdao() {
		return roleuserdao;
	}

	public void setRoleuserdao(SysRoleUserDAO roleuserdao) {
		this.roleuserdao = roleuserdao;
	}

	public void setRoledao(SysRoleDAO roledao) {
		this.roledao = roledao;
	}

	public SysRoleDAO getRoledao() {
		return roledao;
	}

	public void setRolefuncdao(RoleFuncPermDAO rolefuncdao) {
		this.rolefuncdao = rolefuncdao;
	}

	public RoleFuncPermDAO getRolefuncdao() {
		return rolefuncdao;
	}

	public void setSysfuncdao(SysFuncDAO sysfuncdao) {
		this.sysfuncdao = sysfuncdao;
	}

	public SysFuncDAO getSysfuncdao() {
		return sysfuncdao;
	}

}
