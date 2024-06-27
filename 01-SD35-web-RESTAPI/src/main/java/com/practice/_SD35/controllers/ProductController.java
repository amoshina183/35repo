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
import org.springframework.web.bind.annotation.RestController;

import com.practice._SD35.entities.Products;
import com.practice._SD35.services.ProductService;

@RestController
@RequestMapping("/arsh/products")
public class ProductController {
	
	@Autowired
	public ProductService productService;
	
	
	@PostMapping("/saveProducts")
	public void saveAllProducts(@RequestBody Products product) {
		System.out.println("Product name: "+product.getName());
		productService.saveAllProducts(product);
		
	}
	
	//https://localhost:8080/arsh/products/getProducts
	@GetMapping("/getProducts")
	public List<Products> getAllProducts(){
		List<Products> p = productService.getAllProductsService();
		return p;
	}
	
	@PutMapping("{pid}")
	public void updateProducts(@PathVariable Long pid,@PathVariable Products p) {
		Products prod = productService.getProductById(pid);
		prod.setName(p.getName());
		prod.getCategory().setC_name(p.getCategory().getC_name());
		productService.saveAllProducts(prod);
		
	}
	

	@DeleteMapping("{pid}")
	public void deleteProducts(@PathVariable Long pid) {
		productService.deleteProduct(pid);
		
	}
	
	@GetMapping("/name/{pname}")
	public Products findByName(@PathVariable String pname) {
		return productService.getProductsByName(pname);
		
		
	}
	
}
