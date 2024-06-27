package com.practice._SD35.services;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice._SD35.entities.Category;
import com.practice._SD35.repo.CategoryRepo;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	public List<Category> getAllCategories(){
		List<Category> c = categoryRepo.findAll();
		List<Category> result = c.stream().sorted(Comparator.comparing(Category :: getC_name)).toList();
		return result;	
	}
	
	public void saveCategory(Category c) {
		categoryRepo.save(c);
	}
	
	public void updateCategory(Long cId, Category c) {
		Category cat = getCategoryById(cId);
		cat.setC_name(c.getC_name());
		categoryRepo.save(cat);
	}
	
	public void deleteCategory(Long cId) {
		if(categoryRepo.existsById(cId)) {
			categoryRepo.deleteById(cId);
		}else {
			throw new RuntimeException("Category not available to delete");
		}
		
	}

	public Category getCategoryById(Long cId) {
		Category c = categoryRepo.findById(cId)
				.orElseThrow(() -> new RuntimeException("Category not available"));
		// TODO Auto-generated method stub
		return c;
	}

}
