package com.rural.usermanager.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rural.bean.RoleFuncPerm;
import com.rural.bean.SysFunc;

public interface ISysFuncService {

	public abstract ArrayList<HashMap<String, Object>> findAll();
	public abstract List<SysFunc> getChildPermissions( String parentId );  
	public abstract List<SysFunc> getChildSysFunc( String parentId );  
	public abstract List<SysFunc> getChildSysFunc(  ); 
	public abstract List<RoleFuncPerm> getRoleFunc(String parentId);
}
