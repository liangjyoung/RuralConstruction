package com.rural.expert.service;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.rural.bean.CityBasicInfo;
import com.rural.bean.EvalExpertDist;
import com.rural.bean.Expert;
import com.rural.bean.ExpertMajorCatg;
import com.rural.bean.Sex;
import com.rural.bean.SysRole;
import com.rural.bean.SysRoleUser;
import com.rural.bean.SysUser;
import com.rural.dao.CityBasicInfoDAO;
import com.rural.dao.EvalExpertDistDAO;
import com.rural.dao.ExpertDAO;
import com.rural.dao.ExpertMajorCatgDAO;
import com.rural.dao.SexDAO;
import com.rural.dao.SysRoleDAO;
import com.rural.dao.SysRoleUserDAO;
import com.rural.dao.SysUserDAO;
import com.rural.tool.Criterion;
import com.rural.tool.EncoderHandler;


public class ExpertService implements IExpertService{

	private ExpertMajorCatgDAO catgDAO = new ExpertMajorCatgDAO();
	private ExpertDAO expertDAO = new ExpertDAO();
	private SexDAO sexdao = new SexDAO();
	private CityBasicInfoDAO citydao = new CityBasicInfoDAO();
	private SysUserDAO sysuserDao =new SysUserDAO();
	private SysRoleDAO sysroleDao =new SysRoleDAO();
	private SysRoleUserDAO sysroleuserDAO = new SysRoleUserDAO(); 
	
	private EvalExpertDistDAO evalExpertDistdao = new EvalExpertDistDAO();
	
	public EvalExpertDistDAO getEvalExpertDistdao() {
		return evalExpertDistdao;
	}

	public void setEvalExpertDistdao(EvalExpertDistDAO evalExpertDistdao) {
		this.evalExpertDistdao = evalExpertDistdao;
	}

	public SysUserDAO getSysuserDao() {
		return sysuserDao;
	}

	public void setSysuserDao(SysUserDAO sysuserDao) {
		this.sysuserDao = sysuserDao;
	}

	public SysRoleDAO getSysroleDao() {
		return sysroleDao;
	}

	public void setSysroleDao(SysRoleDAO sysroleDao) {
		this.sysroleDao = sysroleDao;
	}

	public SysRoleUserDAO getSysroleuserDAO() {
		return sysroleuserDAO;
	}

	public void setSysroleuserDAO(SysRoleUserDAO sysroleuserDAO) {
		this.sysroleuserDAO = sysroleuserDAO;
	}

	public ExpertDAO getExpertDAO() {
		return expertDAO;
	}

	public void setExpertDAO(ExpertDAO expertDAO) {
		this.expertDAO = expertDAO;
	}

	
	public SexDAO getSexdao() {
		return sexdao;
	}

	public void setSexdao(SexDAO sexdao) {
		this.sexdao = sexdao;
	}

	public CityBasicInfoDAO getCitydao() {
		return citydao;
	}

