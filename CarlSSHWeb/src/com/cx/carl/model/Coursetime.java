package com.cx.carl.model;

/**
 * Coursetime entity. @author MyEclipse Persistence Tools
 */

public class Coursetime implements java.io.Serializable {

	// Fields

	private Integer ctId;
	private Course course;
	private Integer ctWeekNum;
	private Integer ctWeekChoose;
	private Integer ctWeekDay;
	private Integer ctStartClass;
	private Integer ctEndClass;
	private String ctAddress;

	// Constructors

	/** default constructor */
	public Coursetime() {
	}

	/** full constructor */
	public Coursetime(Integer ctId, Course course, Integer ctWeekNum,
			Integer ctWeekChoose, Integer ctWeekDay, Integer ctStartClass,
			Integer ctEndClass, String ctAddress) {
		this.ctId = ctId;
		this.course = course;
		this.ctWeekNum = ctWeekNum;
		this.ctWeekChoose = ctWeekChoose;
		this.ctWeekDay = ctWeekDay;
		this.ctStartClass = ctStartClass;
		this.ctEndClass = ctEndClass;
		this.ctAddress = ctAddress;
	}

	// Property accessors

	public Integer getCtId() {
		return this.ctId;
	}

	public void setCtId(Integer ctId) {
		this.ctId = ctId;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Integer getCtWeekNum() {
		return this.ctWeekNum;
	}

	public void setCtWeekNum(Integer ctWeekNum) {
		this.ctWeekNum = ctWeekNum;
	}

	public Integer getCtWeekChoose() {
		return this.ctWeekChoose;
	}

	public void setCtWeekChoose(Integer ctWeekChoose) {
		this.ctWeekChoose = ctWeekChoose;
	}

	public Integer getCtWeekDay() {
		return this.ctWeekDay;
	}

	public void setCtWeekDay(Integer ctWeekDay) {
		this.ctWeekDay = ctWeekDay;
	}

	public Integer getCtStartClass() {
		return this.ctStartClass;
	}

	public void setCtStartClass(Integer ctStartClass) {
		this.ctStartClass = ctStartClass;
	}

	public Integer getCtEndClass() {
		return this.ctEndClass;
	}

	public void setCtEndClass(Integer ctEndClass) {
		this.ctEndClass = ctEndClass;
	}

	public String getCtAddress() {
		return this.ctAddress;
	}

	public void setCtAddress(String ctAddress) {
		this.ctAddress = ctAddress;
	}

}