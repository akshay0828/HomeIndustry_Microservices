package com.spicland.delivery.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spicland.delivery.entity.Orders;
import com.spicland.delivery.entity.Products;
import com.spicland.delivery.entity.User;
import com.spicland.delivery.service.OrderService;

@RestController
@RequestMapping("/api/delivery")
@CrossOrigin("http://localhost:3000")
public class DeliveryController {

	@Autowired
	private com.spicland.delivery.service.UserDetailsService service;

	@Autowired
	private OrderService orderService;

	private static final Logger logger = LoggerFactory.getLogger(DeliveryController.class);

	String location;

	
	@GetMapping("/getData")
	public ResponseEntity<String> getData() {
		return new ResponseEntity<>("Hello World!", HttpStatus.OK);
	}

	@GetMapping("/getUserData/{id}")
	public User getUserData(@PathVariable("id") int id, Model model) {
		return service.getuser(id);
	}

	@PutMapping("/UpdateDeliveryPerson/{id}")
	public void deliveryDataPerson(@RequestBody User user, @PathVariable("id") int id, Model model) {

		service.updateUser(user);
	}

	@GetMapping("/getAllOrders/{id}")
	public List<Orders> getOrderDetails() {
		return orderService.findAll();
	}
	
	@GetMapping("/getOrdersAllByArea/{status}")
	public List<String> getOrderAllByArea(@PathVariable("status") String status) {
		List<Orders> orders = orderService.FindByStatus(status);
		ArrayList<String> address = new ArrayList<>();
		for(Orders order :orders){
			if(address.contains(order.getArea())) {
				continue;
			}
			address.add(order.getArea());
			
		}
		return address;
	}
	@GetMapping("/getProducts")
	public List<Products> getProducts() {
		return service.findAllProducts();
	}


	@GetMapping("/getOrdersByArea/{id}")
	public List<Orders> getOrdersByArea(@PathVariable("id") int id,@RequestParam("address") String loc){
		return orderService.FindByArea(loc);
	}
	
	@GetMapping("/getOrdersByAreaAndStatus/{id}")
	public List<Orders> getOrdersByAreaAndStatus(@PathVariable("id") int id,@RequestParam("address") String loc,
			@RequestParam("status") String status){
		
		return orderService.getOrdersByAreaAndStatus(loc,status);
	}
	
	
	@GetMapping("/acceptOrder/{vendor_id}/{customer_id}")
	public List<String> getAddressDetails(@PathVariable("vendor_id") int vendor_id,@PathVariable("customer_id") int cust_id){
		User vendor=service.getuser(vendor_id);
		User customer=service.getuser(cust_id);
		String vendor_add=vendor.getAddress();
		String cust_add=customer.getAddress();
		ArrayList<String> address = new ArrayList<>();
		address.add("This is Vendor-Address :"+vendor_add+" "
				+ "From Where You have to collect the products "+"And this is his Contact Number is -");
		address.add("Vendor-Contact  "+vendor.getContact()+"                                      ");
		address.add("This is Customer-Address :"+cust_add+" Where You Have To Deliver the Order And this is his Contact Number -");
		
		address.add("Customer-Contact  "+customer.getContact());
		System.out.println(address);
		return address;
	}
	
	@PutMapping("/updateStatus/{id}")
	public void updateStatus(@PathVariable("id") int id,@RequestBody Orders order) {
		order.setId(id);
		orderService.updateStatus(order);
		
	}

//	@GetMapping("/acceptorder/{id}/{userid}")
//	public String acceptorders(@PathVariable("id") int id, Model model, @PathVariable("userid") int userid) {
//		logger.info("Accepting orders placed by customer");
//		model.addAttribute("deliver", service.getByid(id));
//		model.addAttribute("user", service.getByid(userid));
//		logger.debug("Accepted order with the " + id + " from the customer with the id " + userid);
//		return "delivery/acceptorder";
//	}

}
