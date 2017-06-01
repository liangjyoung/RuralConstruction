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

import com.rural.admiDivisions.action.TownBasicInfoAction;
import com.rural.bean.CountryBasicInfo;
import com.rural.bean.DataCollDataDic;
import com.rural.bean.TownBasicInfo;
import com.rural.bean.TownCont;
import com.rural.bean.TownFil;
import com.rural.bean.VilBasicInfo;
import com.rural.dao.CountryBasicInfoDAO;
import com.rural.dao.TownBasicInfoDAO;
import com.rural.dao.TownContDAO;
import com.rural.dao.TownFilDAO;
import com.rural.dao.VilBasicInfoDAO;
import com.rural.datacolldatadic.action.DataCollDataDicAction;
import com.rural.tool.Criterion;
public class TownBasicInfoService implements ITownBasicInfoService{
	
	private TownBasicInfoDAO townBasicInfoDAO = new TownBasicInfoDAO();
	private CountryBasicInfoDAO countryBasicInfoDAO  =  new CountryBasicInfoDAO(); 
	private VilBasicInfoDAO vilBasicInfoDAO  =  new VilBasicInfoDAO(); 
	private TownContDAO townContDAO = new TownContDAO();
	private TownFilDAO townFilDAO = new TownFilDAO();
	public VilBasicInfoDAO getVilBasicInfoDAO() {
		return vilBasicInfoDAO;
	}

	public void setVilBasicInfoDAO(VilBasicInfoDAO vilBasicInfoDAO) {
		this.vilBasicInfoDAO = vilBasicInfoDAO;
	}

	public TownContDAO getTownContDAO() {
		return townContDAO;
	}

	public void setTownContDAO(TownContDAO townContDAO) {
		this.townContDAO = townContDAO;
	}

	public TownFilDAO getTownFilDAO() {
		return townFilDAO;
	}

	public void setTownFilDAO(TownFilDAO townFilDAO) {
		this.townFilDAO = townFilDAO;
	}

	
	

	

	public CountryBasicInfoDAO getCountryBasicInfoDAO() {
		return countryBasicInfoDAO;
	}

	public void setCountryBasicInfoDAO(CountryBasicInfoDAO countryBasicInfoDAO) {
		this.countryBasicInfoDAO = countryBasicInfoDAO;
	}

	public TownBasicInfoDAO getTownBasicInfoDAO() {
		return townBasicInfoDAO;
	}

	public void setTownBasicInfoDAO(TownBasicInfoDAO townBasicInfoDAO) {
		this.townBasicInfoDAO = townBasicInfoDAO;
	}
	
	
	

