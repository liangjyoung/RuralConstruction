package com.rural.expert.action;


import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.rural.bean.CityBasicInfo;
import com.rural.bean.ExpertMajorCatg;
import com.rural.expert.service.IExpertService;

import com.rural.tool.AdditionalParameters;
import com.rural.tool.Criterion;
import com.rural.tool.Item;
import com.rural.tool.ItemType;
import com.rural.tool.JqGridBaseAction;



public class ExpertAction  extends JqGridBaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private IExpertService expertService;
	private String expertID;
	private String expertNum;
	private String  expertWorkTel;
	private String  expertMobTel;
	private String expertName;
	private String sexID;
	private String expertTitle;
	private Date expertBirth;
	private String expertAddress;
	private String cityBasicInfoId;
	
	private String oper;
	private String JQID;
	public static String JQS;
	



	



	//判断专家编码是否重复
	public String checkExpertNum(){
		try {
			
			//flag==true表示提示错误，flag==false表示没有重复，不提示错误
			if(expertID.equals("undefined"))expertID=null;//若id未定义则给其赋值为null
				boolean flag = expertService.checkExpertNum(expertNum,expertID);
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


	//表入口
	public String manageExpert() {
		
		
		ExpertAction.setJQS(JQID);
		if(!search){
			if ("add".equals(oper)) {//
				addEvalExpert();
			} else if ("search".equals(oper)) {//
				refreshGridModel();
				responseData();
			} else if ("del".equals(oper)) {//
				delEvalExpert();
			}else if("edit".equals(oper)){//
				updateEvalExpert();
				//CheckLoginName();
				//editLoginname();
			}
		}else{//查询
			refreshGridModel();
			responseData();
		}
		return SUCCESS;
	}
	
	public String addEvalExpert() {
		// TODO Auto-generated method stub
//		dataMap.put("ss","ss"); //ja1.toString());
		//注意，地市管理员要根据区划专家添加所属市
		//JQID表示专家类别ID
		expertService.addEvalExpert(JQID,expertNum, expertName, sexID, expertTitle, expertWorkTel, expertMobTel, expertBirth, expertAddress);
		this.dataMap.put("success", true);
		return SUCCESS;
	}
	
	private String updateEvalExpert(){
		expertService.updateEvalExpert(JQID,expertID, expertNum, expertName, sexID, expertTitle,  expertWorkTel, expertMobTel, expertBirth, expertAddress);
		this.dataMap.put("success", true);
		return SUCCESS;
	}
	
	private String  delEvalExpert(){
		/*expertService.delEvalExpert(expertID);
		
		this.dataMap.put("success", true);
		return SUCCESS;*/
		String message="";
		for(String expert: expertID.split(",")){
			message= message+ expertService.delEvalExpert(Integer.parseInt(expert));
		}
		dataMap.put("success", message);
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
	public String singTree( ) {
		
		Map<String,Item> items = new LinkedHashMap<String,Item>( ); //LinkedHashMap保存了记录的插入顺序，
		
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
		List<ExpertMajorCatg> permissions=expertService.getAllExpertMajor();  
		//对每个根进行遍历
		int count = 0;
            for ( ExpertMajorCatg expert : permissions )// BudgPro是要形成树的类 
            {  
            
               //设置节点
                Item item=new Item( );  
                item.setName( expert.getExpertMajorCatg()); //将名字加入到item 
                //得到哪个节点的节点
                item.setType( ItemType.NODE_ITEM );  
                AdditionalParameters additionalParameters=new AdditionalParameters( );  
                additionalParameters.setId( expert.getExpertMajorCatgId().toString());
                if (count == 0) {
                	additionalParameters.setItemSelected(true);
                	count++;
  				} else {
					additionalParameters.setItemSelected(false);
				}
                
                item.setAdditionalParameters( additionalParameters ); 
                items.put( expert.getExpertMajorCatg(), item );  
            }  
  
		return items;
    }


	@Override
	public int getResultSize() {
		// TODO Auto-generated method stub
		return this.expertService.queryResultsCount(null);
	}

	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return  this.expertService.queryByPage(null, from, length);
	}

	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return  this.expertService.queryResultsCount(criteria);
	}

	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		return results=this.expertService.queryByPage(criteria, from, length);
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

	public String getSexID() {
		return sexID;
	}


	public void setSexID(String sexID) {
		this.sexID = sexID;
	}



	public String getCityBasicInfoId() {
		return cityBasicInfoId;
	}


	public void setCityBasicInfoId(String cityBasicInfoId) {
		this.cityBasicInfoId = cityBasicInfoId;
	}


	public String getExpertID() {
		return expertID;
	}


	public void setExpertID(String expertID) {
		this.expertID = expertID;
	}


	public IExpertService getExpertService() {
		return expertService;
	}


	public void setExpertService(IExpertService expertService) {
		this.expertService = expertService;
	}
	
	
	public String getExpertNum() {
		return expertNum;
	}


	public void setExpertNum(String expertNum) {
		this.expertNum = expertNum;
	}


	public String getExpertName() {
		return expertName;
	}


	public void setExpertName(String expertName) {
		this.expertName = expertName;
	}




	public String getExpertTitle() {
		return expertTitle;
	}


	public void setExpertTitle(String expertTitle) {
		this.expertTitle = expertTitle;
	}




	public Date getExpertBirth() {
		return expertBirth;
	}


	public void setExpertBirth(Date expertBirth) {
		this.expertBirth = expertBirth;
	}


	public String getExpertAddress() {
		return expertAddress;
	}


	public void setExpertAddress(String expertAddress) {
		this.expertAddress = expertAddress;
	}


	public String getExpertWorkTel() {
		return expertWorkTel;
	}


	public void setExpertWorkTel(String expertWorkTel) {
		this.expertWorkTel = expertWorkTel;
	}


	public String getExpertMobTel() {
		return expertMobTel;
	}


	public void setExpertMobTel(String expertMobTel) {
		this.expertMobTel = expertMobTel;
	}

}
