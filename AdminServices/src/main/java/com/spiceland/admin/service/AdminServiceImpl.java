package com.spiceland.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spiceland.admin.dao.AdminDAO;
import com.spiceland.admin.entity.Orders;
import com.spiceland.admin.entity.Payment;
import com.spiceland.admin.entity.User;
import com.spiceland.admin.repo.OrdersRepo;
import com.spiceland.admin.repo.PaymentRepo;
import com.spiceland.admin.repo.UserRepo;

@Service
@Transactional(propagation=Propagation.SUPPORTS)
public class AdminServiceImpl implements AdminService  {
	

	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private AdminDAO adminDAO;
	

	

	@Override
	public List<User> getAllByVendorFalse(){
		return userRepo.findAllByRole("VENDOR");
	}
	@Override
	public List<User> getAllByDeliveryFalse(){
		return userRepo.findAllByRole("DELIVERY");
		
	}
	@Override
	public List<Payment> getAllPayment() {
		return adminDAO.findAllPayment();
		
	}
	
	@Override
	public User enable(String role) {
		User u= userRepo.findByRole(role);
		return u;
		
	}
	
	

	
	
	
}
