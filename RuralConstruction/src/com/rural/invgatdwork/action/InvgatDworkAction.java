package com.rural.invgatdwork.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.rural.bean.Invgat;
import com.rural.bean.VilBasicInfo;
import com.rural.invgatdwork.service.IInvgatDworkService;
import com.rural.tool.Criterion;
import com.rural.tool.JqGridBaseAction;



public class InvgatDworkAction extends JqGridBaseAction{
	
	private static final long serialVersionUID = 1L;
	private IInvgatDworkService iInvgatDworkService;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private String oper;
	private String invgatID;
	private String vilBasicInfoID;
	private String invgatDworkID;
	public static String JQI;
	public static String JQV;
	//public static String[] isVilNum =  new String[100];
	//public static ArrayList<String> list = new ArrayList<String>();
	
	
	public IInvgatDworkService getiInvgatDworkService() {
		return iInvgatDworkService;
	}
	
	public void setiInvgatDworkService(IInvgatDworkService iInvgatDworkService) {
		this.iInvgatDworkService = iInvgatDworkService;
	}
	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
	public String getOper() {
		return oper;
	}
	public void setOper(String oper) {
		this.oper = oper;
	}
	
	
	

	public String getInvgatID() {
		return invgatID;
	}

	public void setInvgatID(String invgatID) {
		this.invgatID = invgatID;
	}

	public String getVilBasicInfoID() {
		return vilBasicInfoID;
	}

	public void setVilBasicInfoID(String vilBasicInfoID) {
		this.vilBasicInfoID = vilBasicInfoID;
	}

	public static String getJQI() {
		return JQI;
	}

	public static void setJQI(String jQI) {
		JQI = jQI;
	}

	public static String getJQV() {
		return JQV;
	}

	public static void setJQV(String jQV) {
		JQV = jQV;
	}

	
	public String getInvgatDworkID() {
		return invgatDworkID;
	}

	public void setInvgatDworkID(String invgatDworkID) {
		this.invgatDworkID = invgatDworkID;
	}

	public String manageInvgatDwork(){
		InvgatDworkAction.setJQV(vilBasicInfoID);
		InvgatDworkAction.setJQI(invgatID);
		if(!search){
			if ("add".equals(oper)) {//澧炲姞
				addInvgatDwork();
			} else if ("search".equals(oper)) {//杞藉叆椤甸潰鏃舵煡璇�
				refreshGridModel();
				responseData();
			} else if ("del".equals(oper)) {//鍒犻櫎
				delInvgatDwork();
			}else if("edit".equals(oper)){//淇敼
				updateInvgatDwork();
				
			}
		}else{//鏌ヨ
			refreshGridModel();
			responseData();
		}
		return SUCCESS;
	}
	
	public String manageInvgatDwork1(){
		InvgatDworkAction.setJQV(vilBasicInfoID);
		InvgatDworkAction.setJQI(invgatID);
		if(!search){
			if ("add".equals(oper)) {//澧炲姞
				addInvgatDwork1();
			} else if ("search".equals(oper)) {//杞藉叆椤甸潰鏃舵煡璇�
				refreshGridModel();
				responseData();
			} else if ("del".equals(oper)) {//鍒犻櫎
				delInvgatDwork();
			}else if("edit".equals(oper)){//淇敼
				updateInvgatDwork();
				
			}
		}else{//鏌ヨ
			refreshGridModel();
			responseData();
		}
		return SUCCESS;
	}
	
	public String aa(){
		this.dataMap.put("success", "ss");
		return SUCCESS;
		
	}

	public String updateInvgatDwork() {
		// TODO Auto-generated method stub
		//iInvgatDworkService.updateInvgatDwork( invgatNum,vilNum);
		this.dataMap.put("success", true);
		return SUCCESS;
	}

