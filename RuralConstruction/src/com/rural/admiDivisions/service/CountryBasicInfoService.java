package com.rural.admiDivisions.service;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;





import com.rural.admiDivisions.action.CountryBasicInfoAction;
import com.rural.admiDivisions.action.TownBasicInfoAction;
import com.rural.bean.CityBasicInfo;
import com.rural.bean.CountryBasicInfo;
import com.rural.bean.CountryCont;
import com.rural.bean.CountryFil;
import com.rural.bean.TownBasicInfo;

import com.rural.dao.CityBasicInfoDAO;
import com.rural.dao.CountryBasicInfoDAO;
import com.rural.dao.CountryContDAO;
import com.rural.dao.CountryFilDAO;
import com.rural.dao.TownBasicInfoDAO;
import com.rural.tool.Criterion;

public class CountryBasicInfoService implements ICountryBasicInfoService{
	
	private CountryBasicInfoDAO countryBasicInfoDAO = new CountryBasicInfoDAO();
	private CityBasicInfoDAO  cityBasicInfoDAO = new CityBasicInfoDAO();
	private TownBasicInfoDAO  townBasicInfoDAO  = new TownBasicInfoDAO();
	private CountryContDAO     countryContDAO  = new CountryContDAO();
	private CountryFilDAO  countryFilDAO  =  new  CountryFilDAO();
	

	

	public TownBasicInfoDAO getTownBasicInfoDAO() {
		return townBasicInfoDAO;
	}

	public void setTownBasicInfoDAO(TownBasicInfoDAO townBasicInfoDAO) {
		this.townBasicInfoDAO = townBasicInfoDAO;
	}

	public CountryContDAO getCountryContDAO() {
		return countryContDAO;
	}

	public void setCountryContDAO(CountryContDAO countryContDAO) {
		this.countryContDAO = countryContDAO;
	}

	public CountryFilDAO getCountryFilDAO() {
		return countryFilDAO;
	}

	public void setCountryFilDAO(CountryFilDAO countryFilDAO) {
		this.countryFilDAO = countryFilDAO;
	}

	public CityBasicInfoDAO getCityBasicInfoDAO() {
		return cityBasicInfoDAO;
	}

	public void setCityBasicInfoDAO(CityBasicInfoDAO cityBasicInfoDAO) {
		this.cityBasicInfoDAO = cityBasicInfoDAO;
	}

	public CountryBasicInfoDAO getCountryBasicInfoDAO() {
		return countryBasicInfoDAO;
	}

