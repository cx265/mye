package com.cx.carl.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Teacher entity. @author MyEclipse Persistence Tools
 */

public class Teacher implements java.io.Serializable {

	// Fields

	private Integer TId;
	private String TNum;
	private String TName;
	private String TDepartment;
	private String TTel;
	private String TEmail;
	private String TPassword;
	private Set notes = new HashSet(0);
	private Set courses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Teacher() {
	}

	/** minimal constructor */
	public Teacher(Integer TId, String TNum, String TName, String TDepartment,
			String TPassword) {
		this.TId = TId;
		this.TNum = TNum;
		this.TName = TName;
		this.TDepartment = TDepartment;
		this.TPassword = TPassword;
	}

	/** full constructor */
	public Teacher(Integer TId, String TNum, String TName, String TDepartment,
			String TTel, String TEmail, String TPassword, Set notes, Set courses) {
		this.TId = TId;
		this.TNum = TNum;
		this.TName = TName;
		this.TDepartment = TDepartment;
		this.TTel = TTel;
		this.TEmail = TEmail;
		this.TPassword = TPassword;
		this.notes = notes;
		this.courses = courses;
	}

	// Property accessors

	public Integer getTId() {
		return this.TId;
	}

	public void setTId(Integer TId) {
		this.TId = TId;
	}

	public String getTNum() {
		return this.TNum;
	}

	public void setTNum(String TNum) {
		this.TNum = TNum;
	}

	public String getTName() {
		return this.TName;
	}

	public void setTName(String TName) {
		this.TName = TName;
	}

	public String getTDepartment() {
		return this.TDepartment;
	}

	public void setTDepartment(String TDepartment) {
		this.TDepartment = TDepartment;
	}

	public String getTTel() {
		return this.TTel;
	}

	public void setTTel(String TTel) {
		this.TTel = TTel;
	}

	public String getTEmail() {
		return this.TEmail;
	}

	public void setTEmail(String TEmail) {
		this.TEmail = TEmail;
	}

	public String getTPassword() {
		return this.TPassword;
	}

	public void setTPassword(String TPassword) {
		this.TPassword = TPassword;
	}

	public Set getNotes() {
		return this.notes;
	}

	public void setNotes(Set notes) {
		this.notes = notes;
	}

	public Set getCourses() {
		return this.courses;
	}

	public void setCourses(Set courses) {
		this.courses = courses;
	}

}