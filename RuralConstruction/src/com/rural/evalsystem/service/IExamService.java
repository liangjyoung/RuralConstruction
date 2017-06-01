package com.rural.evalsystem.service;

import java.util.List;

import com.rural.dao.ExamMethDAO;

public class IExamService {
	private ExamMethDAO examMethDAO = new ExamMethDAO();

	public void setExamMethDAO(ExamMethDAO examMethDAO) {
		this.examMethDAO = examMethDAO;
	}

	public ExamMethDAO getExamMethDAO() {
		return examMethDAO;
	}
	public List<?>findAll(){
		return examMethDAO.findAll();
	}
}
