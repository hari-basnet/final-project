package com.habasnet.springdemo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.habasnet.springdemo.dto.TourPackageDTO;
import com.habasnet.springdemo.model.TourPackage;
import com.habasnet.springdemo.service.TourCategoryPackageService;
import com.habasnet.springdemo.service.TourPackageService;

@Controller
public class TourPackageController {
	public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/TourPackageImages";
	@Autowired
	private TourCategoryPackageService tourCategory;
	@Autowired
	private TourPackageService tourPackageService;
	@GetMapping("/package")
	public String gotoAddPackage(Model model) {
		model.addAttribute("tourPackageDTO",new TourPackageDTO());
		model.addAttribute("categoryPackage", tourCategory.categoryList());
		return "addpackage";
	}
	@PostMapping("/package")
	public String addTourPackage(@ModelAttribute("tourPackageDTO") @Valid TourPackageDTO tourPackageDTO,BindingResult bindingResult, @RequestParam("productImage")MultipartFile file,
			@RequestParam("imgName")String photoName, RedirectAttributes redirectAttributes) throws IOException {
		TourPackage tourPackage = new TourPackage();
		tourPackage.setId(tourPackageDTO.getId());
		tourPackage.setName(tourPackageDTO.getName());
		tourPackage.setDescription(tourPackageDTO.getDescription());
		tourPackage.setInclude(tourPackageDTO.getInclude());
		tourPackage.setExclude(tourPackageDTO.getExclude());
		tourPackage.setCost(tourPackageDTO.getCost());
		tourPackage.setCategory(tourCategory.getCategoryById(tourPackageDTO.getCategoryId()).get());
		String imageUUID;
		if(!file.isEmpty()) {
			imageUUID =  file.getOriginalFilename();
			Path fileNameAndPath = Paths.get(uploadDir,imageUUID);
			Files.write(fileNameAndPath, file.getBytes());
		}else {
			imageUUID = photoName;
		}
		tourPackage.setImage(imageUUID);
		if(bindingResult.hasErrors()) {
			return "addpackage";
		}else {
		tourPackageService.addTourPackage(tourPackage);
		redirectAttributes.addFlashAttribute("message","Package added successfully!!");
		return "redirect:/packagelist";
		}
	}
	@GetMapping("/packagelist")
	public String gotoPackagelist(Model model) {
		model.addAttribute("packageList", tourPackageService.getPackageList());
		return "tourpackagelist";
	}
	@GetMapping("/package/delete/{id}")
	public String deletePackage(@PathVariable int id,RedirectAttributes redirectAttributes) {
		tourPackageService.removePackageById(id);
		redirectAttributes.addFlashAttribute("deleteMessage","Package deleted successfully!!");
		return "redirect:/packagelist";
	}
	@GetMapping("/package/{id}")
	public String updatePackage(@PathVariable int id, Model model) {
		TourPackage tourPackage = tourPackageService.getTourPackageById(id).get();
		TourPackageDTO tourPackageDTO = new TourPackageDTO();
		tourPackageDTO.setId(tourPackage.getId());
		tourPackageDTO.setName(tourPackage.getName());
		tourPackageDTO.setDescription(tourPackage.getDescription());
		tourPackageDTO.setExclude(tourPackage.getExclude());
		tourPackageDTO.setInclude(tourPackage.getInclude());
		tourPackageDTO.setImage(tourPackage.getImage());
		tourPackageDTO.setCost(tourPackage.getCost());
		tourPackageDTO.setCategoryId(tourPackage.getCategory().getId());
		
		model.addAttribute("categoryPackage", tourCategory.categoryList());
		model.addAttribute("tourPackageDTO",tourPackageDTO);
		return "addpackage";
	}

}
