package com.rural.evalsystem.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.rural.bean.EvalCont;
import com.rural.bean.EvalSyst;
import com.rural.bean.EvalSystInd;
import com.rural.bean.EvalSystState;
import com.rural.bean.ExpertMajorCatg;
import com.rural.bean.InvesPro;
import com.rural.evalsystem.service.IEvalSysService;
import com.rural.tool.AdditionalParameters;
import com.rural.tool.Criterion;
import com.rural.tool.Item;
import com.rural.tool.ItemType;
import com.rural.tool.JqGridBaseAction;


public class EvalSysAction extends JqGridBaseAction{
	private static final long serialVersionUID = 1L;

	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private String oper;
	private IEvalSysService evalSysService;
	private static int TreeS;
	private int TreeJS;
	private String evalNum; //添加节点
	private String evalName;//添加节点
	private String evalSco;
	private String sv;//获取下拉框中选中的值
	private String sc;//获取下拉框中选中的值
	private String evalSystid;
	private String evalNo;//删除节点
	private String EvalSystName;
	private String Startime;
	private String Endtime;
	private String EvalSystNote;
	private String EvalSystID;//新ID
	private String EvalSystID2;//旧ID
	private String editEvalSystID;//所要修改的评价体系ID
	private String evalSystStateID;//评价体系状态ID
	private String EvalSysID;//选择下拉框的体系ID
	

	
	/*$( "#dialog-message1" ).on('click', function(e) {
		 alert(rowid);			
			$.ajax({
			url: "../../evalsys_queryAllState.action",//tree_singTree.action
			async:false,  
			type: 'POST',
			dataType: 'json',
			data:{ 
				   "evalNum":rowid,
			    },
			success : function(data) {
			//tree_data=$.parseJSON(data.ss);
			$.ajax({
				url: "../../evalsys_queryAllState.action",
				datatype:"json",
				type:'post',
				success:function(data)	//success callback
				{   
					var json = data.info;
					//aler(json);
					for(var i=0; i<json.length; i++)  
					{  
						$("#select-state").append("<option value=\"" + json[i].EvalSystStateId + "\">" + json[i].EvalSystStateDes +"</option>");
					}  
				},
			});
			location.reload();
			},
			});
		
				
				}),*/
	
	
	
	public String getEvalSysID() {
		return EvalSysID;
	}

	public void setEvalSysID(String evalSysID) {
		EvalSysID = evalSysID;
	}

	public String getEditEvalSystID() {
		return editEvalSystID;
	}

	public void setEditEvalSystID(String editEvalSystID) {
		this.editEvalSystID = editEvalSystID;
	}

	public String getEvalSystStateID() {
		return evalSystStateID;
	}

	public void setEvalSystStateID(String evalSystStateID) {
		this.evalSystStateID = evalSystStateID;
	}

	public String getEvalSystID2() {
		return EvalSystID2;
	}

	public void setEvalSystID2(String evalSystID2) {
		EvalSystID2 = evalSystID2;
	}

	public String getEvalSco() {
		return evalSco;
	}

	public void setEvalSco(String evalSco) {
		this.evalSco = evalSco;
	}

	public String getEvalNum() {
		return evalNum;
	}

	public void setEvalNum(String evalNum) {
		this.evalNum = evalNum;
	}

	public String getEvalName() {
		return evalName;
	}

	public void setEvalName(String evalName) {
		this.evalName = evalName;
	}

	public String getSv() {
		return sv;
	}

	public void setSv(String sv) {
		this.sv = sv;
	}

	public String getSc() {
		return sc;
	}

	public void setSc(String sc) {
		this.sc = sc;
	}

	public static int getTreeS() {
		return TreeS;
	}

	public static void setTreeS(int treeS) {
		TreeS = treeS;
	}

	public int getTreeJS() {
		return TreeJS;
	}

	public void setTreeJS(int treeJS) {
		TreeJS = treeJS;
	}

	
	
	
	public String getEvalSystName() {
		return EvalSystName;
	}

