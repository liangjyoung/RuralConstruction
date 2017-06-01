package com.rural.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * EvalSystState entity. @author MyEclipse Persistence Tools
 */

public class EvalSystState implements java.io.Serializable {

	// Fields

	private Integer evalSystStateId;
	private String evalSystStateNum;
	private String evalSystStateDes;
	private Set evalSysts = new HashSet(0);

	// Constructors

	/** default constructor */
	public EvalSystState() {
	}

	/** minimal constructor */
	public EvalSystState(String evalSystStateNum) {
		this.evalSystStateNum = evalSystStateNum;
	}

	/** full constructor */
	public EvalSystState(String evalSystStateNum, String evalSystStateDes,
			Set evalSysts) {
		this.evalSystStateNum = evalSystStateNum;
		this.evalSystStateDes = evalSystStateDes;
		this.evalSysts = evalSysts;
	}

	// Property accessors

	public Integer getEvalSystStateId() {
		return this.evalSystStateId;
	}

	public void setEvalSystStateId(Integer evalSystStateId) {
		this.evalSystStateId = evalSystStateId;
	}

	public String getEvalSystStateNum() {
		return this.evalSystStateNum;
	}

	public void setEvalSystStateNum(String evalSystStateNum) {
		this.evalSystStateNum = evalSystStateNum;
	}

	public String getEvalSystStateDes() {
		return this.evalSystStateDes;
	}

	public void setEvalSystStateDes(String evalSystStateDes) {
		this.evalSystStateDes = evalSystStateDes;
	}

	public Set getEvalSysts() {
		return this.evalSysts;
	}

	public void setEvalSysts(Set evalSysts) {
		this.evalSysts = evalSysts;
	}

}