package com.rural.expertolgra.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.rural.bean.EvalContInvesObj;
import com.rural.bean.VilFilData;
import com.rural.dao.EvalContInvesObjDAO;
import com.rural.dao.EvalExpertDistDAO;
import com.rural.dao.VilFilDataDAO;
import com.rural.officetopdf.OpenOfficePDFConverter;

public class EvalContFileDataService implements IEvalContFileDataService {
	private VilFilDataDAO vilFilDataDAO = new VilFilDataDAO();
	private EvalContInvesObjDAO evalContInvesObjDAO = new EvalContInvesObjDAO();
	private EvalExpertDistDAO evalExpertDistDAO = new EvalExpertDistDAO();
	/**
     * 根据“村庄数据采集记录ID”和“调查对象ID”查询数据库中对应的“文件标识”
     */
//    public void listfile(Map<String, ArrayList<String>> fileNameMap, Integer vilDataCollRecID, List<EvalContInvesObj> methObjs) {
//		
//		List<VilFilData> vilFilDatas = new ArrayList<VilFilData>();
//		String sql = "InvesObjID in (";
//		for(EvalContInvesObj methObj : methObjs){
//			sql += ("'" + methObj.getInvesObj().getInvesObjId() + "',"); 
//		}
//		sql += "'')";
//		sql += " and VilDataCollRecID = " + vilDataCollRecID;
//		vilFilDatas = vilFilDataDAO.findBySql(sql);
//		//存在相应的记录
//		if(vilFilDatas.size() > 0){
//			for(VilFilData vilFilData : vilFilDatas){
//				String vilFilIdef = vilFilData.getVilFilIdef();
//				if(vilFilIdef != null && vilFilIdef != ""){
//					String fileName = vilFilIdef.substring(vilFilIdef.lastIndexOf('\\') + 1);
//					//System.out.println(fileName);
//					/**
//					 * 将所有类型的文件转为PDF文件，提供在线查看功能
//					 */
//					//源文件的路径（不含文件名）
//					int startOfPath = 0;
//					if(vilFilIdef.indexOf("uploadFile") != -1)
//						startOfPath = vilFilIdef.indexOf("uploadFile");
//					else if(vilFilIdef.indexOf("uploadImg") != -1)
//						startOfPath = vilFilIdef.indexOf("uploadImg");
//					//源文件路径（文件标识）调整为"..\\..\\uploadFile\\......"或"..\\..\\uploadImg\\......"
//					vilFilIdef = "..\\..\\" + vilFilIdef.substring(startOfPath);
//					int startOfPath_1 = 0;
//					if(vilFilIdef.indexOf("uploadFile") != -1)
//						startOfPath_1 = vilFilIdef.indexOf("uploadFile");
//					else if(vilFilIdef.indexOf("uploadImg") != -1)
//						startOfPath_1 = vilFilIdef.indexOf("uploadImg");
//					//不含文件名的文件路径
//					String pathOnly = vilFilIdef.substring(0, vilFilIdef.lastIndexOf('\\') + 1);
//					
//					//源文件名（不含后缀）
//					String nameOnly = fileName.substring(0, fileName.lastIndexOf('.'));
//					//源文件后缀
//					String suffix = fileName.substring(fileName.lastIndexOf('.')+1);
//					//转换后的文件完成路径（含文件名）
//					//举例：（D:\Example\example.dox --> D:\Example\exampleFROMdox.pdf），这样可以保证文件名称的唯一性
//					String pdfPath = "..\\" + pathOnly + nameOnly + "FROM" + suffix + ".pdf";
//					int startOfPath_2 = 0;
//					if(pdfPath.indexOf("uploadFile") != -1)
//						startOfPath_2 = pdfPath.indexOf("uploadFile");
//					else if(pdfPath.indexOf("uploadImg") != -1)
//						startOfPath_2 = pdfPath.indexOf("uploadImg");
//					//项目绝对路径
//					String realPathOfApp = ServletActionContext.getServletContext().getRealPath("/");
////					System.out.println(realPathOfApp);
////					new OpenOfficePDFConverter().convert2PDF(vilFilIdef.substring(startOfPath_1), pdfPath.substring(startOfPath_2));
//					new OpenOfficePDFConverter().convert2PDF(realPathOfApp+vilFilIdef.substring(startOfPath_1), realPathOfApp+pdfPath.substring(startOfPath_2));
//					//文件的绝对路径是唯一的，可以作为key，文件名并不一定唯一，作为value
//					ArrayList<String> strs = new ArrayList<String>();
//					strs.add(fileName);
//					strs.add(pdfPath);
//					fileNameMap.put(vilFilIdef, strs);
//				}
//			}
//		}
//	}
	 public void listfile(Map<String, ArrayList<String>> fileNameMap, Integer vilDataCollRecID, List<EvalContInvesObj> methObjs) {
			
			List<VilFilData> vilFilDatas = new ArrayList<VilFilData>();
			String sql = "InvesObjID in (";
			for(EvalContInvesObj methObj : methObjs){
				sql += ("'" + methObj.getInvesObj().getInvesObjId() + "',"); 
			}
			sql += "'')";
			sql += " and VilDataCollRecID = " + vilDataCollRecID;
			vilFilDatas = vilFilDataDAO.findBySql(sql);
			//存在相应的记录
			if(vilFilDatas.size() > 0){
				for(VilFilData vilFilData : vilFilDatas){
					String vilFilIdef = vilFilData.getVilFilIdef();
					if(vilFilIdef != null && vilFilIdef != ""){
						String fileName = vilFilIdef.substring(vilFilIdef.lastIndexOf('\\') + 1);
						//System.out.println(fileName);
						/**
						 * 将所有类型的文件转为PDF文件，提供在线查看功能
						 */
						//源文件路径（文件标识）调整为"..\\..\\uploadFile\\......"或"..\\..\\uploadImg\\......"
						vilFilIdef = "uploadFile\\" + vilFilIdef;
//						int startOfPath_1 = 0;
//						if(vilFilIdef.indexOf("uploadFile") != -1)
//							startOfPath_1 = vilFilIdef.indexOf("uploadFile");
//						else if(vilFilIdef.indexOf("uploadImg") != -1)
//							startOfPath_1 = vilFilIdef.indexOf("uploadImg");
						//不含文件名的文件路径
						String pathOnly = vilFilIdef.substring(0, vilFilIdef.lastIndexOf('\\') + 1);
						
						//源文件名（不含后缀）
						String nameOnly = fileName.substring(0, fileName.lastIndexOf('.'));
						//源文件后缀
						String suffix = fileName.substring(fileName.lastIndexOf('.')+1);
						//转换后的文件完成路径（含文件名）
						//举例：（D:\Example\example.dox --> D:\Example\exampleFROMdox.pdf），这样可以保证文件名称的唯一性
						String pdfName = nameOnly + "FROM" + suffix + ".pdf";
//						int startOfPath_2 = 0;
//						if(pdfPath.indexOf("uploadFile") != -1)
//							startOfPath_2 = pdfPath.indexOf("uploadFile");
//						else if(pdfPath.indexOf("uploadImg") != -1)
//							startOfPath_2 = pdfPath.indexOf("uploadImg");
						//项目绝对路径
						String realPathOfApp = ServletActionContext.getServletContext().getRealPath("/");
//						System.out.println(realPathOfApp);
//						new OpenOfficePDFConverter().convert2PDF(vilFilIdef.substring(startOfPath_1), pdfPath.substring(startOfPath_2));
						new OpenOfficePDFConverter().convert2PDF(realPathOfApp+vilFilIdef, realPathOfApp+pathOnly+pdfName);
						//文件的绝对路径是唯一的，可以作为key，文件名并不一定唯一，作为value
						ArrayList<String> strs = new ArrayList<String>();
						strs.add(fileName);
						strs.add("..\\..\\..\\" + pathOnly + pdfName);
						fileNameMap.put(vilFilIdef, strs);
					}
				}
			}
		}
    