	public void setCitydao(CityBasicInfoDAO citydao) {
		this.citydao = citydao;
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
		// List<DepartmentAdmin> list = new ArrayList<DepartmentAdmin>();
		List<Expert> list2 = new ArrayList<Expert>();
//		//获取用户所属区划编码
//		String cityBasicInfoNum= (String) ServletActionContext.getRequest().getSession().getAttribute("sysUserBeloDiviCode");
//		//String cityBasicInfoNum="371200000000";
//		List<CityBasicInfo> city1=citydao.findByCityNum(cityBasicInfoNum);
//		int cityBasicInfoId = city1.get(0).getCityBasicInfoId();
		list2 = this.expertDAO.findByConditionAndPager(sql, values, from,length);
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for (Expert b : list2) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			
			//int a=b.getExpertId();
			//System.out.println(a+"-------------"+b.getExpertName());
			map.put("expertID", b.getExpertId());
//			if (b.getCityBasicInfo() == null) {
//				map.put("cityBasicInfoId", null);
//			} else {
//				map.put("cityBasicInfoId", b.getCityBasicInfo().getCityName());
//			}
			
			if (b.getEdu() == null) {
				map.put("EduCode", null);
			} else {
				map.put("EduCode", b.getEdu().getEduName());
			}
			
			if (b.getPol() == null) {
				map.put("PolCode", null);
			} else {
				map.put("PolCode", b.getPol().getPolName());
			}
			
			if(b.getSex()== null){
				map.put("SexID", null);
			}else{
				map.put("SexID", b.getSex().getSexName());
			}
			
			if (b.getNation() == null) {
				map.put("NationID", null);
			} else {
				map.put("NationID", b.getNation().getNationName());
			}
			if(b.getExpertMajorCatg()==null){
				map.put("MajorCatgNum", null);
			}else{
				map.put("MajorCatgNum", b.getExpertMajorCatg().getExpertMajorCatg());
			}
			
			if (b.getExpertNum() == null) {
				map.put("ExpertNum",null);
			} else {
				map.put("ExpertNum", b.getExpertNum());
			}
			
			if (b.getExpertName() == null) {
				map.put("ExpertName", null);
			} else {
				map.put("ExpertName", b.getExpertName());
			}
			
			if ( b.getExpertBirth() == null) {
				map.put("ExpertBirth", null);
			}else{
				map.put("ExpertBirth", b.getExpertBirth().toString().substring(0, 11));
			}
			if (b.getExpertTitle() == null) {
				map.put("ExpertTitle", null);
			} else {
				map.put("ExpertTitle", b.getExpertTitle());
			}
			if (b.getExpertPost() == null) {
				map.put("ExpertPost", null);
			} else {
				map.put("ExpertPost", b.getExpertPost());
			}
			if (b.getExpertWorkTel() == null) {
				map.put("ExpertWorkTel", null);
			} else {
				map.put("ExpertWorkTel", b.getExpertWorkTel());
			}
			if (b.getExpertMobTel() == null) {
				map.put("ExpertMobTel", null);
			} else {
				map.put("ExpertMobTel", b.getExpertMobTel());
			}
			if (b.getExpertComp() == null) {
				map.put("ExpertComp", null);
			} else {
				map.put("ExpertComp", b.getExpertComp());
			}
			
			if (b.getExpertGraReli() == null) {
				map.put("ExpertGraReli", null);
			} else {
				map.put("ExpertGraReli", b.getExpertGraReli());
			}
			if (b.getExpertEmail() == null) {
				map.put("ExpertEmail", null);
			} else {
				map.put("ExpertEmail", b.getExpertEmail());
			}
			if (b.getExpertWx() == null) {
				map.put("ExpertWx", null);
			} else {
				map.put("ExpertWx", b.getExpertWx());
			}
			if (b.getExpertAddress() == null) {
				map.put("ExpertAddress", null);
			} else {
				map.put("ExpertAddress", b.getExpertAddress());
			}
			if (b.getExpertBank() == null) {
				map.put("expertBank", null);
			} else {
				map.put("expertBank", b.getExpertBank());
			}
			if (b.getExpertAccount() == null) {
				map.put("expertAccount", null);
			} else {
				map.put("expertAccount", b.getExpertAccount());
			}
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
		int rows = this.expertDAO.getCounts(sql, values);
		return rows;
	}

	
	
	
	
	public List<ExpertMajorCatg> getAllExpertMajor() {
		// TODO Auto-generated method stub
		List<ExpertMajorCatg> list = new ArrayList<ExpertMajorCatg>();
		list = this.catgDAO.findAll();
		return list;
	}

	public void setCatgDAO(ExpertMajorCatgDAO catgDAO) {
		this.catgDAO = catgDAO;
	}

	public ExpertMajorCatgDAO getCatgDAO() {
		return catgDAO;
	}

