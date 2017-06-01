package com.rural.datacolldatadic.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.rural.bean.DataCollDicEntry;
import com.rural.datacolldatadic.service.SelDataCollDataEntryService;


public class SelDataCollDataEntryAction extends ActionSupport {
private static final long serialVersionUID = 1L;
	
	private SelDataCollDataEntryService selDataCollDataentryService;

	private String DataCollDataDicId;
	private static String DataDic;
	
	



	public String getDataCollDataDicId() {
		return DataCollDataDicId;
	}

	public void setDataCollDataDicId(String dataCollDataDicId) {
		DataCollDataDicId = dataCollDataDicId;
	}

	public static String getDataDic() {
		return DataDic;
	}

	public static void setDataDic(String dataDic) {
		DataDic = dataDic;
	}

	public SelDataCollDataEntryService getSelDataCollDataentryService() {
		return selDataCollDataentryService;
	}

	public void setSelDataCollDataentryService(
			SelDataCollDataEntryService selDataCollDataentryService) {
		this.selDataCollDataentryService = selDataCollDataentryService;
	}




	@SuppressWarnings("unchecked")	
	public void findByDataCollDataDicId() throws IOException{
		SelDataCollDataEntryAction.setDataDic(DataCollDataDicId);
		String s=SelDataCollDataEntryAction.getDataDic();
		int a=Integer.parseInt(s);
		List<DataCollDicEntry> dataCollDataDiclList=(List<DataCollDicEntry>)selDataCollDataentryService.findByDataCollDataDicId(a);
		StringBuilder sb = new StringBuilder();
		sb.append("<select>");
		for (DataCollDicEntry dataCollDataDic : dataCollDataDiclList) {
			sb.append("<option value='");
			sb.append(dataCollDataDic.getDataCollDataDic().getDataCollDataDicId()).append("'>").append(dataCollDataDic.getDicEntryName());
			sb.append("</option>");
		}
		sb.append("</select>");
		ServletActionContext.getResponse().setContentType(
				"text/html; charset=utf-8");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		out.write(sb.toString());
	}
	

}
