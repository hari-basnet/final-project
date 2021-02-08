package com.habasnet.springdemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Itinerary {
	@Id
	@GeneratedValue
	@Column(nullable = false, updatable = false)
	private Long id;
	@NotNull(message = "Title cannot be null")
	@Column(unique = true)
	private String title;
	@NotNull
	private int day_no;
	@Column(length = 3000)
	private String description;
	@Column(nullable = true)
	private String image;
	@ManyToOne
	@JoinColumn(name="tourpackage_id")
	private TourPackage tourPackage;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getDay_no() {
		return day_no;
	}
	public void setDay_no(int day_no) {
		this.day_no = day_no;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public TourPackage getTourPackage() {
		return tourPackage;
	}
	public void setTourPackage(TourPackage tourPackage) {
		this.tourPackage = tourPackage;
	}
	
	
}
