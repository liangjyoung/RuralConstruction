package com.rural.expertolgra.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.rural.bean.EvalContInvesObj;
import com.rural.bean.VilFilData;
import com.rural.dao.EvalContInvesObjDAO;
import com.rural.dao.EvalExpertDistDAO;
import com.rural.dao.VilFilDataDAO;
import com.rural.expertolgra.service.IEvalContFileDataService;
import com.rural.tool.Criterion;
import com.rural.tool.JqGridBaseAction;

public class EvalContFileDataAction extends JqGridBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer distID;
	private Integer contID;
	private static Integer expertDistId;
	private static Integer evalContId;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private IEvalContFileDataService iEvalContFileDataService;

	public String getFiles() throws ServletException, IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		setEvalContId(contID);
		setExpertDistId(distID);
		List<EvalContInvesObj> methObjs = new ArrayList<EvalContInvesObj>();
		methObjs = iEvalContFileDataService.getMethObjsByContId(evalContId);
		//根据expertDistID得到所有的“村庄数据采集记录”
		Integer vilDataCollRecID = iEvalContFileDataService.getRecIdByDistId(expertDistId); 
        //获取上传文件的目录
//        String uploadFilePath = this.getServletContext().getRealPath("/uploadFile");
        //存储要下载的文件名
        Map<String,ArrayList<String>> fileNameMap = new HashMap<String,ArrayList<String>>();
        //从数据库中获取对应文件的文件标识（路径）存储到map集合中
        iEvalContFileDataService.listfile(fileNameMap, vilDataCollRecID, methObjs);
		dataMap.put("fileMap", fileNameMap);
		request.setAttribute("fileNameMap", fileNameMap);
        request.getRequestDispatcher("/rural/VillBuildEval/listfile.jsp").forward(request, response);
		return null;
	}
	
	@Override
	public int getResultSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getDistID() {
		return distID;
	}

	public void setDistID(Integer distID) {
		this.distID = distID;
	}

	public Integer getContID() {
		return contID;
	}

	public void setContID(Integer contID) {
		this.contID = contID;
	}

	public static Integer getExpertDistId() {
		return expertDistId;
	}

	public static void setExpertDistId(Integer expertDistId) {
		EvalContFileDataAction.expertDistId = expertDistId;
	}

	public static Integer getEvalContId() {
		return evalContId;
	}

	public static void setEvalContId(Integer evalContId) {
		EvalContFileDataAction.evalContId = evalContId;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
	public IEvalContFileDataService getiEvalContFileDataService() {
		return iEvalContFileDataService;
	}
	public void setiEvalContFileDataService(
			IEvalContFileDataService iEvalContFileDataService) {
		this.iEvalContFileDataService = iEvalContFileDataService;
	}

}
