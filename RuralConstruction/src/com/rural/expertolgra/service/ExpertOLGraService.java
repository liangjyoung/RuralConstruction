package com.rural.expertolgra.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rural.bean.EvalContSubSco;
import com.rural.bean.EvalExpertDist;
import com.rural.bean.EvalCont;
import com.rural.bean.EvalSyst;
import com.rural.bean.EvalSystInd;
import com.rural.bean.Expert;
import com.rural.bean.ExpertGra;
import com.rural.bean.VilEvalSco;
import com.rural.dao.EvalContSubScoDAO;
import com.rural.dao.EvalExpertDistDAO;
import com.rural.dao.EvalContDAO;
import com.rural.dao.EvalSystDAO;
import com.rural.dao.EvalSystIndDAO;
import com.rural.dao.ExpertDAO;
import com.rural.dao.ExpertGraDAO;
import com.rural.dao.VilEvalScoDAO;
import com.rural.expertolgra.action.ExpertOLGraAction;
import com.rural.tool.Criterion;

public class ExpertOLGraService implements IExpertOLGraService {

	private ExpertDAO expertDAO = new ExpertDAO();
	private EvalExpertDistDAO evalExpertDistDAO = new EvalExpertDistDAO();
	private EvalSystIndDAO evalSystIndDAO = new EvalSystIndDAO();
	private EvalContDAO evalContDAO = new EvalContDAO();
	private ExpertGraDAO expertGraDAO = new ExpertGraDAO();
	private EvalSystDAO evalSystDAO = new EvalSystDAO();
	private EvalContSubScoDAO evalContSubScoDAO = new EvalContSubScoDAO();
	private VilEvalScoDAO vilEvalScoDAO = new VilEvalScoDAO();
	
	@SuppressWarnings("unchecked")
	public void saveScore(Integer expertDistID, Map<Integer, List<String>> scoreMap) {
		// TODO Auto-generated method stub
		EvalExpertDist evalExpertDist = new EvalExpertDist();
		evalExpertDist = evalExpertDistDAO.findById(expertDistID);
		try {
			expertGraDAO.updateByProtoSql("UPDATE ExpertGra set Sco = NULL WHERE EvalExpertDistID = " + expertDistID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Map.Entry<Integer, List<String>> ms : scoreMap.entrySet()){
			//判断该项得分是否曾经存入过数据库
			String sql = "EvalExpertDistID = " + expertDistID;
			sql += " and EvalContID = " + ms.getKey();
			List<ExpertGra> oldGra = expertGraDAO.findBySql(sql);
			ExpertGra expertGra = new ExpertGra();
			if(oldGra.size() == 0){//之前没有对该项进行评分，需要添加记录
				expertGra.setEvalExpertDist(evalExpertDist);
				expertGra.setEvalContId(ms.getKey());
				expertGra.setSco(ms.getValue().get(0).toString());
				expertGra.setGraRea(ms.getValue().get(1).toString());
				expertGra.setGraTim(new Date());
				expertGraDAO.save(expertGra);
			}else{//之前已经对该项打分，需要修改记录
				expertGra = oldGra.get(0);
				expertGra.setSco(ms.getValue().get(0).toString());
				expertGra.setGraRea(ms.getValue().get(1).toString());
				expertGra.setGraTim(new Date());
				expertGraDAO.merge(expertGra);
			}
			
		}

	}
	
	public void modifyIsSubmit(Integer expertDistID) {
		// TODO Auto-generated method stub
		EvalExpertDist evalExpertDist = evalExpertDistDAO.findById(expertDistID);
		evalExpertDist.setIsSub(true);
		evalExpertDistDAO.merge(evalExpertDist);
	}

	public int getExpertId(int userId) {
		// TODO Auto-generated method stub
		Expert expert = (Expert)(expertDAO.findByProperty("sysUser.sysUserId", userId).get(0));
		return (expert != null) ? expert.getExpertId() : -1;
	}
	/**
	 * 根据专家ID和是否提交（ExpertID & isSub）查询专家没有进行提交（评价）的村庄
	 */
	public List<EvalExpertDist> getDistsUnevaluated(int expertId, boolean isSub) {
		// TODO Auto-generated method stub
		String sql = "ExpertID = " + ExpertOLGraAction.getExpertId() + " and IsSub = " + isSub;
		List<EvalExpertDist> evalExpertDists = evalExpertDistDAO.findBySql(sql);
		return evalExpertDists;
	}
	
	@SuppressWarnings({ "unchecked"})
	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria, int from, int length) {
		// TODO Auto-generated method stub
		//根据专家获得其专业分类，用以寻找该专家可以评价的“评价方法”
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		Integer majorId = this.expertDAO.findById(ExpertOLGraAction.getExpertId()).getExpertMajorCatg().getExpertMajorCatgId();
		List<EvalSyst> evalSysts = evalSystDAO.findByProperty("evalSystState.evalSystStateId", 1);
		EvalSyst evalSyst = new EvalSyst();
		if(evalSysts.size() > 0){
			evalSyst = evalSysts.get(0);
			String sql_0 = "EvalSystID = "+ evalSyst.getEvalSystId() +" and ExpertMajorCatgID = " + majorId;
			List<EvalSystInd> evalSystInds = this.evalSystIndDAO.findBySql(sql_0);
			String sql = "EvalIndNum in (";
			for(EvalSystInd evalSystInd: evalSystInds){
				sql += ("'" + evalSystInd.getEvalIndNum() + "',");
			}
			sql += "'')";
			List<Object> values = null;
			if (criteria != null) {
				sql = Criterion.convertToSql(criteria);
				values = Criterion.getCriteriaValues(criteria);
			}
			List<EvalCont> evalConts = new ArrayList<EvalCont>();
			evalConts = this.evalContDAO.findByConditionAndPager(sql, values, from, length);
			
			for (EvalCont evalCont : evalConts) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("EvalContId", evalCont.getEvalContId());
				map.put("EvalContNum", evalCont.getEvalContNum());
				map.put("EvalContDes", evalCont.getEvalContDes());
				map.put("EvalContScore", evalCont.getEvalContScore());
				//map.put("BulReq", evalCont.getBulReq());
				if(evalCont.getExamMeth()!=null){
					map.put("ExamMeth", evalCont.getExamMeth().getExamMethName());
				}
				map.put("EvalContNote", evalCont.getEvalContNote());
				if (evalCont.getSubjObjecValu() == null) {
					map.put("SubjObjecValu", null);
				} else {
					map.put("SubjObjecValu", evalCont.getSubjObjecValu());
				}
				//判断该项得分是否曾经存入过数据库
				String sql_1 = "EvalExpertDistID = " + ExpertOLGraAction.getExpertDistID();
				sql_1 += " and EvalContID = " + evalCont.getEvalContId();
				List<ExpertGra> oldGra = expertGraDAO.findBySql(sql_1);
				if(oldGra.size()!=0){
					map.put("Score", oldGra.get(0).getSco());
					map.put("GraRea", oldGra.get(0).getGraRea());
				}
			
				result.add(map);
			}
		}
		
