package com.habasnet.springdemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Location {
	@Id
	@GeneratedValue
	private Long id;
	@NotNull(message = "Location name cannnot be null")
	private String locationName;
	@Column(length = 2000)
	private String about;
	private String image;
	private int status;
	private String locationMap;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getLocationMap() {
		return locationMap;
	}
	public void setLocationMap(String locationMap) {
		this.locationMap = locationMap;
	}
	
}
