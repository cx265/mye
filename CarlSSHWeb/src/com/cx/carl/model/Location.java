package com.cx.carl.model;

/**
 * Location entity. @author MyEclipse Persistence Tools
 */

public class Location implements java.io.Serializable {

	// Fields

	private Integer TId;
	private Integer TCId;
	private String latitude;
	private String longitude;

	// Constructors

	/** default constructor */
	public Location() {
	}

	/** full constructor */
	public Location(Integer TId, Integer TCId, String latitude, String longitude) {
		this.TId = TId;
		this.TCId = TCId;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	// Property accessors

	public Integer getTId() {
		return this.TId;
	}

	public void setTId(Integer TId) {
		this.TId = TId;
	}

	public Integer getTCId() {
		return this.TCId;
	}

	public void setTCId(Integer TCId) {
		this.TCId = TCId;
	}

	public String getLatitude() {
		return this.latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

}