package com.rural.govfile.action;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;


import com.rural.bean.GoveFilClfy;
import com.rural.govfile.service.ITownFilService;

import com.rural.tool.AdditionalParameters;
import com.rural.tool.Criterion;
import com.rural.tool.Item;
import com.rural.tool.ItemType;
import com.rural.tool.JqGridBaseAction;

public class TownFilAction  extends JqGridBaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private ITownFilService townfilService;
	private String GoveFilClfyNum;
	private String GoveFilClfyName;
	private String GoveFilClfyID;
	private String TownFilID;
	private Integer TownBasicInfoID;
	private String TownFilNum;
	private String TownFilName;
	private String TownFilIdef;
	private Date TownFilMadTim;
	private String TownFilPubComp;
	private String TownFilExpl;
	private String oper;
	private String JQID;
	public static String JQS;
	
	
	
	public String getTownFilID() {
		return TownFilID;
	}

	public void setTownFilID(String townFilID) {
		TownFilID = townFilID;
	}

	public Integer getTownBasicInfoID() {
		return TownBasicInfoID;
	}

	public void setTownBasicInfoID(Integer townBasicInfoID) {
		TownBasicInfoID = townBasicInfoID;
	}

	public String getTownFilNum() {
		return TownFilNum;
	}

	public void setTownFilNum(String townFilNum) {
		TownFilNum = townFilNum;
	}

	public String getTownFilName() {
		return TownFilName;
	}

	public void setTownFilName(String townFilName) {
		TownFilName = townFilName;
	}

	public String getTownFilIdef() {
		return TownFilIdef;
	}

	public void setTownFilIdef(String townFilIdef) {
		TownFilIdef = townFilIdef;
	}

	public Date getTownFilMadTim() {
		return TownFilMadTim;
	}

	public void setTownFilMadTim(Date townFilMadTim) {
		TownFilMadTim = townFilMadTim;
	}

	public String getTownFilPubComp() {
		return TownFilPubComp;
	}

	public void setTownFilPubComp(String townFilPubComp) {
		TownFilPubComp = townFilPubComp;
	}

	public String getTownFilExpl() {
		return TownFilExpl;
	}

	public void setTownFilExpl(String townFilExpl) {
		TownFilExpl = townFilExpl;
	}

	
	
	public String getGoveFilClfyNum() {
		return GoveFilClfyNum;
	}

	public void setGoveFilClfyNum(String goveFilClfyNum) {
		GoveFilClfyNum = goveFilClfyNum;
	}

	public String getGoveFilClfyName() {
		return GoveFilClfyName;
	}

	public void setGoveFilClfyName(String goveFilClfyName) {
		GoveFilClfyName = goveFilClfyName;
	}

	

	public String getGoveFilClfyID() {
		return GoveFilClfyID;
	}

	public void setGoveFilClfyID(String goveFilClfyID) {
		GoveFilClfyID = goveFilClfyID;
	}

	public ITownFilService getTownfilService() {
		return townfilService;
	}

	public void setTownfilService(ITownFilService townfilService) {
		this.townfilService = townfilService;
	}

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
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}


	//检查编码是否重复并添加节点
	public String addMenusAsTree(){
		
		String message="";
		boolean flag = townfilService.checkGoveFilClfyNumCode1(GoveFilClfyNum);
		if(flag){//编码有重复
			message = "文件编码重复，请重新录入";
			dataMap.put("success", message);
		}else{
			
			boolean flage2 = townfilService.addGoveFilClfy(GoveFilClfyNum, GoveFilClfyName);
			if(flage2){
				message = "添加成功";
				dataMap.put("success", message);
			}
			
		}
				
		return SUCCESS;
	}
	

		//删除节点
		public String delMenusAsTree() {
			// TODO Auto-generated method stub
				
			String message="";
			for(String id: GoveFilClfyID.split(",")){
				
				message= message+ townfilService.delGoveFilClfy1(id.trim());
			}
			dataMap.put("success", message);
		    return SUCCESS;
		}
	
	//判断专家编码是否重复
	public String checkTownFilNum(){
		try {
			
			//flag==true表示提示错误，flag==false表示没有重复，不提示错误
			if(TownFilID.equals("undefined"))TownFilID=null;//若id未定义则给其赋值为null
				boolean flag = townfilService.checkTownFilNum(TownFilNum, TownFilID);
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
	
	public String manageTownFil() {
		TownFilAction.setJQS(JQID);
		if(!search){
			if ("add".equals(oper)) {
				addTownFil();
			} else if ("search".equals(oper)) {//
				refreshGridModel();
				responseData();
			} else if ("del".equals(oper)) {//
				delTownFil();
			}else if("edit".equals(oper)){//
				updateTownFil();
				//CheckLoginName();
				//editLoginname();
			}
		}else{
			refreshGridModel();
			responseData();
		}
		return SUCCESS;
	}
	
	
	public void responseData(){
		dataMap.put("page", page);
		dataMap.put("total", total);
		dataMap.put("records", records);
		dataMap.put("data", results);
	}
	
	public String addTownFil() {
		// TODO Auto-generated method stub
		//JQID表示镇文件类别ID
		townfilService.addTownFil(JQID,TownBasicInfoID,TownFilNum,TownFilName,TownFilIdef,TownFilMadTim,TownFilPubComp,TownFilExpl);
		this.dataMap.put("success", "添加成功");
		return SUCCESS;
	}
	
	private String updateTownFil(){
		townfilService.updateTownFil(JQID,TownBasicInfoID,TownFilID,TownFilNum,TownFilName,TownFilIdef,TownFilMadTim,TownFilPubComp,TownFilExpl);
		this.dataMap.put("success", true);
		return SUCCESS;
	}
	
	private String  delTownFil(){
		
		for(String allld: TownFilID.split(",")){
			//System.out.println("_----------->"+allid);		
			townfilService.delTownFil(allld);
			}
	
		this.dataMap.put("success","删除成功");
		return SUCCESS;
	}
	

	public String GoveFilClfy( ) {
		
		Map<String,Item> items = new LinkedHashMap<String,Item>( ); //LinkedHashMap�����˼�¼�Ĳ���˳��
		
	    items= getChildNodes(items); 
		dataMap.put("ss",items); //ja1.toString());
		return SUCCESS;
	}
	
	
	

	private Map getChildNodes( Map<String,Item> items )  
    {  
		
		List<GoveFilClfy> permissions=townfilService.getChildPrivance( );  
	
		int count = 0;
       // if(permissions.size( )>0){  
            for (GoveFilClfy permission : permissions )// BudgPro��Ҫ�γ������� 
            {  
            
           
                Item item=new Item( );  
                item.setName( permission.getGoveFilClfyName()); //�����ּ��뵽item 
              
            
                item.setType( ItemType.NODE_ITEM );  
                AdditionalParameters additionalParameters=new AdditionalParameters( );  
                additionalParameters.setId( permission.getGoveFilClfyId().toString() );
                if (count == 0) {
                	additionalParameters.setItemSelected(true);
                	count++;
                	//System.out.println("------------------>"+JSONObject.fromObject(additionalParameters));
				} else {
					
					additionalParameters.setItemSelected(false);
				}
                
                item.setAdditionalParameters( additionalParameters ); 
                
                //getChildItems(item,permission.getMajorCatgNum().toString( ),permission.getMajorCatgName( ));  
                items.put( permission.getGoveFilClfyName(), item );  
            }  
      //  }  
        return items;
    }





	
	
	@Override
	public int getResultSize() {
		// TODO Auto-generated method stub
		return this.townfilService.queryResultsCount(null);
	}

	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return  this.townfilService.queryByPage(null, from, length);
	}

	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return  this.townfilService.queryResultsCount(criteria);
	}

	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		return results=this.townfilService.queryByPage(criteria, from, length);
	}

	
	public ITownFilService getCitysfilService() {
		return townfilService;
	}

	public void setCitysfilService(ITownFilService townfilService) {
		this.townfilService = townfilService;
	}

	

}
