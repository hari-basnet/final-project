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
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.habasnet.springdemo.dto.CategoryDTO;
import com.habasnet.springdemo.model.Category;
import com.habasnet.springdemo.service.TourCategoryPackageService;

@Controller
public class TourCategoryPackageController {

	public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/categoryImages";
	@Autowired
	private TourCategoryPackageService tourService;
	@GetMapping("/category")
	public String gotoAddTourPackageCategory(Model model) {
		model.addAttribute("categoryDTO", new CategoryDTO());
		return "addcategory";
	}
	@PostMapping("/category")
	public String addNewPackageCategory(@ModelAttribute("categoryDTO") @Valid CategoryDTO categoryDTO,BindingResult bindingResult, Model model,
			@RequestParam("productImage")MultipartFile file,
			@RequestParam("imgName")String photoName ) throws IOException {
		Category category = new Category();
		category.setId(categoryDTO.getId());
		category.setName(categoryDTO.getName());
		category.setDescription(categoryDTO.getDescription());
		String imageUUID;
		if(!file.isEmpty()) {
			imageUUID =  file.getOriginalFilename();
			Path fileNameAndPath = Paths.get(uploadDir,imageUUID);
			Files.write(fileNameAndPath, file.getBytes());
		}else {
			imageUUID = photoName;
		}
		category.setImage(imageUUID);
		if(bindingResult.hasErrors()) {
			return "addcategory";
		}else {
		tourService.addPackageCategory(category);
		model.addAttribute("msg","added successfully");
		return "redirect:/categorylist";
		}
	
	}
	@GetMapping("/categorylist")
	public String gotoTourCategoryList(Model model) {
		model.addAttribute("tourpackageCategorylist",tourService.categoryList());
		return "categorylist";
	}
	@GetMapping("/category/update/{id}")
	public String updateTourCategoryPackage(@PathVariable int id, Model model) {
		Category category = tourService.getCategoryById(id).get();
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(category.getId());
		categoryDTO.setName(category.getName());
		categoryDTO.setDescription(category.getDescription());
		categoryDTO.setImage(category.getImage());
		model.addAttribute("categoryDTO",categoryDTO);
		return "addcategory";
	}
	@GetMapping("/category/delete/{id}")
	public String deleteCategoryPackage(@PathVariable int id) {
		tourService.removeCategoryById(id);
		return "redirect:/categorylist";
	}
	
}
