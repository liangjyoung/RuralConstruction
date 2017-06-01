package com.rural.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * ExpertMajorCatg entity. @author MyEclipse Persistence Tools
 */

public class ExpertMajorCatg implements java.io.Serializable {

	// Fields

	private Integer expertMajorCatgId;
	private String expertMajorNum;
	private String expertMajorCatg;
	private Set evalSystInds = new HashSet(0);
	private Set experts = new HashSet(0);

	// Constructors

	/** default constructor */
	public ExpertMajorCatg() {
	}

	/** minimal constructor */
	public ExpertMajorCatg(String expertMajorNum) {
		this.expertMajorNum = expertMajorNum;
	}

	/** full constructor */
	public ExpertMajorCatg(String expertMajorNum, String expertMajorCatg,
			Set evalSystInds, Set experts) {
		this.expertMajorNum = expertMajorNum;
		this.expertMajorCatg = expertMajorCatg;
		this.evalSystInds = evalSystInds;
		this.experts = experts;
	}

	// Property accessors

	public Integer getExpertMajorCatgId() {
		return this.expertMajorCatgId;
	}

	public void setExpertMajorCatgId(Integer expertMajorCatgId) {
		this.expertMajorCatgId = expertMajorCatgId;
	}

	public String getExpertMajorNum() {
		return this.expertMajorNum;
	}

	public void setExpertMajorNum(String expertMajorNum) {
		this.expertMajorNum = expertMajorNum;
	}

	public String getExpertMajorCatg() {
		return this.expertMajorCatg;
	}

	public void setExpertMajorCatg(String expertMajorCatg) {
		this.expertMajorCatg = expertMajorCatg;
	}

	public Set getEvalSystInds() {
		return this.evalSystInds;
	}

	public void setEvalSystInds(Set evalSystInds) {
		this.evalSystInds = evalSystInds;
	}

	public Set getExperts() {
		return this.experts;
	}

	public void setExperts(Set experts) {
		this.experts = experts;
	}

}