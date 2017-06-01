package com.rural.govfile.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONObject;


import com.rural.bean.GoveFilClfy;
import com.rural.bean.VilBasicInfo;
import com.rural.govfile.service.IVilFilService;

import com.rural.tool.AdditionalParameters;
import com.rural.tool.Criterion;
import com.rural.tool.Item;
import com.rural.tool.ItemType;
import com.rural.tool.JqGridBaseAction;

public class VilFilAction  extends JqGridBaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private IVilFilService vilfilService;
	private String GoveFilClfyNum;
	private String GoveFilClfyName;
	private String VilFilID;
	private String GoveFilClfyID;
	private Integer VilBasicInfoID;
	private String VilFilNum;
	private String VilFilName;
	private String VilFilIdef;
	private Date VilFilMadTim;
	private String VilFilPubComp;
	private String VilFilExpl;
	private String oper;
	private String JQID;
	public static String JQS;
	
	

	
	
	//检查编码是否重复并添加节点
	public String addMenusAsTree(){
		
		String message="";
		boolean flag = vilfilService.checkGoveFilClfyNumCode1(GoveFilClfyNum);
		if(flag){//编码有重复
			message = "文件编码重复，请重新录入";
			dataMap.put("success", message);
		}else{
			
			boolean flage2 = vilfilService.addGoveFilClfy(GoveFilClfyNum, GoveFilClfyName);
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
				
				message= message+ vilfilService.delGoveFilClfy1(id.trim());
			}
				
			dataMap.put("success", message);
		    return SUCCESS;
		}
	
	//判断专家编码是否重复
	public String checkVilFilNum(){
		try {
			
			//flag==true表示提示错误，flag==false表示没有重复，不提示错误
			if(VilFilID.equals("undefined"))VilFilID=null;//若id未定义则给其赋值为null
				boolean flag = vilfilService.checkVilFilNum(VilFilNum, VilFilID);
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

	
	public String manageVilFil() {
		VilFilAction.setJQS(JQID);
		if(!search){
			if ("add".equals(oper)) {//
				addVilFil();
			} else if ("search".equals(oper)) {//
				refreshGridModel();
				responseData();
			} else if ("del".equals(oper)) {//
				delVilFil();
			}else if("edit".equals(oper)){//
				updateVilFil();
				//CheckLoginName();
				//editLoginname();
			}
		}else{
			refreshGridModel();
			responseData();
		}
		return SUCCESS;
	}
	


	private String updateVilFil() {
		// TODO Auto-generated method stub
		vilfilService.updateVilFil(JQID,VilBasicInfoID,VilFilID, VilFilNum, VilFilName, VilFilIdef, VilFilMadTim, VilFilPubComp, VilFilExpl);
		this.dataMap.put("success", true);
		return SUCCESS;
	}

	


	private String delVilFil() {
		
		for(String allld: VilFilID.split(",")){
			//System.out.println("_----------->"+allid);		
			vilfilService.delVilFil(allld);
			}
		// TODO Auto-generated method stub
		this.dataMap.put("success","删除成功");
		return SUCCESS;
	}



	private String addVilFil() {
		// TODO Auto-generated method stub
		vilfilService.addVilFil(JQID,VilBasicInfoID,VilFilNum, VilFilName, VilFilIdef, VilFilMadTim, VilFilPubComp, VilFilExpl);
		this.dataMap.put("success","添加成功");
		return SUCCESS;
	}



	
	public void responseData(){
		dataMap.put("page", page);
		dataMap.put("total", total);
		dataMap.put("records", records);
		dataMap.put("data", results);
	}
	
	
	
	
	
	//树结构入口
	public String GoveFilClfy( ) {
		
		Map<String,Item> items = new LinkedHashMap<String,Item>( ); //LinkedHashMap�����˼�¼�Ĳ���˳��
		
	    items= getChildNodes(items); //根据父节点找到所有子节点，并put到map集合中
	   // JSONObject ja1 = JSONObject.fromObject(items);
	   // System.out.println(ja1.toString());
		dataMap.put("ss",items); //ja1.toString());
		return SUCCESS;
	}
	
	
	
/*
 * 得到所有根节点
 * */
	private Map getChildNodes( Map<String,Item> items )  
    {  
		//得到所有的根 ;getChildPermissions()方法自己写
		List<GoveFilClfy> permissions=vilfilService.getChildPrivance( );  
		//对每个根进行遍历
		int count = 0;
       // if(permissions.size( )>0){  
            for (GoveFilClfy permission : permissions )// BudgPro是要形成树的类 
            {  
            
            	//设置节点
                Item item=new Item( );  
                item.setName( permission.getGoveFilClfyName()); //将名字加入到item 
              
              //得到哪个节点的节点
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
		return this.vilfilService.queryResultsCount(null);
	}

	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return  this.vilfilService.queryByPage(null, from, length);
	}

	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return  this.vilfilService.queryResultsCount(criteria);
	}

	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		return results=this.vilfilService.queryByPage(criteria, from, length);
	}

	
	public IVilFilService getCitysfilService() {
		return vilfilService;
	}

	public void setCitysfilService(IVilFilService vilfilService) {
		this.vilfilService =vilfilService;
	}
	public IVilFilService getVilfilService() {
		return vilfilService;
	}

	public void setVilfilService(IVilFilService vilfilService) {
		this.vilfilService = vilfilService;
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

	public String getVilFilID() {
		return VilFilID;
	}

	public void setVilFilID(String vilFilID) {
		VilFilID = vilFilID;
	}

	

	public String getGoveFilClfyID() {
		return GoveFilClfyID;
	}


	public void setGoveFilClfyID(String goveFilClfyID) {
		GoveFilClfyID = goveFilClfyID;
	}


	public Integer getVilBasicInfoID() {
		return VilBasicInfoID;
	}

	public void setVilBasicInfoID(Integer vilBasicInfoID) {
		VilBasicInfoID = vilBasicInfoID;
	}

	public String getVilFilNum() {
		return VilFilNum;
	}

	public void setVilFilNum(String vilFilNum) {
		VilFilNum = vilFilNum;
	}

	public String getVilFilName() {
		return VilFilName;
	}

	public void setVilFilName(String vilFilName) {
		VilFilName = vilFilName;
	}

	public String getVilFilIdef() {
		return VilFilIdef;
	}

	public void setVilFilIdef(String vilFilIdef) {
		VilFilIdef = vilFilIdef;
	}

	public Date getVilFilMadTim() {
		return VilFilMadTim;
	}

	public void setVilFilMadTim(Date vilFilMadTim) {
		VilFilMadTim = vilFilMadTim;
	}

	public String getVilFilPubComp() {
		return VilFilPubComp;
	}

	public void setVilFilPubComp(String vilFilPubComp) {
		VilFilPubComp = vilFilPubComp;
	}

	public String getVilFilExpl() {
		return VilFilExpl;
	}

	public void setVilFilExpl(String vilFilExpl) {
		VilFilExpl = vilFilExpl;
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
	
	
	

}

