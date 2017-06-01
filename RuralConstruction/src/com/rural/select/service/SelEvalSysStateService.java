package com.rural.select.service;

import java.util.List;

import com.rural.dao.EvalSystStateDAO;


public class SelEvalSysStateService {

	private EvalSystStateDAO evalSystStateDAO;
	
	public List<?>findAll(){
		return evalSystStateDAO.findAll();
	}

	public EvalSystStateDAO getEvalSystStateDAO() {
		return evalSystStateDAO;
	}

	public void setEvalSystStateDAO(EvalSystStateDAO evalSystStateDAO) {
		this.evalSystStateDAO = evalSystStateDAO;
	}

	
}