		return result;
	}
	@SuppressWarnings("unchecked")
	public int queryResultsCount(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		int rows = 0;
		Integer majorId = this.expertDAO.findById(ExpertOLGraAction.getExpertId()).getExpertMajorCatg().getExpertMajorCatgId();
		List<EvalSyst> evalSysts = evalSystDAO.findByProperty("evalSystState.evalSystStateId", 1);
		EvalSyst evalSyst = new EvalSyst();
		if(evalSysts.size() > 0){
			evalSyst = evalSysts.get(0);
			String sql = "EvalSystID = "+ evalSyst.getEvalSystId() +" and ExpertMajorCatgID = " + majorId;
			List<EvalSystInd> evalSystInds = this.evalSystIndDAO.findBySql(sql);
			for(EvalSystInd evalSystInd : evalSystInds){
				List<EvalCont> evalConts = this.evalContDAO.findByProperty("evalSystInd.evalIndNum", evalSystInd.getEvalIndNum());
				rows += evalConts.size();
			}
		}
		return rows;
	}
	
	
	public Integer getMajorId(Integer expertDistID) {
		// TODO Auto-generated method stub
		EvalExpertDist evalExpertDist = evalExpertDistDAO.findById(expertDistID);
		return evalExpertDist.getExpert().getExpertMajorCatg().getExpertMajorCatgId();
	}
	

	public Integer getVilEvalScoId(Integer expertDistID) {
		// TODO Auto-generated method stub
		EvalExpertDist evalExpertDist = evalExpertDistDAO.findById(expertDistID);
		return evalExpertDist.getVilEvalSco().getVilEvalScoId();
	}
	
	

	@SuppressWarnings("unchecked")
	public List<EvalExpertDist> getExpertsTotal(Integer majorId, Integer vilEvalScoId) {
		// TODO Auto-generated method stub
		List<EvalExpertDist> evalExpertDists = evalExpertDistDAO.findByProperty("expert.expertMajorCatg.expertMajorCatgId", majorId);
		List<EvalExpertDist> evalExpertDists2 = new ArrayList<EvalExpertDist>();
		for(EvalExpertDist evalExpertDist : evalExpertDists){
			if(evalExpertDist.getVilEvalSco().getVilEvalScoId().equals(vilEvalScoId))
				evalExpertDists2.add(evalExpertDist);
		}
		return evalExpertDists2;
	}
	
	//如果一个专业下所有专家完成提交，则进行“评价内容合计分”的计算
	@SuppressWarnings("unchecked")
	public void calcEvalContSubSco(List<Integer> contIds, List<Integer> distIds, Integer vilEvalScoId) {
		// TODO Auto-generated method stub
		String sql = "SELECT EvalContID, AVG(cast(SCO as float)) as AvgSco FROM ExpertGra ";
		sql += "WHERE EvalExpertDistID IN (";
		for(Integer contId : contIds){
			sql += contId + ",";
		}
		sql += "'')";
		sql += " and EvalContID IN (";
		for(Integer distId: distIds){
			sql += distId + ",";
		}
		sql += "'')";
		sql += " GROUP BY EvalContID";
		Map<Integer, String> subScos = new HashMap<Integer, String>();
		try {
			subScos = expertGraDAO.findByProtoSql(sql);
			for(Map.Entry<Integer, String> subSco : subScos.entrySet()){
				int cid = (Integer) subSco.getKey();
				String sco = (String) subSco.getValue();
				String sql_1 = "VilEvalScoID = " + vilEvalScoId + " and EvalContID = " + cid;
				EvalContSubSco evalContSubSco = new EvalContSubSco();
				List<EvalContSubSco> evalContSubScos = evalContSubScoDAO.findBySql(sql_1);
				//如果有该条记录（一般情况下都有，因为原则上只要采集数据一提交就会生成关于此次评价下此条评价内容的该记录）
				if(evalContSubScos.size() > 0){
					evalContSubSco = evalContSubScos.get(0);
					evalContSubSco.setExpertEvalContTotGra(sco);
					evalContSubScoDAO.merge(evalContSubSco);
				}
				//如果没有该条记录
				else{
					EvalCont evalCont = evalContDAO.findById(cid);
					VilEvalSco vilEvalSco = vilEvalScoDAO.findById(vilEvalScoId);
					evalContSubSco.setEvalCont(evalCont);
					evalContSubSco.setVilEvalSco(vilEvalSco);
					evalContSubSco.setExpertEvalContTotGra(sco);
					evalContSubScoDAO.save(evalContSubSco);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@SuppressWarnings("unchecked")
	public void calcVilEvalSco(Integer vilEvalScoId) {
		// TODO Auto-generated method stub
		String sql = "WHERE VilEvalScoID = " + vilEvalScoId + " and ExpertEvalContTotGra is NULL";
		List<EvalContSubSco> evalContSubScos = evalContSubScoDAO.findBySql(sql);
		//该村本次评价的所有“评价内容”还有未计算的“专家-评价-内容-总分”
		if(evalContSubScos.size() != 0)
			return;
		//该村本次评价的所有“评价内容”的“专家-评价-内容-总分”全部已经计算
		else{
			int totalSco = 0;
			for(EvalContSubSco evalContSubSco : evalContSubScos){
				String sco = evalContSubSco.getExpertEvalContTotGra();
				if(sco != null && sco != ""){
					totalSco += Integer.parseInt(sco);
					VilEvalSco vilEvalSco = vilEvalScoDAO.findById(vilEvalScoId);
					vilEvalSco.setExpertEvalTotGra(Integer.toString(totalSco));
					vilEvalScoDAO.merge(vilEvalSco);
				}
				else
					System.out.println("还有未填（未计算）的“专家-评价-内容-总分”，故总分无法计算");
					return;
			}
		}
	}

	public EvalSystIndDAO getEvalSystIndDAO() {
		return evalSystIndDAO;
	}
	public void setEvalSystIndDAO(EvalSystIndDAO evalSystIndDAO) {
		this.evalSystIndDAO = evalSystIndDAO;
	}
	public EvalContDAO getEvalContDAO() {
		return evalContDAO;
	}
	public void setEvalContDAO(EvalContDAO evalContDAO) {
		this.evalContDAO = evalContDAO;
	}
	public ExpertDAO getExpertDAO() {
		return expertDAO;
	}
	public void setExpertDAO(ExpertDAO expertDAO) {
		this.expertDAO = expertDAO;
	}
	public EvalExpertDistDAO getEvalExpertDistDAO() {
		return evalExpertDistDAO;
	}
	public void setEvalExpertDistDAO(EvalExpertDistDAO evalExpertDistDAO) {
		this.evalExpertDistDAO = evalExpertDistDAO;
	}
	public ExpertGraDAO getExpertGraDAO() {
		return expertGraDAO;
	}
	public void setExpertGraDAO(ExpertGraDAO expertGraDAO) {
		this.expertGraDAO = expertGraDAO;
	}

	public EvalSystDAO getEvalSystDAO() {
		return evalSystDAO;
	}

	public void setEvalSystDAO(EvalSystDAO evalSystDAO) {
		this.evalSystDAO = evalSystDAO;
	}

	public EvalContSubScoDAO getEvalContSubScoDAO() {
		return evalContSubScoDAO;
	}

	public void setEvalContSubScoDAO(EvalContSubScoDAO evalContSubScoDAO) {
		this.evalContSubScoDAO = evalContSubScoDAO;
	}

	public VilEvalScoDAO getVilEvalScoDAO() {
		return vilEvalScoDAO;
	}

	public void setVilEvalScoDAO(VilEvalScoDAO vilEvalScoDAO) {
		this.vilEvalScoDAO = vilEvalScoDAO;
	}

}
