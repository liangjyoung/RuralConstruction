package com.rural.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * ExamMeth entity. @author MyEclipse Persistence Tools
 */

public class ExamMeth implements java.io.Serializable {

	// Fields

	private Integer examMethId;
	private String examMethCode;
	private String examMethName;
	private String examMethNote;
	private Set evalConts = new HashSet(0);

	// Constructors

	/** default constructor */
	public ExamMeth() {
	}

	/** full constructor */
	public ExamMeth(String examMethCode, String examMethName,
			String examMethNote, Set evalConts) {
		this.examMethCode = examMethCode;
		this.examMethName = examMethName;
		this.examMethNote = examMethNote;
		this.evalConts = evalConts;
	}

	// Property accessors

	public Integer getExamMethId() {
		return this.examMethId;
	}

	public void setExamMethId(Integer examMethId) {
		this.examMethId = examMethId;
	}

	public String getExamMethCode() {
		return this.examMethCode;
	}

	public void setExamMethCode(String examMethCode) {
		this.examMethCode = examMethCode;
	}

	public String getExamMethName() {
		return this.examMethName;
	}

	public void setExamMethName(String examMethName) {
		this.examMethName = examMethName;
	}

	public String getExamMethNote() {
		return this.examMethNote;
	}

	public void setExamMethNote(String examMethNote) {
		this.examMethNote = examMethNote;
	}

	public Set getEvalConts() {
		return this.evalConts;
	}

	public void setEvalConts(Set evalConts) {
		this.evalConts = evalConts;
	}

}