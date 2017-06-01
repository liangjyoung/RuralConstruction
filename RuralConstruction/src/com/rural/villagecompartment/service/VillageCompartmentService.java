package com.rural.villagecompartment.service;

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


import com.rural.dao.InvgatDworkDAO;
import com.rural.dao.TownBasicInfoDAO;
import com.rural.dao.VilBasicInfoDAO;
import com.rural.dao.VilContDAO;
import com.rural.dao.VilDataCollRecDAO;
import com.rural.dao.VilFilDAO;
import com.rural.datacolldatadic.action.DataCollDataDicAction;

import com.rural.tool.Criterion;



import com.rural.bean.DataCollDataDic;
import com.rural.bean.TownBasicInfo;
import com.rural.bean.VilBasicInfo;
import com.rural.bean.VilFil;



public class VillageCompartmentService implements IVillageCompartmentService {
	
	private VilBasicInfoDAO vilBasicInfoDAO = new VilBasicInfoDAO();
	private TownBasicInfoDAO townBasicInfoDAO = new TownBasicInfoDAO();
	
	
	
	
	
	
	private VilFilDAO vilfilDAO = new VilFilDAO();
	private VilContDAO vilContDAO = new VilContDAO();
	private VilDataCollRecDAO vilDataCollRecDAO = new VilDataCollRecDAO();
	
	private InvgatDworkDAO invgatDworkDAO = new InvgatDworkDAO();
	
	
	
	
	
	
	
	public VilContDAO getVilContDAO() {
		return vilContDAO;
	}
	public void setVilContDAO(VilContDAO vilContDAO) {
		this.vilContDAO = vilContDAO;
	}
	public VilDataCollRecDAO getVilDataCollRecDAO() {
		return vilDataCollRecDAO;
	}
	public void setVilDataCollRecDAO(VilDataCollRecDAO vilDataCollRecDAO) {
		this.vilDataCollRecDAO = vilDataCollRecDAO;
	}
	public TownBasicInfoDAO getTownBasicInfoDAO() {
		return townBasicInfoDAO;
	}
	public void setTownBasicInfoDAO(TownBasicInfoDAO townBasicInfoDAO) {
		this.townBasicInfoDAO = townBasicInfoDAO;
	}
	public VilBasicInfoDAO getVilBasicInfoDAO() {
		return vilBasicInfoDAO;
	}
	public void setVilBasicInfoDAO(VilBasicInfoDAO vilBasicInfoDAO) {
		this.vilBasicInfoDAO = vilBasicInfoDAO;
	}
	

	public VilFilDAO getVilfilDAO() {
		return vilfilDAO;
	}
	public void setVilfilDAO(VilFilDAO vilfilDAO) {
		this.vilfilDAO = vilfilDAO;
	}

	public InvgatDworkDAO getInvgatDworkDAO() {
		return invgatDworkDAO;
	}
	public void setInvgatDworkDAO(InvgatDworkDAO invgatDworkDAO) {
		this.invgatDworkDAO = invgatDworkDAO;
	}
	@SuppressWarnings("unchecked")
	
	
	
	
	//检查编码是否重复
	public boolean checkVilNum(String vilNum,String id) {
		// TODO Auto-generated method stub
		
		//id=-1表示为增加一条记录,否则表示编辑
		//flag==true表示提示错误，flag==false表示没有重复，不提示错误
		if(id==null){
			if(vilBasicInfoDAO.findByVilNum(vilNum).isEmpty()){
				return false;
			}else{
				return true;
			}
		}else{
			if(vilBasicInfoDAO.findById(Integer.parseInt(id)).getVilNum().equals(vilNum)){
				return false;
			}else{
				if(vilBasicInfoDAO.findByVilNum(vilNum).isEmpty()){
					return false;
				}else{
					return true;
				}
			}
		}
	}
	