	@SuppressWarnings("unchecked")
	public List<EvalContInvesObj> getMethObjsByContId(Integer evalContId) {
		// TODO Auto-generated method stub
		return evalContInvesObjDAO.findByProperty("evalCont.evalContId", evalContId);
	}

	public Integer getRecIdByDistId(Integer expertDistId) {
		// TODO Auto-generated method stub
		return evalExpertDistDAO.findById(expertDistId).getVilEvalSco().getVilDataCollRec().getVilDataCollRecId();
	}

	public VilFilDataDAO getVilFilDataDAO() {
		return vilFilDataDAO;
	}
	public void setVilFilDataDAO(VilFilDataDAO vilFilDataDAO) {
		this.vilFilDataDAO = vilFilDataDAO;
	}

	public EvalContInvesObjDAO getEvalContInvesObjDAO() {
		return evalContInvesObjDAO;
	}

	public void setEvalContInvesObjDAO(EvalContInvesObjDAO evalContInvesObjDAO) {
		this.evalContInvesObjDAO = evalContInvesObjDAO;
	}

	public EvalExpertDistDAO getEvalExpertDistDAO() {
		return evalExpertDistDAO;
	}

	public void setEvalExpertDistDAO(EvalExpertDistDAO evalExpertDistDAO) {
		this.evalExpertDistDAO = evalExpertDistDAO;
	}
    
}
