package com.spiceland.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spiceland.admin.entity.Orders;
import com.spiceland.admin.entity.Payment;
import com.spiceland.admin.service.AdminService;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/api/orders")
	public List<Orders> getOrderDetails(){
		return adminService.getAllOrders();
		
	}
	

	@GetMapping("/api/payments")
	public List<Payment> getPaymentDetails(){
		return adminService.getAllPayments();
	}

}
