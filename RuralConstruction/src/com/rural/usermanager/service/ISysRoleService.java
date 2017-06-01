package com.rural.usermanager.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rural.bean.SysRole;

public interface ISysRoleService {
	public abstract ArrayList<HashMap<String, Object>> findAll();
	public abstract List<SysRole> getChildPermissions( String parentId );  
	 
	public abstract List<SysRole> getChildSysRole(  ); 
}

