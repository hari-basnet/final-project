package com.habasnet.springdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.habasnet.springdemo.model.Category;
import com.habasnet.springdemo.repository.TourCategoryPackageRepository;

@Service
public class TourCategoryPackageService {
	@Autowired
	private TourCategoryPackageRepository tourRepo;

	public Category addPackageCategory(Category category) {
		return tourRepo.save(category);
	}

	public List<Category> categoryList() {
		return tourRepo.findAll();
	}

	public Optional<Category> getCategoryById(int id) {
		return tourRepo.findById(id);

	}
	public void removeCategoryById(int id) {
		tourRepo.deleteById(id);
	}
	
}
