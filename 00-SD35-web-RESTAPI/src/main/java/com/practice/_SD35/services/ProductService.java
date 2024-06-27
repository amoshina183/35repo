package com.practice._SD35.services;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice._SD35.entities.Products;
import com.practice._SD35.repo.ProductRepo;


@Service
public class ProductService {
	
	@Autowired
	public ProductRepo productRepo;
	
	public List<Products> getAllProductsService(){
		List<Products> p = productRepo.findAll();
		p.stream().sorted(Comparator.comparing(Products :: getName));
		return p;
	}
	
	public void saveAllProducts(Products product) {
		productRepo.save(product);
	}
	
	public Products findProductsById(Long productId) {
		Products p = productRepo.findById(productId)
					.orElseThrow(() -> new RuntimeException());
		return p;
		
	}
	
	public void deleteProduct(Long productId) {
		Products p = findProductsById(productId);
		
		if(p.getProductId() != null) {
			productRepo.deleteById(productId);
		
		}
		else {
			throw new RuntimeException("Product Id not found");
		}
		
	}
	
	public void updateProduct() {
		
	}
	
	

}
