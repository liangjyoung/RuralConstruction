package com.rural.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * EvalContSubSco entity. @author MyEclipse Persistence Tools
 */

public class EvalContSubSco implements java.io.Serializable {

	// Fields

	private Integer evalScoId;
	private VilEvalSco vilEvalSco;
	private EvalCont evalCont;
	private String autoEvalSco;
	private String expertEvalContTotGra;
	private String vilEvalContTotGra;
	private String evalMeth;
	private Set prmtMeases = new HashSet(0);

	// Constructors

	/** default constructor */
	public EvalContSubSco() {
	}

	/** full constructor */
	public EvalContSubSco(VilEvalSco vilEvalSco, EvalCont evalCont,
			String autoEvalSco, String expertEvalContTotGra,
			String vilEvalContTotGra, String evalMeth, Set prmtMeases) {
		this.vilEvalSco = vilEvalSco;
		this.evalCont = evalCont;
		this.autoEvalSco = autoEvalSco;
		this.expertEvalContTotGra = expertEvalContTotGra;
		this.vilEvalContTotGra = vilEvalContTotGra;
		this.evalMeth = evalMeth;
		this.prmtMeases = prmtMeases;
	}

	// Property accessors

	public Integer getEvalScoId() {
		return this.evalScoId;
	}

	public void setEvalScoId(Integer evalScoId) {
		this.evalScoId = evalScoId;
	}

	public VilEvalSco getVilEvalSco() {
		return this.vilEvalSco;
	}

	public void setVilEvalSco(VilEvalSco vilEvalSco) {
		this.vilEvalSco = vilEvalSco;
	}

	public EvalCont getEvalCont() {
		return this.evalCont;
	}

	public void setEvalCont(EvalCont evalCont) {
		this.evalCont = evalCont;
	}

	public String getAutoEvalSco() {
		return this.autoEvalSco;
	}

	public void setAutoEvalSco(String autoEvalSco) {
		this.autoEvalSco = autoEvalSco;
	}

	public String getExpertEvalContTotGra() {
		return this.expertEvalContTotGra;
	}

	public void setExpertEvalContTotGra(String expertEvalContTotGra) {
		this.expertEvalContTotGra = expertEvalContTotGra;
	}

	public String getVilEvalContTotGra() {
		return this.vilEvalContTotGra;
	}

	public void setVilEvalContTotGra(String vilEvalContTotGra) {
		this.vilEvalContTotGra = vilEvalContTotGra;
	}

	public String getEvalMeth() {
		return this.evalMeth;
	}

	public void setEvalMeth(String evalMeth) {
		this.evalMeth = evalMeth;
	}

	public Set getPrmtMeases() {
		return this.prmtMeases;
	}

	public void setPrmtMeases(Set prmtMeases) {
		this.prmtMeases = prmtMeases;
	}

}