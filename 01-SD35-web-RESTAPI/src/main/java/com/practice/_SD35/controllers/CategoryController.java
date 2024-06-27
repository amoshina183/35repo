package com.practice._SD35.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice._SD35.entities.Category;
import com.practice._SD35.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/getAll")
	public List<Category> findCategory(){
		List<Category> cat = categoryService.getAllCategories();
		return cat;
	}
	
	@GetMapping("/getById/{cId}")
	public Category findCategoryById(@PathVariable Long cId){
		Category cat = categoryService.getCategoryById(cId);
		return cat;
	}
	
	@PostMapping
	public void saveCategory(@RequestBody Category c) {
		categoryService.saveCategory(c);
		
	}
	
	
	@PutMapping("{cId}")
	public void updateCategory(@PathVariable Long cId, @RequestBody Category c) {
		categoryService.updateCategory(cId, c);
	}
	
	
	@DeleteMapping("{cId}")
	public void deleteCategory(@PathVariable Long cId) {
		categoryService.deleteCategory(cId);
	}
}