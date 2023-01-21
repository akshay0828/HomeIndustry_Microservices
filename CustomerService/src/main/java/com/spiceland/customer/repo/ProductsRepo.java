package com.spiceland.customer.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spiceland.customer.entity.Products;

@Repository
public interface ProductsRepo extends JpaRepository<Products, Integer>{
	
	List<Products> findByProductName(String pName);

}
