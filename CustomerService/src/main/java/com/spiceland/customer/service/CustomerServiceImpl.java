package com.spiceland.customer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spiceland.customer.dao.UserDAO;
import com.spiceland.customer.entity.Orders;
import com.spiceland.customer.entity.Products;
import com.spiceland.customer.entity.User;
import com.spiceland.customer.repo.OrdersRepo;
import com.spiceland.customer.repo.ProductsRepo;
import com.spiceland.customer.repo.UserRepo;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private UserDAO userdao;
	
	@Autowired
	private ProductsRepo productsRepo;
	
	@Autowired
	private OrdersRepo ordersRepo;
	
	@Override
	public User getUser(int id) {
		User u = userRepo.getById(id);
		return u;
	}

	@Override
	public void updateUser(User user) {
		userdao.updateUserDao(user.getName(), user.getContact(), user.getAddress(), user.getArea(),  user.getId());
		
	}

	@Override
	public List<Orders> getPreviousOrders(int id) {
		return  ordersRepo.findByUser_id(id);
		 
	}

	@Override
	public List<Products> getproducts() {
		List<Products> pro=new ArrayList<>();
		List<Products> allPro=productsRepo.findAll();
		for (Products products : allPro) {
			for (Products products2 : pro) {
				if(products2.getProductName().equals(products.getProductName())) {
					break;
					
				}
				else {
					pro.add(products);
				}
			}
		}
		return pro;
	}
	@Override
	public List<Products> searchForProduct(String search) {
		List<Products> prod=new ArrayList<>();
		List<Products> pro=getproducts();
		String serach1=search.toUpperCase();
		for (Products products : pro) {
			if(products.getProductName().equals(serach1)) {
			prod.add(products);
			}	
		}
//		,BeanPropertyRowMapper.newInstance(Products.class)
	return 	prod;
	}

	@Override
	public void getVendorDetailsForProduct(String pName) {
		// TODO Auto-generated method stub
		
	}
}
