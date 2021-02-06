package com.habasnet.springdemo.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class TourPackage {
	@Id
	@GeneratedValue
	private Long id;
	@Column(unique = true)
	private String name;
	@Column(length = 3000)
	private String description;
	@NotNull
	private Long cost;
	private String include;
	private String exclude;
	@Column(nullable = true)
	private String image;
	
	@CreationTimestamp
	private LocalDateTime created;
	@UpdateTimestamp
	private LocalDateTime updated;
	@OneToMany(mappedBy = "tourPackage", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Itinerary> itineraryList;
	
	@OneToMany(targetEntity = Location.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "tourpackage_id",referencedColumnName = "id")
	private List<Location> locationList;
	@OneToMany(targetEntity = TourPackageOption.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "tourpackage_id",referencedColumnName = "id")
	private List<TourPackageOption> tourPackageOptionsList;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	
	

}