	public ArrayList<HashMap<String, Object>> findAll() {
		// TODO Auto-generated method stub
		List<VilBasicInfo> list = new ArrayList<VilBasicInfo>();
		list = this.vilBasicInfoDAO.findAll();
		ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for(VilBasicInfo s : list){
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("vilBasicInfoId", s.getVilBasicInfoId());
			map.put("VilNum", s.getVilNum());//第一个=必须是id
			map.put("TownBasicInfoId", s.getTownBasicInfo().getTownName());
			map.put("VilName", s.getVilName());
			map.put("VilLongi", s.getVilLongi());
			map.put("VilLati", s.getVilLati());
			map.put("VilMeas", s.getVilMeas());
			map.put("VilPop", s.getVilPop());
			map.put("VilHholds", s.getVilHholds());
			map.put("VilNatural", s.getVilNatural());
			map.put("VilIntro", s.getVilIntro());
			result.add(map);
		}
		
		return result;
	}
	
	public int queryResultsCount(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		String sql = null;
		List<Object> values = null;
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
		int rows = vilBasicInfoDAO.getCounts(sql, values);
		// int rows = this.departmentadmindao.getCounts(sql, values);
		return rows;
	}
	
	
	
	

	//查询
	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		String sql = null;
		List<Object> values = null;
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
		List<VilBasicInfo> list2 = new ArrayList<VilBasicInfo>();
	//	list2 = vilBasicInfoDAO.findByTownNum(sql, values, from, length, VillageCompartmentAction.townNo);
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
						
		//list2 = this.vilBasicInfoDAO.findByProperty("townNum", "371202108000");
		list2 = this.vilBasicInfoDAO.findByConditionAndPager(sql, values, from, length);
		
		for (VilBasicInfo xt : list2) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			
		//	VilBasicInfo x = new VilBasicInfo();
			map.put("VilBasicInfoId", xt.getVilBasicInfoId());
			if(xt.getVilNum()==null){
				map.put("VilNum", null);
			}else{
				map.put("VilNum", xt.getVilNum());
			}
			if(xt.getTownBasicInfo()==null){
				map.put("TownBasicInfoId", null);
			}else{
				map.put("TownBasicInfoId", xt.getTownBasicInfo().getTownName());
			}
			if(xt.getVilName()==null){
				map.put("VilName", null);
			}else{
				map.put("VilName", xt.getVilName());
			}
		    if(xt.getVilLongi()==null){
		    	map.put("VilLongi", null);
		    }else{
		    	map.put("VilLongi", xt.getVilLongi());
		    }
			if( xt.getVilLati()==null){
				map.put("VilLati", null);
			}else{
				map.put("VilLati", xt.getVilLati());
			}
			if(xt.getVilMeas()==null){
				map.put("VilMeas",null);
			}else{
				map.put("VilMeas", xt.getVilMeas());
			}
			if(xt.getVilPop()==null){
				map.put("VilPop", null);
			}else{
				map.put("VilPop", xt.getVilPop());
			}
			
			if(xt.getVilHholds()==null){
				map.put("VilHholds", null);
			}else{
				map.put("VilHholds", xt.getVilHholds());
			}
			if(xt.getVilNatural()==null){
				map.put("VilNatural", null);
			}else{
				map.put("VilNatural", xt.getVilNatural());
			}
			if(xt.getVilIntro()==null){
				map.put("VilIntro", null);
			}else{
				byte[] bys = xt.getVilIntro();
				String ss;
				try {
					ss = new String(bys,"UTF-8");
					map.put("VilIntro",ss );
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			result.add(map);
		}
		
		return  result;
	}
	
	//添加村
	public void addVillage(String vilNum,Integer townBasicInfoId,String vilName,String vilLongi,
			String vilLati,String vilMeas,String vilPop,String vilHholds,String vilNatural, byte[] vilIntro  ) {
		// TODO Auto-generated method stub
		TownBasicInfo tb = new TownBasicInfo();
	//	System.out.println(VillageCompartmentAction.townNo);
	    tb = townBasicInfoDAO.findById(townBasicInfoId);
	   
	    
		VilBasicInfo vb = new VilBasicInfo();	
		vb.setVilNum(vilNum);		
		vb.setTownBasicInfo(tb);
		vb.setVilName(vilName);
		vb.setVilLongi(vilLongi);
		vb.setVilLati(vilLati);
		vb.setVilMeas(vilMeas);
		vb.setVilPop(vilPop);
		vb.setVilHholds(vilHholds);
		vb.setVilNatural(vilNatural);
		vb.setVilIntro(vilIntro);
	
		
		vilBasicInfoDAO.save(vb);
	}
	

