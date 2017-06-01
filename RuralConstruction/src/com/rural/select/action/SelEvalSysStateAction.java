package com.rural.select.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.rural.bean.EvalSystState;
import com.rural.select.service.SelEvalSysStateService;

public class SelEvalSysStateAction {

	private static final long serialVersionUID = 1L;
	
	private SelEvalSysStateService selEvalSysStateService;

	
	public SelEvalSysStateService getSelEvalSysStateService() {
		return selEvalSysStateService;
	}

	public void setSelEvalSysStateService(
			SelEvalSysStateService selEvalSysStateService) {
		this.selEvalSysStateService = selEvalSysStateService;
	}


	@SuppressWarnings("unchecked")	
	public void findAll() throws IOException{
		List<EvalSystState> evalSysStateList=(List<EvalSystState>)selEvalSysStateService.findAll();
		StringBuilder sb = new StringBuilder();
		sb.append("<select>");
		
		
		for (EvalSystState evalSystState : evalSysStateList) {
			sb.append("<option value='");
			sb.append(evalSystState.getEvalSystStateId()).append("'>").append(evalSystState.getEvalSystStateDes());
			sb.append("</option>");
		}
		sb.append("</select>");
		ServletActionContext.getResponse().setContentType(
				"text/html; charset=utf-8");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		out.write(sb.toString());
	}
}
