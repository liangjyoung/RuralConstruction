package com.rural.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * EvalSyst entity. @author MyEclipse Persistence Tools
 */

public class EvalSyst implements java.io.Serializable {

	// Fields

	private Integer evalSystId;
	private EvalSystState evalSystState;
	private String evalSystName;
	private Date startime;
	private Date endtime;
	private String evalSystNote;
	private Set evalSystInds = new HashSet(0);

	// Constructors

	/** default constructor */
	public EvalSyst() {
	}

	/** minimal constructor */
	public EvalSyst(EvalSystState evalSystState) {
		this.evalSystState = evalSystState;
	}

	/** full constructor */
	public EvalSyst(EvalSystState evalSystState, String evalSystName,
			Date startime, Date endtime, String evalSystNote, Set evalSystInds) {
		this.evalSystState = evalSystState;
		this.evalSystName = evalSystName;
		this.startime = startime;
		this.endtime = endtime;
		this.evalSystNote = evalSystNote;
		this.evalSystInds = evalSystInds;
	}

	// Property accessors

	public Integer getEvalSystId() {
		return this.evalSystId;
	}

	public void setEvalSystId(Integer evalSystId) {
		this.evalSystId = evalSystId;
	}

	public EvalSystState getEvalSystState() {
		return this.evalSystState;
	}

	public void setEvalSystState(EvalSystState evalSystState) {
		this.evalSystState = evalSystState;
	}

	public String getEvalSystName() {
		return this.evalSystName;
	}

	public void setEvalSystName(String evalSystName) {
		this.evalSystName = evalSystName;
	}

	public Date getStartime() {
		return this.startime;
	}

	public void setStartime(Date startime) {
		this.startime = startime;
	}

	public Date getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public String getEvalSystNote() {
		return this.evalSystNote;
	}

	public void setEvalSystNote(String evalSystNote) {
		this.evalSystNote = evalSystNote;
	}

	public Set getEvalSystInds() {
		return this.evalSystInds;
	}

	public void setEvalSystInds(Set evalSystInds) {
		this.evalSystInds = evalSystInds;
	}

}