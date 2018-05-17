package com.cx.carl.model;

import java.sql.Timestamp;

/**
 * Studenthomework entity. @author MyEclipse Persistence Tools
 */

public class Studenthomework implements java.io.Serializable {

	// Fields

	private Integer shId;
	private Student student;
	private Sourcemanage sourcemanage;
	private String shName;
	private String shPath;
	private Integer shScore;
	private Timestamp shDateTime;

	// Constructors

	/** default constructor */
	public Studenthomework() {
	}

	/** full constructor */
	public Studenthomework(Integer shId, Student student,
			Sourcemanage sourcemanage, String shName, String shPath,
			Integer shScore, Timestamp shDateTime) {
		this.shId = shId;
		this.student = student;
		this.sourcemanage = sourcemanage;
		this.shName = shName;
		this.shPath = shPath;
		this.shScore = shScore;
		this.shDateTime = shDateTime;
	}

	// Property accessors

	public Integer getShId() {
		return this.shId;
	}

	public void setShId(Integer shId) {
		this.shId = shId;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Sourcemanage getSourcemanage() {
		return this.sourcemanage;
	}

	public void setSourcemanage(Sourcemanage sourcemanage) {
		this.sourcemanage = sourcemanage;
	}

	public String getShName() {
		return this.shName;
	}

	public void setShName(String shName) {
		this.shName = shName;
	}

	public String getShPath() {
		return this.shPath;
	}

	public void setShPath(String shPath) {
		this.shPath = shPath;
	}

	public Integer getShScore() {
		return this.shScore;
	}

	public void setShScore(Integer shScore) {
		this.shScore = shScore;
	}

	public Timestamp getShDateTime() {
		return this.shDateTime;
	}

	public void setShDateTime(Timestamp shDateTime) {
		this.shDateTime = shDateTime;
	}

}