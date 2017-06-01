package com.rural.bean;

/**
 * RoleFuncPerm entity. @author MyEclipse Persistence Tools
 */

public class RoleFuncPerm implements java.io.Serializable {

	// Fields

	private Integer roleFuncPermId;
	private SysFunc sysFunc;
	private SysRole sysRole;
	private String roleFuncPermNote;

	// Constructors

	/** default constructor */
	public RoleFuncPerm() {
	}

	/** full constructor */
	public RoleFuncPerm(SysFunc sysFunc, SysRole sysRole,
			String roleFuncPermNote) {
		this.sysFunc = sysFunc;
		this.sysRole = sysRole;
		this.roleFuncPermNote = roleFuncPermNote;
	}

	// Property accessors

	public Integer getRoleFuncPermId() {
		return this.roleFuncPermId;
	}

	public void setRoleFuncPermId(Integer roleFuncPermId) {
		this.roleFuncPermId = roleFuncPermId;
	}

	public SysFunc getSysFunc() {
		return this.sysFunc;
	}

	public void setSysFunc(SysFunc sysFunc) {
		this.sysFunc = sysFunc;
	}

	public SysRole getSysRole() {
		return this.sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}

	public String getRoleFuncPermNote() {
		return this.roleFuncPermNote;
	}

	public void setRoleFuncPermNote(String roleFuncPermNote) {
		this.roleFuncPermNote = roleFuncPermNote;
	}

}