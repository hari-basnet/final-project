package com.habasnet.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.habasnet.springdemo.model.TourPackage;
@Repository
public interface TourPackageRepository extends JpaRepository<TourPackage, Integer> {

}
