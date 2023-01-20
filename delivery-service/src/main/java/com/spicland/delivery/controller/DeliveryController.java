package com.spicland.delivery.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spicland.delivery.entity.Orders;
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

	@GetMapping("/deliveryHome/{id}")
	public String deliveryhome(@PathVariable("id") int id, ModelMap model) {
		logger.info("Navigating towards delivery dashboard");
		model.addAttribute("user", service.getuser(id));
		List<Orders> orders = orderService.findAll();
		ArrayList<Integer> customerIds = new ArrayList<>();

		if (orders.size() > 0) {
			logger.debug("The number of orders received is " + orders.size());

			for (Orders order : orders) {

				if (customerIds.contains(order.getUser_id())) {
					logger.info("No Entry of duplicate location available in drop-down ");
				} else {
					customerIds.add(order.getUser_id());
					logger.info("Entry of new location into the drop-down");
				}
			}
		}

		ArrayList<String> address = new ArrayList<>();

		for (int i = 0; i < customerIds.size(); i++) {

			User user = service.getByid(customerIds.get(i));

			address.add(user.getArea());

		}

		model.addAttribute("address", address);

		logger.debug("Currently available orders based on location is/are " + address);

		return "delivery/deliverhome";
	}

	@GetMapping("/getData")
	public ResponseEntity<String> getData() {
		return new ResponseEntity<>("Hello World!", HttpStatus.OK);
	}

	@GetMapping("/getUserData/{id}")
	public User getUserData(@PathVariable("id") int id, Model model) {
		return service.getuser(id);
	}

	@GetMapping("/UpdateDeliveryPerson/{id}")
	public String updateDelivery(@PathVariable("id") int id, Model model) {
		model.addAttribute("user", service.getuser(id));
		model.addAttribute("id", id);
		return "/update";
	}

	@PutMapping("/UpdateDeliveryPerson/{id}")
	public void deliveryDataPerson(@RequestBody User user, @PathVariable("id") int id, Model model) {

		service.updateUser(user);
	}

	@GetMapping("/getAllOrders/{id}")
	public List<Orders> getOrderDetails() {
		return orderService.findAll();
	}

	@GetMapping("/getOrders/{id}")
	public String getOrders(@PathVariable("id") int id, @RequestParam("address") String loc, Model model) {
		model.addAttribute("user", service.getByid(id));
		location = loc;
		model.addAttribute("Orders", orderService.FindByArea(loc));
		logger.debug("Location " + loc);
		return "delivery/getOrders";
	}

	@GetMapping("/acceptorder/{id}/{userid}")
	public String acceptorders(@PathVariable("id") int id, Model model, @PathVariable("userid") int userid) {
		logger.info("Accepting orders placed by customer");
		model.addAttribute("deliver", service.getByid(id));
		model.addAttribute("user", service.getByid(userid));
		logger.debug("Accepted order with the " + id + " from the customer with the id " + userid);
		return "delivery/acceptorder";
	}

}
