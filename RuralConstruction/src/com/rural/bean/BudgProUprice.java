package com.rural.bean;

/**
 * BudgProUprice entity. @author MyEclipse Persistence Tools
 */

public class BudgProUprice implements java.io.Serializable {

	// Fields

	private Integer budgProUpriceId;
	private BudgProCatg budgProCatg;
	private String budgProUpriceNum;
	private String budgProName;
	private double budgProUprice;
	private String budgProUpriceComp;
	private String budgProUpriceExpl;

	// Constructors

	/** default constructor */
	public BudgProUprice() {
	}

	/** minimal constructor */
	public BudgProUprice(String budgProUpriceNum) {
		this.budgProUpriceNum = budgProUpriceNum;
	}

	/** full constructor */
	public BudgProUprice(BudgProCatg budgProCatg, String budgProUpriceNum,
			String budgProName, double budgProUprice, String budgProUpriceComp,
			String budgProUpriceExpl) {
		this.budgProCatg = budgProCatg;
		this.budgProUpriceNum = budgProUpriceNum;
		this.budgProName = budgProName;
		this.budgProUprice = budgProUprice;
		this.budgProUpriceComp = budgProUpriceComp;
		this.budgProUpriceExpl = budgProUpriceExpl;
	}

	// Property accessors

	public Integer getBudgProUpriceId() {
		return this.budgProUpriceId;
	}

	public void setBudgProUpriceId(Integer budgProUpriceId) {
		this.budgProUpriceId = budgProUpriceId;
	}

	public BudgProCatg getBudgProCatg() {
		return this.budgProCatg;
	}

	public void setBudgProCatg(BudgProCatg budgProCatg) {
		this.budgProCatg = budgProCatg;
	}

	public String getBudgProUpriceNum() {
		return this.budgProUpriceNum;
	}

	public void setBudgProUpriceNum(String budgProUpriceNum) {
		this.budgProUpriceNum = budgProUpriceNum;
	}

	public String getBudgProName() {
		return this.budgProName;
	}

	public void setBudgProName(String budgProName) {
		this.budgProName = budgProName;
	}

	public double getBudgProUprice() {
		return this.budgProUprice;
	}

	public void setBudgProUprice(double budgProUprice) {
		this.budgProUprice = budgProUprice;
	}

	public String getBudgProUpriceComp() {
		return this.budgProUpriceComp;
	}

	public void setBudgProUpriceComp(String budgProUpriceComp) {
		this.budgProUpriceComp = budgProUpriceComp;
	}

	public String getBudgProUpriceExpl() {
		return this.budgProUpriceExpl;
	}

	public void setBudgProUpriceExpl(String budgProUpriceExpl) {
		this.budgProUpriceExpl = budgProUpriceExpl;
	}

}