package com.rural.colldatatemplet.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import com.rural.bean.InvesPro;
import com.rural.bean.TownBasicInfo;
import com.rural.colldatatemplet.service.IInvesProTreeService;
import com.rural.colldatatemplet.service.InvesObjService;


import com.rural.tool.AdditionalParameters;
import com.rural.tool.Criterion;
import com.rural.tool.Item;
import com.rural.tool.ItemType;
import com.rural.tool.JqGridBaseAction;






public class InvesProTreeAction extends JqGridBaseAction{
	
	private static final long serialVersionUID = 1L;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private IInvesProTreeService iInvesProTreeService;
	private int isFirstItem = 0;
	private String proNum; //添加节点
	private String ProName;//添加节点
	private String InvesProNum;
	private String InvesProName;
	private String sv;//获取下拉框中选中的值
	private String proNo;//删除节点
	



	public String getProNo() {
		return proNo;
	}

	public void setProNo(String proNo) {
		this.proNo = proNo;
	}

	public String getSv() {
		return sv;
	}

	public void setSv(String sv) {
		this.sv = sv;
	}

	public String getInvesProNum() {
		return InvesProNum;
	}

	public void setInvesProNum(String invesProNum) {
		InvesProNum = invesProNum;
	}

	public String getInvesProName() {
		return InvesProName;
	}

	public void setInvesProName(String invesProName) {
		InvesProName = invesProName;
	}

	public String getProNum() {
		return proNum;
	}

	public void setProNum(String proNum) {
		this.proNum = proNum;
	}

	public String getProName() {
		return ProName;
	}

	public void setProName(String proName) {
		ProName = proName;
	}

	public int getIsFirstItem() {
		return isFirstItem;
	}

	public void setIsFirstItem(int isFirstItem) {
		this.isFirstItem = isFirstItem;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public IInvesProTreeService getiInvesProTreeService() {
		return iInvesProTreeService;
	}

	public void setiInvesProTreeService(IInvesProTreeService iInvesProTreeService) {
		this.iInvesProTreeService = iInvesProTreeService;
	}


	

	
	
	//删除节点
	public String delMenusAsTree() {
		// TODO Auto-generated method stub
				
		String message="";
		for(String id: proNo.split(",")){
			
			message= message+ iInvesProTreeService.delInvesPro(id.trim());
		}
		dataMap.put("success", message);
	    return SUCCESS;
	}
	
//检查编码是否重复并添加节点
	public String addMenusAsTree(){
		
		String message="";
		boolean flag = iInvesProTreeService.checkProNumCode(proNum);
		if(flag){//编码有重复
			message = "调查项目编码重复，请重新录入";
			dataMap.put("success", message);
		}else{
			
			boolean flage2 = iInvesProTreeService.addPro(proNum, ProName,sv);//flage2看该节点下是否存在调查，若有则不能添加节点
			if(flage2){
				message = "添加成功";
				dataMap.put("success", message);
			}else{
				message = "该节点下存在调查对象，不允许添加子节点";
				dataMap.put("success", message);
			}
			
		}
				
		return SUCCESS;
	}
	
	
	
	
	//查询所有
	public String queryAll(){
		
		List<Map<String, Object>> invesProList = new ArrayList<Map<String, Object>>();
		List<InvesPro> ds = iInvesProTreeService.findAllPro();
		for (InvesPro c : ds) {
			Map<String, Object> dsMap = new HashMap<String, Object>();
			dsMap.put("InvesProNum", c.getInvesProNum());
			dsMap.put("InvesProName", c.getInvesProName());
			invesProList.add(dsMap);
		}
		dataMap.put("info", invesProList);
		return SUCCESS;
			
	
	}
	
	
	//树结构入口
	
	public String queryAllMenusAsTree()
	{
		Map<String, Item> items = new LinkedHashMap<String, Item>();
		items = getChildNodes(items, null);
		ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String,Object>>();
		
		//JSONObject json = JSONObject.fromObject(items);
		
		dataMap.put("ss",items );
		return SUCCESS;
	}
	
	private Map getChildNodes(Map<String, Item> items, String parentId) {
		
		//get all root
		List<InvesPro> permissions = iInvesProTreeService.getChildPermissions(parentId);
		if(permissions.size( )>0){  
            for ( InvesPro permission : permissions )  
            {  
                //递归子节点  
                Item item=new Item( );  
                item.setName( permission.getInvesProName());  
                item.setType( ItemType.NODE_FOLDER );  
                //得到哪个节点的节点
                getChildItems(item,permission.getInvesProNum().toString( ),permission.getInvesProName( ));  
                items.put( permission.getInvesProName(), item );  
            }  
        }  
        return items;
	}
	
	
	


	private void getChildItems(Item item, String parentId,String parentName){
		//获得节点编号为parentiD的所有子节点
		
		List<InvesPro> childPermissions = iInvesProTreeService.getChildPermissions( parentId );  
        if(childPermissions.size( )>0){  
            //父节点为“folder”  
            item.setName(parentName);  
            item.setType( ItemType.NODE_FOLDER );  
            AdditionalParameters additionalParameters=new AdditionalParameters( );  
            additionalParameters.setId( parentId );  
            Map<String, Item> children=new LinkedHashMap<String, Item>();
            
            
            for ( InvesPro childPermission : childPermissions )  
            {  
                Item item2=new Item( );  
                getChildItems( item2, childPermission.getInvesProNum( ).toString( ),childPermission.getInvesProName( ) );  
                children.put( childPermission.getInvesProName( ), item2 );  
            }  
            additionalParameters.setChildren( children );  
            item.setAdditionalParameters( additionalParameters );  
              
        }else{  
            //父节点为“item”,获取当前  
            item.setName(parentName);  
            item.setType( ItemType.NODE_ITEM );  
            
            AdditionalParameters additionalParameters=new AdditionalParameters( );  
            additionalParameters.setId( parentId );  
            if(this.isFirstItem==0){
            	additionalParameters.setItemSelected(true);
            	this.isFirstItem++;
            }
            item.setAdditionalParameters( additionalParameters );  
        }  
		
	}

	@Override
	public int getResultSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
