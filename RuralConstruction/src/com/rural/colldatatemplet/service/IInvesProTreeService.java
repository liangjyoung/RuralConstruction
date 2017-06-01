package com.rural.colldatatemplet.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rural.bean.InvesPro;
import com.rural.tool.Criterion;

public interface IInvesProTreeService {
	
	public abstract ArrayList<HashMap<String, Object>> findAll();
	public abstract List<InvesPro> getChildPermissions( String parentId );  
	public abstract List<InvesPro> getChildInvesPro( String parentId );  
	public abstract List<InvesPro> getChildInvesPro(  );
	public boolean addPro(String proNum,String proName,String sv);
	public List<InvesPro> findAllPro();
	public String delInvesPro(String invesProNum);
	public boolean checkProNumCode(String invesProNum);
}
