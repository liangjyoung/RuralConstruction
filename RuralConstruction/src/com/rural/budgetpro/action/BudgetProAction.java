package com.rural.budgetpro.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.jasper.compiler.ELFunctionMapper;

import com.rural.tool.ItemType;

import net.sf.json.JSONObject;

import com.rural.bean.BudgProCatg;
import com.opensymphony.xwork2.ActionSupport;
import com.rural.budgetpro.service.IBudgetProService;
import com.rural.tool.Criterion;
import com.rural.tool.Item;
import com.rural.tool.AdditionalParameters;
import com.rural.tool.JqGridBaseAction;

public class BudgetProAction extends JqGridBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private IBudgetProService iBudgetProService;
	private String budgProUpriceID;
	private String budgProUpriceNum;
	private String budgProName;
	private double budgProUprice;
	private String budgProUpriceComp;
	private String budgProUpriceExpl;
	
	private String proID;
	private String propID;
	
	private static String proIDs;//判断选中的节点是叶子节点还是父节点
	private static String propIDs;//判断选中的节点是叶子节点还是父节点

	
	
	private String oper;
	//private String JQID;
	public static String JQS;
	private int isFirstItem = 0;
	
	
	
	
	public String getProID() {
		return proID;
	}
	public void setProID(String proID) {
		this.proID = proID;
	}
	public String getPropID() {
		return propID;
	}
	public void setPropID(String propID) {
		this.propID = propID;
	}
	public int getIsFirstItem() {
		return isFirstItem;
	}
	public void setIsFirstItem(int isFirstItem) {
		this.isFirstItem = isFirstItem;
	}
	
	public static String getProIDs() {
		return proIDs;
	}
	public static void setProIDs(String proIDs) {
		BudgetProAction.proIDs = proIDs;
	}
	
	public String getBudgProUpriceID() {
		return budgProUpriceID;
	}
	public static String getPropIDs() {
		return propIDs;
	}
	public static void setPropIDs(String propIDs) {
		BudgetProAction.propIDs = propIDs;
	}
	public void setBudgProUpriceID(String budgProUpriceID) {
		this.budgProUpriceID = budgProUpriceID;
	}
	public String getBudgProUpriceNum() {
		return budgProUpriceNum;
	}
	public void setBudgProUpriceNum(String budgProUpriceNum) {
		this.budgProUpriceNum = budgProUpriceNum;
	}
	public String getBudgProName() {
		return budgProName;
	}
	public void setBudgProName(String budgProName) {
		this.budgProName = budgProName;
	}
	public double getBudgProUprice() {
		return budgProUprice;
	}
	public void setBudgProUprice(double budgProUprice) {
		this.budgProUprice = budgProUprice;
	}
	public String getBudgProUpriceComp() {
		return budgProUpriceComp;
	}
	public void setBudgProUpriceComp(String budgProUpriceComp) {
		this.budgProUpriceComp = budgProUpriceComp;
	}
	public String getBudgProUpriceExpl() {
		return budgProUpriceExpl;
	}
	public void setBudgProUpriceExpl(String budgProUpriceExpl) {
		this.budgProUpriceExpl = budgProUpriceExpl;
	}
	public String getOper() {
		return oper;
	}
	public void setOper(String oper) {
		this.oper = oper;
	}
	public static String getJQS() {
		return JQS;
	}
	public static void setJQS(String jQS) {
		JQS = jQS;
	}
	
	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
	public IBudgetProService getiBudgetProService() {
		return iBudgetProService;
	}
	public void setiBudgetProService(IBudgetProService iBudgetProService) {
		this.iBudgetProService = iBudgetProService;
	}
	
	public String queryAllBudgetProAsTree()
	{
		Map<String, Item> items = new LinkedHashMap<String, Item>();
		items = getChildNodes(items, null);
		ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String,Object>>();
		
		//JSONObject json = JSONObject.fromObject(items);
		
		dataMap.put("ss",items );
		return SUCCESS;
	}
	
	public String manageBudgetPrice()
	{
		BudgetProAction.setProIDs(proID);
		BudgetProAction.setPropIDs(propID);
		//BudgetProAction.setJQS(JQID);
		
		//BudgetProAction.setPropIDs(propIDs);
		//BudgetProAction.setProIDs(proIDs);
		if(!search){
			if("add".equals(oper)){
				addBudgProUprice();
			}else if ("search".equals(oper)) {
				refreshGridModel();
				responseData();
			}else if ("del".equals(oper)) {
				delBudgProUprice();
			}else if ("edit".equals(oper)) {
				updateBudgProUprice();
			}
		}else{
			refreshGridModel();
			responseData();
		}
		return SUCCESS;
	}
	
	
	private String addBudgProUprice() {
		// TODO Auto-generated method stub
		iBudgetProService.addBudgProUprice(proID ,budgProUpriceNum,budgProName,budgProUprice,budgProUpriceComp,budgProUpriceExpl);
		this.dataMap.put("success", true);
		return SUCCESS;
	}
	
	private String updateBudgProUprice() {
		// TODO Auto-generated method stub
		iBudgetProService.updateBudgProUprice(proID ,budgProUpriceID,budgProUpriceNum,budgProName,budgProUprice,budgProUpriceComp,budgProUpriceExpl);
		this.dataMap.put("success", true);
		return SUCCESS;
	}
	
	private String delBudgProUprice() {
		// TODO Auto-generated method stub
		/*iBudgetProService.delBudgProUprice(budgProUpriceID);
		this.dataMap.put("success", true);
		return SUCCESS;*/
		for(String invgat: budgProUpriceID.split(",")){
			iBudgetProService.delBudgProUprice(Integer.parseInt(invgat));
		}
		this.dataMap.put("success", true);
		return SUCCESS;
		
	}
	
	//判断单价号是否重复
	public String checkBudgProUpriceNum(){
		try {
			
			//flag==true表示提示错误，flag==false表示没有重复，不提示错误
			if(budgProUpriceID.equals("undefined"))budgProUpriceID=null;//若id未定义则给其赋值为null
				boolean flag = iBudgetProService.checkBudgProUpriceNum(budgProUpriceNum,budgProUpriceID);
				if(flag){
					dataMap.put("success", true);
				}else{
					dataMap.put("success", false);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/**
	 * 打包服务器数据
	 */
	public void responseData(){
		dataMap.put("page", page);
		dataMap.put("total", total);
		dataMap.put("records", records);
		dataMap.put("data", results);
	}
	private Map getChildNodes(Map<String, Item> items, String parentId)
	{
		//get all root
		List<BudgProCatg> permissions = iBudgetProService.getChildPermissions(parentId);
		if(permissions.size( )>0){  
            for ( BudgProCatg permission : permissions )  
            {  
                //递归子节点  
                Item item=new Item( );  
                item.setName( permission.getBudgProCatgDes());  
                item.setType( ItemType.NODE_FOLDER );  
                //得到哪个节点的节点
                getChildItems(item,permission.getBudgProCatgNum().toString( ),permission.getBudgProCatgDes());  
                items.put( permission.getBudgProCatgDes(), item );  
            }  
        }  
        return items;
	}

	private void getChildItems(Item item, String parentId,String parentName){
		//获得节点编号为parentiD的所有子节点
		
		List<BudgProCatg> childPermissions = iBudgetProService.getChildPermissions( parentId );  
        if(childPermissions.size( )>0){  
            //父节点为“folder”  
            item.setName(parentName);  
            item.setType( ItemType.NODE_FOLDER );  
            AdditionalParameters additionalParameters=new AdditionalParameters( );  
            additionalParameters.setId( parentId );  
            Map<String, Item> children=new LinkedHashMap<String, Item>();
            
            
            for ( BudgProCatg childPermission : childPermissions )  
            {  
                Item item2=new Item( );  
                getChildItems( item2, childPermission.getBudgProCatgNum().toString( ),childPermission.getBudgProCatgDes() );  
                children.put( childPermission.getBudgProCatgDes(), item2 );  
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
		return this.iBudgetProService.queryResultsCount(null);
	}
	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return this.iBudgetProService.queryResultsCount(criteria);
	}
	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return this.iBudgetProService.queryByPage(null, from, length);
	}
	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		return this.iBudgetProService.queryByPage(criteria, from, length);
	}

}
