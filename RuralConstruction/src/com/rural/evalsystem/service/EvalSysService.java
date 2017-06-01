package com.rural.evalsystem.service;


import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import com.rural.bean.EvalCont;
import com.rural.bean.EvalContInvesObj;
import com.rural.bean.EvalSyst;
import com.rural.bean.EvalSystInd;
import com.rural.bean.EvalSystState;
import com.rural.bean.ExpertMajorCatg;
import com.rural.bean.InvesObj;
import com.rural.bean.InvesPro;
import com.rural.dao.EvalContDAO;
import com.rural.dao.EvalSystDAO;
import com.rural.dao.EvalSystIndDAO;
import com.rural.dao.EvalSystStateDAO;
import com.rural.dao.ExpertMajorCatgDAO;
import com.rural.evalcontsee.action.FullEvalContAction;
import com.rural.tool.Criterion;


public class EvalSysService implements IEvalSysService{

	private EvalSystDAO evalSystDAO = new EvalSystDAO();
	private EvalSystIndDAO evalSystIndDAO = new EvalSystIndDAO();
	private EvalContDAO evalContDAO = new EvalContDAO();
	private ExpertMajorCatgDAO expertMajorCatgDAO = new ExpertMajorCatgDAO();
	private EvalSystStateDAO evalSystStateDAO = new EvalSystStateDAO();
	
	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		String sql = null;
		List<Object> values = null;
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
		List<EvalSyst> list2 = new ArrayList<EvalSyst>();
		list2 = this.evalSystDAO.findByConditionAndPager(sql, values, from,length);
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for (EvalSyst xt : list2) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("EvalSystID", xt.getEvalSystId());
			if ( xt.getEvalSystState() == null) {
				map.put("EvalSystStateID", null);
			} else {
				map.put("EvalSystStateID", xt.getEvalSystState().getEvalSystStateDes());
			}
			if (xt.getEvalSystName() == null) {
				map.put("EvalSystName", null);
			} else {
				map.put("EvalSystName", xt.getEvalSystName());
			}
			if (xt.getStartime() == null) {
				map.put("Startime", null);
			} else {
				map.put("Startime", xt.getStartime().toString().substring(0, 4));
			}
			if (xt.getEndtime() == null) {
				map.put("Endtime",null);
			} else {
				map.put("Endtime",xt.getEndtime().toString().substring(0, 4));
			}
			
