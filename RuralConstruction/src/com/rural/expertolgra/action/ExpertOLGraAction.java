package com.rural.expertolgra.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.rural.bean.EvalExpertDist;
import com.rural.expertolgra.service.IExpertOLGraService;
import com.rural.tool.AdditionalParameters;
import com.rural.tool.Criterion;
import com.rural.tool.Item;
import com.rural.tool.ItemType;
import com.rural.tool.JqGridBaseAction;

public class ExpertOLGraAction extends JqGridBaseAction {

	private static final long serialVersionUID = 1L;
	private IExpertOLGraService iExpertOLGraService;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private int userId;
	private static int expertId;
	private String oper;
	private static int isFirstItem = 0;
	private Integer methID;
	private Integer distID;
	private static Integer evalMethID;
	private static Integer expertDistID;
	private String scores;
	private Map<Integer, List<String>> scoreMap = new HashMap<Integer, List<String>>();
	private boolean sub;
	private static boolean isSubmit = false;
	
	public String getVilsTree(){
		//根据用户（登录）ID（SysUserID）查询专家的专家ID（ExpertID）
		userId= Integer.parseInt((String) ServletActionContext.getRequest().getSession().getAttribute("userid"));
		expertId = iExpertOLGraService.getExpertId(userId);
		//ExpertOLGraAction.setExpertId(expertId);
		//根据‘ExpertID’和‘是否提交’字段查询“评价专家分配（EvalExpertDist）”表
		//从而获得该专家未评价的村庄
		/**
		 * “村庄”树中虽然仅仅显示[村名]，但为了方便之后的专家打分后向“专家打分”表插入数据，
		 * 该树还需要携带“评价-专家-分配-ID”信息，因为在“专家打分”表中有该字段，
		 * 该字段唯一确定哪个专家对村庄的哪次评价进行打分；
		 * 故该树每个节点所包含的信息为（item_name:村名，item_id:评价-专家-分配-ID）
		 * 
		 */
		List<EvalExpertDist> evalExpertDists = iExpertOLGraService.getDistsUnevaluated(expertId, false);
		Map<String, Item> tree = new LinkedHashMap<String, Item>();
		for(EvalExpertDist evalExpertDist : evalExpertDists){
			Item vilItem = new Item();
			AdditionalParameters vilAdditionalParameters = new AdditionalParameters();
			//设置节点ID
			if(isFirstItem == 0)
				vilAdditionalParameters.setItemSelected(true);
			else
				isFirstItem++;
			String id = evalExpertDist.getEvalExpertDistId().toString();
			vilAdditionalParameters.setId(id);
			vilItem.setAdditionalParameters(vilAdditionalParameters);
			vilItem.setType(ItemType.NODE_ITEM);
			String itemName = evalExpertDist.getVilEvalSco().getVilDataCollRec().getVilBasicInfo().getVilName();
			vilItem.setName(itemName+"(分配ID:"+id+")");
			tree.put(itemName+"(分配ID:"+id+")", vilItem);//去掉（分配ID）后，树中不能有两个相同名称的item
		}
		dataMap.put("ss", tree);
		return SUCCESS;
	}
	public String manageEvalCont(){
		//根据用户（登录）ID（SysUserID）查询专家的专家ID（ExpertID）
		userId= Integer.parseInt((String) ServletActionContext.getRequest().getSession().getAttribute("userid"));
		expertId = iExpertOLGraService.getExpertId(userId);
		ExpertOLGraAction.setExpertDistID(distID);
		if(!search){
			if("add".equals(oper)){
				
			}else if("search".equals(oper)){
				refreshGridModel();
				responseData();
			}else if("del".equals(oper)){
				
			}else if("edit".equals(oper)){
				
			}
		}else{
			refreshGridModel();
			responseData();
		}
		return SUCCESS;
	}
	
