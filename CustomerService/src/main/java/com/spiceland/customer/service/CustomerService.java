package com.spiceland.customer.service;

import java.util.List;

import com.spiceland.customer.entity.CartLine;
import com.spiceland.customer.entity.Orders;
import com.spiceland.customer.entity.Products;
import com.spiceland.customer.entity.User;

public interface CustomerService {

	User getUser(int id);

	void updateUser(User user);

	List<Orders> getPreviousOrders(int id);

	List<Products> getproducts();

	List<Products> searchForProduct(String search);

	List<User> getVendorDetailsForProduct(String pName);

	List<Products> getProductDetailsWithSameProductName(String pName);

	List<CartLine> getCartDetails(int customerId);
	
	List<User>  getUsers();

}