			if (xt.getEvalSystNote() == null) {
				map.put("EvalSystNote",null);
			} else {
				map.put("EvalSystNote",xt.getEvalSystNote());
			}
			result.add(map);
		}
		
		return  result;
	}

	public int queryResultsCount(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		String sql = null;
		List<Object> values = null;
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
		int rows = this.evalSystDAO.getCounts(sql, values);
		return rows;
	}

	public void setEvalSystDAO(EvalSystDAO evalSystDAO) {
		this.evalSystDAO = evalSystDAO;
	}

	public EvalSystDAO getEvalSystDAO() {
		return evalSystDAO;
	}

	public void setEvalSystIndDAO(EvalSystIndDAO evalSystIndDAO) {
		this.evalSystIndDAO = evalSystIndDAO;
	}

	public EvalSystIndDAO getEvalSystIndDAO() {
		return evalSystIndDAO;
	}
	
	
	
	public EvalSystStateDAO getEvalSystStateDAO() {
		return evalSystStateDAO;
	}

	public void setEvalSystStateDAO(EvalSystStateDAO evalSystStateDAO) {
		this.evalSystStateDAO = evalSystStateDAO;
	}

	public ExpertMajorCatgDAO getExpertMajorCatgDAO() {
		return expertMajorCatgDAO;
	}

	public void setExpertMajorCatgDAO(ExpertMajorCatgDAO expertMajorCatgDAO) {
		this.expertMajorCatgDAO = expertMajorCatgDAO;
	}

	public EvalContDAO getEvalContDAO() {
		return evalContDAO;
	}

	public void setEvalContDAO(EvalContDAO evalContDAO) {
		this.evalContDAO = evalContDAO;
	}

	public List<EvalSystInd> getChildPermissions(String parentId) {
		// TODO Auto-generated method stub
		List<EvalSystInd> list = new ArrayList<EvalSystInd>();
		if (parentId==null) {
			list = this.evalSystIndDAO.findFather();
		}else{
			list = this.evalSystIndDAO.findChild(parentId);
		}
		return list;
	}

	//评价体系下拉框
	public List<EvalSystInd> findAllEval() {
			List<EvalSystInd> list = new ArrayList<EvalSystInd>();
			list = this.evalSystIndDAO.findAll();
			return list;
		}
	
	
	//专业类别下拉框
	public List<ExpertMajorCatg> findAllEvmc() {
		List<ExpertMajorCatg> list = new ArrayList<ExpertMajorCatg>();
		list = this.expertMajorCatgDAO.findAll();
		return list;
	}

	
	public String addEval(String evalNum, String evalName,String evalSco, String sv, String sc,String evalSystid) {
	 String message = "";
		String esid = evalSystDAO.findById(Integer.parseInt(evalSystid)).getEvalSystNote();
		String EvalNum = "";
		EvalNum = esid+"."+evalNum;
		List<EvalSystInd> evalnums = evalSystIndDAO.findByProperty("evalIndNum", EvalNum);
		if (evalnums.size()>0) {
			message = "该编码已存在！";
		} else {
			
			List<EvalCont> inp= evalContDAO.findByProperty("evalSystInd.evalIndNum", sv);//查看该节点下是否存在调查对象
			if(inp.size()==0||sv.equals("0")){//若不存在调查对象或者要添加一级节点
				ExpertMajorCatg em = new ExpertMajorCatg();
				em = expertMajorCatgDAO.findById(Integer.parseInt(sc));
				EvalSystInd ip = new EvalSystInd();
				ip = evalSystIndDAO.findById(sv);
				EvalSyst est = new EvalSyst();
				est = evalSystDAO.findById(Integer.parseInt(evalSystid));
					EvalSystInd newip = new EvalSystInd();
					newip.setEvalSystInd(ip);
					newip.setEvalSyst(est);
					newip.setExpertMajorCatg(em);
					newip.setEvalIndName(evalName);
					newip.setEvalIndNum(esid +"."+ evalNum);
					newip.setEvalIndScore(evalSco);
					//newip.setExpertMajorCatg(expertMajorCatg)
					evalSystIndDAO.save(newip);
					message = "添加成功！";
			
			}else{
				message = "该评价指标下存在评价内容，无法添加评价指标";
			
			}
		}
		
		return message;
	}
	
	

	

	public String delEval(String evalIndNum) {
		// TODO Auto-generated method stub
		String message = "";
		EvalSystInd evalSystInd = new EvalSystInd();
		evalSystInd = evalSystIndDAO.findById(evalIndNum);
		
		
		List<EvalSystInd> ip= evalSystIndDAO.findByProperty("evalSystInd.evalIndNum", evalIndNum);
		List io= evalContDAO.findByProperty("evalSystInd.evalIndNum", evalIndNum);
		if(ip.size()>0){
			message = "评价指标已引用评价指标名称为"+evalSystInd.getEvalIndName()+"的对象，无法删除！\n";
		}else if(io.size()>0){
			message = "评价内容已引用评价指标名称为"+evalSystInd.getEvalIndName()+"的对象，无法删除！\n";
		}else if(evalIndNum.equals("")){
			
			message = "请先删除其子节点";
		}
		else{
			evalSystIndDAO.delete(evalSystInd);
			message = "评价指标名称为"+evalSystInd.getEvalIndName()+"的对象，删除成功！\n";
		}
		
	
		
		return message;
	}

	public String addEvalsys(String EvalSystName, String Startime, String Endtime,String EvalSystNote) {
		// TODO Auto-generated method stub
		String message="";
		List<EvalSystState> evalSystState = new ArrayList<EvalSystState>();
		EvalSyst evalSyst= new EvalSyst();
		List <EvalSyst> eva = evalSystDAO.findByProperty("evalSystNote", EvalSystNote);
		
		evalSystState = evalSystStateDAO.findByEvalSystStateNum("2");
		for (EvalSystState evalSystState2 : evalSystState) {
			evalSyst.setEvalSystState(evalSystState2);
		}
		 String reg="^[0-9]{1}[0-9]{1}$";
		 String reg1="^((19\\d{2})|(2\\d{3}))$";
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(EvalSystNote);
		
		Pattern pattern1 = Pattern.compile(reg1);
		Matcher matcher1 = pattern1.matcher(Startime);
		
		Pattern pattern2 = Pattern.compile(reg1);
		Matcher matcher2 = pattern2.matcher(Endtime);
		try{
			if(!matcher1.matches()||!matcher2.matches()){
				message += "请输入合理时间";
			}else if(Integer.parseInt(Startime)-Integer.parseInt(Endtime)>0){
				message += "结束时间不能早于开始时间";
		 
			}else if(!matcher.matches()){
				message += "评价体系版本格式必须为：00";
			}else if(eva.size()>0){
				message += "第"+EvalSystNote+"套评价体系已存在";
			}else{
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
				 java.sql.Date sdate = null; 
				 java.sql.Date sdate1 = null; 
				 java.util.Date startime = formatter.parse(Startime);  
				 java.util.Date endtime = formatter.parse(Endtime);  
				 sdate = new java.sql.Date(startime.getTime()); //2013-01-14//初始化  
				 sdate1 = new java.sql.Date(endtime.getTime()); //2013-01-14//初始化  
				 
				 evalSyst.setStartime(sdate);
				 evalSyst.setEndtime(sdate1);
				 evalSyst.setEvalSystName(EvalSystName);
				 evalSyst.setEvalSystNote(EvalSystNote);
				 evalSystDAO.save(evalSyst);
				 message="successful";
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return message;
	}

	public String delEvalsys(Integer EvalSystID) {
		// TODO Auto-generated method stub
		EvalSyst evalSyst= new EvalSyst();
		evalSyst = evalSystDAO.findById(EvalSystID);
		String message = "";
		//int num = invgatdao.findById(id);
		List<EvalSystInd> em= evalSystIndDAO.findByProperty("evalSyst.evalSystId", EvalSystID);
		if(em.size()>0){
			message = "评价指标已引用评价体系版本为"+evalSyst.getEvalSystNote()+"的对象，无法删除！\n";
		}else{
			evalSystDAO.delete(evalSyst);
			message = "评价体系版本为"+evalSyst.getEvalSystNote()+"的对象，删除成功！\n";
		}
		return message;
	}

	public String updateEvalsys(Integer EvalSystID,String EvalSystName, String Startime,
			String Endtime, String EvalSystNote) {
		// TODO Auto-generated method stub
		String message="";
		EvalSyst evalSyst = evalSystDAO.findById(EvalSystID);
		
		
		List <EvalSyst> eva = evalSystDAO.findByProperty("evalSystNote", EvalSystNote);
		 String reg="^[0-9]{1}[0-9]{1}$";
		 String reg1="^((19\\d{2})|(2\\d{3}))$";
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(EvalSystNote);
		
		Pattern pattern1 = Pattern.compile(reg1);
		Matcher matcher1 = pattern1.matcher(Startime);
		
		Pattern pattern2 = Pattern.compile(reg1);
		Matcher matcher2 = pattern2.matcher(Endtime);
		try{
			if(!matcher1.matches()||!matcher2.matches()){
				message += "请输入合理时间";
			}else if(Integer.parseInt(Startime)-Integer.parseInt(Endtime)>0){
				message += "结束时间不能早于开始时间";
		 
			}else if(!matcher.matches()){
				message += "评价体系版本格式必须为：00";
			}else if(eva.size()>0){
				if(EvalSystNote.equals(evalSyst.getEvalSystNote())){
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
					 java.sql.Date sdate = null; 
					 java.sql.Date sdate1 = null; 
					 java.util.Date startime = formatter.parse(Startime);  
					 java.util.Date endtime = formatter.parse(Endtime);  
					 sdate = new java.sql.Date(startime.getTime()); //2013-01-14//初始化  
					 sdate1 = new java.sql.Date(endtime.getTime()); //2013-01-14//初始化  
					 
					 evalSyst.setStartime(sdate);
					 evalSyst.setEndtime(sdate1);
					 evalSyst.setEvalSystName(EvalSystName);
					 evalSystDAO.merge(evalSyst);
					 message="successful";
				}else {
						message += "第"+EvalSystNote+"套评价体系已存在";
				}
				
			}else{
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
				 java.sql.Date sdate = null; 
				 java.sql.Date sdate1 = null; 
				 java.util.Date startime = formatter.parse(Startime);  
				 java.util.Date endtime = formatter.parse(Endtime);  
				 sdate = new java.sql.Date(startime.getTime()); //2013-01-14//初始化  
				 sdate1 = new java.sql.Date(endtime.getTime()); //2013-01-14//初始化  
				 
				 evalSyst.setStartime(sdate);
				 evalSyst.setEndtime(sdate1);
				 evalSyst.setEvalSystName(EvalSystName);
				 evalSyst.setEvalSystNote(EvalSystNote);
				 evalSystDAO.merge(evalSyst);
				 message="successful";
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return message;
	}

	//评价体系版本下拉框
	public List<EvalSyst> findAllEvalSys() {
		// TODO Auto-generated method stub
		List<EvalSyst> list = new ArrayList<EvalSyst>();
		list = this.evalSystDAO.findAll();
		return list;
	}

	public List<EvalCont> findEvalContByNum(String EvalIndNum) {
		// TODO Auto-generated method stub
		List<EvalCont> list = new ArrayList<EvalCont>();
		list = this.evalContDAO.findByProperty("evalSystInd.evalIndNum", EvalIndNum);
		return list;
	}

	public List<EvalSystInd> findSystIndByID(Integer EvalSystID2) {
		// TODO Auto-generated method stub
		List<EvalSystInd> list = new ArrayList<EvalSystInd>();
		list = this.evalSystIndDAO.findByProperty("evalSyst.evalSystId", EvalSystID2);
		return list;
	}
  
	//复制评价指标
	public String copeSystInd(EvalSystInd evalSystInd, String newevalSysNum,EvalSyst newevalSyst) {//参数：评价指标，新的评价体系ID
		// TODO Auto-generated method stub
		String message = "";
		//String newNote = "";
		try {
			//EvalSyst esi = this.evalSystDAO.findById(EvalSystID);
			//newNote = esi.getEvalSystNote();//新评价体系的版本号
			EvalSystInd newInd = new EvalSystInd();
			String a = evalSystInd.getEvalIndNum().substring(2,14);
			newInd.setEvalIndNum(newevalSysNum+a);
			newInd.setExpertMajorCatg(evalSystInd.getExpertMajorCatg());
			newInd.setEvalSyst(newevalSyst);
			if(evalSystInd.getEvalSystInd()== null){
				newInd.setEvalSystInd(null);
			}else{
				String esid = evalSystInd.getEvalSystInd().getEvalIndNum().substring(2,14);//父节点的后几位编码
				
				String newesid = newevalSysNum+esid;//新父节点的编码
				EvalSystInd newUpInd = evalSystIndDAO.findById(newesid);
				newInd.setEvalSystInd(newUpInd);
			}
			newInd.setEvalIndName(evalSystInd.getEvalIndName());
			newInd.setEvalIndSeqNum(evalSystInd.getEvalIndSeqNum());
			newInd.setEvalIndScore(evalSystInd.getEvalIndScore());
			newInd.setEvalIndIsLeaf(evalSystInd.getEvalIndIsLeaf());
			newInd.setEvalIndNote(evalSystInd.getEvalIndNote());	
			evalSystIndDAO.save(newInd);			
			message = "success";
		} catch (Exception e) {
			// TODO: handle exception
			message = "error";
		}
		
		
		return message;
	}

	public String copeEvalCont(EvalCont evalCont, String EvalIndNum,Integer EvalSystID) {//参数：评价内容，评价指标的编号,新的评价体系id
		// TODO Auto-generated method stub
		String message = "";
		String newNote = "";
		String newIndNum="";
		String newConNum="";
		try {
			EvalSyst esi = this.evalSystDAO.findById(EvalSystID);
			newNote = esi.getEvalSystNote();//新评价体系的版本号
			newIndNum = newNote+EvalIndNum.substring(2, 14);//新的评价指标编号
			newConNum = newIndNum.substring(0, 6);//新的评价内容编号的前半部分
			EvalCont newCont = new EvalCont();
			EvalSystInd evalSystInd = evalSystIndDAO.findById(newIndNum);		
			newCont.setEvalSystInd(evalSystInd);
			newCont.setExamMeth(evalCont.getExamMeth());
			String b = evalCont.getEvalContNum().substring(6, 14);
			newCont.setEvalContNum(newConNum+b);
			newCont.setEvalContDes(evalCont.getEvalContDes());
			newCont.setEvalContScore(evalCont.getEvalContScore());
			newCont.setBulReq(evalCont.getBulReq());
			newCont.setEvalContScorMeth(evalCont.getEvalContScorMeth());
			newCont.setSubjObjecValu(evalCont.getSubjObjecValu());
			newCont.setEvalContSeqNum(evalCont.getEvalContSeqNum());
			newCont.setEvalContNote(evalCont.getEvalContNote());
			evalContDAO.save(newCont);			
			message = "添加成功！";
		} catch (Exception e) {
			message = "请检查是否已复制改模板";
		}
		
		return message;
	}

	public String getUpNum(EvalSystInd evalSystInd) {
		// TODO Auto-generated method stub	
		return evalSystInd.getEvalSystInd().getEvalIndNum().substring(10, 14);
	}

	public String copyEvalSys(String newEvalSysID, String oldEvalSysNum) {
		// TODO Auto-generated method stub
		//(1)查询所有一级为空的评价指标
		//String sql = " evalSystInd.evalIndNum is null and EvalSystID"
		//List<EvalSystInd> evalSystIndsList = evalSystIndDAO.findByProperty("evalSystInd.evalIndNum", null);
		String message = "";
		String newIndNum="";
	
		EvalSyst newevalSyst = this.evalSystDAO.findById(Integer.parseInt(newEvalSysID));
		String newevalSysNum = newevalSyst.getEvalSystNote();//新的版本号
		
		
		
		String sql = " evalSyst.evalSystId = "+Integer.parseInt(oldEvalSysNum)+" and evalSystInd.evalIndNum is null ";
		List<EvalSystInd> evalSystIndslist = evalSystIndDAO.findBySql(sql);//（1）根据所选的评价体系版本id和评价指标的父节点为空查询所有数据
		if (evalSystIndslist.size()>0) {
			for (EvalSystInd evalSystInd : evalSystIndslist) {
				message = copeSystInd(evalSystInd,newevalSysNum,newevalSyst);
				if (message.equals("success")||message == "success") {
				//	（2）根据父节点找二级子节点
					message = copyEvalIndChild(oldEvalSysNum, newevalSyst,newevalSysNum, evalSystInd);
				} else {
					message = "模板已复制过！！";
					break;
				}
				
			}
		} else {
			message = "评价体系不存在！";
		}
		
		//findByProperty("evalSyst.evalSystId", Integer.parseInt(oldEvalSysNum));
		
		
		return message;
	}

	private String copyEvalIndChild(String oldEvalSysNum, EvalSyst newevalSyst, String newevalSysNum, EvalSystInd evalSystInd) {
		String message ="";
		String childsql =  " evalSyst.evalSystId = "+Integer.parseInt(oldEvalSysNum)+" and evalSystInd.evalIndNum ='"+evalSystInd.getEvalIndNum()+"'";
		List<EvalSystInd> evalIndschildlist = evalSystIndDAO.findBySql(childsql);
		if (evalIndschildlist.size() >0) {//说明评价指标中有二级子节点
			//再进行递归查询
			for (EvalSystInd evalSystInd2 : evalIndschildlist) {
				message = copeSystInd(evalSystInd2,newevalSysNum,newevalSyst);
				if (message.equals("success")||message == "success") {
					message = copyEvalIndChild(oldEvalSysNum, newevalSyst,newevalSysNum, evalSystInd2);
				} else {
					message = "模板已复制过！！";
					break;
				}
			}
		} else {
			//没有二级子节点，对评价内容的表查询并复制
			
			List<EvalCont> evalContslist = evalContDAO.findByProperty("evalSystInd.evalIndNum", evalSystInd.getEvalIndNum());
			if (evalContslist.size()>0) {
				for (EvalCont evalCont : evalContslist) {
					EvalCont newCont = new EvalCont();
					EvalSystInd evalSystIndss = evalSystIndDAO.findById(evalSystInd.getEvalIndNum());
					String evalSystIndsnum = newevalSysNum+evalSystIndss.getEvalIndNum().substring(2, 14);
					EvalSystInd evalSystInds =  evalSystIndDAO.findById(evalSystIndsnum);
					newCont.setEvalSystInd(evalSystInds);
					newCont.setExamMeth(evalCont.getExamMeth());
					String newConNum = evalSystInds.getEvalIndNum().substring(0, 6);
					String b = evalCont.getEvalContNum().substring(6, 14);
					newCont.setEvalContNum(newConNum+b);
					newCont.setEvalContDes(evalCont.getEvalContDes());
					newCont.setEvalContScore(evalCont.getEvalContScore());
					newCont.setBulReq(evalCont.getBulReq());
					newCont.setEvalContScorMeth(evalCont.getEvalContScorMeth());
					newCont.setSubjObjecValu(evalCont.getSubjObjecValu());
					newCont.setEvalContSeqNum(evalCont.getEvalContSeqNum());
					newCont.setEvalContNote(evalCont.getEvalContNote());
					evalContDAO.save(newCont);			
					message = "添加成功！";
				}
			} 
			
		}
		return message;
	}

	public List<EvalSystState> findAllState(Integer EvalSysID) {
		// TODO Auto-generated method stub
		List<EvalSystState> list = new ArrayList<EvalSystState>();
		List<EvalSystState> list1 = new ArrayList<EvalSystState>();
		EvalSyst evalSyst = evalSystDAO.findById(EvalSysID);
		 EvalSystState l = evalSyst.getEvalSystState();
	 String num =	l.getEvalSystStateNum();
		if(num.trim().equals("2")){//所要修改的评价体系状态为未使用
			list = this.evalSystStateDAO.findByEvalSystStateNum("1");
			for (EvalSystState evalSystState : list) {
				list1.add(evalSystState);
			}
			list = this.evalSystStateDAO.findByEvalSystStateNum("2");
			for (EvalSystState evalSystState : list) {
				list1.add(evalSystState);
			}
			list = this.evalSystStateDAO.findByEvalSystStateNum("3");
			for (EvalSystState evalSystState : list) {
				list1.add(evalSystState);
			}
			
		}else if(num.trim().equals("1")){
			list = this.evalSystStateDAO.findByEvalSystStateNum("1");
			for (EvalSystState evalSystState : list) {
				list1.add(evalSystState);
			}
			list = this.evalSystStateDAO.findByEvalSystStateNum("3");
			for (EvalSystState evalSystState : list) {
				list1.add(evalSystState);
			}
		}else{
			list = this.evalSystStateDAO.findByEvalSystStateNum("3");
			for (EvalSystState evalSystState : list) {
				list1.add(evalSystState);
			}
		}
	
	
		
		return list1;
	}

	public String editState(String evalSystStateID, String editEvalSystID) {
		// TODO Auto-generated method stub
		String message = "";
		EvalSyst evalSyst = new EvalSyst();
		evalSyst = evalSystDAO.findById(Integer.parseInt(editEvalSystID));
		
		EvalSystState evalSystState = new EvalSystState();
		evalSystState = evalSystStateDAO.findById(Integer.parseInt(evalSystStateID));
		
		if(evalSystStateID.equals("1")){
			List<EvalSyst> evalSyst1 = evalSystDAO.findAll();
			Integer count =  evalSyst1.size();
			for (EvalSyst evalSyst2 : evalSyst1) {
				count--;
				String stateNum = evalSyst2.getEvalSystState().getEvalSystStateNum();
				if(stateNum.equals("1")){
					message = "版本为"+evalSyst2.getEvalSystNote()+"的评价体系处于在使用状态，请先将其状态修改为已作废";
					break;
					
				}else if(count==0){
					evalSyst.setEvalSystState(evalSystState);
					evalSystDAO.merge(evalSyst);
					message = "状态修改成功";
				}
			}
		}else{
			evalSyst.setEvalSystState(evalSystState);
			evalSystDAO.merge(evalSyst);
			message = "状态修改成功";
		}
		
		return message;
	}

	
	

}
