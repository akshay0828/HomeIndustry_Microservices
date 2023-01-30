package com.spiceland.admin.service;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;

import com.spiceland.admin.dao.AdminDAO;
import com.spiceland.admin.entity.Orders;
import com.spiceland.admin.entity.Payment;
import com.spiceland.admin.entity.User;
import com.spiceland.admin.repo.OrdersRepo;
import com.spiceland.admin.repo.PaymentRepo;

@Service
@Transactional(propagation=Propagation.SUPPORTS)
public class AdminServiceImpl implements AdminService  {
	

	
//	@Autowired
//	private UserRepo userRepo;
	
	@Autowired
	private AdminDAO adminDAO;
	
	@Autowired 
	private OrdersRepo ordersRepo;
	

	private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);
	
	

	

//	@Override
//	public List<User> getAllByVendorFalse(){
//		return userRepo.findAllByRoleAndEnabledFalse("VENDOR");
//	}
//	@Override
//	public List<User> getAllByDeliveryFalse(){
//		return userRepo.findAllByRoleAndEnabledFalse("DELIVERY");
//		
//	}
	
	//List of orders and payment
	@Override
	public List<Orders> getAllOrdersAndPayment() {
		return ordersRepo.findAll();
		
	}
	
//	@Override
//	public User enable(String role) {
//		User u= userRepo.findByRole(role);
//		return u;
//		
//	}
//	
//	@Override
//	public void deleteUser(int id) {
//		userRepo.deleteById(id);
//	}
//	
	
	//update the user
	@Override
	public void updateUser(int id) {
		logger.info("enable the user");
		adminDAO.updateUser(id);
		logger.debug("Enable user with id = " + id);
	}
	
//	logger.info("updating Existing product");
//	Products p = productRepository.save(product);
//	logger.debug("Enable user with id = " + id);
	
	
	
}
