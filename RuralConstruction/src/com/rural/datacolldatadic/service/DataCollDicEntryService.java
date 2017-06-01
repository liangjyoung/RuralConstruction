package com.rural.datacolldatadic.service;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import net.sf.json.JSONObject;

import com.rural.bean.DataCollDataDic;
import com.rural.bean.DataCollDicEntry;
import com.rural.bean.InvesObjData;
import com.rural.bean.Sex;
import com.rural.dao.DataCollDataDicDAO;
import com.rural.dao.DataCollDicEntryDAO;
import com.rural.dao.InvesObjDataDAO;
import com.rural.datacolldatadic.action.DataCollDataDicAction;
import com.rural.datacolldatadic.action.DataCollDicEntryAction;
import com.rural.tool.Criterion;

public class DataCollDicEntryService implements IDataCollDicEntryService{
	
	private DataCollDicEntryDAO dataCollDicEntryDAO =  new DataCollDicEntryDAO();
	private DataCollDataDicDAO dataCollDataDicDAO = new DataCollDataDicDAO();
	private InvesObjDataDAO invesObjDataDAO = new InvesObjDataDAO();
	
	

	public InvesObjDataDAO getInvesObjDataDAO() {
		return invesObjDataDAO;
	}

	public void setInvesObjDataDAO(InvesObjDataDAO invesObjDataDAO) {
		this.invesObjDataDAO = invesObjDataDAO;
	}

	public DataCollDicEntryDAO getDataCollDicEntryDAO() {
		return dataCollDicEntryDAO;
	}

	public void setDataCollDicEntryDAO(DataCollDicEntryDAO dataCollDicEntryDAO) {
		this.dataCollDicEntryDAO = dataCollDicEntryDAO;
	} 
	
	

	public DataCollDataDicDAO getDataCollDataDicDAO() {
		return dataCollDataDicDAO;
	}

	public void setDataCollDataDicDAO(DataCollDataDicDAO dataCollDataDicDAO) {
		this.dataCollDataDicDAO = dataCollDataDicDAO;
	}



	public int queryResultsCount(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		String sql = null;
		int rows = 0;
		String s = DataCollDicEntryAction.getJQS();
		if ("null".equals(s.trim())) {
			rows = 0;
		} else {
			sql= " dataCollDataDic.dataCollDataDicId ="+Integer.parseInt(s);
			List<Object> values = null;
			if (criteria != null) {
				sql = Criterion.convertToSql(criteria);
				values = Criterion.getCriteriaValues(criteria);
			}
			rows = this.dataCollDicEntryDAO.getCounts(sql, values);
		}
		
		// int rows = this.departmentadmindao.getCounts(sql, values);
		return rows;
	}

	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		String sql = null;
		List<Object> values = null;
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
		String s = DataCollDicEntryAction.getJQS();
		List<DataCollDicEntry> list2 = new ArrayList<DataCollDicEntry>();
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		if ("null".equals(s.trim())) {
			sql=" dataCollDataDic.dataCollDataDicId is null";
		} else {
			sql= " dataCollDataDic.dataCollDataDicId ="+Integer.parseInt(s);
			
		}
		list2 = this.dataCollDicEntryDAO.findByConditionAndPager(sql, values, from,length);
		
		
		for (DataCollDicEntry b : list2) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("dataCollDicEntryId", b.getDataCollDicEntryId());
			if(b.getDicEntryCode()==null){
				map.put("dicEntryCode",null);
			}else{
				map.put("dicEntryCode", b.getDicEntryCode());
			}
			
			map.put("dataCollDataDicId", b.getDataCollDataDic().getDataCollDataDicId());
			
