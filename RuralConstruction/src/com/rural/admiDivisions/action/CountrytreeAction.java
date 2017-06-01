package com.rural.admiDivisions.action;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.rural.admiDivisions.service.CountrytreeService;
import com.rural.bean.CountryBasicInfo;
import com.rural.tool.AdditionalParameters;
import com.rural.tool.Item;
import com.rural.tool.ItemType;

public class CountrytreeAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private CountrytreeService countrytreeService;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private int JQID;
	public static int JQS;
	private String countryBasicInfoID;
	private String oper;
	private String countryNum;
	private String countryName;
	private String countryLongi;
	private String countryLati;
	private String countryMeas;
	private String countryPop;
	private String countryHholds;
	//private byte[] countryIntro;
	
	private String countryIntro;
	
	public CountrytreeService getCountrytreeService() {
		return countrytreeService;
	}
	public void setCountrytreeService(CountrytreeService countrytreeService) {
		this.countrytreeService = countrytreeService;
	}
	public int getJQID() {
		return JQID;
	}
	public void setJQID(int jQID) {
		JQID = jQID;
	}
	public static int getJQS() {
		return JQS;
	}
	public static void setJQS(int jQS) {
		JQS = jQS;
	}
	public String getCountryBasicInfoID() {
		return countryBasicInfoID;
	}
	public void setCountryBasicInfoID(String countryBasicInfoID) {
		this.countryBasicInfoID = countryBasicInfoID;
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
	public String getCountryNum() {
		return countryNum;
	}
	public void setCountryNum(String countryNum) {
		this.countryNum = countryNum;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	public String getCountryLongi() {
		return countryLongi;
	}
	public void setCountryLongi(String countryLongi) {
		this.countryLongi = countryLongi;
	}
	public String getCountryLati() {
		return countryLati;
	}
	public void setCountryLati(String countryLati) {
		this.countryLati = countryLati;
	}
	public String getCountryMeas() {
		return countryMeas;
	}
	public void setCountryMeas(String countryMeas) {
		this.countryMeas = countryMeas;
	}
	public String getCountryPop() {
		return countryPop;
	}
	public void setCountryPop(String countryPop) {
		this.countryPop = countryPop;
	}
	public String getCountryHholds() {
		return countryHholds;
	}
	public void setCountryHholds(String countryHholds) {
		this.countryHholds = countryHholds;
	}
	
	
	
	public String getCountryIntro() {
		return countryIntro;
	}
	public void setCountryIntro(String countryIntro) {
		this.countryIntro = countryIntro;
	}
public String singTree( ) {
		
		Map<String,Item> items = new LinkedHashMap<String,Item>( ); //LinkedHashMap�����˼�¼�Ĳ���˳��
		
	    items= getChildNodes(items); //��ݸ��ڵ��ҵ������ӽڵ㣬��put��map������
	   // JSONObject ja1 = JSONObject.fromObject(items);
	   // System.out.println(ja1.toString());
		dataMap.put("ss",items); //ja1.
		return SUCCESS;
	}
	
	/*
	 * �õ����и�ڵ�
	 * */
		private Map getChildNodes( Map<String,Item> items )  
	    {  
			//�õ����еĸ� ;getChildPermissions()�����Լ�д
			List<CountryBasicInfo> permissions=countrytreeService.getChildPrivance( );  
			//��ÿ������б���
			int count = 0;
	       // if(permissions.size( )>0){  
	            for ( CountryBasicInfo permission : permissions )// BudgPro��Ҫ�γ������� 
	            {  
	            
	               //���ýڵ�
	                Item item=new Item( );  
	                item.setName( permission.getCountryName()); //�����ּ��뵽item 
	              
	                //�õ��ĸ��ڵ�Ľڵ�
	                item.setType( ItemType.NODE_ITEM );  
	                AdditionalParameters additionalParameters=new AdditionalParameters( );  
	                additionalParameters.setId( permission.getCountryNum() );
	                if (count == 0) {
	                	additionalParameters.setItemSelected(true);
	                	count++;
	                	//System.out.println("------------------>"+JSONObject.fromObject(additionalParameters));
					} else {
						
						additionalParameters.setItemSelected(false);
					}
	                
	                item.setAdditionalParameters( additionalParameters ); 
	                
	                //getChildItems(item,permission.getMajorCatgNum().toString( ),permission.getMajorCatgName( ));  
	                items.put( permission.getCountryName(), item );  
	            }  
	      //  }  
	        return items;
	    }

	
	

	
}
