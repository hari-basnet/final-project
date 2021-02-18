package com.habasnet.springdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.habasnet.springdemo.model.TourPackage;
import com.habasnet.springdemo.repository.TourPackageRepository;

@Service
public class TourPackageService {
	@Autowired
	private TourPackageRepository tourPackageRepository;
	
	public TourPackage addTourPackage(TourPackage tourPackage) {
		return tourPackageRepository.save(tourPackage);
	}

	 
	public Optional<TourPackage> getTourPackageById(int id){
		return tourPackageRepository.findById(id);
	}
	public List<TourPackage> getPackageList(){
		return tourPackageRepository.findAll();
	}


	public void removePackageById(int id) {
		tourPackageRepository.deleteById(id);
		
	}
}
