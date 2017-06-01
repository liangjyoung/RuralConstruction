package com.rural.usermanager.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONObject;


import com.rural.bean.CityBasicInfo;
import com.rural.bean.CountryBasicInfo;
import com.rural.bean.ProBasicInfo;
import com.rural.bean.Sex;
import com.rural.bean.SysRole;
import com.rural.bean.TownBasicInfo;
import com.rural.bean.VilBasicInfo;
import com.rural.dao.SysUserDAO;

import com.rural.usermanager.service.ISysUserService;
import com.rural.tool.AdditionalParameters;
import com.rural.tool.Criterion;
import com.rural.tool.Item;
import com.rural.tool.ItemType;
import com.rural.tool.JqGridBaseAction;

public class SysUserAction  extends JqGridBaseAction{

	
	private static final long serialVersionUID = 1L;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private String SysUserID;
	private String SysRoleUserID;
	private String UserPas;
	private String UserName;
	private String UserNote;
	private String UserBeloDiviCode;//所属区划
	private String oper;
	private String JQID;//角色的ID
	private ISysUserService isysuserService;
	public static String JQS;
	
	
	
	

	public String getSysUserID() {
		return SysUserID;
	}

	public void setSysUserID(String sysUserID) {
		SysUserID = sysUserID;
	}

	public String getUserPas() {
		return UserPas;
	}

	public void setUserPas(String userPas) {
		UserPas = userPas;
	}
	
	

	public String getSysRoleUserID() {
		return SysRoleUserID;
	}