	public String saveScore(){
		ExpertOLGraAction.setExpertDistID(distID);//获得评价专家分配ID
		ExpertOLGraAction.setSubmit(sub);//是否“提交”
		JSONArray jsonArray = JSONArray.fromObject(scores);
		List<Integer> contIds = new ArrayList<Integer>();
		for(int i = 0; i < jsonArray.size()-1; ++i){
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			if(jsonObject.getString("Score").equals(""))
				continue;
			int cid = jsonObject.getInt("contID");
			String sco = jsonObject.getString("Score");
			String graRea = jsonObject.getString("GraRea");
			System.out.println(graRea);
			List<String> temp = new ArrayList<String>();
			temp.add(sco);
			temp.add(graRea);
			scoreMap.put(cid, temp);//每一项为：评价内容ID、分数
			contIds.add(cid);
		}
		iExpertOLGraService.saveScore(expertDistID, scoreMap);
		if(isSubmit){
			//将该专家的状态设为已提交
			iExpertOLGraService.modifyIsSubmit(expertDistID);
			//计算  评价内容合计分--专家评价内容总分
			Integer majorId = iExpertOLGraService.getMajorId(expertDistID);//获得该专家的专业
			Integer vilEvalScoId = iExpertOLGraService.getVilEvalScoId(expertDistID);
			List<EvalExpertDist> expertsTotal = iExpertOLGraService.getExpertsTotal(majorId, vilEvalScoId);
			int expertsSubmited = 0;
			List<Integer> distIds = new ArrayList<Integer>();
			for(EvalExpertDist evalExpertDist : expertsTotal){
				if(evalExpertDist.getIsSub() == true){
					expertsSubmited++;
					distIds.add(evalExpertDist.getEvalExpertDistId());
				}
				else
					break;
			}
			//如果该专业的所有专家已经全部完成提交，则计算该专业下的所有评价内容的合计分
			if(expertsSubmited == expertsTotal.size()){
				calcEvalContSubSco(contIds, distIds, vilEvalScoId);
				/*
				 * 每次进行完单条“评价内容”的合计分计算后，判断是否
				 * 全部评价内容都已经完成合计分（专家评价合计分）的计算，
				 * 如果已完成，则算出总分并填入“村庄-评价-得分”表
				 */
				calcVilEvalSco(vilEvalScoId);
			}
		}
		return SUCCESS;
	}
	
	public void responseData(){
		dataMap.put("page", page);
		dataMap.put("total", total);
		dataMap.put("records", records);
		dataMap.put("data", results);
	}
	
	private void calcEvalContSubSco(List<Integer> contIds, List<Integer> distIds, Integer vilEvalScoId){
		iExpertOLGraService.calcEvalContSubSco(contIds, distIds, vilEvalScoId);
	}
	
	private void calcVilEvalSco(Integer vilEvalScoId){
		iExpertOLGraService.calcVilEvalSco(vilEvalScoId);
	}


	@Override
	public int getResultSize() {
		// TODO Auto-generated method stub
		return this.iExpertOLGraService.queryResultsCount(null);
	}

	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return this.iExpertOLGraService.queryResultsCount(criteria);
	}

	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return this.iExpertOLGraService.queryByPage(null, from, length);
	}

	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		return this.iExpertOLGraService.queryByPage(criteria, from, length);
	}

	public IExpertOLGraService getiExpertOLGraService() {
		return iExpertOLGraService;
	}

	public void setiExpertOLGraService(IExpertOLGraService iExpertOLGraService) {
		this.iExpertOLGraService = iExpertOLGraService;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public static int getExpertId() {
		return expertId;
	}

	public static void setExpertId(int expertId) {
		ExpertOLGraAction.expertId = expertId;
	}
	public String getOper() {
		return oper;
	}
	public void setOper(String oper) {
		this.oper = oper;
	}
	public Integer getMethID() {
		return methID;
	}
	public void setMethID(Integer methID) {
		this.methID = methID;
	}
	public Integer getDistID() {
		return distID;
	}
	public void setDistID(Integer distID) {
		this.distID = distID;
	}
	public static Integer getEvalMethID() {
		return evalMethID;
	}
	public static void setEvalMethID(Integer evalMethID) {
		ExpertOLGraAction.evalMethID = evalMethID;
	}
	public static Integer getExpertDistID() {
		return expertDistID;
	}
	public static void setExpertDistID(Integer expertDistID) {
		ExpertOLGraAction.expertDistID = expertDistID;
	}
	public String getScores() {
		return scores;
	}
	public void setScores(String scores) {
		this.scores = scores;
	}
	public Map<Integer, List<String>> getScoreMap() {
		return scoreMap;
	}
	public void setScoreMap(Map<Integer, List<String>> scoreMap) {
		this.scoreMap = scoreMap;
	}
	public boolean isSub() {
		return sub;
	}
	public void setSub(boolean sub) {
		this.sub = sub;
	}
	public static boolean isSubmit() {
		return isSubmit;
	}
	public static void setSubmit(boolean isSubmit) {
		ExpertOLGraAction.isSubmit = isSubmit;
	}
	
}
