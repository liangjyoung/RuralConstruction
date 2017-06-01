package com.rural.govfile.action;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;


import com.rural.bean.GoveFilClfy;

import com.rural.govfile.service.ICountryFilService;
import com.rural.tool.AdditionalParameters;
import com.rural.tool.Criterion;
import com.rural.tool.Item;
import com.rural.tool.ItemType;
import com.rural.tool.JqGridBaseAction;

public class CountryFilAction  extends JqGridBaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private ICountryFilService countryfilService;
	private String GoveFilClfyNum;
	private String GoveFilClfyName;
	private String GoveFilClfyID;
	private String CountryFilID;
	private Integer CountryBasicInfoID;
	private String CountryFilNum;
	private String CountryFilName;
	private String CountryFilIdef;
	private Date CountryFilMadTim;
	private String CountryFilPubComp;
	private String CountryFilExpl;
	private String oper;
	private String JQID;
	public static String JQS;
	
	
	
	//检查编码是否重复并添加节点
	public String addMenusAsTree(){
		
		String message="";
		boolean flag = countryfilService.checkGoveFilClfyNumCode1(GoveFilClfyNum);
		if(flag){//编码有重复
			message = "文件编码重复，请重新录入";
			dataMap.put("success", message);
		}else{
			
			boolean flage2 = countryfilService.addGoveFilClfy(GoveFilClfyNum, GoveFilClfyName);
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
				
				message= message+ countryfilService.delGoveFilClfy1(id.trim());
			}
			dataMap.put("success", message);
		    return SUCCESS;
		}
	
	//判断编码是否重复
	public String checkCountryFilNum(){
		try {
			
			//flag==true表示提示错误，flag==false表示没有重复，不提示错误
			if(CountryFilID.equals("undefined"))CountryFilID=null;//若id未定义则给其赋值为null
				boolean flag = countryfilService.checkCountryFilNum(CountryFilNum, CountryFilID);
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
	
	
	public String getCountryFilID() {
		return CountryFilID;
	}

	public void setCountryFilID(String countryFilID) {
		CountryFilID = countryFilID;
	}

	public Integer getCountryBasicInfoID() {
		return CountryBasicInfoID;
	}

	public void setCountryBasicInfoID(Integer countryBasicInfoID) {
		CountryBasicInfoID = countryBasicInfoID;
	}

	public String getCountryFilNum() {
		return CountryFilNum;
	}

	public void setCountryFilNum(String countryFilNum) {
		CountryFilNum = countryFilNum;
	}

	public String getCountryFilName() {
		return CountryFilName;
	}

	public void setCountryFilName(String countryFilName) {
		CountryFilName = countryFilName;
	}

	public String getCountryFilIdef() {
		return CountryFilIdef;
	}

	public void setCountryFilIdef(String countryFilIdef) {
		CountryFilIdef = countryFilIdef;
	}

	public Date getCountryFilMadTim() {
		return CountryFilMadTim;
	}

	public void setCountryFilMadTim(Date countryFilMadTim) {
		CountryFilMadTim = countryFilMadTim;
	}

	public String getCountryFilPubComp() {
		return CountryFilPubComp;
	}

	public void setCountryFilPubComp(String countryFilPubComp) {
		CountryFilPubComp = countryFilPubComp;
	}

	public String getCountryFilExpl() {
		return CountryFilExpl;
	}

	public void setCountryFilExpl(String countryFilExpl) {
		CountryFilExpl = countryFilExpl;
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

	public ICountryFilService getCountryfilService() {
		return countryfilService;
	}

	public void setCountryfilService(ICountryFilService countryfilService) {
		this.countryfilService = countryfilService;
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


	public String manageCountryFil() {
		CountryFilAction.setJQS(JQID);
		if(!search){
			if ("add".equals(oper)) {
				addCountryFil();
			} else if ("search".equals(oper)) {//
				refreshGridModel();
				responseData();
			} else if ("del".equals(oper)) {//
				delCountryFil();
			}else if("edit".equals(oper)){//
				updateCountryFil();
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
	
	public String addCountryFil() {
		// TODO Auto-generated method stub
		//JQID表示镇文件类别ID
		countryfilService.addCountryFil(JQID,CountryBasicInfoID,CountryFilNum,CountryFilName,CountryFilIdef,CountryFilMadTim,CountryFilPubComp,CountryFilExpl);
		this.dataMap.put("success", "添加成功");
		return SUCCESS;
	}
	
	
	private String updateCountryFil() {
		// TODO Auto-generated method stub
		countryfilService.updateCountryFil(JQID,CountryBasicInfoID,CountryFilID,CountryFilNum,CountryFilName,CountryFilIdef,CountryFilMadTim,CountryFilPubComp,CountryFilExpl);
		this.dataMap.put("success", true);
		return SUCCESS;
	}

	


	private String delCountryFil() {
		// TODO Auto-generated method stub
		for(String allld: CountryFilID.split(",")){
			//System.out.println("_----------->"+allid);		
			countryfilService.delCountryFil(allld);
			}
		
		this.dataMap.put("success","删除成功");
		return SUCCESS;
	}

	
	
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
		List<GoveFilClfy> permissions=countryfilService.getChildPrivance( );  
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
		return this.countryfilService.queryResultsCount(null);
	}

	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return  this.countryfilService.queryByPage(null, from, length);
	}

	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return  this.countryfilService.queryResultsCount(criteria);
	}

	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		return results=this.countryfilService.queryByPage(criteria, from, length);
	}

	
	public ICountryFilService getCitysfilService() {
		return countryfilService;
	}

	public void setCitysfilService(ICountryFilService citysfilService) {
		this.countryfilService = countryfilService;
	}

	

}

