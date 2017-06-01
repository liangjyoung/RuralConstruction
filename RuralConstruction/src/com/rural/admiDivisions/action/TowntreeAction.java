package com.rural.admiDivisions.action;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.rural.admiDivisions.service.TowntreeService;
import com.rural.bean.TownBasicInfo;
import com.rural.tool.AdditionalParameters;
import com.rural.tool.Item;
import com.rural.tool.ItemType;

public class TowntreeAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private TowntreeService towntreeService;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private String JQID;
	public static String JQS;
	private String townBasicInfoID;
	private String oper;
	private String townNum;
	private String townName;
	private String townLongi;
	private String townLati;
	private String townMeas;
	private String townPop;
	private String townHholds;
	//private byte[] townIntro;
	private String townIntro;
	private int isFirstItem = 0;
	public TowntreeService getTowntreeService() {
		return towntreeService;
	}
	public void setTowntreeService(TowntreeService towntreeService) {
		this.towntreeService = towntreeService;
	}
	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
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
	public String getTownBasicInfoID() {
		return townBasicInfoID;
	}
	public void setTownBasicInfoID(String townBasicInfoID) {
		this.townBasicInfoID = townBasicInfoID;
	}
	public String getOper() {
		return oper;
	}
	public void setOper(String oper) {
		this.oper = oper;
	}
	public String getTownNum() {
		return townNum;
	}
	public void setTownNum(String townNum) {
		this.townNum = townNum;
	}
	public String getTownName() {
		return townName;
	}
	public void setTownName(String townName) {
		this.townName = townName;
	}
	public String getTownLongi() {
		return townLongi;
	}
	public void setTownLongi(String townLongi) {
		this.townLongi = townLongi;
	}
	public String getTownLati() {
		return townLati;
	}
	public void setTownLati(String townLati) {
		this.townLati = townLati;
	}
	public String getTownMeas() {
		return townMeas;
	}
	public void setTownMeas(String townMeas) {
		this.townMeas = townMeas;
	}
	public String getTownPop() {
		return townPop;
	}
	public void setTownPop(String townPop) {
		this.townPop = townPop;
	}
	public String getTownHholds() {
		return townHholds;
	}
	public void setTownHholds(String townHholds) {
		this.townHholds = townHholds;
	}
	
	
	
	public String getTownIntro() {
		return townIntro;
	}
	public void setTownIntro(String townIntro) {
		this.townIntro = townIntro;
	}
public String singTree( ) {
	TowntreeAction.setJQS(JQID);
	
		Map<String,Item> items = new LinkedHashMap<String,Item>( ); //LinkedHashMap�����˼�¼�Ĳ���˳��
		
	    items= getChildNodes(items); //��ݸ��ڵ��ҵ������ӽڵ㣬��put��map������
	   // JSONObject ja1 = JSONObject.fromObject(items);
	   // System.out.println(ja1.toString());
		dataMap.put("ss",items); //
		return SUCCESS;
	}
	
	/*
	 * �õ����и�ڵ�
	 * */
		private Map getChildNodes( Map<String,Item> items )  
	    {  
			String s=TowntreeAction.getJQS().trim();
			//�õ����еĸ� ;getChildPermissions()�����Լ�д
			List<TownBasicInfo> permissions=towntreeService.getChildPrivance(s);  
			//��ÿ������б���
			int count = 0;
	       // if(permissions.size( )>0){  
	            for ( TownBasicInfo permission : permissions )// BudgPro��Ҫ�γ������� 
	            {  
	            
	               //���ýڵ�
	                Item item=new Item( );  
	                item.setName( permission.getTownName()); //�����ּ��뵽item 
	              
	                //�õ��ĸ��ڵ�Ľڵ�
	                item.setType( ItemType.NODE_ITEM );  
	                AdditionalParameters additionalParameters=new AdditionalParameters( );  
	                additionalParameters.setId( permission.getTownNum() );
	                if(this.isFirstItem==0){
		            	additionalParameters.setItemSelected(true);
		            	this.isFirstItem++;
		            }
	                
	                item.setAdditionalParameters( additionalParameters ); 
	                
	                //getChildItems(item,permission.getMajorCatgNum().toString( ),permission.getMajorCatgName( ));  
	                items.put( permission.getTownName(), item );  
	            }  
	      //  }  
	        return items;
	    }

}
