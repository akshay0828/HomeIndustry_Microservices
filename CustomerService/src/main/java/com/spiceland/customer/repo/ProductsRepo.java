package com.spiceland.customer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spiceland.customer.entity.Products;

@Repository
public interface ProductsRepo extends JpaRepository<Products, Integer>{

}
