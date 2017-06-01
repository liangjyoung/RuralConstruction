package com.rural.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * EvalCont entity. @author MyEclipse Persistence Tools
 */

public class EvalCont implements java.io.Serializable {

	// Fields

	private Integer evalContId;
	private ExamMeth examMeth;
	private EvalSystInd evalSystInd;
	private String evalContNum;
	private String evalContDes;
	private String evalContScore;
	private String bulReq;
	private String evalContScorMeth;
	private String subjObjecValu;
	private String evalContSeqNum;
	private String evalContNote;
	private Set evalContInvesObjs = new HashSet(0);
	private Set evalContSubScos = new HashSet(0);

	// Constructors

	/** default constructor */
	public EvalCont() {
	}

	/** minimal constructor */
	public EvalCont(String evalContNum) {
		this.evalContNum = evalContNum;
	}

	/** full constructor */
	public EvalCont(ExamMeth examMeth, EvalSystInd evalSystInd,
			String evalContNum, String evalContDes, String evalContScore,
			String bulReq, String evalContScorMeth, String subjObjecValu,
			String evalContSeqNum, String evalContNote, Set evalContInvesObjs,
			Set evalContSubScos) {
		this.examMeth = examMeth;
		this.evalSystInd = evalSystInd;
		this.evalContNum = evalContNum;
		this.evalContDes = evalContDes;
		this.evalContScore = evalContScore;
		this.bulReq = bulReq;
		this.evalContScorMeth = evalContScorMeth;
		this.subjObjecValu = subjObjecValu;
		this.evalContSeqNum = evalContSeqNum;
		this.evalContNote = evalContNote;
		this.evalContInvesObjs = evalContInvesObjs;
		this.evalContSubScos = evalContSubScos;
	}

	// Property accessors

	public Integer getEvalContId() {
		return this.evalContId;
	}

	public void setEvalContId(Integer evalContId) {
		this.evalContId = evalContId;
	}

	public ExamMeth getExamMeth() {
		return this.examMeth;
	}

	public void setExamMeth(ExamMeth examMeth) {
		this.examMeth = examMeth;
	}

	public EvalSystInd getEvalSystInd() {
		return this.evalSystInd;
	}

	public void setEvalSystInd(EvalSystInd evalSystInd) {
		this.evalSystInd = evalSystInd;
	}

	public String getEvalContNum() {
		return this.evalContNum;
	}

	public void setEvalContNum(String evalContNum) {
		this.evalContNum = evalContNum;
	}

	public String getEvalContDes() {
		return this.evalContDes;
	}

	public void setEvalContDes(String evalContDes) {
		this.evalContDes = evalContDes;
	}

	public String getEvalContScore() {
		return this.evalContScore;
	}

	public void setEvalContScore(String evalContScore) {
		this.evalContScore = evalContScore;
	}

	public String getBulReq() {
		return this.bulReq;
	}

	public void setBulReq(String bulReq) {
		this.bulReq = bulReq;
	}

	public String getEvalContScorMeth() {
		return this.evalContScorMeth;
	}

	public void setEvalContScorMeth(String evalContScorMeth) {
		this.evalContScorMeth = evalContScorMeth;
	}

	public String getSubjObjecValu() {
		return this.subjObjecValu;
	}

	public void setSubjObjecValu(String subjObjecValu) {
		this.subjObjecValu = subjObjecValu;
	}

	public String getEvalContSeqNum() {
		return this.evalContSeqNum;
	}

	public void setEvalContSeqNum(String evalContSeqNum) {
		this.evalContSeqNum = evalContSeqNum;
	}

	public String getEvalContNote() {
		return this.evalContNote;
	}

	public void setEvalContNote(String evalContNote) {
		this.evalContNote = evalContNote;
	}

	public Set getEvalContInvesObjs() {
		return this.evalContInvesObjs;
	}

	public void setEvalContInvesObjs(Set evalContInvesObjs) {
		this.evalContInvesObjs = evalContInvesObjs;
	}

	public Set getEvalContSubScos() {
		return this.evalContSubScos;
	}

	public void setEvalContSubScos(Set evalContSubScos) {
		this.evalContSubScos = evalContSubScos;
	}

}