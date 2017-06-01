package com.rural.usermanager.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rural.bean.RoleFuncPerm;
import com.rural.bean.SysFunc;
import com.rural.bean.SysRole;
import com.rural.bean.SysUser;
import com.rural.dao.RoleFuncPermDAO;
import com.rural.dao.SysFuncDAO;
import com.rural.dao.SysRoleDAO;

public class SysRoleFuncService implements ISysRoleFuncService{
	private SysFuncDAO sysfuncDAO = new SysFuncDAO();
	private SysRoleDAO  sysRoleDAO = new SysRoleDAO();
	private RoleFuncPermDAO roleFuncPermDAO = new RoleFuncPermDAO();
	
	public SysFuncDAO getSysfuncDAO() {
		return sysfuncDAO;
	}
	public void setSysfuncDAO(SysFuncDAO sysfuncDAO) {
		this.sysfuncDAO = sysfuncDAO;
	}
	public SysRoleDAO getSysRoleDAO() {
		return sysRoleDAO;
	}
	public void setSysRoleDAO(SysRoleDAO sysRoleDAO) {
		this.sysRoleDAO = sysRoleDAO;
	}
	public String  modify(int roleId, String[] funcIdArray) {
		// TODO Auto-generated method stub
		String message = "";
		if(roleId==1){
			message = "系统管理员不能进行权限分配";
		}else{
			List <RoleFuncPerm> roleFuncPermList = this.roleFuncPermDAO.findByProperty("sysRole.sysRoleId", roleId);
			for(RoleFuncPerm rf: roleFuncPermList){
				this.roleFuncPermDAO.delete(rf);
			}
			
			
			for(int i=0; i<funcIdArray.length; i++){
				RoleFuncPerm rf = new RoleFuncPerm();
				
				SysRole sr = new SysRole();
				SysFunc sf = new SysFunc();
				SysFunc sf1 = new SysFunc();
				
				sf=sysfuncDAO.findById(funcIdArray[i]);
				sr.setSysRoleId(new Integer(roleId));
				sf.setFuncNum(funcIdArray[i].trim());
				if(sf.getSysFunc()!=null){	
				RoleFuncPerm rf1 = new RoleFuncPerm();
				String a = sf.getSysFunc().getFuncNum();
				List <RoleFuncPerm> roleFuncPermList1 = this.roleFuncPermDAO.findByProperty1("sysFunc.funcNum", a.trim());
				boolean flag=true;
				for(RoleFuncPerm rl: roleFuncPermList1){
					if(rl.getSysRole().getSysRoleId()==roleId){
						flag=false;
						break;
						
					}
				}
				if(roleFuncPermList1.size()==0||flag==true){
				sf1.setFuncNum(sf.getSysFunc().getFuncNum());
				rf1.setSysFunc(sf1);
				rf1.setSysRole(sr);
				this.roleFuncPermDAO.save(rf1);
				}
				}
				
				rf.setSysRole(sr);
				rf.setSysFunc(sf);
				
				this.roleFuncPermDAO.save(rf);
				
				
			}
			message = "权限分配成功！";
			
		}
		return message;
		
		
		
		
	}
	public RoleFuncPermDAO getRoleFuncPermDAO() {
		return roleFuncPermDAO;
	}
	public void setRoleFuncPermDAO(RoleFuncPermDAO roleFuncPermDAO) {
		this.roleFuncPermDAO = roleFuncPermDAO;
	}

}