	public void setCountryBasicInfoDAO(CountryBasicInfoDAO countryBasicInfoDAO) {
		this.countryBasicInfoDAO = countryBasicInfoDAO;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public ArrayList<HashMap<String, Object>> findAll() {
		// TODO Auto-generated method stub
		List<CountryBasicInfo> list = new ArrayList<CountryBasicInfo>();
		list = this.countryBasicInfoDAO.findAll();
		ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for(CountryBasicInfo s : list){
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("countryBasicInfoID", s.getCountryBasicInfoId());
			if(s.getCountryNum()==null){
				map.put("countryNum", null);
				
			}else{
				map.put("countryNum", s.getCountryNum());
			}
		
			if(s.getCountryName()==null){
				map.put("countryName", null);
			}else{
				map.put("countryName", s.getCountryName());
			}
			map.put("cityBasicInfoID", s.getCityBasicInfo().getCityBasicInfoId());
			
			if(s.getCountryLongi()==null){
				map.put("countryLongi",null);
			}else{
				map.put("countryLongi", s.getCountryLongi());
			}
			if(s.getCountryLati()==null){
				map.put("countryLati",null);
			}else{
				map.put("countryLati",s.getCountryLati());
			}
			if(s.getCountryMeas()==null){
				map.put("countryMeas",null);
			}else{
				map.put("countryMeas",s.getCountryMeas());
			}
			if(s.getCountryPop()==null){
				map.put("countryPop",null);
			}else{
				map.put("countryPop",s.getCountryPop());
			}
			if(s.getCountryHholds()==null){
				map.put("countryHholds",null);
			}else{
				map.put("countryHholds",s.getCountryHholds());
			}
			
				if(s.getCountryIntro()==null){
					map.put("countryIntro",null);
				}else{
					map.put("countryIntro",s.getCountryIntro());
				}
			
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
		List<CountryBasicInfo> list2 = new ArrayList<CountryBasicInfo>();
		list2 = this.countryBasicInfoDAO.findByConditionAndPager(sql, values, from,length);
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for (CountryBasicInfo xt : list2) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("countryBasicInfoID", xt.getCountryBasicInfoId());
			
			if(xt.getCountryNum()==null){
				map.put("countryNum",null);
			}else{
				map.put("countryNum", xt.getCountryNum());
			}
			if(xt.getCountryName()==null){
				map.put("countryName", null);
			}else{
				map.put("countryName", xt.getCountryName());
			}
			map.put("cityBasicInfoID", xt.getCityBasicInfo().getCityBasicInfoId());
			
			if(xt.getCountryLongi()==null){
				map.put("countryLongi", null);
			}else{
				map.put("countryLongi", xt.getCountryLongi());
			}
			if(xt.getCountryLati()==null){
				map.put("countryLati",null);
			}else{
				map.put("countryLati",xt.getCountryLati());
			}
			if(xt.getCountryMeas()==null){
				map.put("countryMeas",null);
			}else{
				map.put("countryMeas",xt.getCountryMeas());
			}
		if(xt.getCountryPop()==null){
			map.put("countryPop",null);
		}else{
			map.put("countryPop",xt.getCountryPop());
		}
			if(xt.getCountryHholds()==null){
				map.put("countryHholds",null);
			}else{
				map.put("countryHholds",xt.getCountryHholds());
			}
			if(xt.getCountryIntro()==null){
				map.put("countryIntro",null);
				
			}else{
				//map.put("countryIntro",xt.getCountryIntro());
				byte[]intro = xt.getCountryIntro();
				String s;
				try{
					s= new String(intro,"UTF-8");
					map.put("countryIntro",s);
				}catch(UnsupportedEncodingException e){
					e.printStackTrace();
				}
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
		int rows = this.countryBasicInfoDAO.getCounts(sql, values);
		// int rows = this.departmentadmindao.getCounts(sql, values);
		return rows;
	}

	public String addCountryBasicInfo(String countryNum,String countryName,int cityBasicInfoID, String countryLongi,String countryLati,String countryMeas,String countryPop,String countryHholds,byte[] countryIntro) {
		// TODO Auto-generated method stub
		String message = "";
		List<CountryBasicInfo> countryBasicInfos = countryBasicInfoDAO.findByProperty1("countryNum", countryNum);
		if (countryBasicInfos.size()>0) {
			message = "县(区)编号已存在！";
		} else {
		CountryBasicInfo countryBasicInfo= new CountryBasicInfo();
		countryBasicInfo.setCountryNum(countryNum);
		countryBasicInfo.setCountryName(countryName);
		CityBasicInfo cityBasicInfo = new CityBasicInfo();
		cityBasicInfo = cityBasicInfoDAO.findById(cityBasicInfoID);
		countryBasicInfo.setCityBasicInfo(cityBasicInfo);
		countryBasicInfo.setCountryLongi(countryLongi);
		countryBasicInfo.setCountryLati(countryLati);
		countryBasicInfo.setCountryMeas(countryMeas);
		countryBasicInfo.setCountryPop(countryPop);
		countryBasicInfo.setCountryHholds(countryHholds);
		countryBasicInfo.setCountryIntro(countryIntro);
		countryBasicInfoDAO.save(countryBasicInfo);
		message = "添加成功";
		}
		return message;
	}

	@SuppressWarnings("unchecked")
	public String updateCountryBasicInfo(int countryBasicInfoID,String countryNum,String countryName, String countryLongi,String countryLati,String countryMeas,String countryPop,String countryHholds,byte[] countryIntro) {
		// TODO Auto-generated method stub
		String message="";
		
		CountryBasicInfo countryBasicInfo= new CountryBasicInfo();
		countryBasicInfo = countryBasicInfoDAO.findById(countryBasicInfoID);
		String cinfonum = countryBasicInfo.getCountryNum().trim();
		if (cinfonum.equals(countryNum)) {
			countryBasicInfo.setCountryNum(countryNum);
			countryBasicInfo.setCountryName(countryName);
			countryBasicInfo.setCountryLongi(countryLongi);
			countryBasicInfo.setCountryLati(countryLati);
			countryBasicInfo.setCountryMeas(countryMeas);
			countryBasicInfo.setCountryPop(countryPop);
			countryBasicInfo.setCountryHholds(countryHholds);
			countryBasicInfo.setCountryIntro(countryIntro);
			countryBasicInfoDAO.attachDirty(countryBasicInfo);
			message = "添加成功";
		} else {
			List<CountryBasicInfo> countryBasicInfos = countryBasicInfoDAO.findByProperty1("countryNum", countryNum);
			if (countryBasicInfos.size()>0) {
			
			}else {
				countryBasicInfo.setCountryNum(countryNum);
				countryBasicInfo.setCountryName(countryName);
				countryBasicInfo.setCountryLongi(countryLongi);
				countryBasicInfo.setCountryLati(countryLati);
				countryBasicInfo.setCountryMeas(countryMeas);
				countryBasicInfo.setCountryPop(countryPop);
				countryBasicInfo.setCountryHholds(countryHholds);
				countryBasicInfo.setCountryIntro(countryIntro);
				countryBasicInfoDAO.attachDirty(countryBasicInfo);
				message = "添加成功";
			}
			}

		return message;
		}

	@SuppressWarnings("unchecked")
	public String delCountryBasicInfo(int countryBasicInfoID) {
		// TODO Auto-generated method stub
		String message = "";
		CountryBasicInfo countryBasicInfo= new CountryBasicInfo();
		countryBasicInfo = countryBasicInfoDAO.findById(countryBasicInfoID);
		List<TownBasicInfo> townBasicInfo = townBasicInfoDAO.findByProperty("countryBasicInfo.countryBasicInfoId", countryBasicInfoID);
		List<CountryCont>  countryCont = countryContDAO.findByProperty("countryBasicInfo.countryBasicInfoId", countryBasicInfoID);
		List<CountryFil>  countryFil = countryFilDAO.findByProperty("countryBasicInfo.countryBasicInfoId", countryBasicInfoID);
		if(townBasicInfo.size()>0){
			
			message = message + "该县(区)下存在镇,无法删除！\n";
			
		}
		if(countryCont.size()>0){
			
			message = message + "该县(区)下存在联系人,无法删除！\n";
			
		}
		if(countryFil.size()>0){
			
			message = message +  "该县(区)下存在市级文件,无法删除！\n";
			
		}
		if(townBasicInfo.size()==0&&countryCont.size()==0&&countryFil.size()==0){
			
			CountryBasicInfo countryBasicInfo1= new CountryBasicInfo();
			countryBasicInfo1 = countryBasicInfoDAO.findById(countryBasicInfoID);
			countryBasicInfoDAO.delete(countryBasicInfo1);
			message = message + "删除成功！\n" ;
			
		}
		
		
		return message;
	}
	

	//检查编码是否重复
	public boolean checkCountryNum(String countryNum,String countryBasicInfoID) {
		// TODO Auto-generated method stub
		
		//id=-1表示为增加一条记录,否则表示编辑
		//flag==true表示提示错误，flag==false表示没有重复，不提示错误
		if(countryBasicInfoID==null){
			
			if(countryBasicInfoDAO.findByProperty1("countryNum", countryNum).isEmpty()){
				return false;
			}else{
				return true;
			}
		}else{
			if(countryBasicInfoDAO.findById(Integer.parseInt(countryBasicInfoID)).getCountryNum().equals(countryNum)){
				return false;
			}else{
				if(countryBasicInfoDAO.findByProperty1("countryNum", countryNum).isEmpty()){
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
        
        List<?> countryList = countryBasicInfoDAO.findAll();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            workbook = Workbook.createWorkbook(os);
            WritableSheet sheet = workbook.createSheet("Sheet1", 0);
            label = new jxl.write.Label(0, 0, "所属市级编码(市.00.00.000)");
            sheet.addCell(label);
            label = new jxl.write.Label(1, 0, "编号(市.县.00.000)");
            sheet.addCell(label);
            label = new jxl.write.Label(2, 0, "名称");
            sheet.addCell(label);
            label = new jxl.write.Label(3, 0, "经度");
            sheet.addCell(label);
            label = new jxl.write.Label(4, 0, "纬度");
            sheet.addCell(label);
            label = new jxl.write.Label(5, 0, "面积(平方公里)");
            sheet.addCell(label);
            label = new jxl.write.Label(6, 0, "人口数(万人)");
            sheet.addCell(label);
            label = new jxl.write.Label(7, 0, "户数");
            sheet.addCell(label);
            label = new jxl.write.Label(8, 0, "简介");
            sheet.addCell(label);
           
            int i = 1;
            for (Object object : countryList) {
            	CountryBasicInfo countryBasicInfo = (CountryBasicInfo)object;
				label = new jxl.write.Label(0, i, countryBasicInfo.getCityBasicInfo().getCityNum());
	            sheet.addCell(label);
	            label = new jxl.write.Label(1, i,countryBasicInfo.getCountryNum());
	            sheet.addCell(label);
	            label = new jxl.write.Label(2, i, countryBasicInfo.getCountryName());
	            sheet.addCell(label);
	            label = new jxl.write.Label(3, i, countryBasicInfo.getCountryLongi());
	            sheet.addCell(label);
	            label = new jxl.write.Label(4, i, countryBasicInfo.getCountryLati());
	            sheet.addCell(label);
	            label = new jxl.write.Label(5, i, countryBasicInfo.getCountryMeas());
	            sheet.addCell(label);
	            label = new jxl.write.Label(6, i, countryBasicInfo.getCountryPop());
	            sheet.addCell(label);
	            label = new jxl.write.Label(7, i, countryBasicInfo.getCountryHholds());
	            sheet.addCell(label);
	            byte[]intro = countryBasicInfo.getCountryIntro();
				String s;
				try{
					if(intro!=null&&intro.length!=0){
					s= new String(intro,"UTF-8");
					   label = new jxl.write.Label(8, i, s);
			           sheet.addCell(label);
					}
					if(intro==null||intro.length==0){
				    label = new jxl.write.Label(8, i, "");
						
					}
					
				}catch(UnsupportedEncodingException e){
					e.printStackTrace();
				}
	         
	            
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
                 label = new jxl.write.Label(0, 0, "所属市级编码(市.00.00.000)");
                 sheet.addCell(label);
                 label = new jxl.write.Label(1, 0, "编号(市.县.00.000)");
                 sheet.addCell(label);
                 label = new jxl.write.Label(2, 0, "名称");
                 sheet.addCell(label);
                 label = new jxl.write.Label(3, 0, "经度");
                 sheet.addCell(label);
                 label = new jxl.write.Label(4, 0, "纬度");
                 sheet.addCell(label);
                 label = new jxl.write.Label(5, 0, "面积(平方公里)");
                 sheet.addCell(label);
                 label = new jxl.write.Label(6, 0, "人口数(万人)");
                 sheet.addCell(label);
                 label = new jxl.write.Label(7, 0, "户数");
                 sheet.addCell(label);
                 label = new jxl.write.Label(8, 0, "简介");
                 sheet.addCell(label);
                
                 int i = 1;
                 for(String a:CountryBasicInfoAction.getIds().trim().split(",")){
                 	
                	 CountryBasicInfo country = countryBasicInfoDAO.findById(Integer.parseInt(a));
              
                 	
                	 label = new jxl.write.Label(0, i, country.getCityBasicInfo().getCityNum());
     	            sheet.addCell(label);
     	            label = new jxl.write.Label(1, i,country.getCountryNum());
     	            sheet.addCell(label);
     	            label = new jxl.write.Label(2, i, country.getCountryName());
     	            sheet.addCell(label);
     	            label = new jxl.write.Label(3, i, country.getCountryLongi());
     	            sheet.addCell(label);
     	            label = new jxl.write.Label(4, i, country.getCountryLati());
     	            sheet.addCell(label);
     	            label = new jxl.write.Label(5, i, country.getCountryMeas());
     	            sheet.addCell(label);
     	            label = new jxl.write.Label(6, i, country.getCountryPop());
     	            sheet.addCell(label);
     	            label = new jxl.write.Label(7, i, country.getCountryHholds());
     	            sheet.addCell(label);
     	           byte[]intro = country.getCountryIntro();
   				   String s;
   				  try{
   					if(intro!=null&&intro.length!=0){
   					s= new String(intro,"UTF-8");
   					   label = new jxl.write.Label(8, i, s);
   			           sheet.addCell(label);
   					}
   					if(intro==null||intro.length==0){
   				    label = new jxl.write.Label(8, i, "");
   						
   					}
   					
   				}catch(UnsupportedEncodingException e){
   					e.printStackTrace();
   				}
     	            
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
