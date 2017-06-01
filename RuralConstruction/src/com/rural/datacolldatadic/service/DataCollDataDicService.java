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

import com.rural.bean.DataCollDataDic;
import com.rural.bean.DataCollDicEntry;
import com.rural.bean.InvesObj;
import com.rural.bean.InvesObjData;
import com.rural.dao.DataCollDataDicDAO;
import com.rural.dao.DataCollDicEntryDAO;
import com.rural.dao.InvesObjDAO;
import com.rural.datacolldatadic.action.DataCollDataDicAction;

import com.rural.tool.Criterion;


public class DataCollDataDicService implements IDataCollDataDicService {

	//private DataCollDicCatgDAO dataCollDicCatgDAO = new DataCollDicCatgDAO ();
	private DataCollDataDicDAO dataCollDataDicdao = new DataCollDataDicDAO();
	private DataCollDicEntryDAO dataCollDicEntryDAO = new DataCollDicEntryDAO();
	private InvesObjDAO invesObjDAO = new InvesObjDAO();
 
	
	public DataCollDicEntryDAO getDataCollDicEntryDAO() {
		return dataCollDicEntryDAO;
	}

	public void setDataCollDicEntryDAO(DataCollDicEntryDAO dataCollDicEntryDAO) {
		this.dataCollDicEntryDAO = dataCollDicEntryDAO;
	}

	public InvesObjDAO getInvesObjDAO() {
		return invesObjDAO;
	}

	public void setInvesObjDAO(InvesObjDAO invesObjDAO) {
		this.invesObjDAO = invesObjDAO;
	}

	public DataCollDataDicDAO getDataCollDataDicdao() {
		return dataCollDataDicdao;
	}

	public void setDataCollDataDicdao(DataCollDataDicDAO dataCollDataDicdao) {
		this.dataCollDataDicdao = dataCollDataDicdao;
	}
    
	

	@SuppressWarnings("unchecked")
	public ArrayList<HashMap<String, Object>> findAll() {
		// TODO Auto-generated method stub
		List<DataCollDataDic> list = new ArrayList<DataCollDataDic>();
		list = this.dataCollDataDicdao.findAll();
		ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for(DataCollDataDic s : list){
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("dataCollDataDicId", s.getDataCollDataDicId());
			if(s.getDataDicCode()==null){
				map.put("dataDicCode", null);//第一个=必须是id
			}else{
				map.put("dataDicCode", s.getDataDicCode());//第一个=必须是id
			}
			
			if(s.getDataDicName()==null){
				map.put("dataDicName",null);
			}else{
				map.put("dataDicName", s.getDataDicName());
			}
			
		    map.put("isdChoDic", s.getIsdChoDic());
			
			result.add(map);
		}
		
		return result;
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
		List<DataCollDataDic> list2 = new ArrayList<DataCollDataDic>();
		list2 = this.dataCollDataDicdao.findByConditionAndPager(sql, values, from,length);
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for (DataCollDataDic xt : list2) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("dataCollDataDicId", xt.getDataCollDataDicId());
			map.put("dataDicCode", xt.getDataDicCode());//第一个=必须是id
			map.put("dataDicName", xt.getDataDicName());
			map.put("isdChoDic", xt.getIsdChoDic());
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
		int rows = this.dataCollDataDicdao.getCounts(sql, values);
		// int rows = this.departmentadmindao.getCounts(sql, values);
		return rows;
	}

	public void addDataCollDataDic(String dataDicCode, String dataDicName, boolean isdChoDic) {
		// TODO Auto-generated method stub
		DataCollDataDic dataCollDataDic = new DataCollDataDic();
		dataCollDataDic.setDataDicCode(dataDicCode);
		dataCollDataDic.setDataDicName(dataDicName);
		dataCollDataDic.setIsdChoDic(isdChoDic);
		dataCollDataDicdao.save(dataCollDataDic);
	}

	@SuppressWarnings("unchecked")
	public void updateDataCollDataDic(int dataCollDataDicId,String dataDicCode, String dataDicName, boolean isdChoDic) {
		// TODO Auto-generated method stub
		DataCollDataDic dataCollDataDic = new DataCollDataDic();
		dataCollDataDic = dataCollDataDicdao.findById(dataCollDataDicId);
		dataCollDataDic.setDataDicCode(dataDicCode);
		dataCollDataDic.setDataDicName(dataDicName);
		dataCollDataDic.setIsdChoDic(isdChoDic);
		dataCollDataDicdao.attachDirty(dataCollDataDic);
	}

