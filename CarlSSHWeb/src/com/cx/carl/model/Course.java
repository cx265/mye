package com.cx.carl.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Course entity. @author MyEclipse Persistence Tools
 */

public class Course implements java.io.Serializable {

	// Fields

	private Integer CId;
	private Teacher teacher;
	private String CNum;
	private String CName;
	private Boolean CFlag;
	private Integer CPointTotalNum;
	private Set coursetimes = new HashSet(0);
	private Set sourcemanages = new HashSet(0);
	private Set courseevaluations = new HashSet(0);
	private Set studentcourses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Course() {
	}

	/** minimal constructor */
	public Course(Integer CId, Teacher teacher, String CNum, String CName,
			Boolean CFlag, Integer CPointTotalNum) {
		this.CId = CId;
		this.teacher = teacher;
		this.CNum = CNum;
		this.CName = CName;
		this.CFlag = CFlag;
		this.CPointTotalNum = CPointTotalNum;
	}

	/** full constructor */
	public Course(Integer CId, Teacher teacher, String CNum, String CName,
			Boolean CFlag, Integer CPointTotalNum, Set coursetimes,
			Set sourcemanages, Set courseevaluations, Set studentcourses) {
		this.CId = CId;
		this.teacher = teacher;
		this.CNum = CNum;
		this.CName = CName;
		this.CFlag = CFlag;
		this.CPointTotalNum = CPointTotalNum;
		this.coursetimes = coursetimes;
		this.sourcemanages = sourcemanages;
		this.courseevaluations = courseevaluations;
		this.studentcourses = studentcourses;
	}

	// Property accessors

	public Integer getCId() {
		return this.CId;
	}

	public void setCId(Integer CId) {
		this.CId = CId;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getCNum() {
		return this.CNum;
	}

	public void setCNum(String CNum) {
		this.CNum = CNum;
	}

	public String getCName() {
		return this.CName;
	}

	public void setCName(String CName) {
		this.CName = CName;
	}

	public Boolean getCFlag() {
		return this.CFlag;
	}

	public void setCFlag(Boolean CFlag) {
		this.CFlag = CFlag;
	}

	public Integer getCPointTotalNum() {
		return this.CPointTotalNum;
	}

	public void setCPointTotalNum(Integer CPointTotalNum) {
		this.CPointTotalNum = CPointTotalNum;
	}

	public Set getCoursetimes() {
		return this.coursetimes;
	}

	public void setCoursetimes(Set coursetimes) {
		this.coursetimes = coursetimes;
	}

	public Set getSourcemanages() {
		return this.sourcemanages;
	}

	public void setSourcemanages(Set sourcemanages) {
		this.sourcemanages = sourcemanages;
	}

	public Set getCourseevaluations() {
		return this.courseevaluations;
	}

	public void setCourseevaluations(Set courseevaluations) {
		this.courseevaluations = courseevaluations;
	}

	public Set getStudentcourses() {
		return this.studentcourses;
	}

	public void setStudentcourses(Set studentcourses) {
		this.studentcourses = studentcourses;
	}

}