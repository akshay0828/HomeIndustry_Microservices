package com.spiceland.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spiceland.admin.entity.Orders;
import com.spiceland.admin.entity.Payment;
import com.spiceland.admin.entity.User;
import com.spiceland.admin.facade.UserDetailsFacade;
import com.spiceland.admin.repo.PaymentRepo;
import com.spiceland.admin.service.AdminService;
import com.spiceland.admin.service.AdminServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private PaymentRepo repo;

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private UserDetailsFacade userDetailsFacade;

	// List of orders with payment
	@GetMapping("/orders")
	public List<Orders> getOrdersAndPayment() {
		logger.info("List of orders with payment");
		return adminService.getAllOrdersAndPayment();
	}

	// List of Vendor pending for approval
	@GetMapping("/vendorApproval")
	public List<User> getAllVendors() {
        logger.info("List of vendors waiting for approval");
        return  userDetailsFacade.getAllByVendorFalse();
		 
	}

	

	// List of Delivery pending for approval
	@GetMapping("/deliveryApproval")
	public List<User> getAllDelivery() {
		 logger.info("List of delivery");
		return userDetailsFacade.getAllByDeliveryFalse();
	}

	// Approve the user
	@PostMapping("/approval/{id}")
	public String enableUser(@PathVariable("id") int id) {
		 logger.info("Approved");
		adminService.updateUser(id);
		logger.debug("Approved for id=" +id );
		return "Approved";
	}

	// Disapprove the user
	@PostMapping("/disapproval/{id}")
	public String disableUser(@PathVariable("id") int id) {
		 logger.info("DisApproved");
		userDetailsFacade.deleteUser(id);
		logger.debug("DisApproved for id=" +id );
		return "DisApproved";
	}

}
