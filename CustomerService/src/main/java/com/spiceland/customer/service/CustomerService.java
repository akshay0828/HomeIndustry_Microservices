package com.spiceland.customer.service;

import java.util.List;

import com.spiceland.customer.entity.CartLine;
import com.spiceland.customer.entity.Orders;
import com.spiceland.customer.entity.Payment;
import com.spiceland.customer.entity.Products;
import com.spiceland.customer.entity.User;

public interface CustomerService {

//	User getUser(int id);

//	void updateUser(User user);

	List<Orders> getPreviousOrders(int id);

	List<Products> getproducts();

	List<Products> searchForProduct(String search);

//	List<User> getVendorDetailsForProduct(String pName);

	List<Products> getProductDetailsWithSameProductName(String pName);

	List<CartLine> getCartDetails(int customerId);
	
//	List<User>  getUsers();

	void addToCart(int id, int productId, int qauntity);

	void removeItemFromCart(int cartId);

	void changeQaunity(int cartId, int qauntity);

	void paymentSucces(int customerId, Payment payment);

	List<Orders> getAllOrders();

	String totalAmonut(int id);

	void decreaseByOne(int cartId);

	void increaseByOne(int cartId);


}