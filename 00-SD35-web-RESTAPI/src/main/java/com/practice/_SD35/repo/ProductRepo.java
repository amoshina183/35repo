package com.practice._SD35.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice._SD35.entities.Products;

@Repository
public interface ProductRepo extends JpaRepository<Products, Long>{

}
