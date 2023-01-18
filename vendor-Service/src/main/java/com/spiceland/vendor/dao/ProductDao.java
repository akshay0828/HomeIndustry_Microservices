package com.spiceland.vendor.dao;

import java.util.List;

import com.spiceland.vendor.entity.Products;


public interface ProductDao {

	void productUpdateDao(String productName, Double price, Float weight, int quantity, String productDescription, int id)
			throws Exception;

	void deleteProductDao(int id);

	List<Products> searchForProductDao(String search);

}