	public void setSysRoleUserID(String sysRoleUserID) {
		SysRoleUserID = sysRoleUserID;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getUserNote() {
		return UserNote;
	}

	public void setUserNote(String userNote) {
		UserNote = userNote;
	}

	public String getUserBeloDiviCode() {
		return UserBeloDiviCode;
	}

	public void setUserBeloDiviCode(String userBeloDiviCode) {
		UserBeloDiviCode = userBeloDiviCode;
	}

	public ISysUserService getIsysuserService() {
		return isysuserService;
	}

	public void setIsysuserService(ISysUserService isysuserService) {
		this.isysuserService = isysuserService;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public String getJQID() {
		return JQID;
	}

	public void setJQID(String jQID) {
		JQID = jQID;
	}

	public static String getJQS() {
		return JQS;
	}

	public static void setJQS(String jQS) {
		JQS = jQS;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	
	//判断用户名称是否重复
	public String checkUserName(){
		//UserName = URLDecoder.decode(UserName, "UTF-8");
		try {
			
			//flag==true表示提示错误，flag==false表示没有重复，不提示错误
			if(SysUserID.equals("undefined"))SysUserID=null;//若id未定义则给其赋值为null
				boolean flag = isysuserService.checkUserName(UserName, SysUserID);
				if(flag){
					dataMap.put("success", true);
				}else{
					dataMap.put("success", false);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	
	//表入口
	public String manageSysUser() {
		SysUserAction.setJQS(JQID);
		if(!search){
			if ("add".equals(oper)) {//
				addSysRoleUser();
			} else if ("search".equals(oper)) {//
				refreshGridModel();
				responseData();
			} else if ("del".equals(oper)) {//
				delSysRoleUser();
			}else if("edit".equals(oper)){//
				updateSysRoleUser();
			}
		}else{
			refreshGridModel();
			responseData();
		}
		return SUCCESS;
	}
	
	
	public String addSysRoleUser() {
		
		String message = "";
		//获取角色	
		String	changeroleid= (String) ServletActionContext.getRequest().getSession().getAttribute("changeroleid");
		//根据角色判断是系统管理员还是地市管理员
		  if(changeroleid.equals("1"))	{//系统管理员   
			  message = isysuserService.addSysRoleUser(UserName,UserNote,UserBeloDiviCode);
		  }else{//地市管理员
			  if(JQID.equals("1")){
				  message = "很抱歉，您没有权限添加系统管理员！";
			  }
			  else{
				  message = isysuserService.addSysRoleUser(UserName,UserNote,UserBeloDiviCode);
			  }
			 
		  }
		
		this.dataMap.put("success", message);
		return SUCCESS;
	}
	
	//选择框
	public void selectData() throws Exception{
		
		
		//获取角色	
		String	changeroleid= (String) ServletActionContext.getRequest().getSession().getAttribute("changeroleid");
		// TODO Auto-generated method stub
		//根据角色判断是系统管理员还是地市管理员
		 StringBuilder sb = new StringBuilder();
		 sb.append("<select>");
        if(changeroleid.equals("1"))	{//系统管理员   	 
    	
    	 if(JQID.equals("2")){//所有市  		  
    		  List<CityBasicInfo> city1=isysuserService.AllCity();			
				for (CityBasicInfo city : city1) {
					sb.append("<option value='");
					sb.append(city.getCityNum()).append("'>").append(city.getCityName());
					sb.append("</option>");
				}		
    		  
    	  }else if(JQID.equals("3")){//获得所有市
    		  
    		List<CityBasicInfo> city1=isysuserService.AllCity();			
				for (CityBasicInfo city : city1) {
					sb.append("<option value='");
					sb.append(city.getCityNum()).append("'>").append(city.getCityName());
					sb.append("</option>");
				}	
    	  }else if(JQID.equals("4")){//获得所有县
    		  
    		  List<CountryBasicInfo> country1=isysuserService.AllCountry();			
				for (CountryBasicInfo country : country1) {
					sb.append("<option value='");
					sb.append(country.getCountryNum()).append("'>").append(country.getCountryName());
					sb.append("</option>");
				}		
				
    	  }else if(JQID.equals("5")){//获得所有镇
    		  
    		  List<TownBasicInfo> town1=isysuserService.Alltown();			
				for (TownBasicInfo town : town1) {
					sb.append("<option value='");
					sb.append(town.getTownNum()).append("'>").append(town.getTownName());
					sb.append("</option>");
				}		
				
    	  }
    	  
    	  
    	  
    	  
    	  
      }else{//地市管理员
    	  
    	//获取区划编码
  		String UserBeloDiviCode= (String) ServletActionContext.getRequest().getSession().getAttribute("sysUserBeloDiviCode");
  		String userBeloDiviCode="'"+UserBeloDiviCode+"'";
  		
    	  if(JQID.equals("2")){
    		  //获得所有的市 		  
    		  //查找时那个市的
    	//	 Integer a =  isysuserService.secrchCity(UserBeloDiviCode);
    		 List<CityBasicInfo> city=isysuserService.chooseCity(userBeloDiviCode);			
				for (CityBasicInfo sex : city) {
					sb.append("<option value='");
					sb.append(sex.getCityNum()).append("'>").append(sex.getCityName());
					sb.append("</option>");
				}		
    		  
    	  }else if(JQID.equals("3")){
    		  List<CityBasicInfo> city=isysuserService.chooseCity(userBeloDiviCode);			
				for (CityBasicInfo sex : city) {
					sb.append("<option value='");
					sb.append(sex.getCityNum()).append("'>").append(sex.getCityName());
					sb.append("</option>");
				}		
    	  }else if(JQID.equals("4")){//县级
    		  List<CountryBasicInfo> country= isysuserService.chooseCountry(userBeloDiviCode);			
				for (CountryBasicInfo sex : country) {
					sb.append("<option value='");
					sb.append(sex.getCountryNum()).append("'>").append(sex.getCountryName());
					sb.append("</option>");
				}	
    		  
    	  }
    	  else if(JQID.equals("5")){//镇级
    		  List< List<TownBasicInfo>> diviName=isysuserService.chooseTown(userBeloDiviCode);			
				for (List<TownBasicInfo> sex : diviName) {
					for (TownBasicInfo townBasicInfo : sex) {
						sb.append("<option value='");
						sb.append(townBasicInfo.getTownNum()).append("'>").append(townBasicInfo.getTownName());
						sb.append("</option>");
					}
					
				}	
    		  
    	  }
    	  
      }
        sb.append("</select>");
		ServletActionContext.getResponse().setContentType(
				"text/html; charset=utf-8");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		out.write(sb.toString());	
		
		
		
		
		
	}
	
	private String updateSysRoleUser(){
		String message="";
		//获取角色	
		String	changeroleid= (String) ServletActionContext.getRequest().getSession().getAttribute("changeroleid");
		//根据角色判断是系统管理员还是地市管理员
		  if(changeroleid.equals("1")){
			  message= message+ isysuserService.updateSysUser(Integer.parseInt(SysUserID),UserName,UserNote,UserBeloDiviCode);
		  }else{
			  if(JQID.equals("1")){
				  message = "很抱歉，您没有权限修改系统管理员信息！"  ;
			  }else{
				  message= message+ isysuserService.updateSysUser(Integer.parseInt(SysUserID),UserName,UserNote,UserBeloDiviCode);
			  }
		  }
		 
	
		this.dataMap.put("success", message);
		return SUCCESS;
	}
	
	private String delSysRoleUser(){
		String message="";
		//获取角色	
		String	changeroleid= (String) ServletActionContext.getRequest().getSession().getAttribute("changeroleid");
		//根据角色判断是系统管理员还是地市管理员
		  if(changeroleid.equals("1")){
				for(String id:SysRoleUserID.split(",")){
					message= message+ isysuserService.delSysRoleUser(Integer.parseInt(id));
				}
			  
		  }	else{
			  if(JQID.equals("1")){
				  message = "很抱歉，您没有权限删除系统管理员！"  ;
			  }else{
				  for(String id:SysRoleUserID.split(",")){
						message= message+ isysuserService.delSysRoleUser(Integer.parseInt(id));
					}
			  }
		  }
		
		
	
		dataMap.put("success", message);
		//this.dataMap.put("success", true);
	    return SUCCESS;
	}
	
	/**
	 * 打包服务器数据
	 */
	public void responseData(){
		dataMap.put("page", page);
		dataMap.put("total", total);
		dataMap.put("records", records);
		dataMap.put("data", results);
	}
	
	
	//重置学生密码
	public String resetPassword(){
		String message="";
		//获取角色	
		String	changeroleid= (String) ServletActionContext.getRequest().getSession().getAttribute("changeroleid");
		//根据角色判断是系统管理员还是地市管理员
		  if(changeroleid.equals("1")){
			  message= message+ isysuserService.resetPassword(SysRoleUserID);
		  }else{
			  if(JQID.equals("1")){
				  message = "很抱歉，您没有权限重置系统管理员密码！"  ; 
			  }else{
				  message= message+ isysuserService.resetPassword(SysRoleUserID);
			  }
		  }
		  this.dataMap.put("success", message);		
		return SUCCESS;
	}
	
	
	
	
	
	//���ṹ���
	public String SysRole( ) {
		
		Map<String,Item> items = new LinkedHashMap<String,Item>( ); 
		
	    items= getChildNodes(items); 
	   // JSONObject ja1 = JSONObject.fromObject(items);
	   // System.out.println(ja1.toString());
		dataMap.put("ss",items); //ja1.toString());
		return SUCCESS;
	}
	
	
	private Map getChildNodes( Map<String,Item> items )  
    {  
		List<SysRole> permissions=isysuserService.getChildPrivance( );  
		int count = 0;
       // if(permissions.size( )>0){  
            for ( SysRole permission : permissions )// BudgPro��Ҫ�γ������� 
            {  
            
               //���ýڵ�
                Item item=new Item( );  
                item.setName( permission.getRoleName()); //�����ּ��뵽item 
              
                //�õ��ĸ��ڵ�Ľڵ�
                item.setType( ItemType.NODE_ITEM );  
                AdditionalParameters additionalParameters=new AdditionalParameters( );  
                additionalParameters.setId(permission.getSysRoleId()+"");
                if (count == 0) {
                	additionalParameters.setItemSelected(true);
                	count++;
                	//System.out.println("------------------>"+JSONObject.fromObject(additionalParameters));
				} else {
					
					additionalParameters.setItemSelected(false);
				}
                
                item.setAdditionalParameters( additionalParameters ); 
                
                //getChildItems(item,permission.getMajorCatgNum().toString( ),permission.getMajorCatgName( ));  
                items.put( permission.getRoleName(), item );  
            }  
      //  }  
        return items;
    }
	
	
	

	@Override
	public int getResultSize() {
		// TODO Auto-generated method stub
		return this.isysuserService.queryResultsCount(null);
	}

	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return  this.isysuserService.queryByPage(null, from, length);
	}

	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return  this.isysuserService.queryResultsCount(criteria);
	}

	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		return results=this.isysuserService.queryByPage(criteria, from, length);
	}

	public ISysUserService getSysuserService() {
		return isysuserService;
	}

	public void setSysuserService(ISysUserService sysuserService) {
		this.isysuserService = sysuserService;
	}
}
