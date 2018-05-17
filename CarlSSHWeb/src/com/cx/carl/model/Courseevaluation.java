package com.cx.carl.model;

/**
 * Courseevaluation entity. @author MyEclipse Persistence Tools
 */

public class Courseevaluation implements java.io.Serializable {

	// Fields

	private Integer ceId;
	private Course course;
	private Student student;
	private Integer ceWeekNum;
	private Integer ceQuestion1;
	private Integer ceQuestion2;
	private Integer ceQuestion3;

	// Constructors

	/** default constructor */
	public Courseevaluation() {
	}

	/** full constructor */
	public Courseevaluation(Integer ceId, Course course, Student student,
			Integer ceWeekNum, Integer ceQuestion1, Integer ceQuestion2,
			Integer ceQuestion3) {
		this.ceId = ceId;
		this.course = course;
		this.student = student;
		this.ceWeekNum = ceWeekNum;
		this.ceQuestion1 = ceQuestion1;
		this.ceQuestion2 = ceQuestion2;
		this.ceQuestion3 = ceQuestion3;
	}

	// Property accessors

	public Integer getCeId() {
		return this.ceId;
	}

	public void setCeId(Integer ceId) {
		this.ceId = ceId;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Integer getCeWeekNum() {
		return this.ceWeekNum;
	}

	public void setCeWeekNum(Integer ceWeekNum) {
		this.ceWeekNum = ceWeekNum;
	}

	public Integer getCeQuestion1() {
		return this.ceQuestion1;
	}

	public void setCeQuestion1(Integer ceQuestion1) {
		this.ceQuestion1 = ceQuestion1;
	}

	public Integer getCeQuestion2() {
		return this.ceQuestion2;
	}

	public void setCeQuestion2(Integer ceQuestion2) {
		this.ceQuestion2 = ceQuestion2;
	}

	public Integer getCeQuestion3() {
		return this.ceQuestion3;
	}

	public void setCeQuestion3(Integer ceQuestion3) {
		this.ceQuestion3 = ceQuestion3;
	}

}