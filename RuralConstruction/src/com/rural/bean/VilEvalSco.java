package com.rural.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * VilEvalSco entity. @author MyEclipse Persistence Tools
 */

public class VilEvalSco implements java.io.Serializable {

	// Fields

	private Integer vilEvalScoId;
	private VilDataCollRec vilDataCollRec;
	private ScoLev scoLev;
	private String expertEvalTotGra;
	private String autoEvalTotGra;
	private String vilEvalTotGra;
	private String vilEvalScoNote;
	private Set evalContSubScos = new HashSet(0);
	private Set evalExpertDists = new HashSet(0);

	// Constructors

	/** default constructor */
	public VilEvalSco() {
	}

	/** full constructor */
	public VilEvalSco(VilDataCollRec vilDataCollRec, String expertEvalTotGra,
			String autoEvalTotGra, String vilEvalTotGra, String vilEvalScoNote,
			Set evalContSubScos, Set evalExpertDists) {
		this.vilDataCollRec = vilDataCollRec;
		this.expertEvalTotGra = expertEvalTotGra;
		this.autoEvalTotGra = autoEvalTotGra;
		this.vilEvalTotGra = vilEvalTotGra;
		this.vilEvalScoNote = vilEvalScoNote;
		this.evalContSubScos = evalContSubScos;
		this.evalExpertDists = evalExpertDists;
	}

	// Property accessors

	public Integer getVilEvalScoId() {
		return this.vilEvalScoId;
	}

	public void setVilEvalScoId(Integer vilEvalScoId) {
		this.vilEvalScoId = vilEvalScoId;
	}

	public VilDataCollRec getVilDataCollRec() {
		return this.vilDataCollRec;
	}

	public void setVilDataCollRec(VilDataCollRec vilDataCollRec) {
		this.vilDataCollRec = vilDataCollRec;
	}
	
	public ScoLev getScoLev() {
        return this.scoLev;
    }
    
    public void setScoLev(ScoLev scoLev) {
        this.scoLev = scoLev;
    }

	public String getExpertEvalTotGra() {
		return this.expertEvalTotGra;
	}

	public void setExpertEvalTotGra(String expertEvalTotGra) {
		this.expertEvalTotGra = expertEvalTotGra;
	}

	public String getAutoEvalTotGra() {
		return this.autoEvalTotGra;
	}

	public void setAutoEvalTotGra(String autoEvalTotGra) {
		this.autoEvalTotGra = autoEvalTotGra;
	}

	public String getVilEvalTotGra() {
		return this.vilEvalTotGra;
	}

	public void setVilEvalTotGra(String vilEvalTotGra) {
		this.vilEvalTotGra = vilEvalTotGra;
	}

	public String getVilEvalScoNote() {
		return this.vilEvalScoNote;
	}

	public void setVilEvalScoNote(String vilEvalScoNote) {
		this.vilEvalScoNote = vilEvalScoNote;
	}

	public Set getEvalContSubScos() {
		return this.evalContSubScos;
	}

	public void setEvalContSubScos(Set evalContSubScos) {
		this.evalContSubScos = evalContSubScos;
	}

	public Set getEvalExpertDists() {
		return this.evalExpertDists;
	}

	public void setEvalExpertDists(Set evalExpertDists) {
		this.evalExpertDists = evalExpertDists;
	}

}