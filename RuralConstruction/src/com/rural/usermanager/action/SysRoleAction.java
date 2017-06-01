package com.rural.usermanager.action;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.rural.tool.AdditionalParameters;
import com.rural.tool.Item;
import com.rural.tool.ItemType;


import com.rural.bean.SysRole;
import com.opensymphony.xwork2.ActionSupport;
import com.rural.usermanager.service.ISysRoleService;

public class SysRoleAction	extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private static final String RoleName = null;
	
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private ISysRoleService iSysRoleService;
	


	/*
	 * ���ô�action�õ�json�ַ���ǰ̨�ĺ���
	 * */
	public String SysRole( ) {
		
		Map<String,Item> items = new LinkedHashMap<String,Item>( ); //LinkedHashMap�����˼�¼�Ĳ���˳��
		
	    items= getChildNodes(items); //��ݸ��ڵ��ҵ������ӽڵ㣬��put��map������
	    //JSONObject ja1 = JSONObject.fromObject(items);
	   // System.out.println(ja1.toString());
		dataMap.put("ss", items);
		return SUCCESS;
	}
	
	/*
	 * �õ����и�ڵ�
	 * */
		private Map getChildNodes( Map<String,Item> items )  
	    {  
			//�õ����еĸ� ;getChildPermissions()�����Լ�д
			int acount = 0;
			List<SysRole> permissions=iSysRoleService.getChildSysRole( );  
			//��ÿ������б���
	       // if(permissions.size( )>0){  
	            for ( SysRole permission : permissions )// BudgPro��Ҫ�γ������� 
	            {  
	               //���ýڵ�
	                Item item=new Item( );  
	                item.setName( permission.getRoleName()); //�����ּ��뵽item 
	           
	                //�õ��ĸ��ڵ�Ľڵ�
	                
		            item.setType( ItemType.NODE_ITEM );  
		            AdditionalParameters additionalParameters=new AdditionalParameters( );  
		            additionalParameters.setId( String.valueOf(permission.getSysRoleId()) ); 
		            if (acount == 0) {
		            	additionalParameters.setItemSelected(true);
		            	acount++;
					} else {
						additionalParameters.setItemSelected(false);
						
					}
		            item.setAdditionalParameters( additionalParameters );  
	              //  getChildItems(item,permission.getSysRoleId( ),permission.getSysRoleName( ));  
	                items.put( permission.getRoleName(), item );  
	            }  
	      //  }  
	        return items;
	    }
	
	

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	/**
	 * @param dataMap the dataMap to set
	 */
	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}


	public ISysRoleService getiSysRoleService() {
		return iSysRoleService;
	}


	public void setiSysRoleService(ISysRoleService iSysRoleService) {
		this.iSysRoleService = iSysRoleService;
	}

		
}
