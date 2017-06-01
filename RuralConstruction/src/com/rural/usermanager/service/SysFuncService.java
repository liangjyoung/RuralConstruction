package com.rural.usermanager.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rural.bean.SysFunc;
import com.rural.bean.RoleFuncPerm;
import com.rural.dao.SysFuncDAO;
import com.rural.dao.RoleFuncPermDAO;
import com.rural.tool.Criterion;


public class SysFuncService implements ISysFuncService{

	private SysFuncDAO sysfuncDAO = new SysFuncDAO();
	private RoleFuncPermDAO rolefuncpermDAO = new RoleFuncPermDAO();
	public ArrayList<HashMap<String, Object>> findAll() {
		// TODO Auto-generated method stub
	
		List<SysFunc> list = new ArrayList<SysFunc>();
		String s = "asd";
		list = this.sysfuncDAO.findByProperty("UpFuncNum", s);
		ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for (SysFunc a : list) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			
			map.put("passwordModify",a.getFuncNum());

			result.add(map);
		}
		return result;

	}
		
	
		public SysFuncDAO getSysfuncDAO() {
			return sysfuncDAO;
		}
	
	
		public void setSysfuncDAO(SysFuncDAO sysfuncDAO) {
			this.sysfuncDAO = sysfuncDAO;
		}

		
	
		public RoleFuncPermDAO getRolefuncpermDAO() {
			return rolefuncpermDAO;
		}


		public void setRolefuncpermDAO(RoleFuncPermDAO rolefuncpermDAO) {
			this.rolefuncpermDAO = rolefuncpermDAO;
		}


		public List<SysFunc> getChildPermissions(String parentId) {
			// TODO Auto-generated method stub
			//���parentId���õ����ӽڵ�������û�
			List<SysFunc> list = new ArrayList<SysFunc>();
			if (parentId==null) {
				list = this.sysfuncDAO.findFather();
			}else{
				list = this.sysfuncDAO.findChild(parentId);
			}
			return list;	
		}
	
	/*
	 * ���parentId���õ������ӽڵ�
	 * */
	public List<SysFunc> getChildSysFunc(String parentId) {
		// TODO Auto-generated method stub
		List<SysFunc> list = new ArrayList<SysFunc>();
		list = this.sysfuncDAO.findFather(parentId);		
		return list;
	}
	
	public List<SysFunc> getChildSysFunc() {
		// TODO Auto-generated method stub
		List<SysFunc> list = new ArrayList<SysFunc>();
		list = this.sysfuncDAO.findAll();
		return list;
	}


	public List<RoleFuncPerm> getRoleFunc(String parentId) {
		// TODO Auto-generated method stub
		List<RoleFuncPerm> list = new ArrayList<RoleFuncPerm>();
		list = this.rolefuncpermDAO.findFather(parentId);
		//list = this.rolefuncpermDAO.findByProperty("sysFunc.sysFuncNum", parentId);
		return list;
	}
	
	








}

