package com.cx.carl.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Sourcemanage entity. @author MyEclipse Persistence Tools
 */

public class Sourcemanage implements java.io.Serializable {

	// Fields

	private Integer smId;
	private Course course;
	private String smName;
	private Integer smType;
	private String smPath;
	private String smUploader;
	private Timestamp smDateTime;
	private Set studenthomeworks = new HashSet(0);

	// Constructors

	/** default constructor */
	public Sourcemanage() {
	}

	/** minimal constructor */
	public Sourcemanage(Integer smId, Course course, String smName,
			Integer smType, String smPath, String smUploader,
			Timestamp smDateTime) {
		this.smId = smId;
		this.course = course;
		this.smName = smName;
		this.smType = smType;
		this.smPath = smPath;
		this.smUploader = smUploader;
		this.smDateTime = smDateTime;
	}

	/** full constructor */
	public Sourcemanage(Integer smId, Course course, String smName,
			Integer smType, String smPath, String smUploader,
			Timestamp smDateTime, Set studenthomeworks) {
		this.smId = smId;
		this.course = course;
		this.smName = smName;
		this.smType = smType;
		this.smPath = smPath;
		this.smUploader = smUploader;
		this.smDateTime = smDateTime;
		this.studenthomeworks = studenthomeworks;
	}

	// Property accessors

	public Integer getSmId() {
		return this.smId;
	}

	public void setSmId(Integer smId) {
		this.smId = smId;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getSmName() {
		return this.smName;
	}

	public void setSmName(String smName) {
		this.smName = smName;
	}

	public Integer getSmType() {
		return this.smType;
	}

	public void setSmType(Integer smType) {
		this.smType = smType;
	}

	public String getSmPath() {
		return this.smPath;
	}

	public void setSmPath(String smPath) {
		this.smPath = smPath;
	}

	public String getSmUploader() {
		return this.smUploader;
	}

	public void setSmUploader(String smUploader) {
		this.smUploader = smUploader;
	}

	public Timestamp getSmDateTime() {
		return this.smDateTime;
	}

	public void setSmDateTime(Timestamp smDateTime) {
		this.smDateTime = smDateTime;
	}

	public Set getStudenthomeworks() {
		return this.studenthomeworks;
	}

	public void setStudenthomeworks(Set studenthomeworks) {
		this.studenthomeworks = studenthomeworks;
	}

}