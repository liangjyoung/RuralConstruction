package com.rural.govfile.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONObject;


import com.rural.bean.GoveFilClfy;

import com.rural.govfile.service.ICitysFilService;
import com.rural.tool.AdditionalParameters;
import com.rural.tool.Criterion;
import com.rural.tool.Item;
import com.rural.tool.ItemType;
import com.rural.tool.JqGridBaseAction;

public class CitysFilAction  extends JqGridBaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private ICitysFilService icitysfilService;
	private String GoveFilClfyNum;
	private String GoveFilClfyName;
	private String GoveFilClfyID;
	private String CitysFilID;
	private Integer CityBasicInfoID;
	private String CitysFilNum;
	private String CitysFilName;
	private String CitysFilIdef;
	private Date CitysFilMadTim;
	private String CitysFilPubComp;
	private String CitysFilExpl;
	private String oper;
	private String JQID;
	public static String JQS;
	
	
	
	
	
	public Integer getCityBasicInfoID() {
		return CityBasicInfoID;
	}

	public void setCityBasicInfoID(Integer cityBasicInfoID) {
		CityBasicInfoID = cityBasicInfoID;
	}

	public ICitysFilService getIcitysfilService() {
		return icitysfilService;
	}

	public void setIcitysfilService(ICitysFilService icitysfilService) {
		this.icitysfilService = icitysfilService;
	}

	
	public String getCitysFilID() {
		return CitysFilID;
	}

	public void setCitysFilID(String citysFilID) {
		CitysFilID = citysFilID;
	}


	public String getCitysFilNum() {
		return CitysFilNum;
	}

	public void setCitysFilNum(String citysFilNum) {
		CitysFilNum = citysFilNum;
	}

	public String getCitysFilName() {
		return CitysFilName;
	}

	public void setCitysFilName(String citysFilName) {
		CitysFilName = citysFilName;
	}

	public String getCitysFilIdef() {
		return CitysFilIdef;
	}

	public void setCitysFilIdef(String citysFilIdef) {
		CitysFilIdef = citysFilIdef;
	}

	public Date getCitysFilMadTim() {
		return CitysFilMadTim;
	}

	public void setCitysFilMadTim(Date citysFilMadTim) {
		CitysFilMadTim = citysFilMadTim;
	}

	public String getCitysFilPubComp() {
		return CitysFilPubComp;
	}

	public void setCitysFilPubComp(String citysFilPubComp) {
		CitysFilPubComp = citysFilPubComp;
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

	public String getCitysFilExpl() {
		return CitysFilExpl;
	}

	public void setCitysFilExpl(String citysFilExpl) {
		CitysFilExpl = citysFilExpl;
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
		boolean flag = icitysfilService.checkGoveFilClfyNumCode1(GoveFilClfyNum);
		if(flag){//编码有重复
			message = "文件编码重复，请重新录入";
			dataMap.put("success", message);
		}else{
			
			boolean flage2 = icitysfilService.addGoveFilClfy(GoveFilClfyNum, GoveFilClfyName);
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
				
				message= message+ icitysfilService.delGoveFilClfy1(id.trim());
			}
			dataMap.put("success", message);
		    return SUCCESS;
		}

	//判断地市文件编码是否重复
	public String checkCitysFilNum(){
		try {
			
			//flag==true表示提示错误，flag==false表示没有重复，不提示错误
			if(CitysFilID.equals("undefined"))CitysFilID=null;//若id未定义则给其赋值为null
				boolean flag = icitysfilService.checkCitysFilNum(CitysFilNum,CitysFilID);
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


	public String manageCitysFil() {
		CitysFilAction.setJQS(JQID);
		if(!search){
			if ("add".equals(oper)) {//
				addCitysFil();
			} else if ("search".equals(oper)) {//
				refreshGridModel();
				responseData();
			} else if ("del".equals(oper)) {//
				delCitysFil();
			}else if("edit".equals(oper)){//
				updateCitysFil();
				//CheckLoginName();
				//editLoginname();
			}
		}else{//查询
			refreshGridModel();
			responseData();
		}
		return SUCCESS;
	}
	
	
	public String addCitysFil() {
		// TODO Auto-generated method stub
//		dataMap.put("ss","ss"); //ja1.toString());
		//注意，地市管理员要根据区划专家添加所属市
		//JQID表示专家类别ID
		icitysfilService.addCitysFil(JQID,CityBasicInfoID,CitysFilNum,CitysFilName,CitysFilIdef,CitysFilMadTim,CitysFilPubComp,CitysFilExpl);
		this.dataMap.put("success", "添加成功");
		return SUCCESS;
	}
	
	private String updateCitysFil(){
		icitysfilService.updateCitysFil(JQID,CityBasicInfoID,CitysFilID,CitysFilNum,CitysFilName,CitysFilIdef,CitysFilMadTim,CitysFilPubComp,CitysFilExpl);
		this.dataMap.put("success", true);
		return SUCCESS;
	}
	
	private String  delCitysFil(){
		for(String allld: CitysFilID.split(",")){
			//System.out.println("_----------->"+allid);		
			icitysfilService.delCitysFil(allld);
			}
		
		this.dataMap.put("success","删除成功");
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
	
	
	
	
	//树结构入口
	public String GoveFilClfy( ) {
		
		Map<String,Item> items = new LinkedHashMap<String,Item>( ); //LinkedHashMap�����˼�¼�Ĳ���˳��
		
	    items= getChildNodes(items); 
	   // JSONObject ja1 = JSONObject.fromObject(items);
	   // System.out.println(ja1.toString());
		dataMap.put("ss",items); //ja1.toString());
		return SUCCESS;
	}
	
	
	

	private Map getChildNodes( Map<String,Item> items )  
    {  
		List<GoveFilClfy> permissions=icitysfilService.getChildPrivance( );  
		int count = 0;
       // if(permissions.size( )>0){  
            for (GoveFilClfy permission : permissions )// BudgPro��Ҫ�γ������� 
            {  
            
           
                Item item=new Item( );  
                item.setName( permission.getGoveFilClfyName()); //�����ּ��뵽item 
     
                item.setType( ItemType.NODE_ITEM );  
                AdditionalParameters additionalParameters=new AdditionalParameters( );  
                additionalParameters.setId( permission.getGoveFilClfyId().toString());
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
		return this.icitysfilService.queryResultsCount(null);
	}

	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return  this.icitysfilService.queryByPage(null, from, length);
	}

	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return  this.icitysfilService.queryResultsCount(criteria);
	}

	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		return results=this.icitysfilService.queryByPage(criteria, from, length);
	}

	
	public ICitysFilService getCitysfilService() {
		return icitysfilService;
	}

	public void setCitysfilService(ICitysFilService citysfilService) {
		this.icitysfilService = citysfilService;
	}

	

}
