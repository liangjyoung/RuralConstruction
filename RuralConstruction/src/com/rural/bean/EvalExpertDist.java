package com.rural.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * EvalExpertDist entity. @author MyEclipse Persistence Tools
 */

public class EvalExpertDist implements java.io.Serializable {

	// Fields

	private Integer evalExpertDistId;
	private VilEvalSco vilEvalSco;
	private Expert expert;
	private boolean isSub;
	private String evalExpertDistNote;
	private Set expertGras = new HashSet(0);

	// Constructors

	/** default constructor */
	public EvalExpertDist() {
	}

	/** full constructor */
	public EvalExpertDist(VilEvalSco vilEvalSco, Expert expert, boolean isSub,
			String evalExpertDistNote, Set expertGras) {
		this.vilEvalSco = vilEvalSco;
		this.expert = expert;
		this.isSub = isSub;
		this.evalExpertDistNote = evalExpertDistNote;
		this.expertGras = expertGras;
	}

	// Property accessors

	public Integer getEvalExpertDistId() {
		return this.evalExpertDistId;
	}

	public void setEvalExpertDistId(Integer evalExpertDistId) {
		this.evalExpertDistId = evalExpertDistId;
	}

	public VilEvalSco getVilEvalSco() {
		return this.vilEvalSco;
	}

	public void setVilEvalSco(VilEvalSco vilEvalSco) {
		this.vilEvalSco = vilEvalSco;
	}

	public Expert getExpert() {
		return this.expert;
	}

	public void setExpert(Expert expert) {
		this.expert = expert;
	}

	public boolean getIsSub() {
		return this.isSub;
	}

	public void setIsSub(boolean isSub) {
		this.isSub = isSub;
	}

	public String getEvalExpertDistNote() {
		return this.evalExpertDistNote;
	}

	public void setEvalExpertDistNote(String evalExpertDistNote) {
		this.evalExpertDistNote = evalExpertDistNote;
	}

	public Set getExpertGras() {
		return this.expertGras;
	}

	public void setExpertGras(Set expertGras) {
		this.expertGras = expertGras;
	}

}