			if(b.getDicEntryName()==null){
				map.put("dicEntryName", null);		
			}else{
				map.put("dicEntryName", b.getDicEntryName());	
			}
			result.add(map);
			 
		}
		return result;
	}
		
		public String addDataCollDicEntry(String dicEntryCode,String dataCollDataDicId,String dicEntryName) {
			//dataCollDataDic.setDataCollDataDicCode(dataCollDicEntryAction.getJQS());
			// TODO Auto-generated method stub
			 String message = "";
			 System.out.print(dataCollDataDicId);
			 if("null".equals(dataCollDataDicId) ){
				 
				 message = "在添加数据字典条目时，请确保其对应的数据字典被选中，或者存在！\n";
			
		   
			 }else{
				 DataCollDicEntry dataCollDicEntry = new DataCollDicEntry();
				    DataCollDataDic dataCollDataDic = new DataCollDataDic();
				    String[] code = dicEntryCode.split("\\.");
				    if(code[0]==dicEntryCode){
				    	 dataCollDataDic = dataCollDataDicDAO.findById(Integer.parseInt(dataCollDataDicId));
							dataCollDicEntry.setDicEntryCode(dicEntryCode);
							dataCollDicEntry.setDicEntryName(dicEntryName);
							dataCollDicEntry.setDataCollDataDic(dataCollDataDic);
							dataCollDicEntryDAO.save(dataCollDicEntry);
							//message = "数据字典条目编号为"+dataCollDicEntry.getDicEntryCode()+"的对象，添加成功！\n";
				    message ="successful";
				    }else{
				    	message = "数据字典条目的编码的前三位是其相对应数据字典的编码！\n";
				    	
				    }
				
				 
			 }
			return message;
		}

		@SuppressWarnings("unchecked")
		public void updateDataCollDicEntry(int dataCollDicEntryId,String dicEntryCode, String dicEntryName) {
			// TODO Auto-generated method stub
			DataCollDicEntry dataCollDicEntry = new DataCollDicEntry();
			dataCollDicEntry = dataCollDicEntryDAO.findById(dataCollDicEntryId);
		
			dataCollDicEntry.setDicEntryCode(dicEntryCode);
			dataCollDicEntry.setDicEntryName(dicEntryName);
			dataCollDicEntryDAO.attachDirty(dataCollDicEntry);

		}

		
		public String delDataCollDicEntry(int dataCollDicEntryId){
			 String message = "";
			 
			DataCollDicEntry dataCollDicEntry = new DataCollDicEntry();
			dataCollDicEntry = dataCollDicEntryDAO.findById(dataCollDicEntryId);
			 List<InvesObjData>  invesObjData = invesObjDataDAO.findByProperty("dataCollDicEntry.dataCollDicEntryId", dataCollDicEntryId);
			// TODO Auto-generated method stub
			 if (invesObjData.size()>0) {
					message = "调查对象数据已引用数据字典条目编号为"+dataCollDicEntry.getDicEntryCode()+"的对象，无法删除！\n";
				}else{
					DataCollDicEntry dataCollDicEntry1 = new DataCollDicEntry();
					dataCollDicEntry1 = dataCollDicEntryDAO.findById(dataCollDicEntryId);
					dataCollDicEntryDAO.delete(dataCollDicEntry1);
					message = "数据字典条目编号为"+dataCollDicEntry.getDicEntryCode()+"的对象，删除成功！\n";
				}

			return message;
		}
		
		//检查编码是否重复
		public boolean checkEntryCode(String dicEntryCode,String dataCollDicEntryId) {
			// TODO Auto-generated method stub
			
			//id=-1表示为增加一条记录,否则表示编辑
			//flag==true表示提示错误，flag==false表示没有重复，不提示错误
			if(dataCollDicEntryId==null){
				
				if(dataCollDicEntryDAO.findByDicEntryCode(dicEntryCode).isEmpty()){
					return false;
				}else{
					return true;
				}
			}else{
				if(dataCollDicEntryDAO.findById(Integer.parseInt(dataCollDicEntryId)).getDicEntryCode().equals(dicEntryCode)){
					return false;
				}else{
					if(dataCollDicEntryDAO.findByDicEntryCode(dicEntryCode).isEmpty()){
						return false;
					}else{
						return true;
					}
				}
			}
		}
		
		
		public InputStream exportToExcel(){
			Label label;
	        WritableWorkbook workbook;
	        
	        List<?> entryList = dataCollDicEntryDAO.findAll();
	        ByteArrayOutputStream os = new ByteArrayOutputStream();
	        try {
	            workbook = Workbook.createWorkbook(os);
	            WritableSheet sheet = workbook.createSheet("Sheet1", 0);
	            label = new jxl.write.Label(0, 0, "数据字典编码(A01)");
	            sheet.addCell(label);
	            label = new jxl.write.Label(1, 0, "数据字典条目编码(A01.01)");
	            sheet.addCell(label);
	            label = new jxl.write.Label(2, 0, "数据字典条目名称");
	            sheet.addCell(label);
	           
	            int i = 1;
	            for (Object object : entryList) {
	            	DataCollDicEntry dataCollDicEntry = (DataCollDicEntry)object;
					label = new jxl.write.Label(0, i, dataCollDicEntry.getDataCollDataDic().getDataDicCode());
		            sheet.addCell(label);
		            label = new jxl.write.Label(1, i,dataCollDicEntry.getDicEntryCode());
		            sheet.addCell(label);
		            label = new jxl.write.Label(2, i, dataCollDicEntry.getDicEntryName());
		            sheet.addCell(label);
		            
		            i++;
				}
	            workbook.write();
	            workbook.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return new ByteArrayInputStream(os.toByteArray());
		}
		
		public InputStream exportToExcelNow(){
			Label label;
	        WritableWorkbook workbook;
	        
	    
	        ByteArrayOutputStream os = new ByteArrayOutputStream();
	        try {
	            workbook = Workbook.createWorkbook(os);
	            WritableSheet sheet = workbook.createSheet("Sheet1", 0);
	            label = new jxl.write.Label(0, 0, "数据字典编码(A01)");
	            sheet.addCell(label);
	            label = new jxl.write.Label(1, 0, "数据字典条目编码(A01.01)");
	            sheet.addCell(label);
	            label = new jxl.write.Label(2, 0, "数据字典条目名称");
	            sheet.addCell(label);
	           
	            int i = 1;
                    for(String a:DataCollDicEntryAction.getIds().trim().split(",")){
                 	
                    DataCollDicEntry entry = dataCollDicEntryDAO.findById(Integer.parseInt(a));
	            	
					label = new jxl.write.Label(0, i, entry.getDataCollDataDic().getDataDicCode());
		            sheet.addCell(label);
		            label = new jxl.write.Label(1, i,entry.getDicEntryCode());
		            sheet.addCell(label);
		            label = new jxl.write.Label(2, i, entry.getDicEntryName());
		            sheet.addCell(label);
		            
		            i++;
				}
	            workbook.write();
	            workbook.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return new ByteArrayInputStream(os.toByteArray());
		}
		
		
		
	}

