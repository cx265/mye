package com.cx.carl.model;

import java.sql.Timestamp;

/**
 * Note entity. @author MyEclipse Persistence Tools
 */

public class Note implements java.io.Serializable {

	// Fields

	private Integer NId;
	private Teacher teacher;
	private String NReceive;
	private String NContent;
	private Timestamp NDatetime;

	// Constructors

	/** default constructor */
	public Note() {
	}

	/** full constructor */
	public Note(Integer NId, Teacher teacher, String NReceive, String NContent,
			Timestamp NDatetime) {
		this.NId = NId;
		this.teacher = teacher;
		this.NReceive = NReceive;
		this.NContent = NContent;
		this.NDatetime = NDatetime;
	}

	// Property accessors

	public Integer getNId() {
		return this.NId;
	}

	public void setNId(Integer NId) {
		this.NId = NId;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getNReceive() {
		return this.NReceive;
	}

	public void setNReceive(String NReceive) {
		this.NReceive = NReceive;
	}

	public String getNContent() {
		return this.NContent;
	}

	public void setNContent(String NContent) {
		this.NContent = NContent;
	}

	public Timestamp getNDatetime() {
		return this.NDatetime;
	}

	public void setNDatetime(Timestamp NDatetime) {
		this.NDatetime = NDatetime;
	}

}