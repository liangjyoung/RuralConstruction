package com.rural.townAverage.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.rural.averanalysis.service.ITownAverAnalysisService;
import com.rural.bean.EvalSystInd;
import com.rural.evalsystem.action.EvalMethAction;
import com.rural.evalsystem.action.EvalSysAction;

import com.rural.tool.AdditionalParameters;
import com.rural.tool.Criterion;
import com.rural.tool.Item;
import com.rural.tool.ItemType;
import com.rural.tool.JqGridBaseAction;
import com.rural.townAverage.service.ITownAverageService;

public class TownAverageAction extends JqGridBaseAction{

	private String TreeJS;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private ITownAverageService iTownAverageService;
	private ITownAverAnalysisService iTownAverAnalysisService;
	private static String year;
	private String oper;
	
	private String sysUserBeloDiviCode;
	private static String townNum;
	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}



	private String EvaSID;
	private String EvaFSID;
	private static String EvalSysIDs;
	private static String EvalFSysIDs;
	
	
	
	
	public String getSysUserBeloDiviCode() {
		return sysUserBeloDiviCode;
	}

	public void setSysUserBeloDiviCode(String sysUserBeloDiviCode) {
		this.sysUserBeloDiviCode = sysUserBeloDiviCode;
	}

	public static String getTownNum() {
		return townNum;
	}

	public static void setTownNum(String townNum) {
		TownAverageAction.townNum = townNum;
	}

	public static String getYear() {
		return year;
	}

	public static void setYear(String year) {
		TownAverageAction.year = year;
	}

	public String getEvaSID() {
		return EvaSID;
	}

	public void setEvaSID(String evaSID) {
		EvaSID = evaSID;
	}

	public String getEvaFSID() {
		return EvaFSID;
	}

	public void setEvaFSID(String evaFSID) {
		EvaFSID = evaFSID;
	}

	public static String getEvalSysIDs() {
		return EvalSysIDs;
	}

	public static void setEvalSysIDs(String evalSysIDs) {
		EvalSysIDs = evalSysIDs;
	}

	public static String getEvalFSysIDs() {
		return EvalFSysIDs;
	}

	public static void setEvalFSysIDs(String evalFSysIDs) {
		EvalFSysIDs = evalFSysIDs;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public ITownAverAnalysisService getiTownAverAnalysisService() {
		return iTownAverAnalysisService;
	}

	public void setiTownAverAnalysisService(
			ITownAverAnalysisService iTownAverAnalysisService) {
		this.iTownAverAnalysisService = iTownAverAnalysisService;
	}

	

	public String getTreeJS() {
		return TreeJS;
	}

	public void setTreeJS(String treeJS) {
		TreeJS = treeJS;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public ITownAverageService getiTownAverageService() {
		return iTownAverageService;
	}

	public void setiTownAverageService(ITownAverageService iTownAverageService) {
		this.iTownAverageService = iTownAverageService;
	}

	public String evalIndStructree()  
	
    { 
		TownAverageAction.setYear(TreeJS);
		sysUserBeloDiviCode = "3712.06.02.000";
		
		TownAverageAction.setTownNum(sysUserBeloDiviCode);
		int a = 0;
		a = iTownAverageService.getEvalSystIndId(Integer.parseInt(TreeJS));
		EvalSysAction.setTreeS(a);
		Map<String,Item> items = new LinkedHashMap<String,Item>( );  
	    items= getChildNodes(items, null );  
	    ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>(); 
	    dataMap.put("ss", items);
	    return SUCCESS;
    }
	
	public String getLevelsIndAver(String evalIndNum){
		String a = "";
		
		String sysUserBeloDiviCode= (String) ServletActionContext.getRequest().getSession().getAttribute("sysUserBeloDiviCode");
		a = iTownAverageService.getLevelsIndAver("3712.06.02.000", Integer.parseInt(TreeJS), evalIndNum);
		
		return a;
	}
	

	public double getLevelsIndLastAver(int evalContId){
		double a = 0;
		
		
		//a = iTownAverageService.getLevelsIndLastAver("3712.04.01.000", Integer.parseInt(TreeJS), evalContId);
		
		return a;
	}
	
	//根据父节点得到
	private Map getChildNodes( Map<String,Item> items, String parentId )  
    {  
		//得到所有的根
		List<EvalSystInd> permissions=iTownAverageService.getChildPermissions(parentId );  
		//对每个根进行遍历
        if(permissions.size( )>0){  
            for ( EvalSystInd permission : permissions )  
            {  
                //递归子节点  
                Item item=new Item( );  
                String treename = permission.getEvalIndName()+"(平均分:"+this.getLevelsIndAver(permission.getEvalIndNum())+")";
                item.setName(treename);  
                //AdditionalParameters additionalParameters=new AdditionalParameters( ); 
              //  additionalParameters.s
                item.setType( ItemType.NODE_FOLDER );  
                //得到哪个节点的节点
                getChildItems(item,permission.getEvalIndNum().toString( ),treename);  
                items.put( permission.getEvalIndName(), item );  
            }  
        }  
        return items;
    }
	
	
	
	int count = 0;
	private void getChildItems( Item item, String parentId,String parentName ) {
		//获得节点编号为parentiD的所有子节点
	
		List<EvalSystInd> childPermissions = iTownAverageService.getChildPermissions( parentId );  
		
        if(childPermissions.size( )>0){  
            //父节点为“folder”  
            item.setName(parentName);  
            item.setType( ItemType.NODE_FOLDER );  
            AdditionalParameters additionalParameters=new AdditionalParameters( );  
            additionalParameters.setId( parentId );  
            Map<String, Item> children=new LinkedHashMap<String, Item>();
            for (EvalSystInd childPermission : childPermissions )  
            {  
                Item item2=new Item( );  
                String treechildname = childPermission.getEvalIndName()+"(平均分:"+this.getLevelsIndAver(childPermission.getEvalIndNum())+")";
                getChildItems( item2, childPermission.getEvalIndNum().toString( ),treechildname );  
                children.put( childPermission.getEvalIndName(), item2 );  
            }  
            additionalParameters.setChildren( children );  
            item.setAdditionalParameters( additionalParameters );  
              
        }else{  
            //父节点为“item”,获取当前  
            item.setName(parentName);  
            item.setType( ItemType.NODE_ITEM );  
            AdditionalParameters additionalParameters=new AdditionalParameters( );  
            additionalParameters.setId( parentId );
            if (count == 0) {
            	additionalParameters.setItemSelected(true);
            	count++;
			} else {
				additionalParameters.setItemSelected(false);
			}
            item.setAdditionalParameters( additionalParameters );  
        }  
		
	}
	
	public String manageEvalAver(){

		TownAverageAction.setEvalFSysIDs(EvaFSID);
		
		TownAverageAction.setEvalSysIDs(EvaSID);
	
		if(!search){
			if ("add".equals(oper)) {//增加
				//addEvalCont();
			} else if ("search".equals(oper)) {//载入页面时查询
				refreshGridModel();
				responseData();
			} else if ("del".equals(oper)) {//删除
				//delCountryBasicInfo();
				//delEvalCont();
			}else if("edit".equals(oper)){//修改
				//editEvalCont();
			}
		}else{//查询
			refreshGridModel();
			responseData();
		}
		
		return SUCCESS;
	}
	
	/**
	 * 打包服务器响应数据
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
		return this.iTownAverageService.queryResultsCount(null);
	}

	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return this.iTownAverageService.queryResultsCount(criteria);
	}

	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return this.iTownAverageService.queryByPage(null, from, length);
	}

	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		results=this.iTownAverageService.queryByPage(criteria, from, length);
		return results;
	}

	
	
}
