package com.rural.login.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rural.bean.SysUser;


import net.sf.json.JSONArray;

public interface ILoginService {
	
//	public List<UserAlias> findUser(String userID);
//	//public List<UserAlias> findUser(String userID,String password);
//	public List<Staff> findStaff(String userID);
//	public List<Role> findRole(String userID);
//	public List<UserAlias> findUserByGUID(String userID);
//	public Boolean updatePassword(String userID, String password);
	public SysUser findById(int  sysUserId);
	public List findByProperty(String propertyName, Object value);
	public String[] NameCheck(String username, String password) throws SQLException;
	public String chooseDivi(String diviCode);
	public List<String> checkRoleID(int userid) throws SQLException;
	public String checkRoleName(int roleid) throws SQLException;
	public List<String> chooseFunc(int roleid) throws SQLException;
	public boolean updatepassword(String userid, String oldPassword,String newPassword);
}
