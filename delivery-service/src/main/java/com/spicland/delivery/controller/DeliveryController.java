package com.spicland.delivery.controller;

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
import org.springframework.web.bind.annotation.RestController;

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

	@GetMapping("/deliveryHome/{id}")
	public String deliveryDashBoard() {
		return "dashboard";
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
		model.addAttribute("user",service.getuser(id));
		model.addAttribute("id", id);
		return "/update";
	}
	@PutMapping("/UpdateDeliveryPerson/{id}")
	public String deliveryDataPerson(@RequestBody User user,@PathVariable("id") int id, Model model) {
		
		model.addAttribute("user", service.getuser(id));
		model.addAttribute("id", id);
		service.updateUser(user);
		return "redirect:/DeliveryHome"+id;
	}

}
