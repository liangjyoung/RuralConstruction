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

import com.rural.admiDivisions.action.CityBasicInfoAction;
import com.rural.admiDivisions.action.CountryBasicInfoAction;
import com.rural.bean.CityBasicInfo;
import com.rural.bean.CitysCont;
import com.rural.bean.CitysFil;
import com.rural.bean.CountryBasicInfo;
import com.rural.bean.CountryCont;
import com.rural.bean.CountryFil;
import com.rural.bean.Expert;
import com.rural.bean.ExpertGra;
import com.rural.bean.ProBasicInfo;
import com.rural.bean.TownBasicInfo;
import com.rural.dao.CityBasicInfoDAO;
import com.rural.dao.CitysContDAO;
import com.rural.dao.CitysFilDAO;
import com.rural.dao.CountryBasicInfoDAO;
import com.rural.dao.ExpertDAO;
import com.rural.dao.ExpertGraDAO;
import com.rural.dao.ProBasicInfoDAO;

import com.rural.tool.Criterion;

public class CityBasicInfoService implements ICityBasicInfoService{
	private CityBasicInfoDAO cityBasicInfoDAO = new CityBasicInfoDAO();
	private ProBasicInfoDAO proBasicInfoDAO = new ProBasicInfoDAO();
	private CountryBasicInfoDAO countryBasicInfoDAO = new CountryBasicInfoDAO();
	private CitysContDAO citysContDAO = new CitysContDAO();
	private CitysFilDAO  citysFilDAO = new CitysFilDAO();
	//private ExpertDAO expertDAO = new ExpertDAO();
	
	

	

	public CountryBasicInfoDAO getCountryBasicInfoDAO() {
		return countryBasicInfoDAO;
	}

	public void setCountryBasicInfoDAO(CountryBasicInfoDAO countryBasicInfoDAO) {
		this.countryBasicInfoDAO = countryBasicInfoDAO;
	}

	public CitysContDAO getCitysContDAO() {
		return citysContDAO;
	}

	public void setCitysContDAO(CitysContDAO citysContDAO) {
		this.citysContDAO = citysContDAO;
	}

	public CitysFilDAO getCitysFilDAO() {
		return citysFilDAO;
	}

	public void setCitysFilDAO(CitysFilDAO citysFilDAO) {
		this.citysFilDAO = citysFilDAO;
	}

	

	

	public ProBasicInfoDAO getProBasicInfoDAO() {
		return proBasicInfoDAO;
	}

	public void setProBasicInfoDAO(ProBasicInfoDAO proBasicInfoDAO) {
		this.proBasicInfoDAO = proBasicInfoDAO;
	}

	public CityBasicInfoDAO getCityBasicInfoDAO() {
		return cityBasicInfoDAO;
	}

	public void setCityBasicInfoDAO(CityBasicInfoDAO cityBasicInfoDAO) {
		this.cityBasicInfoDAO = cityBasicInfoDAO;
	}
	
	public int getProID(String proNum){
		int a =0 ;
		List<ProBasicInfo> li = new ArrayList<ProBasicInfo>();
		li = this.proBasicInfoDAO.findByProNum(proNum);
		for (ProBasicInfo proBasicInfo : li) {
			a = proBasicInfo.getProBasicInfoId();
		}
		System.out.println("--------->"+a);
		return a;
		
	}
    
