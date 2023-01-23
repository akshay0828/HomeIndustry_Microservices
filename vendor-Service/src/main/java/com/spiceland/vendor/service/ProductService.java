package com.spiceland.vendor.service;

import java.util.List;

import com.spiceland.vendor.entity.Products;
import com.spiceland.vendor.entity.User;


public interface ProductService {

	void createProduct(Products products);

	Products getProduct(int id);

	List<Products> getAllProducts();

	Products updateProduct(Products product);

	User getuserbyid(int id);

	List<Products> getAllproductsbyuser(User user);

	void deleteProduct(int id);

	List<Products> getProductsbyproductname(String productName);

	List<Integer> getuseridbyproductname(String productName);

	void productUpdate(Products pro,int id)
			throws Exception;

	List<Products> searchForProduct(String search);

	
	


}