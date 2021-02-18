package com.habasnet.springdemo.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.habasnet.springdemo.model.Category;
import com.habasnet.springdemo.model.Itinerary;
import com.habasnet.springdemo.model.Location;
import com.habasnet.springdemo.model.TourPackageOption;

public class TourPackageDTO {
	@Id
	@GeneratedValue
	private int id;
//	@Column(unique = true)
	@NotEmpty(message = "Name cannot be empty")
	private String name;
	@Column(length = 3000)
	private String description;
	@NotNull
	private Long cost;
	@Size(min = 1, max = 2000, message = "Cannot be empty")
	private String include;
	@Size(min = 1, max = 2000, message = "Cannot be empty")
	private String exclude;
	@Column(nullable = true)
	private String image;
	private int categoryId;
	@CreationTimestamp
	private LocalDateTime created;
	@UpdateTimestamp
	private LocalDateTime updated;
	private List<Itinerary> itineraryList;
	private List<Location> locationList;
	private List<TourPackageOption> tourPackageOptionsList;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getCost() {
		return cost;
	}
	public void setCost(Long cost) {
		this.cost = cost;
	}
	public String getInclude() {
		return include;
	}
	public void setInclude(String include) {
		this.include = include;
	}
	public String getExclude() {
		return exclude;
	}
	public void setExclude(String exclude) {
		this.exclude = exclude;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public LocalDateTime getCreated() {
		return created;
	}
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	public LocalDateTime getUpdated() {
		return updated;
	}
	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}
	public List<Itinerary> getItineraryList() {
		return itineraryList;
	}
	public void setItineraryList(List<Itinerary> itineraryList) {
		this.itineraryList = itineraryList;
	}
	public List<Location> getLocationList() {
		return locationList;
	}
	public void setLocationList(List<Location> locationList) {
		this.locationList = locationList;
	}
	public List<TourPackageOption> getTourPackageOptionsList() {
		return tourPackageOptionsList;
	}
	public void setTourPackageOptionsList(List<TourPackageOption> tourPackageOptionsList) {
		this.tourPackageOptionsList = tourPackageOptionsList;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	
}
