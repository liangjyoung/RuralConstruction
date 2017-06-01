package com.rural.login.action;

import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import java.util.Map;



import org.apache.struts2.ServletActionContext;


import com.opensymphony.xwork2.ActionSupport;
import com.rural.login.service.ILoginService;
import com.rural.tool.EncoderHandler;

/**
 * @author LYJ
 *
 */
public class LoginAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String checkcode;  
	private ILoginService loginservice;
//	private HttpServletResponse response;
//	private Map<String, Object> session;
    private String              goingToURL;//登录前的URL
    private boolean 				success;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	


	///载入页面、角色切换时获取各项信息
	
	 private String    changeroleid;
	 
	
	public String loadroleid() throws Exception {
		ServletActionContext.getRequest().getSession().setAttribute("changeroleid",changeroleid);
		 return SUCCESS;
	 }
	public String refreshweb() throws Exception {
		String userid= (String) ServletActionContext.getRequest().getSession().getAttribute("userid");
		String sysUserBeloDiviCode= (String) ServletActionContext.getRequest().getSession().getAttribute("sysUserBeloDiviCode");
		changeroleid= (String) ServletActionContext.getRequest().getSession().getAttribute("changeroleid");
		//System.out.println("切换的ID为"+changeroleid);
		//userid="1";
		//sysUserBeloDiviCode="371202106248";
	//根据用户所属区划ID获得用户区划名
	String diviname=loginservice.chooseDivi(sysUserBeloDiviCode);
   	List<String> roleIDList=loginservice.checkRoleID(Integer.parseInt(userid));//根据userID获得roleID
   	//根据角色ID获得角色名
  //当前角色
   	String currentrole=null;
  //当前角色id
   	String currentroleid=null;
//   	if(changeroleid==null){
//   		currentrole=loginservice.checkRoleName(Integer.parseInt(roleIDList.get(0)));//当前角色
//   		currentroleid=roleIDList.get(0);
//   	}else{
   		currentroleid=changeroleid;
   		currentrole=loginservice.checkRoleName(Integer.parseInt(changeroleid));//修改后的角色角色
//   	}
   	String[] currentfunc=this.getRoleFunc(Integer.parseInt(currentroleid));	//当前角色功能
   	int ruleIDListnum=roleIDList.size();
   	String[] otherrolelist =new String[ruleIDListnum-1];
   	String[] otherroleidlist =new String[ruleIDListnum-1];
  //一个循环找到除当前角色外的其他角色
	int j=0;
	for(int i=0;i<ruleIDListnum;i++){
		if(roleIDList.get(i).equals(currentroleid)){
			continue;
		}else{
			otherrolelist[j]=loginservice.checkRoleName(Integer.parseInt(roleIDList.get(i)));;
			otherroleidlist[j]=roleIDList.get(i);
			j++;
		}
	}
	dataMap.put("currentrole", currentrole);
	dataMap.put("currentfunc", currentfunc);
	dataMap.put("otherrolelist", otherrolelist);
	dataMap.put("otherroleidlist", otherroleidlist);
	dataMap.put("diviname", diviname);
	changeroleid=null;//最后为roleid赋空值
		return SUCCESS;
	}
	public String getChangeroleid() {
		return changeroleid;
	}
	public void setChangeroleid(String changeroleid) {
		this.changeroleid = changeroleid;
	}
	public String[] getRoleFunc(int roleid) throws SQLException{
		List<String> funclist=loginservice.chooseFunc(roleid);
		String[] rolefunc=new String[funclist.size()];
		for(int i=0;i<funclist.size();i++){
			rolefunc[i]=funclist.get(i);
		}
		return rolefunc;
	}
	public String Login() throws Exception {

//	    	System.out.println("前台username："+username);
//	    	System.out.println("前台password："+password);
//	    	System.out.println("前台logintype："+logintype);
//	    	System.out.println("前台checkcode："+checkcode);
		
		
		//判断验证码程序  
        //从session中获得验证码的随机值  
        String checkcode1 = (String) ServletActionContext.getRequest().getSession().getAttribute("checkcode");  
        checkcode = checkcode.toLowerCase();
        checkcode1 = checkcode1.toLowerCase();
//        System.out.println("生成的验证码"+checkcode1);
//        System.out.println("输入的验证码"+checkcode);

	        String msg = "";
//	        System.out.println(a[0]);
//	        System.out.println(a[1]);
	        
	       // 检测验证码是否出错
	     /*   if(!checkcode.equalsIgnoreCase(checkcode1)){  
	        	this.success=false;
	        	msg = "验证码输入错误！";
	        	this.dataMap.put("success", success);
	            this.dataMap.put("msg", msg);           
	            return SUCCESS;
	        }*/  
	        
	        username=URLDecoder.decode(username,"UTF-8");
	        //字符串a中第一个为用户ID，第二个为所属区划ID
	        String[] a=this.loginservice.NameCheck(username, EncoderHandler.doubleEncode(password));
	        if(a[0]!=null){
	        	this.success=true;
	        	msg = "登录成功！";
//	        	String diviname=null;
//	        	if(a[1]!=null){
//	        		diviname=loginservice.chooseDivi(a[1]);//获取区划名
//	        	}
	        	//获得角色ID	
//	        	List<String> roleid=loginservice.chooseFunc(Integer.parseInt(a[0]));
	        	 ServletActionContext.getRequest().getSession().setAttribute("username", username);
	        	 ServletActionContext.getRequest().getSession().setAttribute("userid", a[0]);
	        	 ServletActionContext.getRequest().getSession().setAttribute("sysUserBeloDiviCode", a[1]);
	        	 
	        	 List<String> roleIDList=loginservice.checkRoleID(Integer.parseInt(a[0]));
	        	 changeroleid=roleIDList.get(0);
	        	 ServletActionContext.getRequest().getSession().setAttribute("changeroleid", changeroleid);
	        	 
	        	this.dataMap.put("success", success);
	            this.dataMap.put("msg", msg);           
	            return SUCCESS;
	        }else{
	        	this.success=false;
	        	msg = "用户名或密码错误！";
	        	this.dataMap.put("success", success);
	            this.dataMap.put("msg", msg);           
	            return SUCCESS;
	        }
	        
	        
	        
	    
	    }
	 
