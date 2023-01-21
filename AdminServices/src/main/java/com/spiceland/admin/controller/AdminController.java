package com.spiceland.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spiceland.admin.dao.AdminDAO;
import com.spiceland.admin.entity.Orders;
import com.spiceland.admin.entity.Payment;
import com.spiceland.admin.entity.User;
import com.spiceland.admin.repo.UserRepo;
import com.spiceland.admin.service.AdminService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private AdminDAO adminDAO;



	@GetMapping("/payment")
	public List<Payment> getPaymentDetails() {

		return adminDAO.findAllPayment();
	}

	@GetMapping("/vendorApproval")
	public List<User> getAllVendors() {

		return adminService.getAllByVendorFalse();
	}

	@GetMapping("/deliveryApproval")
	public List<User> getAllDelivery() {

		return adminService.getAllByDeliveryFalse();
	}
	
	
	@PostMapping("/approval")
	public String enableUser(@RequestBody User u){
//		u.setEnabled(true);
		System.out.println(u);
		adminDAO.updateUser(u);
		return "Approved";
	}
	
	@PutMapping("/dissapproval")
	public String dissableUser(@RequestBody User u){
		u.setEnabled(false);
		return "DissApproved";
	}

}