	@SuppressWarnings("unchecked")
	public String delDataCollDataDic(int dataCollDataDicId) {
		String message  = "";
		// TODO Auto-generated method stub
		
		DataCollDataDic dataCollDataDic = new DataCollDataDic();
		dataCollDataDic= dataCollDataDicdao.findById(dataCollDataDicId);
		 List<DataCollDicEntry>  dataCollDicEntry = dataCollDicEntryDAO.findByProperty1("dataCollDataDic.dataCollDataDicId", dataCollDataDicId);
		 List<InvesObj>  invesObj = invesObjDAO.findByProperty("dataCollDataDic.dataCollDataDicId", dataCollDataDicId);	
		 // TODO Auto-generated method stub
			 if (dataCollDicEntry.size()>0) {
					message = "数据字典条目已引用数据字典编号为"+dataCollDataDic.getDataDicCode()+"的对象，无法删除！\n";
				}
			 if(invesObj.size()>0){
				 message =message+ "调查对象已引用数据字典编号为"+dataCollDataDic.getDataDicCode()+"的对象，无法删除！\n";
				 
				 
			 }
			if(dataCollDicEntry.size()==0&&invesObj.size()==0){
			 
					DataCollDataDic dataCollDataDic1 = new DataCollDataDic();
					dataCollDataDic1= dataCollDataDicdao.findById(dataCollDataDicId);
					dataCollDataDicdao.delete(dataCollDataDic1);
					message = "数据字典编号为"+dataCollDataDic.getDataDicCode()+"的对象，删除成功！\n";
				 }
		return message;
	}
	
	
	//检查编码是否重复
	
	public boolean checkDicCode(String dataDicCode,String dataCollDataDicId) {
		// TODO Auto-generated method stub
		
		//id=-1表示为增加一条记录,否则表示编辑
		//flag==true表示提示错误，flag==false表示没有重复，不提示错误
		if(dataCollDataDicId==null){
			
			if(dataCollDataDicdao.findByDataDicCode(dataDicCode).isEmpty()){
				return false;
			}else{
				return true;
			}
		}else{
			if(dataCollDataDicdao.findById(Integer.parseInt(dataCollDataDicId)).getDataDicCode().equals(dataDicCode)){
				return false;
			}else{
				if(dataCollDataDicdao.findByDataDicCode(dataDicCode).isEmpty()){
					return false;
				}else{
					return true;
				}
			}
		}
		
	}
	
	public boolean checkDicCode(String dataDicCode,String dataCollDataDicId, String oper) {
		// TODO Auto-generated method stub
		
		//id=-1表示为增加一条记录,否则表示编辑
		//flag==true表示提示错误，flag==false表示没有重复，不提示错误
		if(dataCollDataDicId==null){
			
			if(dataCollDataDicdao.findByDataDicCode(dataDicCode).isEmpty()){
				return false;
			}else{
				return true;
			}
		}else{
			if(oper!=null){
			if(dataCollDataDicdao.findById(Integer.parseInt(dataCollDataDicId)).getDataDicCode().equals(dataDicCode)){
				return false;
			}else{
				if(dataCollDataDicdao.findByDataDicCode(dataDicCode).isEmpty()){
					return false;
				}else{
					return true;
				}
			}
			}else{
				return true;
			}
		}
		
	}
	
	
	
	public InputStream exportToExcel(){
		Label label;
        WritableWorkbook workbook;
        
        List<?> dicList = dataCollDataDicdao.findAll();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            workbook = Workbook.createWorkbook(os);
            WritableSheet sheet = workbook.createSheet("Sheet1", 0);
            label = new jxl.write.Label(0, 0, "数据字典编码(A01)");
            sheet.addCell(label);
            label = new jxl.write.Label(1, 0, "数据字典名称");
            sheet.addCell(label);
            label = new jxl.write.Label(2, 0, "是否多选(true/false)");
            sheet.addCell(label);
           
            int i = 1;
            for (Object object : dicList) {
            	DataCollDataDic dataCollDataDic = (DataCollDataDic)object;
				label = new jxl.write.Label(0, i, dataCollDataDic.getDataDicCode());
	            sheet.addCell(label);
	            label = new jxl.write.Label(1, i,dataCollDataDic.getDataDicName());
	            sheet.addCell(label);
	            label = new jxl.write.Label(2, i, String.valueOf(dataCollDataDic.getIsdChoDic()));
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
                 label = new jxl.write.Label(1, 0, "数据字典名称");
                 sheet.addCell(label);
                 label = new jxl.write.Label(2, 0, "是否多选(true/false)");
                 sheet.addCell(label);
                
                 int i = 1;
                 for(String a:DataCollDataDicAction.getIds().trim().split(",")){
                 	
                 	DataCollDataDic dic = dataCollDataDicdao.findById(Integer.parseInt(a));
              
                 	
     				label = new jxl.write.Label(0, i, dic.getDataDicCode());
     	            sheet.addCell(label);
     	            label = new jxl.write.Label(1, i,dic.getDataDicName());
     	            sheet.addCell(label);
     	            label = new jxl.write.Label(2, i, String.valueOf(dic.getIsdChoDic()));
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
