package com.rural.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * EvalSystInd entity. @author MyEclipse Persistence Tools
 */

public class EvalSystInd implements java.io.Serializable {

	// Fields

	private String evalIndNum;
	private EvalSystInd evalSystInd;
	private EvalSyst evalSyst;
	private ExpertMajorCatg expertMajorCatg;
	private String evalIndName;
	private String evalIndSeqNum;
	private String evalIndScore;
	private boolean evalIndIsLeaf;
	private String evalIndNote;
	private Set levelsIndScos = new HashSet(0);
	private Set evalSystInds = new HashSet(0);
	private Set evalConts = new HashSet(0);

	// Constructors

	/** default constructor */
	public EvalSystInd() {
	}

	/** full constructor */
	public EvalSystInd(EvalSystInd evalSystInd, EvalSyst evalSyst,
			ExpertMajorCatg expertMajorCatg, String evalIndName,
			String evalIndSeqNum, String evalIndScore, boolean evalIndIsLeaf,
			String evalIndNote, Set evalSystInds, Set evalConts) {
		this.evalSystInd = evalSystInd;
		this.evalSyst = evalSyst;
		this.expertMajorCatg = expertMajorCatg;
		this.evalIndName = evalIndName;
		this.evalIndSeqNum = evalIndSeqNum;
		this.evalIndScore = evalIndScore;
		this.evalIndIsLeaf = evalIndIsLeaf;
		this.evalIndNote = evalIndNote;
		this.evalSystInds = evalSystInds;
		this.evalConts = evalConts;
	}

	// Property accessors

	public String getEvalIndNum() {
		return this.evalIndNum;
	}

	public void setEvalIndNum(String evalIndNum) {
		this.evalIndNum = evalIndNum;
	}

	public EvalSystInd getEvalSystInd() {
		return this.evalSystInd;
	}

	public void setEvalSystInd(EvalSystInd evalSystInd) {
		this.evalSystInd = evalSystInd;
	}

	public EvalSyst getEvalSyst() {
		return this.evalSyst;
	}

	public void setEvalSyst(EvalSyst evalSyst) {
		this.evalSyst = evalSyst;
	}

	public ExpertMajorCatg getExpertMajorCatg() {
		return this.expertMajorCatg;
	}

	public void setExpertMajorCatg(ExpertMajorCatg expertMajorCatg) {
		this.expertMajorCatg = expertMajorCatg;
	}

	public String getEvalIndName() {
		return this.evalIndName;
	}

	public void setEvalIndName(String evalIndName) {
		this.evalIndName = evalIndName;
	}

	public String getEvalIndSeqNum() {
		return this.evalIndSeqNum;
	}

	public void setEvalIndSeqNum(String evalIndSeqNum) {
		this.evalIndSeqNum = evalIndSeqNum;
	}

	public String getEvalIndScore() {
		return this.evalIndScore;
	}

	public void setEvalIndScore(String evalIndScore) {
		this.evalIndScore = evalIndScore;
	}

	public boolean getEvalIndIsLeaf() {
		return this.evalIndIsLeaf;
	}

	public void setEvalIndIsLeaf(boolean evalIndIsLeaf) {
		this.evalIndIsLeaf = evalIndIsLeaf;
	}

	public String getEvalIndNote() {
		return this.evalIndNote;
	}

	public void setEvalIndNote(String evalIndNote) {
		this.evalIndNote = evalIndNote;
	}

	public Set getEvalSystInds() {
		return this.evalSystInds;
	}

	public void setEvalSystInds(Set evalSystInds) {
		this.evalSystInds = evalSystInds;
	}

	public Set getEvalConts() {
		return this.evalConts;
	}

	public void setEvalConts(Set evalConts) {
		this.evalConts = evalConts;
	}
	public Set getLevelsIndScos() {
        return this.levelsIndScos;
    }
    
    public void setLevelsIndScos(Set levelsIndScos) {
        this.levelsIndScos = levelsIndScos;
    }

}