	//删除
	public String delVilBasicInfo(Integer vilBasicInfoId) {
		// TODO Auto-generated method stub
		VilBasicInfo vilBasicInfo = new VilBasicInfo();
		vilBasicInfo = vilBasicInfoDAO.findById(vilBasicInfoId);		
		String message = "";
		
		
		//int num = invgatdao.findById(id);
		List<VilFil> vf= vilfilDAO.findByProperty("vilBasicInfo.vilBasicInfoId", vilBasicInfoId);
		List id = invgatDworkDAO.findByProperty("vilBasicInfo.vilBasicInfoId", vilBasicInfoId);
		List vc=vilDataCollRecDAO.findByProperty("vilBasicInfo.vilBasicInfoId", vilBasicInfoId);
		List vct=vilContDAO.findByProperty("vilBasicInfo.vilBasicInfoId", vilBasicInfoId);
		
		
		if (vf.size()>0) {
			message = "村庄文件已引用村庄编号为"+vilBasicInfo.getVilNum()+"的对象，无法删除！\n";
		} else if(id.size()>0){
			message = "调查员分工已引用村庄编号为"+vilBasicInfo.getVilNum()+"的对象，无法删除！\n";
		}else if(vc.size()>0){
			message = "村庄数据采集记录已引用村庄编号为"+vilBasicInfo.getVilNum()+"的对象，无法删除！\n";
		}else if(vct.size()>0){
			message = "村庄联系人已引用村庄编号为"+vilBasicInfo.getVilNum()+"的对象，无法删除！\n";
		}
		else{
			vilBasicInfoDAO.delete(vilBasicInfo);
			message = "村庄编号为"+vilBasicInfo.getVilNum()+"的对象，删除成功！\n";
		}
			
		return message;
	}
	
	
	
	
	//编辑
	public void updateVillage(Integer vilBasicInfoId,Integer TownBasicInfoID,String vilNum, String vilName, String vilLongi,
			String vilLati, String vilMeas, String vilPop, String vilHholds,
			String vilNatural, byte[] vilIntro) {
		
		TownBasicInfo tb = new TownBasicInfo();
		
	   tb = townBasicInfoDAO.findById(TownBasicInfoID);
		
		// TODO Auto-generated method stub		
		VilBasicInfo vilBasicInfo = new VilBasicInfo();
		vilBasicInfo = vilBasicInfoDAO.findById(vilBasicInfoId);
		VilBasicInfo newVilBasicInfo = vilBasicInfo;	
		newVilBasicInfo.setVilNum(vilNum);
		newVilBasicInfo.setTownBasicInfo(tb);
		newVilBasicInfo.setVilName(vilName);
		newVilBasicInfo.setVilLongi(vilLongi);
		newVilBasicInfo.setVilLati(vilLati);
		newVilBasicInfo.setVilMeas(vilMeas);
		newVilBasicInfo.setVilPop(vilPop);
		newVilBasicInfo.setVilHholds(vilHholds);
		newVilBasicInfo.setVilNatural(vilNatural);
		newVilBasicInfo.setVilIntro(vilIntro);
		vilBasicInfoDAO.attachDirty(newVilBasicInfo);
		
		
	}
	
	
	public InputStream exportToExcel(){
		Label label;
        WritableWorkbook workbook;
        
        List<?> vilList = vilBasicInfoDAO.findAll();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            workbook = Workbook.createWorkbook(os);
            WritableSheet sheet = workbook.createSheet("Sheet1", 0);
            label = new jxl.write.Label(0, 0, "镇级编码");
            sheet.addCell(label);
            label = new jxl.write.Label(1, 0, "村庄编码");
            sheet.addCell(label);
            label = new jxl.write.Label(2, 0, "村庄名称");
            sheet.addCell(label);
            label = new jxl.write.Label(3, 0, "村庄经度");
            sheet.addCell(label);
            label = new jxl.write.Label(4, 0, "村庄纬度");
            sheet.addCell(label);
            label = new jxl.write.Label(5, 0, "村庄面积");
            sheet.addCell(label);
            label = new jxl.write.Label(6, 0, "村庄人口数");
            sheet.addCell(label);
            label = new jxl.write.Label(7, 0, "村庄户数");
            sheet.addCell(label);
            label = new jxl.write.Label(8, 0, "自然村数");
            sheet.addCell(label);
            label = new jxl.write.Label(9, 0, "备注");
            sheet.addCell(label);
           
            int i = 1;
           
            for (Object object : vilList) {
            	VilBasicInfo vilBasicInfo = (VilBasicInfo)object;
				label = new jxl.write.Label(0, i, vilBasicInfo.getTownBasicInfo().getTownNum());
	            sheet.addCell(label);
	            label = new jxl.write.Label(1, i,vilBasicInfo.getVilNum());
	            sheet.addCell(label);
	            label = new jxl.write.Label(2, i,vilBasicInfo.getVilName());
	            sheet.addCell(label);
	            label = new jxl.write.Label(3, i,vilBasicInfo.getVilLongi());
	            sheet.addCell(label);
	            label = new jxl.write.Label(4, i,vilBasicInfo.getVilLati());
	            sheet.addCell(label);
	            label = new jxl.write.Label(5, i,vilBasicInfo.getVilMeas());
	            sheet.addCell(label);
	            label = new jxl.write.Label(6, i,vilBasicInfo.getVilPop());
	            sheet.addCell(label);
	            label = new jxl.write.Label(7, i,vilBasicInfo.getVilHholds());
	            sheet.addCell(label);
	            label = new jxl.write.Label(8, i,vilBasicInfo.getVilNatural());
	            sheet.addCell(label);
	           //label = new jxl.write.Label(9, i,String.valueOf(vilBasicInfo.getVilIntro()));
	           //sheet.addCell(label);
	            byte[]intro = vilBasicInfo.getVilIntro();
				String s;
				try{
					if(intro!=null&&intro.length!=0){
					s= new String(intro,"UTF-8");
					   label = new jxl.write.Label(9, i, s);
			           sheet.addCell(label);
					}
					if(intro==null||intro.length==0){
				    label = new jxl.write.Label(9, i, "");
						
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
                 label = new jxl.write.Label(0, 0, "镇级编码");
                 sheet.addCell(label);
                 label = new jxl.write.Label(1, 0, "村庄编码");
                 sheet.addCell(label);
                 label = new jxl.write.Label(2, 0, "村庄名称");
                 sheet.addCell(label);
                 label = new jxl.write.Label(3, 0, "村庄经度");
                 sheet.addCell(label);
                 label = new jxl.write.Label(4, 0, "村庄纬度");
                 sheet.addCell(label);
                 label = new jxl.write.Label(5, 0, "村庄面积");
                 sheet.addCell(label);
                 label = new jxl.write.Label(6, 0, "村庄人口数");
                 sheet.addCell(label);
                 label = new jxl.write.Label(7, 0, "村庄户数");
                 sheet.addCell(label);
                 label = new jxl.write.Label(8, 0, "自然村数");
                 sheet.addCell(label);
                 label = new jxl.write.Label(9, 0, "备注");
                 sheet.addCell(label);
                
                 int i = 1;
                 for(String a:DataCollDataDicAction.getIds().trim().split(",")){
                 	
                	 VilBasicInfo vilBasicInfo = vilBasicInfoDAO.findById(Integer.parseInt(a));
              
                 	
                	 label = new jxl.write.Label(0, i, vilBasicInfo.getTownBasicInfo().getTownNum());
     	            sheet.addCell(label);
     	            label = new jxl.write.Label(1, i,vilBasicInfo.getVilNum());
     	            sheet.addCell(label);
     	            label = new jxl.write.Label(2, i,vilBasicInfo.getVilName());
     	            sheet.addCell(label);
     	            label = new jxl.write.Label(3, i,vilBasicInfo.getVilLongi());
     	            sheet.addCell(label);
     	            label = new jxl.write.Label(4, i,vilBasicInfo.getVilLati());
     	            sheet.addCell(label);
     	            label = new jxl.write.Label(5, i,vilBasicInfo.getVilMeas());
     	            sheet.addCell(label);
     	            label = new jxl.write.Label(6, i,vilBasicInfo.getVilPop());
     	            sheet.addCell(label);
     	            label = new jxl.write.Label(7, i,vilBasicInfo.getVilHholds());
     	            sheet.addCell(label);
     	            label = new jxl.write.Label(8, i,vilBasicInfo.getVilNatural());
     	            sheet.addCell(label);
     	           label = new jxl.write.Label(9, i,String.valueOf(vilBasicInfo.getVilIntro()));
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
