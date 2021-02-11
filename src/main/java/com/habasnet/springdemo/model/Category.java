package com.habasnet.springdemo.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Category {
	@Id
	@GeneratedValue
	private int id;
	@NotEmpty(message = "Name should not be empty")
	private String name;
	@Column(length = 3000)
	@NotEmpty(message = "Description should not be empty")
	private String description;
	@OneToMany(targetEntity = TourPackage.class, cascade = CascadeType.ALL )
	@JoinColumn(name = "category_id", referencedColumnName = "id")
	private List<TourPackage> tourPackageList;
	@Column(nullable = true)
	private String image;
	@CreationTimestamp
	private LocalDateTime created;
	@UpdateTimestamp
	private LocalDateTime updated;

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
	public List<TourPackage> getTourPackageList() {
		return tourPackageList;
	}
	public void setTourPackageList(List<TourPackage> tourPackageList) {
		this.tourPackageList = tourPackageList;
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
	

}
