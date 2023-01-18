package com.spiceland.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spiceland.admin.entity.Orders;
import com.spiceland.admin.entity.Payment;
import com.spiceland.admin.repo.OrdersRepo;
import com.spiceland.admin.repo.PaymentRepo;

@Service
@Transactional(propagation=Propagation.SUPPORTS)
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private OrdersRepo ordersRepo;
	
	@Autowired
	private PaymentRepo paymentRepo;
	
	public List<Orders> getAllOrders(){
		return ordersRepo.findAll();
	}
	
	public List<Payment> getAllPayments(){
		return paymentRepo.findAll();
	}

}
