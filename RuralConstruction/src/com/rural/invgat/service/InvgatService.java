package com.rural.invgat.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;



import com.rural.bean.Edu;
import com.rural.bean.Invgat;

import com.rural.bean.InvgatDwork;
import com.rural.bean.Nation;
import com.rural.bean.Pol;
import com.rural.bean.Sex;
import com.rural.bean.SysUser;
import com.rural.bean.VilDataCollRec;
import com.rural.dao.EduDAO;
import com.rural.dao.InvgatDAO;
import com.rural.dao.InvgatDworkDAO;
import com.rural.dao.NationDAO;
import com.rural.dao.PolDAO;
import com.rural.dao.SexDAO;
import com.rural.dao.SysUserDAO;
import com.rural.dao.VilDataCollRecDAO;
import com.rural.tool.Criterion;
import com.rural.tool.EncoderHandler;


public class InvgatService implements IInvgatService{

	private InvgatDAO Invgatdao = new InvgatDAO();
	private EduDAO edudao = new EduDAO();
	private SexDAO sexdao = new SexDAO();
	private NationDAO nationdao = new NationDAO();
	private PolDAO poldao = new PolDAO();
	private VilDataCollRecDAO vilDataCollRecdao = new VilDataCollRecDAO();
	private SysUserDAO sysuserDao =new SysUserDAO();
	
	private InvgatDworkDAO invgatDworkdao = new InvgatDworkDAO();
	
