package com.habasnet.springdemo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String description;
	@OneToMany(mappedBy = "category")
	private List<Package> listofPackage;
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
	public List<Package> getListofPackage() {
		return listofPackage;
	}
	public void setListofPackage(List<Package> listofPackage) {
		this.listofPackage = listofPackage;
	}
	

}
