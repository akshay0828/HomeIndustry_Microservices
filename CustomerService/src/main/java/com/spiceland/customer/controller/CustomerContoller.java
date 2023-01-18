package com.spiceland.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spiceland.customer.entity.User;
import com.spiceland.customer.service.CustomerService;

@RestController
public class CustomerContoller {
	
	@Autowired
	private CustomerService customerService;
	
	

	
	
	@GetMapping("/CustomerHome/{id}")
	public String userhome(@PathVariable("id") final int id, final ModelMap model ,@RequestParam(value = "text", required = false) String search) {



		final User u = customerService.getUser(id);
		model.addAttribute("add", u.getName());
		model.addAttribute("user", u.getId());
		model.addAttribute("id", id);
		
		
		model.addAttribute("products", customerService.getproducts());
		
		if(search==null){
			model.addAttribute("products", customerService.getproducts());
//		model.addAttribute("Products", productservice.getAllProducts());
		}
		else if(customerService.searchForProduct(search).isEmpty()){
			model.addAttribute("error", "The Product you have searched is not in List");
		}
		else{
			model.addAttribute("Products", customerService.searchForProduct(search));
		}
//		model.addAttribute("users", service.getAlluser());

		return "CustomerHome";
	}
	
	/*
	 * If Customer wants to update the profile Navigate to updateprofile
	 * page.
	 */
	@GetMapping("/UpdateCustomer/{id}")
	public String updateCustomer(@PathVariable("id") int id, Model model) {
		model.addAttribute("user",customerService.getUser(id));
		model.addAttribute("id", id);
		return "/updateCustomer";
	}
	
	
	
	@PutMapping("/UpdateCustomer/{id}")
	public String customerUpdated(@RequestBody User user,@PathVariable("id") int id, Model model) {
		
		model.addAttribute("user", customerService.getUser(id));
		model.addAttribute("id", id);
		customerService.updateUser(user);
		return "redirect:/CustomerHome"+id;
	}
	
	
	@GetMapping("/PreviousOrders/{id}")
	public String previousOrders(@PathVariable("id") int id, Model model) {
		model.addAttribute("orders", customerService.getPreviousOrders(id));
		model.addAttribute("id", id);
		return "PreviousOrders";
	}
	
	
	@GetMapping("/SpecificProduct/{id}/{productName}")
	public String specificProduct(@PathVariable("id") int id, @PathVariable("productName") String pName, Model model) {
		customerService.getVendorDetailsForProduct(pName);
		return "abc";
	}
	
	
	
	
	
}


