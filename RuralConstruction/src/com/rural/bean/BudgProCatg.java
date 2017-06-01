package com.rural.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * BudgProCatg entity. @author MyEclipse Persistence Tools
 */

public class BudgProCatg implements java.io.Serializable {

	// Fields

	private String budgProCatgNum;
	private BudgProCatg budgProCatg;
	private String budgProCatgDes;
	private Set budgProUprices = new HashSet(0);
	private Set budgProCatgs = new HashSet(0);

	// Constructors

	/** default constructor */
	public BudgProCatg() {
	}

	/** full constructor */
	public BudgProCatg(BudgProCatg budgProCatg, String budgProCatgDes,
			Set budgProUprices, Set budgProCatgs) {
		this.budgProCatg = budgProCatg;
		this.budgProCatgDes = budgProCatgDes;
		this.budgProUprices = budgProUprices;
		this.budgProCatgs = budgProCatgs;
	}

	// Property accessors

	public String getBudgProCatgNum() {
		return this.budgProCatgNum;
	}

	public void setBudgProCatgNum(String budgProCatgNum) {
		this.budgProCatgNum = budgProCatgNum;
	}

	public BudgProCatg getBudgProCatg() {
		return this.budgProCatg;
	}

	public void setBudgProCatg(BudgProCatg budgProCatg) {
		this.budgProCatg = budgProCatg;
	}

	public String getBudgProCatgDes() {
		return this.budgProCatgDes;
	}

	public void setBudgProCatgDes(String budgProCatgDes) {
		this.budgProCatgDes = budgProCatgDes;
	}

	public Set getBudgProUprices() {
		return this.budgProUprices;
	}

	public void setBudgProUprices(Set budgProUprices) {
		this.budgProUprices = budgProUprices;
	}

	public Set getBudgProCatgs() {
		return this.budgProCatgs;
	}

	public void setBudgProCatgs(Set budgProCatgs) {
		this.budgProCatgs = budgProCatgs;
	}

}