	public SysUserDAO getSysuserDao() {
		return sysuserDao;
	}
	public void setSysuserDao(SysUserDAO sysuserDao) {
		this.sysuserDao = sysuserDao;
	}
	public InvgatDAO getInvgatdao() {
		return Invgatdao;
	}
	public void setInvgatdao(InvgatDAO invgatdao) {
		Invgatdao = invgatdao;
	}
	public EduDAO getEdudao() {
		return edudao;
	}
	public void setEdudao(EduDAO edudao) {
		this.edudao = edudao;
	}
	public SexDAO getSexdao() {
		return sexdao;
	}
	public void setSexdao(SexDAO sexdao) {
		this.sexdao = sexdao;
	}
	public NationDAO getNationdao() {
		return nationdao;
	}
	public void setNationdao(NationDAO nationdao) {
		this.nationdao = nationdao;
	}
	public PolDAO getPoldao() {
		return poldao;
	}
	public void setPoldao(PolDAO poldao) {
		this.poldao = poldao;
	}
	
	
	
	
	public VilDataCollRecDAO getVilDataCollRecdao() {
		return vilDataCollRecdao;
	}
	public void setVilDataCollRecdao(VilDataCollRecDAO vilDataCollRecdao) {
		this.vilDataCollRecdao = vilDataCollRecdao;
	}
	public InvgatDworkDAO getInvgatDworkdao() {
		return invgatDworkdao;
	}
	public void setInvgatDworkdao(InvgatDworkDAO invgatDworkdao) {
		this.invgatDworkdao = invgatDworkdao;
	}
	@SuppressWarnings("unchecked")
	public ArrayList<HashMap<String, Object>> findAll() {
		// TODO Auto-generated method stub
		List<Invgat> list = new ArrayList<Invgat>();
		list = this.Invgatdao.findAll();
		ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for(Invgat s : list){
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", s.getInvgatId());
			if(s.getInvgatNum()==null){
				map.put("InvgatNum", null);
			}else{
				map.put("InvgatNum", s.getInvgatNum());
			}
			
			map.put("EduID", s.getEdu());
			if(s.getInvgatMajor()==null){
				map.put("InvgatMajor", null);
			}else{
				map.put("InvgatMajor", s.getInvgatMajor());
			}
			
			map.put("SexID", s.getSex());
			map.put("NationID", s.getNation());
			map.put("PolID", s.getPol());
			if(s.getInvgatName()==null){
				map.put("InvgatName", null);
			}else{
				map.put("InvgatName", s.getInvgatName());
			}
			if( s.getInvgatBirth()==null){
				map.put("InvgatBirth", null);
			}else{
				map.put("InvgatBirth", s.getInvgatBirth());
			}
			if(s.getInvgatComp()==null){
				map.put("InvgatComp",null );
			}else{
				map.put("InvgatComp", s.getInvgatComp());
			}
			if(s.getInvgatTel()==null){
				map.put("InvgatTel", null);
			}else{
				map.put("InvgatTel", s.getInvgatTel());
			}
			//因为InvgatNote用来存userID了，所以不传了
//			if(s.getInvgatNote()==null){
//				map.put("InvgatNote", null);
//			}else{
//				map.put("InvgatNote", s.getInvgatNote());
//			}
			
			
			
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
		List<Invgat> list2 = new ArrayList<Invgat>();
		list2 = this.Invgatdao.findByConditionAndPager(sql, values, from,length);
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for (Invgat xt : list2) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			Invgat x = new Invgat();
			map.put("id", xt.getInvgatId());//第一个=必须是id
			map.put("InvgatNum", xt.getInvgatNum());
			if(xt.getEdu()!=null){
				map.put("EduID", xt.getEdu().getEduName());
			}
			
			map.put("InvgatMajor", xt.getInvgatMajor());
			
			if(xt.getSex()!=null){
				map.put("SexID", xt.getSex().getSexName());
			}
			if(xt.getNation()!=null){
				map.put("NationID", xt.getNation().getNationName());
			}
			if(xt.getPol()!=null){
				map.put("PolID", xt.getPol().getPolName());
			}
			map.put("InvgatName", xt.getInvgatName());
			if(xt.getInvgatBirth()!=null){
				map.put("InvgatBirth", xt.getInvgatBirth().toString().substring(0, 11));
			}
			map.put("InvgatComp", xt.getInvgatComp());
			map.put("InvgatTel", xt.getInvgatTel());
		//	map.put("InvgatNote", xt.getInvgatNote());
			
			
			
			//SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
			//System.out.println((xt.getInvgatBirth()));
			
			
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
		int rows = this.Invgatdao.getCounts(sql, values);
		// int rows = this.departmentadmindao.getCounts(sql, values);
		return rows;
	}


	@SuppressWarnings("unchecked")
	public String delInvgat(Integer id) {
		// TODO Auto-generated method stub
		String message = "";
		
		Invgat invgat1 = new Invgat();
		invgat1 = Invgatdao.findById(id);

		List<InvgatDwork> i = invgatDworkdao.findByProperty("invgat", invgat1);
		List<VilDataCollRec> v = vilDataCollRecdao.findByProperty("invgat", invgat1);
		if(i.size()>0){
			message = "采集任务分配已引用调查员编号为"+invgat1.getInvgatNum()+"的对象，无法删除！\n";
		}else if (v.size()>0){
			message = "村庄在线采集已引用调查员编号为"+invgat1.getInvgatNum()+"的对象，无法删除！\n";
		}else{
			
			Invgat invgat = new Invgat();
			invgat = Invgatdao.findById(id);
			Invgatdao.delete(invgat);
			message = "调查员编号为"+invgat1.getInvgatNum()+"的对象，删除成功！\n";
		}
		return message;
	}
	
	
	
	public boolean checkInvgatNum(String invgatNum,String id) {
		// TODO Auto-generated method stub
		if(id==null){
			if(Invgatdao.findByInvgatNum(invgatNum).isEmpty()){
				return false;
			}else{
				return true;
			}
		}else{
			if(Invgatdao.findById(Integer.parseInt(id)).getInvgatNum().equals(invgatNum)){
				return false;
			}else{
				if(Invgatdao.findByInvgatNum(invgatNum).isEmpty()){
					return false;
				}else{
					return true;
				}
			}
		}
	}

	public void addInvgat(String invgatNum, Integer eduID,String invgatMajor,
			Integer sexID,Integer nationID,Integer polID,String invgatName,
			Date invgatBirth,String invgatComp,String invgatTel){
		// TODO Auto-generated method stub
		Invgat invgat = new Invgat();
		
		Edu edu = new Edu();
		edu = edudao.findById(eduID);
		
		Sex sex = new Sex();
		sex = sexdao.findById(sexID);
		
		Nation nation = new Nation();
		nation = nationdao.findById(nationID);
		
		Pol pol = new Pol();
		pol = poldao.findById(polID);

		
		invgat.setInvgatNum(invgatNum);
		invgat.setEdu(edu);
		invgat.setInvgatMajor(invgatMajor);
		invgat.setSex(sex); 
		invgat.setNation(nation);
		invgat.setPol(pol);
		invgat.setInvgatName(invgatName);
		invgat.setInvgatBirth(invgatBirth);
		invgat.setInvgatComp(invgatComp);
		invgat.setInvgatTel(invgatTel);
		

		Invgatdao.save(invgat);
		
		//设置调查员用户密码为123456
		List<SysUser> userlist = sysuserDao.findByUserName(invgatNum);
		SysUser user=userlist.get(0);
		user.setUserPas(EncoderHandler.doubleEncode("123456"));//默认密码为123456
		sysuserDao.attachDirty(user);
		
	}

	public void updateInvgat(Integer id,String invgatNum, Integer eduID,
			String invgatMajor,Integer sexID,Integer nationID,Integer polID,
			String invgatName,Date invgatBirth,String invgatComp,String invgatTel) {
		// TODO Auto-generated method stub
		Invgat invgat = new Invgat();
		invgat = Invgatdao.findById(id);
		
		Edu edu = new Edu();
		edu = edudao.findById(eduID);
		
		
		Sex sex = new Sex();
		sex = sexdao.findById(sexID);
		
		Nation nation = new Nation();
		nation = nationdao.findById(nationID);
		
		Pol pol = new Pol();
		pol = poldao.findById(polID);
		
		//Invgatdao.delete(invgat);
		invgat.setInvgatNum(invgatNum);
		invgat.setEdu(edu);
		invgat.setInvgatMajor(invgatMajor);
		invgat.setSex(sex); 
		invgat.setNation(nation);
		invgat.setPol(pol);
		invgat.setInvgatName(invgatName);
		invgat.setInvgatBirth(invgatBirth);
		invgat.setInvgatComp(invgatComp);
		invgat.setInvgatTel(invgatTel);
		//invgat.setInvgatNote(invgatNote);
		
		Invgatdao.attachDirty(invgat);
		
	}
}