	public void addEvalExpert(String MajorCatgID,String expertNum,String expertName,
			String sexId,String expertTitle,String expertWorkTel,String expertMobTel,
			Date expertBirth,String expertAddress) {
		// TODO Auto-generated method stub
		Expert expert = new Expert();
		
		ExpertMajorCatg major=new ExpertMajorCatg();
		major= catgDAO.findById(Integer.parseInt(MajorCatgID));
		
		
		Sex sex = new Sex();
		sex = sexdao.findById(Integer.parseInt(sexId));
		
//		String cityBasicInfoNum= (String) ServletActionContext.getRequest().getSession().getAttribute("sysUserBeloDiviCode");
//		//String cityBasicInfoNum="371200000000";
//		List<CityBasicInfo> city1=citydao.findByCityNum(cityBasicInfoNum);
//		CityBasicInfo city = city1.get(0);
		
		
		
		expert.setExpertNum(expertNum);
		expert.setExpertName(expertName);
		expert.setSex(sex);
		expert.setExpertTitle(expertTitle);
		expert.setExpertWorkTel(expertWorkTel);
		expert.setExpertMobTel(expertMobTel);
		expert.setExpertBirth(expertBirth);
		expert.setExpertAddress(expertAddress);
//		expert.setCityBasicInfo(city);
		expert.setExpertMajorCatg(major);
//		expert.setSysUser(syu);
		expertDAO.save(expert);
		
		//设置专家用户密码为123456
		List<SysUser> userlist = sysuserDao.findByUserName(expertNum);
		SysUser user=userlist.get(0);
		user.setUserPas(EncoderHandler.doubleEncode("123456"));//默认密码为123456
		sysuserDao.attachDirty(user);
		
	}

	public boolean checkExpertNum(String expertNum) {
		// TODO Auto-generated method stub
		if(expertDAO.findByExpertNum(expertNum)==null){
			return false;
		}else{
			return true;
		}
	}

	public String delEvalExpert(Integer expertID) {
		// TODO Auto-generated method stub
		
		/*Expert expert = new Expert();
		expert = expertDAO.findById(Integer.parseInt(expertID));
		expertDAO.delete(expert);*/
		String message = "";
		Expert expert1 = new Expert();
		expert1 = expertDAO.findById(expertID);
		
		List<EvalExpertDist> e= evalExpertDistdao.findByProperty("expert", expert1);
		if (e.size()>0) {
			message = "评价专家分配已引用专家编号为"+expert1.getExpertNum() +"的对象，无法删除！\n";
		}else{
			Expert expert = new Expert();
			expert = expertDAO.findById(expertID);
			expertDAO.delete(expert);
			message = "专家编号为"+expert.getExpertNum()+"的对象，删除成功！\n";
		}
		return message;
	}

	//表格的编辑功能
	public void updateEvalExpert(String MajorCatgID ,String expertID, String expertNum,
			String expertName, String sexId, String expertTitle,String expertWorkTel,
			String expertMobTel, Date expertBirth, String expertAddress) {
		// TODO Auto-generated method stub
		Expert expert = new Expert();
		expert = expertDAO.findById(Integer.parseInt(expertID));
		//expertDAO.delete(expert);
		
		ExpertMajorCatg major=new ExpertMajorCatg();
		major= catgDAO.findById(Integer.parseInt(MajorCatgID));
		
		
		
		Sex sex = new Sex();
		sex = sexdao.findById(Integer.parseInt(sexId));
		
//		String cityBasicInfoNum= (String) ServletActionContext.getRequest().getSession().getAttribute("sysUserBeloDiviCode");
//		//String cityBasicInfoNum="371200000000";
//		List<CityBasicInfo> city1=citydao.findByCityNum(cityBasicInfoNum);
//		CityBasicInfo city = city1.get(0);
		
		
		expert.setExpertNum(expertNum);
		expert.setExpertName(expertName);
		expert.setSex(sex);
		expert.setExpertTitle(expertTitle);
		expert.setExpertWorkTel(expertWorkTel);
		expert.setExpertMobTel(expertMobTel);
		expert.setExpertBirth(expertBirth);
		expert.setExpertAddress(expertAddress);
//		expert.setCityBasicInfo(city);
		expert.setExpertMajorCatg(major);
		expertDAO.merge(expert);
	}
	
	//检查专家编码是否重复
	public boolean checkExpertNum(String expertNum, String expertID) {
		//id=-1表示为增加一条记录,否则表示编辑
		//flag==true表示提示错误，flag==false表示没有重复，不提示错误
		if(expertID==null){
			if(expertDAO.findByExpertNum(expertNum).isEmpty()){
				return false;
			}else{
				return true;
			}
		}else{
			if(expertDAO.findById(Integer.parseInt(expertID)).getExpertNum().equals(expertNum)){
				return false;
			}else{
				if(expertDAO.findByExpertNum(expertNum).isEmpty()){
					return false;
				}else{
					return true;
				}
			}
		}
	}

	


}
