package com.rural.tool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.rural.tool.Criterion.CompareType;

public abstract class JqGridBaseAction extends ActionSupport {
	private static final long serialVersionUID = -6665165581107324487L;
	private Integer rows = 0;
	protected Integer page = 0;
	protected Integer total = 0;
	protected Integer records = 0;
	private String sord;
	private String sidx;
	protected List<HashMap<String, Object>> results = Collections.emptyList();

	// (1)添加和查询有关的成员变量search、searchField、searchString、searchOper
	protected boolean search;
	private String searchField;
	private String searchString;
	private String searchOper;

	public abstract int getResultSize();
	public abstract List<HashMap<String, Object>> listResults(int from, int length);
	
	public static String getOrderColoumn;
	public static String getOrderRule;
	 // (1)添加filters成员变量  
    private String filters;  
    //AND OR 操作
    protected String groupOp;
	// (2)添加用于根据条件进行查询的方法
	public abstract int getResultSize(List<Criterion> criteria);

	public abstract List<HashMap<String, Object>> listResults(List<Criterion> criteria, int from, int length);

	public void refreshGridModel() {
		try {
			//排序规则
			getOrderColoumn = sidx;
			getOrderRule = sord;
			
			List<Criterion> criteria = new ArrayList<Criterion>();
			// (3)如果search值为true，则表明是查询请求
			if (search) {
				criteria = new ArrayList<Criterion>();
				// (2)将Filter转化为Criterion列表，并加入总的Criterion列表  
                if(filters != null && filters.length()>0) {  
                    criteria.addAll(this.generateSearchCriteriaFromFilters(filters));  
                }  
                // (3)将searchField、searchString、searchOper转化为Criterion，并加入总的Criterion列表  
                Criterion criterion = this.generateSearchCriterion(searchField, searchString, searchOper,groupOp);  
                if(criterion != null) {  
                    criteria.add(criterion);  
                }  
			}

			int from = rows * (page - 1);
			int length = rows;

			if (criteria.size() != 0) { // (5)如果criteria列表不为空，则根据条件进行查询
				records = this.getResultSize(criteria);
				results = this.listResults(criteria, from, length);
			} else {
				records = this.getResultSize();
				results = this.listResults(from, length);
			}
			total = (int) Math.ceil((double) records / (double) rows);
		} catch (Exception e) {
			//System.out.println(e.toString());
			e.printStackTrace();
			this.addActionError(e.getMessage());
		}
	}

	// (6)通过searchField、searchString、searchOper三个参数生成Criterion的方法
	public Criterion generateSearchCriterion(String searchField, String searchString, String searchOper, String groupOp) {
		Criterion criterion = null;
		// (7)如果searchField、searchString、searchOper均不为null，且searchString不为空字符串时，则创建Criterion
		if (searchField != null && searchString != null & searchString.length() > 0 && searchOper != null) {
			if ("eq".equals(searchOper)) {
				criterion = Criterion.getEqualCriterion(searchField,searchString, null,groupOp);
			} else if ("ne".equals(searchOper)) {
				criterion = Criterion.getCompareCriterion(CompareType.NE,searchField, searchString, null,groupOp);
			} else if ("lt".equals(searchOper)) {
				criterion = Criterion.getCompareCriterion(CompareType.LT,searchField, searchString, null,groupOp);
			} else if ("le".equals(searchOper)) {
				criterion = Criterion.getCompareCriterion(CompareType.LTE,searchField, searchString, null,groupOp);
			} else if ("gt".equals(searchOper)) {
				criterion = Criterion.getCompareCriterion(CompareType.GT,searchField, searchString, null,groupOp);
			} else if ("ge".equals(searchOper)) {
				criterion = Criterion.getCompareCriterion(CompareType.GTE,searchField, searchString, null,groupOp);
			} else if ("bw".equals(searchOper)) {
				criterion = Criterion.getLikeCriterion(searchField,searchString + "%", null,groupOp);
			} else if ("bn".equals(searchOper)) {
				criterion = Criterion.getNotLikeCriterion(searchField,searchString + "%", null,groupOp);
			} else if ("ew".equals(searchOper)) {
				criterion = Criterion.getLikeCriterion(searchField, "%"+ searchString, null,groupOp);
			} else if ("en".equals(searchOper)) {
				criterion = Criterion.getNotLikeCriterion(searchField, "%"+ searchString, null,groupOp);
			} else if ("cn".equals(searchOper)) {
				criterion = Criterion.getLikeCriterion(searchField, "%"+ searchString + "%", null,groupOp);
			} else if ("nc".equals(searchOper)) {
				criterion = Criterion.getNotLikeCriterion(searchField, "%"+ searchString + "%", null,groupOp);
			}
		}
		return criterion;
	}

	public List<Criterion> generateSearchCriteriaFromFilters(String filters) {
		List<Criterion> criteria = new ArrayList<Criterion>();
		JSONObject jsonObject = JSONObject.fromObject(filters);
		groupOp = jsonObject.getString("groupOp");
		JSONArray rules = jsonObject.getJSONArray("rules");
		for (Object obj : rules) {
			JSONObject rule = (JSONObject) obj;
			String field = rule.getString("field");
			String op = rule.getString("op");
			String data = rule.getString("data");
			Criterion criterion = this.generateSearchCriterion(field, data, op,groupOp);
			if (criterion != null) {
				criteria.add(criterion);
			}
		}
		return criteria;
	}

	// getter和setter
	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getRecords() {
		return records;
	}

	public void setRecords(Integer records) {
		this.records = records;
	}

	public String getSord() {
		return sord;
	}

	public void setSord(String sord) {
		this.sord = sord;
	}

	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public boolean isSearch() {
		return search;
	}

	public void setSearch(boolean search) {
		this.search = search;
	}

	public String getSearchField() {
		return searchField;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public String getSearchOper() {
		return searchOper;
	}

	public void setSearchOper(String searchOper) {
		this.searchOper = searchOper;
	}

	public String getFilters() {
		return filters;
	}

	public void setFilters(String filters) {
		this.filters = filters;
	}
}
