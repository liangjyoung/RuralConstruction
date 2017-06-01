package com.rural.colldatatemplet.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONArray;

import com.rural.bean.EvalContInvesObj;
import com.rural.bean.InvesObj;
import com.rural.bean.InvesPro;
import com.rural.dao.InvesObjDAO;
import com.rural.dao.InvesProDAO;

public class InvesProTreeService  implements IInvesProTreeService{
	
	
	private InvesProDAO invesProDAO = new InvesProDAO();
	private InvesObjDAO  invesObjDAO = new InvesObjDAO();
	
	
	
	public InvesProDAO getInvesProDAO() {
		return invesProDAO;
	}


	public void setInvesProDAO(InvesProDAO invesProDAO) {
		this.invesProDAO = invesProDAO;
	}

//下拉框
	public List<InvesPro> findAllPro() {
			
			List<InvesPro> list = new ArrayList<InvesPro>();
			list = this.invesProDAO.findAll();
			return list;
		}
	
	
	//检查节点编码是否重复
	public boolean checkProNumCode(String invesProNum) {
		// TODO Auto-generated method stub
		//flag==true表示提示错误，flag==false表示没有重复，不提示错误
		
		List<InvesPro> ip= invesProDAO.findByProperty("invesProNum", invesProNum);
		if(ip.size()>0){
			return true;//标识有重复
		}else{
			return false;
		}
				
		
	}
	
	
	
	
	public ArrayList<HashMap<String, Object>> findAll() {
		// TODO Auto-generated method stub
	
		List<InvesPro> list = new ArrayList<InvesPro>();
		String s = "asd";
		list = this.invesProDAO.findByProperty("UpInvesProNum", s);
		ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for (InvesPro a : list) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			
			map.put("passwordModify",a.getInvesProNum());

			result.add(map);
		}
		return result;
	}
	
	
	
	

	
	public InvesObjDAO getInvesObjDAO() {
		return invesObjDAO;
	}
	public void setInvesObjDAO(InvesObjDAO invesObjDAO) {
		this.invesObjDAO = invesObjDAO;
	}
	
	public List<InvesPro> getChildPermissions(String parentId) {
		// TODO Auto-generated method stub
		//根据parentId，得到其子节点的所有用户
		List<InvesPro> list = new ArrayList<InvesPro>();
		if (parentId==null) {
			list = this.invesProDAO.findFather();
		}else{
			list = this.invesProDAO.findChild(parentId);
		}
		return list;
	}
	
	/*
	 * 根据parentId，得到所有子节点
	 * */
	public List<InvesPro> getChildInvesPro(String parentId) {
		// TODO Auto-generated method stub
		List<InvesPro> list = new ArrayList<InvesPro>();
		list = this.invesProDAO.findFather(parentId);		
		return list;
	}
	
	public List<InvesPro> getChildInvesPro() {
		// TODO Auto-generated method stub
		List<InvesPro> list = new ArrayList<InvesPro>();
		list = this.invesProDAO.findAll();
		return list;
	}
	
	
	//添加节点
	public boolean addPro(String proNum, String proName, String sv) {
		// TODO Auto-generated method stub
		List<InvesPro> inp= invesProDAO.findByProperty("invesPro.invesProNum", sv);//查看该节点下是否存在调查对象
		if(inp.size()==0||sv.equals("0")){//若不存在调查对象或者要添加一级节点
			InvesPro ip = new InvesPro();
			ip = invesProDAO.findById(sv);
			InvesPro newip = new InvesPro();
			newip.setInvesPro(ip);
			newip.setInvesProName(proName);
			newip.setInvesProNum(proNum);
			invesProDAO.save(newip);
			return true;
		}else{
			return false;
		}
		
		
	}


	public String delInvesPro(String invesProNum) {
		// TODO Auto-generated method stub
		String message = "";
		InvesPro invesPro = new InvesPro();
		invesPro = invesProDAO.findById(invesProNum);
		
		
		List<InvesPro> ip= invesProDAO.findByProperty("invesPro.invesProNum", invesProNum);
		List io= invesObjDAO.findByProperty("invesPro.invesProNum", invesProNum);
		if(ip.size()>0){
			message = "调查项目已引用调查项目编号为"+invesPro.getInvesProNum()+"的对象，无法删除！\n";
		}else if(io.size()>0){
			message = "调查对象已引用调查项目编号为"+invesPro.getInvesProNum()+"的对象，无法删除！\n";
		}else if(invesProNum.equals("")){
			
			message = "请先删除其子节点";
		}
		else{
			invesProDAO.delete(invesPro);
			message = "项目编号为"+invesPro.getInvesProNum()+"的对象，删除成功！\n";
		}
		
	
		
		return message;
	}

}
