package com.habasnet.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.habasnet.springdemo.model.Category;

@Repository
public interface TourCategoryPackageRepository  extends JpaRepository<Category, Integer>{

}
