package com.spicland.delivery.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spicland.delivery.entity.Products;
@Repository
public interface productsRepo extends JpaRepository<Products, Integer> {

	
}
