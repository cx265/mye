package com.cx.carl.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	private Integer SId;
	private String SNum;
	private String SName;
	private String SSex;
	private String SDepartment;
	private String SClass;
	private String STel;
	private String SEmail;
	private String SPassword;
	private Set studentcourses = new HashSet(0);
	private Set studenthomeworks = new HashSet(0);
	private Set courseevaluations = new HashSet(0);

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(Integer SId, String SNum, String SName, String SSex,
			String SDepartment, String SClass, String STel, String SPassword) {
		this.SId = SId;
		this.SNum = SNum;
		this.SName = SName;
		this.SSex = SSex;
		this.SDepartment = SDepartment;
		this.SClass = SClass;
		this.STel = STel;
		this.SPassword = SPassword;
	}

	/** full constructor */
	public Student(Integer SId, String SNum, String SName, String SSex,
			String SDepartment, String SClass, String STel, String SEmail,
			String SPassword, Set studentcourses, Set studenthomeworks,
			Set courseevaluations) {
		this.SId = SId;
		this.SNum = SNum;
		this.SName = SName;
		this.SSex = SSex;
		this.SDepartment = SDepartment;
		this.SClass = SClass;
		this.STel = STel;
		this.SEmail = SEmail;
		this.SPassword = SPassword;
		this.studentcourses = studentcourses;
		this.studenthomeworks = studenthomeworks;
		this.courseevaluations = courseevaluations;
	}

	// Property accessors

	public Integer getSId() {
		return this.SId;
	}

	public void setSId(Integer SId) {
		this.SId = SId;
	}

	public String getSNum() {
		return this.SNum;
	}

	public void setSNum(String SNum) {
		this.SNum = SNum;
	}

	public String getSName() {
		return this.SName;
	}

	public void setSName(String SName) {
		this.SName = SName;
	}

	public String getSSex() {
		return this.SSex;
	}

	public void setSSex(String SSex) {
		this.SSex = SSex;
	}

	public String getSDepartment() {
		return this.SDepartment;
	}

	public void setSDepartment(String SDepartment) {
		this.SDepartment = SDepartment;
	}

	public String getSClass() {
		return this.SClass;
	}

	public void setSClass(String SClass) {
		this.SClass = SClass;
	}

	public String getSTel() {
		return this.STel;
	}

	public void setSTel(String STel) {
		this.STel = STel;
	}

	public String getSEmail() {
		return this.SEmail;
	}

	public void setSEmail(String SEmail) {
		this.SEmail = SEmail;
	}

	public String getSPassword() {
		return this.SPassword;
	}

	public void setSPassword(String SPassword) {
		this.SPassword = SPassword;
	}

	public Set getStudentcourses() {
		return this.studentcourses;
	}

	public void setStudentcourses(Set studentcourses) {
		this.studentcourses = studentcourses;
	}

	public Set getStudenthomeworks() {
		return this.studenthomeworks;
	}

	public void setStudenthomeworks(Set studenthomeworks) {
		this.studenthomeworks = studenthomeworks;
	}

	public Set getCourseevaluations() {
		return this.courseevaluations;
	}

	public void setCourseevaluations(Set courseevaluations) {
		this.courseevaluations = courseevaluations;
	}

}