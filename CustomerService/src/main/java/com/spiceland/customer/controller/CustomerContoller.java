package com.spiceland.customer.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spiceland.customer.entity.CartLine;
import com.spiceland.customer.entity.Orders;
import com.spiceland.customer.entity.Products;
import com.spiceland.customer.entity.User;
import com.spiceland.customer.service.CustomerService;

@RestController
@CrossOrigin(origins ="http://localhost:3000")
@RequestMapping("/api/customer")
public class CustomerContoller {
	
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/customerDetails/{id}")
	public User customerDetails(@PathVariable("id") int id){
		return customerService.getUser(id);
	}
	
	@GetMapping("/customerDetails")
	public List<User> customerDetails(){
		return customerService.getUsers();
	}
	
//	@GetMapping("/getProducts")
//	public List<Products> getProducts(){
//		
//	return customerService.getproducts();
//		
//	}
	
	@GetMapping("/getProducts")
	public List<Products> getProducts(){
		
    	return customerService.getproducts();
		
	}

	
	
	@GetMapping("/CustomerHome/{id}")
	public String userhome(@PathVariable("id") final int id, final ModelMap model ,@RequestParam(value = "text", required = false) String search) {



//		final User u = customerService.getUser(id);
//		model.addAttribute("add", u.getName());
//		model.addAttribute("user", u.getId());
//		model.addAttribute("id", id);
//		
		
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
	
	
	@GetMapping("/searchingProducts")
	public List<Products> searchingProducts(@RequestParam(value = "text", required = false) String search){
		return customerService.searchForProduct(search);
	}
	
	/*
	 * If Customer wants to update the profile Navigate to updateprofile
	 * page.
	 */
//	@GetMapping("/UpdateCustomer/{id}")
//	public String updateCustomer(@PathVariable("id") int id, Model model) {
//		model.addAttribute("user",customerService.getUser(id));
//		model.addAttribute("id", id);
//		return "/updateCustomer";
//	}
	
	
	
	@PutMapping("/UpdateCustomer/{id}")
//	public String customerUpdated(@RequestBody User user,@PathVariable("id") int id, Model model) {
//		
//		model.addAttribute("user", customerService.getUser(id));
//		model.addAttribute("id", id);
//		customerService.updateUser(user);
//		return "redirect:/CustomerHome"+id;
//	}
	public void deliveryDataPerson(@RequestBody User user, @PathVariable("id") int id, Model model) {

		 

        customerService.updateUser(user);
    }
	
	
	@GetMapping("/PreviousOrders/{id}")
	public List<Orders> previousOrders(@PathVariable("id") int id, Model model) {
		model.addAttribute("orders", customerService.getPreviousOrders(id));
		model.addAttribute("id", id);
		return customerService.getPreviousOrders(id);
	}
	
	
	@GetMapping("/SpecificProduct/{productName}")
	public List<Products> specificProduct(@PathVariable("productName") String pName, Model model) {
		model.addAttribute("vendor",  customerService.getVendorDetailsForProduct(pName));
		
		model.addAttribute("product", customerService.getProductDetailsWithSameProductName(pName));
		
		return customerService.getProductDetailsWithSameProductName(pName);
	}
	
	@GetMapping("/vendorDetailsForSpecificProduct/{productName}")
	public List<User> vendorDetailsForSpecificProduct(@PathVariable("productName") String pName, Model model){
		return customerService.getVendorDetailsForProduct(pName);
	}
	
	
	@PostMapping("/AddToCart/{id}/{productId}/{Qauntity}")
	public String addItemToCart(@PathVariable("id") int id,@PathVariable("productId") int productId,@PathVariable("Qauntity") int qauntity) {
		
		customerService.addToCart(id,productId,qauntity);
		return "af";
	}
	
	@GetMapping("/CartDetails/{id}")
	public List<CartLine> cartDetails(@PathVariable("id") int customerId, Model model) {
		
		model.addAttribute("cart", customerService.getCartDetails(customerId));
		return customerService.getCartDetails(customerId);
	}
	
	
	
	
	
	
	
	
}