	public void setEvalSystName(String evalSystName) {
		EvalSystName = evalSystName;
	}

	

	

	public String getStartime() {
		return Startime;
	}

	public void setStartime(String startime) {
		Startime = startime;
	}

	public String getEndtime() {
		return Endtime;
	}

	public void setEndtime(String endtime) {
		Endtime = endtime;
	}

	public String getEvalSystNote() {
		return EvalSystNote;
	}

	public void setEvalSystNote(String evalSystNote) {
		EvalSystNote = evalSystNote;
	}

	public String getEvalNo() {
		return evalNo;
	}

	public void setEvalNo(String evalNo) {
		this.evalNo = evalNo;
	}

	public String getEvalSystid() {
		return evalSystid;
	}

	public void setEvalSystid(String evalSystid) {
		this.evalSystid = evalSystid;
	}

	
	
	public String getEvalSystID() {
		return EvalSystID;
	}

	public void setEvalSystID(String evalSystID) {
		EvalSystID = evalSystID;
	}

	
	
	//评价体系状态下拉框
	public String queryAllState(){
		
		List<Map<String, Object>> StateList = new ArrayList<Map<String, Object>>();
		List<EvalSystState> est = evalSysService.findAllState(Integer.parseInt(EvalSysID));
		for (EvalSystState c : est) {
			Map<String, Object> dsMap = new HashMap<String, Object>();
			dsMap.put("EvalSystStateId", c.getEvalSystStateId());
			dsMap.put("EvalSystStateDes",c.getEvalSystStateDes());
			StateList.add(dsMap);
		}
		dataMap.put("info", StateList);
		return SUCCESS;
			
	
	}
	
	//评价体系版本下拉框
	public String queryAllEvalSys(){
		
		List<Map<String, Object>> evalSystList = new ArrayList<Map<String, Object>>();
		List<EvalSyst> es = evalSysService.findAllEvalSys();
		for (EvalSyst c : es) {
			Map<String, Object> dsMap = new HashMap<String, Object>();
			dsMap.put("EvalSystId", c.getEvalSystId());
			dsMap.put("EvalSystNote", c.getEvalSystNote());
			evalSystList.add(dsMap);
		}
		dataMap.put("info", evalSystList);
		return SUCCESS;
			
	
	}
	
	
	//评价指标下拉框   超男
	public String queryAll(){
			
			List<Map<String, Object>> evalSystIndList = new ArrayList<Map<String, Object>>();
			List<EvalSystInd> ess = evalSysService.findAllEval();
			for (EvalSystInd c : ess) {
				Map<String, Object> dsMap = new HashMap<String, Object>();
				dsMap.put("EvalIndNum", c.getEvalIndNum());
				dsMap.put("EvalIndName", c.getEvalIndName());
				evalSystIndList.add(dsMap);
			}
			dataMap.put("info", evalSystIndList);
			return SUCCESS;
				
		
		}
	
	//专业类别下拉框   
	public String queryExpertMajorCatg(){
		
		List<Map<String, Object>> expertMajorCatgList = new ArrayList<Map<String, Object>>();
		List<ExpertMajorCatg> zl = evalSysService.findAllEvmc();
		for (ExpertMajorCatg b : zl) {
			Map<String, Object> dsMap = new HashMap<String, Object>();
			dsMap.put("ExpertMajorCatgID", b.getExpertMajorCatgId());
			dsMap.put("ExpertMajorCatg", b.getExpertMajorCatg());
			expertMajorCatgList.add(dsMap);
		}
		dataMap.put("info", expertMajorCatgList);
		return SUCCESS;
			
	
	}
	
	
	//删除节点
	public String delMenusAsTree() {
		// TODO Auto-generated method stub
				
		String message="";
		for(String id: evalNo.split(",")){
			
			message= message+ evalSysService.delEval(id.trim());
		}
		dataMap.put("success", message);
	    return SUCCESS;
	}
	
