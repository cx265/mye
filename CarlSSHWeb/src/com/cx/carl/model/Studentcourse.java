package com.cx.carl.model;

/**
 * Studentcourse entity. @author MyEclipse Persistence Tools
 */

public class Studentcourse implements java.io.Serializable {

	// Fields

	private Integer scId;
	private Student student;
	private Course course;
	private Integer scPointNum;
	private Integer scPointTotalNum;

	// Constructors

	/** default constructor */
	public Studentcourse() {
	}

	/** full constructor */
	public Studentcourse(Integer scId, Student student, Course course,
			Integer scPointNum, Integer scPointTotalNum) {
		this.scId = scId;
		this.student = student;
		this.course = course;
		this.scPointNum = scPointNum;
		this.scPointTotalNum = scPointTotalNum;
	}

	// Property accessors

	public Integer getScId() {
		return this.scId;
	}

	public void setScId(Integer scId) {
		this.scId = scId;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Integer getScPointNum() {
		return this.scPointNum;
	}

	public void setScPointNum(Integer scPointNum) {
		this.scPointNum = scPointNum;
	}

	public Integer getScPointTotalNum() {
		return this.scPointTotalNum;
	}

	public void setScPointTotalNum(Integer scPointTotalNum) {
		this.scPointTotalNum = scPointTotalNum;
	}

}