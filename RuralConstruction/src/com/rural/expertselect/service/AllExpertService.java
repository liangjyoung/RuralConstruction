package com.rural.expertselect.service;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.rural.bean.CityBasicInfo;
import com.rural.bean.Expert;
import com.rural.bean.ExpertMajorCatg;
import com.rural.bean.Sex;
import com.rural.bean.SysRole;
import com.rural.bean.SysRoleUser;
import com.rural.bean.SysUser;
import com.rural.dao.CityBasicInfoDAO;
import com.rural.dao.ExpertDAO;
import com.rural.dao.ExpertMajorCatgDAO;
import com.rural.dao.SexDAO;
import com.rural.dao.SysRoleDAO;
import com.rural.dao.SysRoleUserDAO;
import com.rural.dao.SysUserDAO;
import com.rural.tool.Criterion;
import com.rural.tool.EncoderHandler;


public class AllExpertService implements IAllExpertService{

	private ExpertMajorCatgDAO catgDAO = new ExpertMajorCatgDAO();
	private ExpertDAO expertDAO = new ExpertDAO();
	private SexDAO sexdao = new SexDAO();
	private CityBasicInfoDAO citydao = new CityBasicInfoDAO();
	private SysUserDAO sysuserDao =new SysUserDAO();
	private SysRoleDAO sysroleDao =new SysRoleDAO();
	private SysRoleUserDAO sysroleuserDAO = new SysRoleUserDAO(); 
	
	
	
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

		list2 = this.expertDAO.findByConditionAndPager(sql, values, from,length);
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for (Expert b : list2) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			
			
			map.put("expertID", b.getExpertId());

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

	

	public void delEvalExpert(String expertID) {
		// TODO Auto-generated method stub
		
		Expert expert = new Expert();
		expert = expertDAO.findById(Integer.parseInt(expertID));
		expertDAO.delete(expert);
		
	}

}
