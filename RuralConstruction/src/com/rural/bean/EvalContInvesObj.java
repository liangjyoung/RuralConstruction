package com.rural.bean;

/**
 * EvalContInvesObj entity. @author MyEclipse Persistence Tools
 */

public class EvalContInvesObj implements java.io.Serializable {

	// Fields

	private Integer evalContInvesObjId;
	private InvesObj invesObj;
	private EvalCont evalCont;
	private boolean isMus;
	private String evalContInvesObjScorValu;
	private String evalContInvesObjNote;

	// Constructors

	/** default constructor */
	public EvalContInvesObj() {
	}

	/** minimal constructor */
	public EvalContInvesObj(String evalContInvesObjScorValu) {
		this.evalContInvesObjScorValu = evalContInvesObjScorValu;
	}

	/** full constructor */
	public EvalContInvesObj(InvesObj invesObj, EvalCont evalCont,
			boolean isMus, String evalContInvesObjScorValu,
			String evalContInvesObjNote) {
		this.invesObj = invesObj;
		this.evalCont = evalCont;
		this.isMus = isMus;
		this.evalContInvesObjScorValu = evalContInvesObjScorValu;
		this.evalContInvesObjNote = evalContInvesObjNote;
	}

	// Property accessors

	public Integer getEvalContInvesObjId() {
		return this.evalContInvesObjId;
	}

	public void setEvalContInvesObjId(Integer evalContInvesObjId) {
		this.evalContInvesObjId = evalContInvesObjId;
	}

	public InvesObj getInvesObj() {
		return this.invesObj;
	}

	public void setInvesObj(InvesObj invesObj) {
		this.invesObj = invesObj;
	}

	public EvalCont getEvalCont() {
		return this.evalCont;
	}

	public void setEvalCont(EvalCont evalCont) {
		this.evalCont = evalCont;
	}

	public boolean getIsMus() {
		return this.isMus;
	}

	public void setIsMus(boolean isMus) {
		this.isMus = isMus;
	}

	public String getEvalContInvesObjScorValu() {
		return this.evalContInvesObjScorValu;
	}

	public void setEvalContInvesObjScorValu(String evalContInvesObjScorValu) {
		this.evalContInvesObjScorValu = evalContInvesObjScorValu;
	}

	public String getEvalContInvesObjNote() {
		return this.evalContInvesObjNote;
	}

	public void setEvalContInvesObjNote(String evalContInvesObjNote) {
		this.evalContInvesObjNote = evalContInvesObjNote;
	}

}