package com.rural.villageColldData.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


import com.rural.bean.VilDataCollRec;
import com.rural.tool.Criterion;
import com.rural.tool.JqGridBaseAction;

import com.rural.villageColldData.service.IColldDataJILUService;
import com.rural.tool.AdditionalParameters;
import com.rural.tool.Item;
import com.rural.tool.ItemType;



public class ColldDataJILUAction extends JqGridBaseAction{

	private static final long serialVersionUID = 1L;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private String oper;
	private IColldDataJILUService colldDataJILUService;
	private String VilDataCollRecId;
	private String InvgatID;
	private String VilBasicInfoID;
	private Date CollTim;
	private String CilDataCollRecNote;
	private String CollEqptCode;
	private int isFirstItem = 0;
	
	public String getCollEqptCode() {
		return CollEqptCode;
	}


	public void setCollEqptCode(String collEqptCode) {
		CollEqptCode = collEqptCode;
	}


	public IColldDataJILUService getColldDataJILUService() {
		return colldDataJILUService;
	}


	public void setColldDataJILUService(IColldDataJILUService colldDataJILUService) {
		this.colldDataJILUService = colldDataJILUService;
	}


	

	


	public String getVilDataCollRecId() {
		return VilDataCollRecId;
	}


	public void setVilDataCollRecId(String vilDataCollRecId) {
		VilDataCollRecId = vilDataCollRecId;
	}


	public String getInvgatID() {
		return InvgatID;
	}


	public void setInvgatID(String invgatID) {
		InvgatID = invgatID;
	}


	public String getVilBasicInfoID() {
		return VilBasicInfoID;
	}


	public void setVilBasicInfoID(String vilBasicInfoID) {
		VilBasicInfoID = vilBasicInfoID;
	}


	public Date getCollTim() {
		return CollTim;
	}


	public void setCollTim(Date collTim) {
		CollTim = collTim;
	}


	public String getCilDataCollRecNote() {
		return CilDataCollRecNote;
	}


	public void setCilDataCollRecNote(String cilDataCollRecNote) {
		CilDataCollRecNote = cilDataCollRecNote;
	}



	public String manage() {
		
		
		if (!search) {
			if ("add".equals(oper)) {
				addColldDataJILU();
			} else if ("search".equals(oper)) {// ����ҳ��ʱ��ѯ
				refreshGridModel();
				responseData();
			} else if ("del".equals(oper)) {// ɾ��
				delColldDataJILU();
			} else if ("edit".equals(oper)) {// �޸�
				ediColldDataJILU();
			}
		} else {//��ѯ����
			refreshGridModel();
			responseData();
		}
		return SUCCESS;
	}
	
	
	public void aa(){
		System.out.println(11);
	}
	
	/**
	 * ����������Ӧ���
	 */
	public void responseData(){
		dataMap.put("page", page);
		dataMap.put("total", total);
		dataMap.put("records", records);
		dataMap.put("data", results);
	}
	
	
	public String addColldDataJILU(){
		try {
			
		
		colldDataJILUService.addColldDataJILU(Integer.parseInt(VilBasicInfoID),Integer.parseInt(InvgatID),CollEqptCode,CollTim,CilDataCollRecNote);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		this.dataMap.put("success", true);
		return SUCCESS;
		
	}
	public String delColldDataJILU(){
		String mes="";
		try {
			
		
		for(String a: VilDataCollRecId.split(","))
		{
			colldDataJILUService.delColldDataJILU(Integer.parseInt(a.trim()));
		
		}
		} catch (Exception e) {
			e.printStackTrace();
			mes="无法删除";
		}
		this.dataMap.put("success", mes);
		return SUCCESS;
		
	}
	
	public String ediColldDataJILU(){
		
			colldDataJILUService.ediColldDataJILU(Integer.parseInt(VilDataCollRecId),Integer.parseInt(VilBasicInfoID),Integer.parseInt(InvgatID),CollEqptCode,CollTim,CilDataCollRecNote);
		
		this.dataMap.put("success", true);
		return SUCCESS;
	}
	
	
	@Override
	public int getResultSize() {
		// TODO Auto-generated method stub
		return this.colldDataJILUService.queryResultsCount(null);
	}

	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return this.colldDataJILUService.queryResultsCount(criteria);
	}

	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return this.colldDataJILUService.queryByPage(null, from, length);
	}

	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		results=this.colldDataJILUService.queryByPage(criteria, from, length);
		return results;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public String getOper() {
		return oper;
	}
public String singTree( ) {
		
		Map<String,Item> items = new LinkedHashMap<String,Item>( ); //LinkedHashMap�����˼�¼�Ĳ���˳��
		
	    items= getChildNodes(items); //��ݸ��ڵ��ҵ������ӽڵ㣬��put��map������
	   // JSONObject ja1 = JSONObject.fromObject(items);
	   // System.out.println(ja1.toString());
		dataMap.put("ss",items); //ja1.toString());
		return SUCCESS;
	}
	
	/*
	 * �õ����и�ڵ�
	 * */
		private Map getChildNodes( Map<String,Item> items )  
	    {  
			//�õ����еĸ� ;getChildPermissions()�����Լ�д
			List<VilDataCollRec> permissions=colldDataJILUService.getChildPrivance( );  
			//��ÿ������б���
			//List<VilDataCollRec> dd=colldDataJILUService.getdd();
			int count = permissions.size( );
			
			int [] a = new int[count];
			//System.out.println(a.length);
	       // if(permissions.size( )>0){  
	            for ( VilDataCollRec permission : permissions )// BudgPro��Ҫ�γ������� 
	            {  
	            	//String s=permission.getVilDataCollRecId().toString();
	            	SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
	            	String s1=sdf.format(permission.getCollTim());
	            	String s2=s1+"1";
	               //���ýڵ�
	                Item item=new Item( );  
	                item.setName( s1); //�����ּ��뵽item 
	              
	                //�õ��ĸ��ڵ�Ľڵ�
	                item.setType( ItemType.NODE_ITEM );  
	                AdditionalParameters additionalParameters=new AdditionalParameters( );  
	                additionalParameters.setId( s2);
	                this.isFirstItem++;
	               // System.out.println(isFirstItem);
	                if(this.isFirstItem==a.length){
		            	additionalParameters.setItemSelected(true);
		            	// System.out.println(isFirstItem);
		            	
		            }
	                
	                item.setAdditionalParameters( additionalParameters ); 
	                
	                //getChildItems(item,permission.getMajorCatgNum().toString( ),permission.getMajorCatgName( ));  
	                items.put(s1, item );  
	            }  
	      //  }  
	        return items;
	    }
		
		
	

	

	
}