	//检查编码是否重复并添加节点
	public String addMenusAsTree(){
		
		String message="";
		
			message = evalSysService.addEval(evalNum.trim(), evalName.trim(),evalSco.trim(),sv.trim(),sc.trim(),evalSystid.trim());
			dataMap.put("success", message);	
			return SUCCESS;
	}
	
	
	public String manageEvalSys(){
		
		if(!search){
			if ("add".equals(oper)) {//增加
				addEvalsys();
			} else if ("search".equals(oper)) {//载入页面时查询
				refreshGridModel();
				responseData();
			} else if ("del".equals(oper)) {//删除
				delEvalsys();
			}else if("edit".equals(oper)){//修改
				updateEvalsys();
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
	
	
	public String aa(){
		dataMap.put("ss", "ss");
		return SUCCESS;
	}
	
	
	
	public String addEvalsys(){
		String message="";
		if(EvalSystName.equals("")||Startime.equals("")||Endtime.equals("")||EvalSystNote.equals("")){
			message = "不能有空值";
		}else{
			message = evalSysService.addEvalsys(EvalSystName,Startime,Endtime,EvalSystNote);
		}
		dataMap.put("success", message);
		return SUCCESS;
	}
	
	public String delEvalsys() {
		// TODO Auto-generated method stub
				
		String message="";
		for(String id: EvalSystID.split(",")){
			
			message= message+ evalSysService.delEvalsys(Integer.parseInt(id));
		}
		dataMap.put("success", message);
	    return SUCCESS;
	}
	
	
	//更新
	public String updateEvalsys() {
		// TODO Auto-generated method stub
		String message="";
		if(EvalSystName.equals("")||Startime.equals("")||Endtime.equals("")||EvalSystNote.equals("")){
			message = "不能有空值";
		}else{
			message = evalSysService.updateEvalsys(Integer.parseInt(EvalSystID),EvalSystName,Startime,Endtime,EvalSystNote);
		}
		dataMap.put("success", message);
		return SUCCESS;
	}
	
	public String evalIndStructree()  
    { 
		EvalSysAction.setTreeS(TreeJS);
		Map<String,Item> items = new LinkedHashMap<String,Item>( );  
	    items= getChildNodes(items, null );  
	    ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>(); 
	    dataMap.put("ss", items);
	    return SUCCESS;
    }
	
	
	
	//复制上年评价体系
	public String copeSysEval(){
		String message="";
		//String EvalSystID2 = 
		message = evalSysService.copyEvalSys(EvalSystID, EvalSystID2);
		
		this.dataMap.put("success", message);		
		return SUCCESS;
	}

	//修改评价体系状态
	public String editState(){
		String message="";
		message = evalSysService.editState(evalSystStateID, editEvalSystID);
		this.dataMap.put("success", message);		
		return SUCCESS;
	}
	
	
	
	
	//根据父节点得到
	private Map getChildNodes( Map<String,Item> items, String parentId )  
    {  
		//得到所有的根
		List<EvalSystInd> permissions=evalSysService.getChildPermissions(parentId );  
		//对每个根进行遍历
        if(permissions.size( )>0){  
            for ( EvalSystInd permission : permissions )  
            {  
                //递归子节点  
                Item item=new Item( );  
                String treename = permission.getEvalIndName()+"(分数:"+permission.getEvalIndScore()+")";
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
	
		List<EvalSystInd> childPermissions = evalSysService.getChildPermissions( parentId );  
		
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
                String treechildname = childPermission.getEvalIndName()+"(分数:"+childPermission.getEvalIndScore()+")";
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
	
	
	@Override
	public int getResultSize() {
		// TODO Auto-generated method stub
		return this.evalSysService.queryResultsCount(null);
	}
	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return this.evalSysService.queryResultsCount(criteria);
	}

	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return this.evalSysService.queryByPage(null, from, length);
	}

	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		results=this.evalSysService.queryByPage(criteria, from, length);
		return results;
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

	public void setEvalSysService(IEvalSysService evalSysService) {
		this.evalSysService = evalSysService;
	}

	public IEvalSysService getEvalSysService() {
		return evalSysService;
	}

	
	
}
