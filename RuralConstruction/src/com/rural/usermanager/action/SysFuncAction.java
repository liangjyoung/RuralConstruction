package com.rural.usermanager.action;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.rural.bean.RoleFuncPerm;
import com.rural.bean.SysFunc;
import com.opensymphony.xwork2.ActionSupport;
import com.rural.usermanager.service.ISysFuncService;
import com.rural.usermanager.service.ISysRoleFuncService;
import com.rural.tool.AdditionalParameters;
import com.rural.tool.Item;
import com.rural.tool.ItemType;

public class SysFuncAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private ISysFuncService iSysFuncService;
	private ISysRoleFuncService iSysRoleFuncService;
	private int  roleId;
	private String funcIdStr;
	public int ID;
	public static int IDS;
	
	
	/*private String oper;
	private String JQID;
	public static String JQS;
	
	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public String getJQID() {
		return JQID;
	}

	public void setJQID(String jQID) {
		JQID = jQID;
	}

	public static String getJQS() {
		return JQS;
	}

	public static void setJQS(String jQS) {
		JQS = jQS;
	}*/

	public static int getIDS() {
		return IDS;
	}

	public static void setIDS(int iDS) {
		IDS = iDS;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public ISysRoleFuncService getiSysRoleFuncService() {
		return iSysRoleFuncService;
	}

	public void setiSysRoleFuncService(ISysRoleFuncService iSysRoleFuncService) {
		this.iSysRoleFuncService = iSysRoleFuncService;
	}

	
	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public ISysFuncService getiSysFuncService() {
		return iSysFuncService;
	}

	public void setiSysFuncService(ISysFuncService iSysFuncService) {
		this.iSysFuncService = iSysFuncService;
	}

	public String aa(){
		
		ArrayList<HashMap<String, Object>> li = iSysFuncService.findAll();
		dataMap.put("ss", li);
		return SUCCESS;
		
	}
	public String bb(){
		
		List<SysFunc> li  = iSysFuncService.getChildPermissions("0");
		dataMap.put("ss", li);
		return SUCCESS;
		
	}
	
	
	public String queryAllMenusAsTree( )  
    {  
		SysFuncAction.setIDS(ID);
		
		//SysFuncAction.setJQS(JQID);
        Map<String,Item> items = new LinkedHashMap<String,Item>( );  
        items= getChildNodes(items, null );  
        //Result result=new Result( 200, "", items );
        ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>(); 
      
        //JSONObject ja1 = JSONObject.fromObject(items);  
       // System.out.println(ja1.toString());
        dataMap.put("ss", items);
		return SUCCESS;
	
    }
	
	private Map getChildNodes( Map<String,Item> items, String parentId )  
    {  
		List<SysFunc> permissions=iSysFuncService.getChildPermissions(parentId );  
        if(permissions.size( )>0){  
            for ( SysFunc permission : permissions )  
            {  
                Item item=new Item( );  
               
                item.setName( permission.getFuncName());  
                item.setType( ItemType.NODE_FOLDER );  
                getChildItems(item,permission.getFuncNum().toString( ),permission.getFuncName( ));  
                items.put( permission.getFuncName(), item );  
            }  
        }  
        return items;
    }
	
	private void getChildItems( Item item, String parentId,String parentName ) {
		
		List<SysFunc> childPermissions = iSysFuncService.getChildPermissions( parentId );  
		
        if(childPermissions.size( )>0){  
            item.setName(parentName);  
            item.setType( ItemType.NODE_FOLDER );  
            AdditionalParameters additionalParameters=new AdditionalParameters( );  
            additionalParameters.setId( parentId );  
            Map<String, Item> children=new LinkedHashMap<String, Item>();
            
            
            for (SysFunc childPermission : childPermissions )  
            {  
                Item item2=new Item( );  
                getChildItems( item2, childPermission.getFuncNum( ).toString( ),childPermission.getFuncName( ) );  
                children.put( childPermission.getFuncName( ), item2 );  
            }  
            additionalParameters.setChildren( children );  
            item.setAdditionalParameters( additionalParameters );  
              
        }else{  
            
            item.setName(parentName);  
            item.setType( ItemType.NODE_ITEM );  
            AdditionalParameters additionalParameters=new AdditionalParameters( );   
          //跟据第一棵树的id来对表rolefunctionsperm进行查询，如果有数据的话将select变成true
            
            
            List<RoleFuncPerm> roleFuncPerms = iSysFuncService.getRoleFunc(parentId);
           if (roleFuncPerms.size()>0) {
        	   additionalParameters.setItemSelected(true);
		} else {
			additionalParameters.setItemSelected(false);
		}
            
            additionalParameters.setId( parentId );  
            item.setAdditionalParameters( additionalParameters );  
        }  
		
	}
	//�����ɫȨ��
	public String  distributeFunc() {	
		String message;
		System.out.println("_----------->"+roleId+"-__________>"+funcIdStr);
		String []funcIdArray = funcIdStr.split(",");
		message = this.iSysRoleFuncService.modify(roleId, funcIdArray);
		dataMap.put("success", message);
		return SUCCESS;
	}

	


	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public void setFuncIdStr(String funcIdStr) {
		this.funcIdStr = funcIdStr;
	}

	public String getFuncIdStr() {
		return funcIdStr;
	}


	
//	private List<BudgPro> getChildPermissions( String parentId )  
//    {  
//		
//		SessionFactory sf = new Configuration().configure().buildSessionFactory();
//		Session session = sf.openSession();
//        Criteria criteria = session.createCriteria(BudgPro.class);
//        
//        criteria.createCriteria().createCriteria( ).andEqualTo( "pid", parentId );  
//        List<BudgPro> permissions = permissionMapper.selectByExample( example );  
//        return permissions;  
//    }
}

