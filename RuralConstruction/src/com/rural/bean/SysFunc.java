package com.rural.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * SysFunc entity. @author MyEclipse Persistence Tools
 */

public class SysFunc implements java.io.Serializable {

	// Fields

	private String funcNum;
	private SysFunc sysFunc;
	private String funcName;
	private Set roleFuncPerms = new HashSet(0);
	private Set sysFuncs = new HashSet(0);

	// Constructors

	/** default constructor */
	public SysFunc() {
	}

	/** full constructor */
	public SysFunc(SysFunc sysFunc, String funcName, Set roleFuncPerms,
			Set sysFuncs) {
		this.sysFunc = sysFunc;
		this.funcName = funcName;
		this.roleFuncPerms = roleFuncPerms;
		this.sysFuncs = sysFuncs;
	}

	// Property accessors

	public String getFuncNum() {
		return this.funcNum;
	}

	public void setFuncNum(String funcNum) {
		this.funcNum = funcNum;
	}

	public SysFunc getSysFunc() {
		return this.sysFunc;
	}

	public void setSysFunc(SysFunc sysFunc) {
		this.sysFunc = sysFunc;
	}

	public String getFuncName() {
		return this.funcName;
	}

	public void setFuncName(String funcName) {
		this.funcName = funcName;
	}

	public Set getRoleFuncPerms() {
		return this.roleFuncPerms;
	}

	public void setRoleFuncPerms(Set roleFuncPerms) {
		this.roleFuncPerms = roleFuncPerms;
	}

	public Set getSysFuncs() {
		return this.sysFuncs;
	}

	public void setSysFuncs(Set sysFuncs) {
		this.sysFuncs = sysFuncs;
	}

}