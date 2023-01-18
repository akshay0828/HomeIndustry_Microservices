package com.spiceland.vendor.repo;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spiceland.vendor.entity.Products;
import com.spiceland.vendor.entity.User;



@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {
	Products findById(int id);

	List<Products> findByUser(User user);
	User findUserById(int id);

	List<Products> findByproductName(String productName);
	
	List<Integer> findUseridByproductName(String productName);
	
	Products findByIdAndUser(int id,User user);
	
	/*@Query("SELECT product_name FROM products p WHERE id=402")
	String searchProducts();*/
	
}