//	    public String isLogin(){
//	    	SysUser SysUser = (SysUser) session.get(Constants.SESSION_KEY_USER_NAME);
//	    	boolean is_login = false;
//	    	if (SysUser != null){
//	    		is_login = true;
//	    	}    	
//	    	dataMap.put("sucess", true);
//	    	dataMap.put("is_login", is_login);
//	    	
//	    	return SUCCESS;
//	    }
	 
	    public String logout(){
	    	
	    	 ServletActionContext.getRequest().getSession().invalidate();
	    	dataMap.put("sucess", true);
	    	
	    	return SUCCESS;
	    }
		public boolean isSuccess() {
			return success;
		}

		
	
		
		
		
		
		
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	public String getCheckcode() {
		return checkcode;
	}

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}



	
//	public HttpServletResponse getResponse() {
//		return response;
//	}
//
//
//	public void setResponse(HttpServletResponse response) {
//		this.response = response;
//	}
//
//
//	public Map<String, Object> getSession() {
//		return session;
//	}
//
//
//	public void setSession(Map<String, Object> session) {
//		this.session = session;
//	}


	public ILoginService getLoginservice() {
		return loginservice;
	}

	public void setLoginservice(ILoginService loginservice) {
		this.loginservice = loginservice;
	}

	public String getGoingToURL() {
		return goingToURL;
	}


	public void setGoingToURL(String goingToURL) {
		this.goingToURL = goingToURL;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
	
	
	
	//修改密码时的新、旧密码
	private String oldPassword;
	private String newPassword;
	//修改密码，之后移入SysuserAction
	public String updatepassword(){
		//oldPassword="123";
		//newPassword="321";
		//String userid="1";
		String userid= (String) ServletActionContext.getRequest().getSession().getAttribute("userid");
//		System.out.println("前台oldPassword："+oldPassword);
//		System.out.println("前台newPassword："+newPassword);
		if(loginservice.updatepassword(userid, oldPassword, newPassword)){
			this.dataMap.put("success", true);
		}
		else{
			this.dataMap.put("success", false);
		}
		return SUCCESS;
	}
	
	
	public String getOldPassword() {
		return oldPassword;
	}


	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}


	public String getNewPassword() {
		return newPassword;
	}


	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
//	public void setRoleid(String roleid) {
//		this.roleid = roleid;
//	}
//	public String getRoleid() {
//		return roleid;
//	}

}