	public String delInvgatDwork() {
		// TODO Auto-generated method stub
		for(String a: invgatDworkID.split(","))
		{
			iInvgatDworkService.delInvgatDwork(Integer.parseInt(a));
		}
		this.dataMap.put("success", true);
		return SUCCESS;
	}
/*
	public String addInvgatDwork() {
		// TODO Auto-generated method stub
		String message = "";
		for(String a : vilNum.split(",")){
			message = iInvgatDworkService.addInvgatDwork(invgatNum,a);
		}
		this.dataMap.put("success", message);
		return SUCCESS;
	}
*/

	public boolean isAdd(){
		boolean flag = true;
		for(String a: vilBasicInfoID.split(",")){
			if(!iInvgatDworkService.isAdd(Integer.parseInt(a))){
				flag = false;
				break;			
			}
		}
		return flag;
	} 
	public String addInvgatDwork() {
		// TODO Auto-generated method stub
		String message = "";
		boolean c;
		if(isAdd()){
			for(String b : vilBasicInfoID.split(",")){
				message = iInvgatDworkService.addInvgatDwork(Integer.parseInt(invgatID.trim()),Integer.parseInt(b.trim()));
			}
		}
		else{
			
			
			message = "存在已经被分配的村庄，请重新分配!";
		}
		this.dataMap.put("success", message);
		return SUCCESS;
	}
	
	public boolean isAdd1(){
		boolean flag = true;
		for(String a: vilBasicInfoID.split(",")){
			if(!iInvgatDworkService.isAdd(iInvgatDworkService.getVilID(a.trim()))){
				flag = false;
				break;			
			}
		}
		return flag;
	} 
	
	public String addInvgatDwork1() {
		// TODO Auto-generated method stub
		String message = "";
		String message1= "";
		boolean c;
		int a = 0;
		int t = 0;
		if(vilBasicInfoID.equals("undefined")){
			message = "请选择要分配的村庄！";
		}
		else{
			if(isAdd1()){
				for(String b : vilBasicInfoID.split(",")){
					message = iInvgatDworkService.addInvgatDwork(Integer.parseInt(invgatID.trim()),iInvgatDworkService.getVilID(b.trim()));
				}
			}
			else{
				for(String b : vilBasicInfoID.split(",")){
					
					 a = iInvgatDworkService.getVilID(b.trim());
					 if(iInvgatDworkService.isAdd(a)){
						 iInvgatDworkService.addInvgatDwork(Integer.parseInt(invgatID.trim()),iInvgatDworkService.getVilID(b.trim()));
						 
					 } else{
						 t=a;
					 message1 = message1+	iInvgatDworkService.getVil(t).getVilName()+"  ";
						 
					 }
				
				}
				
				message = "存在已经被分配的村庄:"+" "+message1+" "+"其余的已经分配成功!";
			}
			
		}
		
		
		this.dataMap.put("success", message);
		return SUCCESS;
	}
	
	
//	public String checkInvgatNum(){
//	try {
//		boolean flag = iInvgatService.checkInvgatName(invgatNum);
//		if(flag){
//			dataMap.put("success", true);
//		}else{
//			dataMap.put("success", false);
//		}
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//	return SUCCESS;
//}
	
	/**
	 * 鎵撳寘鏈嶅姟鍣ㄥ搷搴旀暟鎹�
	 */
	public void responseData(){
		dataMap.put("page", page);
		dataMap.put("total", total);
		dataMap.put("records", records);
		dataMap.put("data", results);
	}
	@Override
	public int getResultSize() {
		// TODO Auto-generated method stub
		return this.iInvgatDworkService.queryResultsCount(null);
	}

	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return  this.iInvgatDworkService.queryByPage(null, from, length);
	}

	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return  this.iInvgatDworkService.queryResultsCount(criteria);
	}

	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		
		List<HashMap<String, Object>> results = new ArrayList<HashMap<String,Object>>();
		 results=this.iInvgatDworkService.queryByPage(criteria, from, length);
		return results;
		
	}

}