	@SuppressWarnings("unchecked")
	public ArrayList<HashMap<String, Object>> findAll() {
		// TODO Auto-generated method stub
		List<CityBasicInfo> list = new ArrayList<CityBasicInfo>();
		list = this.cityBasicInfoDAO.findAll();
		ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for(CityBasicInfo s : list){
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("cityBasicInfoID", s.getCityBasicInfoId());
			
			if(s.getCityNum()==null){
				map.put("cityNum",null);
			}else{
				map.put("cityNum", s.getCityNum());
			}
			if(s.getCityName()==null){
				map.put("cityName", null);
			}else{
				map.put("cityName", s.getCityName());
			}
			map.put("proBasicInfoID", s.getProBasicInfo().getProBasicInfoId());
			
			if(s.getCityLongi()==null){
				map.put("cityLongi",null);
			}else{
				map.put("cityLongi", s.getCityLongi());
			}
			if(s.getCityLati()==null){
				map.put("cityLati",null);
			}else{
				map.put("cityLati",s.getCityLati());
			}
			if(s.getCityMeas()==null){
				map.put("cityMeas",null);
			}else{
				map.put("cityMeas",s.getCityMeas());
			}
			if(s.getCityPop()==null){
				map.put("cityPop",null);
			}else{
				map.put("cityPop",s.getCityPop());
			}
			if(s.getCityHholds()==null){
				map.put("cityHholds",null);
			}else{
				map.put("cityHholds",s.getCityHholds());
			}
		   
		    	if(s.getCityIntro()==null){
		    		map.put("cityIntro",null);
		    	}else{
		    		map.put("cityIntro",s.getCityIntro());
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
		List<CityBasicInfo> list2 = new ArrayList<CityBasicInfo>();
		list2 = this.cityBasicInfoDAO.findByConditionAndPager(sql, values, from,length);
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for (CityBasicInfo xt : list2) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("cityBasicInfoID", xt.getCityBasicInfoId());
			if(xt.getCityNum()==null){
				map.put("cityNum",null);
				
			}else{
				map.put("cityNum",xt.getCityNum());
			}
			
			if( xt.getCityName()==null){
				map.put("cityName", null);
			}else{
				map.put("cityName", xt.getCityName());
			}
			map.put("proBasicInfoID", xt.getProBasicInfo().getProBasicInfoId());
			
			if(xt.getCityLongi()==null){
				map.put("cityLongi", null);
			}else{
				map.put("cityLongi", xt.getCityLongi());
			}
			if(xt.getCityLati()==null){
				map.put("cityLati",null);
			}else{
				map.put("cityLati",xt.getCityLati());
			}
			if(xt.getCityMeas()==null){
				map.put("cityMeas",null);
			}else{
				map.put("cityMeas",xt.getCityMeas());
			}
			if(xt.getCityPop()==null){
				map.put("cityPop",null);
			}else{
				map.put("cityPop",xt.getCityPop());
			}
		    if(xt.getCityHholds()==null){
		    	map.put("cityHholds",null);
		    }else{
		    	map.put("cityHholds",xt.getCityHholds());
		    }
			
				if(xt.getCityIntro()==null){
					map.put("cityIntro",null);
				}else{
					byte[]intro = xt.getCityIntro();
					String s;
					try{
						s= new String(intro,"UTF-8");
						map.put("cityIntro",s);
					}catch(UnsupportedEncodingException e){
						e.printStackTrace();
					}
					//map.put("cityIntro",xt.getCityIntro());
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
		int rows = this.cityBasicInfoDAO.getCounts(sql, values);
		// int rows = this.departmentadmindao.getCounts(sql, values);
		return rows;
	}

	public String addCityBasicInfo(String cityNum,String cityName,int proBasicInfoID, String cityLongi,String cityLati,String cityMeas,String cityPop,String cityHholds,byte[] cityIntro) {
		// TODO Auto-generated method stub
		String message = "";
		//cityNum
		List<CityBasicInfo> basicInfos = cityBasicInfoDAO.findByProperty1("cityNum", cityNum);
		if (basicInfos.size()>0) {
			message = "市编号已存在！";
		} else {
			CityBasicInfo cityBasicInfo= new CityBasicInfo();
			cityBasicInfo.setCityNum(cityNum);
			cityBasicInfo.setCityName(cityName);
			ProBasicInfo  proBasicInfo = new ProBasicInfo();
			proBasicInfo= proBasicInfoDAO.findById(proBasicInfoID);
			cityBasicInfo.setProBasicInfo(proBasicInfo);
			cityBasicInfo.setCityLongi(cityLongi);
			cityBasicInfo.setCityLati(cityLati);
			cityBasicInfo.setCityMeas(cityMeas);
			cityBasicInfo.setCityPop(cityPop);
			cityBasicInfo.setCityHholds(cityHholds);
			cityBasicInfo.setCityIntro(cityIntro);
			cityBasicInfoDAO.save(cityBasicInfo);
			message = "添加成功";
		}
		
		
		return message;
	}

	@SuppressWarnings("unchecked")
	public String updateCityBasicInfo(int cityBasicInfoID,String cityNum,String cityName, String cityLongi,String cityLati,String cityMeas,String cityPop,String cityHholds,byte[] cityIntro) {
		// TODO Auto-generated method stub
		String message="";
		CityBasicInfo cityBasicInfo= new CityBasicInfo();
		cityBasicInfo = cityBasicInfoDAO.findById(cityBasicInfoID);
		String citynn = cityBasicInfo.getCityNum().trim();
		if(citynn.equals(cityNum)){
			byte[] intro ;
			
			cityBasicInfo.setCityNum(cityNum);
			cityBasicInfo.setCityName(cityName);
			cityBasicInfo.setCityLongi(cityLongi);
			cityBasicInfo.setCityLati(cityLati);
			cityBasicInfo.setCityMeas(cityMeas);
			cityBasicInfo.setCityPop(cityPop);
			cityBasicInfo.setCityHholds(cityHholds);
			cityBasicInfo.setCityIntro(cityIntro);
			
			cityBasicInfoDAO.attachDirty(cityBasicInfo);
			message = "添加成功";
			
			
		}else{
			List<CityBasicInfo> basicInfos = cityBasicInfoDAO.findByProperty1("cityNum", cityNum);
			if (basicInfos.size()>0) {
				message = "市编号已存在！";
			}else{
				byte[] intro ;
				
				cityBasicInfo.setCityNum(cityNum);
				cityBasicInfo.setCityName(cityName);
				cityBasicInfo.setCityLongi(cityLongi);
				cityBasicInfo.setCityLati(cityLati);
				cityBasicInfo.setCityMeas(cityMeas);
				cityBasicInfo.setCityPop(cityPop);
				cityBasicInfo.setCityHholds(cityHholds);
				cityBasicInfo.setCityIntro(cityIntro);
				
				cityBasicInfoDAO.attachDirty(cityBasicInfo);
				message = "添加成功";
				
			}
			
			
		}
		
		
		
		return message;
	}

	@SuppressWarnings("unchecked")
	public String delCityBasicInfo(int cityBasicInfoID) {
		String message = "";
		// TODO Auto-generated method stub
		CityBasicInfo cityBasicInfo= new CityBasicInfo();
		cityBasicInfo = cityBasicInfoDAO.findById(cityBasicInfoID);
		List<CountryBasicInfo> countryBasicInfo= countryBasicInfoDAO.findByProperty("cityBasicInfo.cityBasicInfoId", cityBasicInfoID);
		List<CitysCont> citysCont = citysContDAO.findByProperty("cityBasicInfo.cityBasicInfoId", cityBasicInfoID);
		List<CitysFil> citysFil = citysFilDAO.findByProperty("cityBasicInfo.cityBasicInfoId", cityBasicInfoID);
		//List<Expert> expert = expertDAO.findByProperty("cityBasicInfo.cityBasicInfoId", cityBasicInfoID);
		if(countryBasicInfo.size()>0){
			
			message = message + "该市下存在县(区),无法删除！\n";
			
		}
		if(citysCont.size()>0){
			
			message = message + "该市下存在联系人,无法删除！\n";
		}
		if(citysFil.size()>0){
			
			message = message +  "该市下存在市级文件,无法删除！\n";
			
		}
		
		if(countryBasicInfo.size()==0&&citysCont.size()==0&&citysFil.size()==0){
			CityBasicInfo cityBasicInfo1= new CityBasicInfo();
			cityBasicInfo1 = cityBasicInfoDAO.findById(cityBasicInfoID);
			cityBasicInfoDAO.delete(cityBasicInfo1);
			message = message + "删除成功！\n" ;
		
		}
		
		return message;
	}
	
	
	//检查编码是否重复
	public boolean checkCityNum(String cityNum,String cityBasicInfoID) {
		// TODO Auto-generated method stub
		
		//id=-1表示为增加一条记录,否则表示编辑
		//flag==true表示提示错误，flag==false表示没有重复，不提示错误
		if(cityBasicInfoID==null){
			
			if(cityBasicInfoDAO.findByProperty1("cityNum", cityNum).isEmpty()){
				return false;
			}else{
				return true;
			}
		}else{
			if(cityBasicInfoDAO.findById(Integer.parseInt(cityBasicInfoID)).getCityNum().equals(cityNum)){
				return false;
			}else{
				if(cityBasicInfoDAO.findByProperty1("cityNum", cityNum).isEmpty()){
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
        
        List<?> cityList = cityBasicInfoDAO.findAll();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            workbook = Workbook.createWorkbook(os);
            WritableSheet sheet = workbook.createSheet("Sheet1", 0);
            label = new jxl.write.Label(0, 0, "编号(市.00.00.000)");
            sheet.addCell(label);
            label = new jxl.write.Label(1, 0, "名称");
            sheet.addCell(label);
            label = new jxl.write.Label(2, 0, "经度");
            sheet.addCell(label);
            label = new jxl.write.Label(3, 0, "纬度");
            sheet.addCell(label);
            label = new jxl.write.Label(4, 0, "面积(平方公里)");
            sheet.addCell(label);
            label = new jxl.write.Label(5, 0, "人口数(万人)");
            sheet.addCell(label);
            label = new jxl.write.Label(6, 0, "户数");
            sheet.addCell(label);
            label = new jxl.write.Label(7, 0, "简介");
            sheet.addCell(label);
           
            int i = 1;
            for (Object object : cityList) {
            	CityBasicInfo cityBasicInfo = (CityBasicInfo)object;
	            label = new jxl.write.Label(0, i,cityBasicInfo.getCityNum());
	            sheet.addCell(label);
	            label = new jxl.write.Label(1, i, cityBasicInfo.getCityName());
	            sheet.addCell(label);
	            label = new jxl.write.Label(2, i, cityBasicInfo.getCityLongi());
	            sheet.addCell(label);
	            label = new jxl.write.Label(3, i, cityBasicInfo.getCityLati());
	            sheet.addCell(label);
	            label = new jxl.write.Label(4, i, cityBasicInfo.getCityMeas());
	            sheet.addCell(label);
	            label = new jxl.write.Label(5, i, cityBasicInfo.getCityPop());
	            sheet.addCell(label);
	            label = new jxl.write.Label(6, i, cityBasicInfo.getCityHholds());
	            sheet.addCell(label);
	            byte[]intro = cityBasicInfo.getCityIntro();
				String s;
				try{
					if(intro!=null&&intro.length!=0){
					s= new String(intro,"UTF-8");
					   label = new jxl.write.Label(7, i, s);
			           sheet.addCell(label);
					}
					if(intro==null||intro.length==0){
				    label = new jxl.write.Label(7, i, "");
						
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
                
                 label = new jxl.write.Label(0, 0, "编号(市.00.00.000)");
                 sheet.addCell(label);
                 label = new jxl.write.Label(1, 0, "名称");
                 sheet.addCell(label);
                 label = new jxl.write.Label(2, 0, "经度");
                 sheet.addCell(label);
                 label = new jxl.write.Label(3, 0, "纬度");
                 sheet.addCell(label);
                 label = new jxl.write.Label(4, 0, "面积(平方公里)");
                 sheet.addCell(label);
                 label = new jxl.write.Label(5, 0, "人口数(万人)");
                 sheet.addCell(label);
                 label = new jxl.write.Label(6, 0, "户数");
                 sheet.addCell(label);
                 label = new jxl.write.Label(7, 0, "简介");
                 sheet.addCell(label);
                
                 int i = 1;
                 for(String a:CityBasicInfoAction.getIds().trim().split(",")){
                 	
                	 CityBasicInfo city = cityBasicInfoDAO.findById(Integer.parseInt(a));
              
                 	
                	
     	            label = new jxl.write.Label(0, i,city.getCityNum());
     	            sheet.addCell(label);
     	            label = new jxl.write.Label(1, i, city.getCityName());
     	            sheet.addCell(label);
     	            label = new jxl.write.Label(2, i, city.getCityLongi());
     	            sheet.addCell(label);
     	            label = new jxl.write.Label(3, i, city.getCityLati());
     	            sheet.addCell(label);
     	            label = new jxl.write.Label(4, i, city.getCityMeas());
     	            sheet.addCell(label);
     	            label = new jxl.write.Label(5, i, city.getCityPop());
     	            sheet.addCell(label);
     	            label = new jxl.write.Label(6, i, city.getCityHholds());
     	            sheet.addCell(label);
     	           byte[]intro = city.getCityIntro();
   				   String s;
   				  try{
   					if(intro!=null&&intro.length!=0){
   					s= new String(intro,"UTF-8");
   					   label = new jxl.write.Label(7, i, s);
   			           sheet.addCell(label);
   					}
   					if(intro==null||intro.length==0){
   				    label = new jxl.write.Label(7, i, "");
   						
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
