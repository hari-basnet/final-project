package com.habasnet.springdemo.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

public class CategoryDTO {
	private int id;
	@NotEmpty(message = "Name should not be empty")
	private String name;

	@Column(length = 3000)
	@NotEmpty(message = "Description should not be empty")
	private String description;
	@Column(nullable = true)
	private String image;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
}
