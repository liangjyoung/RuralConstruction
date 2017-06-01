package com.rural.evalsystem.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.rural.bean.ExamMeth;
import com.rural.evalsystem.service.IExamService;

public class ExamAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IExamService examService;
	public void setExamService(IExamService examService) {
		this.examService = examService;
	}
	public IExamService getExamService() {
		return examService;
	}
	@SuppressWarnings("unchecked")	
	public void findAll() throws IOException{
		List<ExamMeth> departmentnolList=(List<ExamMeth>)examService.findAll();
		StringBuilder sb = new StringBuilder();
		sb.append("<select>");
		for (ExamMeth department : departmentnolList) {
			sb.append("<option value='");
			sb.append(department.getExamMethId()).append("'>").append(department.getExamMethName());
			sb.append("</option>");
		}
		sb.append("</select>");
		ServletActionContext.getResponse().setContentType(
				"text/html; charset=utf-8");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		out.write(sb.toString());
	
	}
}