	@SuppressWarnings("unchecked")
	public ArrayList<HashMap<String, Object>> findAll() {
		// TODO Auto-generated method stub
		List<TownBasicInfo> list = new ArrayList<TownBasicInfo>();
		list = this.townBasicInfoDAO.findAll();
		ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for(TownBasicInfo s : list){
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("townBasicInfoID",s.getTownBasicInfoId());
			if(s.getTownNum()==null){
				map.put("townNum",null);
			}else{
			map.put("townNum",s.getTownNum());
			}
			if(s.getTownName()==null){
				map.put("townName", null);
			}else{
			
				map.put("townName", s.getTownName());
			}
			map.put("countryBasicInfoID", s.getCountryBasicInfo().getCountryBasicInfoId());
			if(s.getTownLongi()==null){
				
				map.put("townLongi", null);
			}else{
			
				map.put("townLongi", s.getTownLongi());
			}
			if(s.getTownLati()==null){
				map.put("townLati",null);
				
			}else{
				map.put("townLati",s.getTownLati());
				
			}
			if(s.getTownMeas()==null){
				map.put("townMeas",null);
				
			}else{
				map.put("townMeas",s.getTownMeas());
				
			}
			if(s.getTownPop()==null){
				map.put("townPop",null);
				
			}else{
				map.put("townPop",s.getTownPop());
				
			}
			if(s.getTownHholds()==null){
				map.put("townHholds",null);
				
			}else{
				map.put("townHholds",s.getTownHholds());
				
			}
			
		if(s.getTownIntro()==null){
			map.put("townIntro",null);
		}else{
			map.put("townIntro",s.getTownIntro());
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
		List<TownBasicInfo> list2 = new ArrayList<TownBasicInfo>();
		list2 = this.townBasicInfoDAO.findByConditionAndPager(sql, values, from,length);
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for (TownBasicInfo xt : list2) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("townBasicInfoID", xt.getTownBasicInfoId());
			if(xt.getTownNum()==null){
				map.put("townNum",null);
				
			}else{
				map.put("townNum", xt.getTownNum());
				
			}
			if(xt.getTownName()==null){
				map.put("townName", null);
			}else{
				map.put("townName", xt.getTownName());
			}
			
			map.put("countryBasicInfoID", xt.getCountryBasicInfo().getCountryBasicInfoId());
			if(xt.getTownLongi()==null){
				map.put("townLongi", null);
				
			}else{
				map.put("townLongi", xt.getTownLongi());
			}
			if(xt.getTownLati()==null){
				map.put("townLati",null);
			}else{
				map.put("townLati",xt.getTownLati());
			}
			
			if(xt.getTownLati()==null){
				map.put("townLati",null);
			}else{
				map.put("townLati",xt.getTownLati());
			}
			if(xt.getTownMeas()==null){
				map.put("townMeas",null);
			}else{
				map.put("townMeas",xt.getTownMeas());
			}
			
			if(xt.getTownPop()==null){
				map.put("townPop",null);
			}else{
				map.put("townPop",xt.getTownPop());
			}
			
			if(xt.getTownHholds()==null){
				map.put("townHholds",null);
			}
			else{
				map.put("townHholds",xt.getTownHholds());
			}
			if (xt.getTownIntro() == null){
				map.put("townIntro",null);
				
			}else{
				
				//map.put("countryIntro",xt.getCountryIntro());
				byte[]intro = xt.getTownIntro();
				String s;
				try{
					s= new String(intro,"UTF-8");
					map.put("townIntro",s);
				}catch(UnsupportedEncodingException e){
					e.printStackTrace();
				}
			//map.put("townIntro",xt.getTownIntro());
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
		int rows = this.townBasicInfoDAO.getCounts(sql, values);
		// int rows = this.departmentadmindao.getCounts(sql, values);
		return rows;
	}

	public String addTownBasicInfo(String townNum,String townName,int countryBasicInfoID, String townLongi,String townLati,String townMeas,String townPop,String townHholds,byte[] townIntro) {
		// TODO Auto-generated method stub
		String message = "";
		List<TownBasicInfo> townBasicInfos = townBasicInfoDAO.findByProperty1("townNum", townNum);
		if (townBasicInfos.size()>0) {
			message = "乡(镇)编号已存在！";
		} else {
		TownBasicInfo townBasicInfo= new TownBasicInfo();
		CountryBasicInfo countryBasicInfo = new CountryBasicInfo();
		countryBasicInfo = countryBasicInfoDAO.findById(countryBasicInfoID);
		townBasicInfo.setTownNum(townNum);
		townBasicInfo.setTownName(townName);
		townBasicInfo.setCountryBasicInfo(countryBasicInfo);
		townBasicInfo.setTownLongi(townLongi);
		townBasicInfo.setTownLati(townLati);
		townBasicInfo.setTownMeas(townMeas);
		townBasicInfo.setTownPop(townPop);
		townBasicInfo.setTownHholds(townHholds);
		townBasicInfo.setTownIntro(townIntro);
		townBasicInfoDAO.save(townBasicInfo);
		message = "添加成功";
		}
		return message;
	}

	@SuppressWarnings("unchecked")
	public String updateTownBasicInfo(int townBasicInfoID,String townNum,String townName,String townLongi,String townLati,String townMeas,String townPop,String townHholds,byte[] townIntro) {
		// TODO Auto-generated method stub
		String message="";
		
		TownBasicInfo townBasicInfo= new TownBasicInfo();
		townBasicInfo = townBasicInfoDAO.findById(townBasicInfoID);
		String townnum = townBasicInfo.getTownNum().trim();
		if (townnum.equals(townNum)) {
			townBasicInfo.setTownNum(townNum);
			townBasicInfo.setTownName(townName);
			townBasicInfo.setTownLongi(townLongi);
			townBasicInfo.setTownLati(townLati);
			townBasicInfo.setTownMeas(townMeas);
			townBasicInfo.setTownPop(townPop);
			townBasicInfo.setTownHholds(townHholds);
			townBasicInfo.setTownIntro(townIntro);
			townBasicInfoDAO.attachDirty(townBasicInfo);
			message = "添加成功";
		} else {
			List<TownBasicInfo> townBasicInfos = townBasicInfoDAO.findByProperty1("townNum", townNum);
			if (townBasicInfos.size()>0) {
				message = "乡(镇)编号已存在！";
			} else {
				townBasicInfo.setTownNum(townNum);
				townBasicInfo.setTownName(townName);
				townBasicInfo.setTownLongi(townLongi);
				townBasicInfo.setTownLati(townLati);
				townBasicInfo.setTownMeas(townMeas);
				townBasicInfo.setTownPop(townPop);
				townBasicInfo.setTownHholds(townHholds);
				townBasicInfo.setTownIntro(townIntro);
				townBasicInfoDAO.attachDirty(townBasicInfo);
				message = "添加成功";
				
			}	
			
		}
		return message;
			}

	@SuppressWarnings("unchecked")
	public String delTownBasicInfo(int townBasicInfoID) {
		// TODO Auto-generated method stub
		String message = "";
		TownBasicInfo townBasicInfo= new TownBasicInfo();
		townBasicInfo = townBasicInfoDAO.findById(townBasicInfoID);
		List<VilBasicInfo> vilBasicInfo = vilBasicInfoDAO.findByProperty1("townBasicInfo.townBasicInfoId", townBasicInfoID);
		List<TownCont> townCont = townContDAO.findByProperty("townBasicInfo.townBasicInfoId", townBasicInfoID);
		List<TownFil>  townFil = townFilDAO.findByProperty("townBasicInfo.townBasicInfoId", townBasicInfoID);
		if(vilBasicInfo.size()>0){
			
			message = message + "该镇下存在村,无法删除！\n";
			
		}
		if(townCont.size()>0){
			
			message = message + "该镇下存在联系人,无法删除！\n";
			
		}
		if(townFil.size()>0){
			
			message = message +  "该镇下存在市级文件,无法删除！\n";
			
		}
		if(vilBasicInfo.size()==0&&townCont.size()==0&&townFil.size()==0){
			
			TownBasicInfo townBasicInfo1= new TownBasicInfo();
			townBasicInfo1 = townBasicInfoDAO.findById(townBasicInfoID);
			townBasicInfoDAO.delete(townBasicInfo1);
			message = message + "删除成功！\n" ;
			
		}
		
		return message;
	}
	
	//检查编码是否重复
	public boolean checkTownNum(String townNum,String townBasicInfoID) {
		// TODO Auto-generated method stub
		
		//id=-1表示为增加一条记录,否则表示编辑
		//flag==true表示提示错误，flag==false表示没有重复，不提示错误
		if(townBasicInfoID==null){
			
			if(townBasicInfoDAO.findByProperty1("townNum", townNum).isEmpty()){
				return false;
			}else{
				return true;
			}
		}else{
			if(townBasicInfoDAO.findById(Integer.parseInt(townBasicInfoID)).getTownNum().equals(townNum)){
				return false;
			}else{
				if(townBasicInfoDAO.findByProperty1("townNum", townNum).isEmpty()){
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
        
        List<?> townList = townBasicInfoDAO.findAll();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            workbook = Workbook.createWorkbook(os);
            WritableSheet sheet = workbook.createSheet("Sheet1", 0);
            label = new jxl.write.Label(0, 0, "所属县(区)编码(市.县.00.000)");
            sheet.addCell(label);
            label = new jxl.write.Label(1, 0, "编号(市.县.镇.000)");
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
            for (Object object : townList) {
            	TownBasicInfo townBasicInfo = (TownBasicInfo)object;
				label = new jxl.write.Label(0, i, townBasicInfo.getCountryBasicInfo().getCountryNum());
	            sheet.addCell(label);
	            label = new jxl.write.Label(1, i,townBasicInfo.getTownNum());
	            sheet.addCell(label);
	            label = new jxl.write.Label(2, i, townBasicInfo.getTownName());
	            sheet.addCell(label);
	            label = new jxl.write.Label(3, i, townBasicInfo.getTownLongi());
	            sheet.addCell(label);
	            label = new jxl.write.Label(4, i, townBasicInfo.getTownLati());
	            sheet.addCell(label);
	            label = new jxl.write.Label(5, i, townBasicInfo.getTownMeas());
	            sheet.addCell(label);
	            label = new jxl.write.Label(6, i, townBasicInfo.getTownPop());
	            sheet.addCell(label);
	            label = new jxl.write.Label(7, i, townBasicInfo.getTownHholds());
	            sheet.addCell(label);
	            byte[]intro = townBasicInfo.getTownIntro();
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
                 label = new jxl.write.Label(0, 0, "所属县(区)编码(市.县.00.000)");
                 sheet.addCell(label);
                 label = new jxl.write.Label(1, 0, "编号(市.县.镇.000)");
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
                 for(String a:TownBasicInfoAction.getIds().trim().split(",")){
                 	
                	 TownBasicInfo towns = townBasicInfoDAO.findById(Integer.parseInt(a));
              
                 	
                	 label = new jxl.write.Label(0, i, towns.getCountryBasicInfo().getCountryNum());
     	            sheet.addCell(label);
     	            label = new jxl.write.Label(1, i,towns.getTownNum());
     	            sheet.addCell(label);
     	            label = new jxl.write.Label(2, i, towns.getTownName());
     	            sheet.addCell(label);
     	            label = new jxl.write.Label(3, i, towns.getTownLongi());
     	            sheet.addCell(label);
     	            label = new jxl.write.Label(4, i, towns.getTownLati());
     	            sheet.addCell(label);
     	            label = new jxl.write.Label(5, i, towns.getTownMeas());
     	            sheet.addCell(label);
     	            label = new jxl.write.Label(6, i, towns.getTownPop());
     	            sheet.addCell(label);
     	            label = new jxl.write.Label(7, i, towns.getTownHholds());
     	            sheet.addCell(label);
     	           byte[]intro = towns.getTownIntro();
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
