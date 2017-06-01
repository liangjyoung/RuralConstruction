package com.rural.usermanager.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rural.bean.SysRole;
import com.rural.dao.SysRoleDAO;

public class SysRoleService implements ISysRoleService{

	private SysRoleDAO sysroleDAO = new SysRoleDAO();
	 public ArrayList<HashMap<String, Object>> findAll() {
		// TODO Auto-generated method stub
	
		List<SysRole> list = new ArrayList<SysRole>();
		String s = "asd";
		list = this.sysroleDAO.findByProperty("UpSysRoleID", s);
		ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for (SysRole a : list) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			
			map.put("passwordModify",a.getSysRoleId());

			result.add(map);
		}
		return result;

	}  
	
	

	public SysRoleDAO getSysroleDAO() {
		return sysroleDAO;
	}



	public void setSysroleDAO(SysRoleDAO sysroleDAO) {
		this.sysroleDAO = sysroleDAO;
	}




	public List<SysRole> getChildPermissions(String parentId) {
		// TODO Auto-generated method stub
		//���parentId���õ����ӽڵ�������û�
		List<SysRole> list = new ArrayList<SysRole>();
		if (parentId==null) {
			list = this.sysroleDAO.findFather();
		}else{
			list = this.sysroleDAO.findChild(parentId);
		}
		return list;	
	}
	
	


	/*
	 * ���parentId���õ������ӽڵ�
	 * */

	
	public List<SysRole> getChildSysRole() {
		// TODO Auto-generated method stub
		List<SysRole> list = new ArrayList<SysRole>();
		list = this.sysroleDAO.findAll();
		return list;
	}

}
