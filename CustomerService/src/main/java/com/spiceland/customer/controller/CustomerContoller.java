package com.spiceland.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spiceland.customer.entity.CartLine;
import com.spiceland.customer.entity.Orders;
import com.spiceland.customer.entity.Payment;
import com.spiceland.customer.entity.Products;
import com.spiceland.customer.entity.User;
import com.spiceland.customer.facade.ProductsFacade;
import com.spiceland.customer.facade.UserDetailsFacade;
import com.spiceland.customer.service.CustomerService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/customer")
public class CustomerContoller {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private UserDetailsFacade userDetailsFacade;
	@Autowired
	private ProductsFacade productsFacade;

	@GetMapping("/customerDetails/{id}")
	public User customerDetails(@PathVariable("id") int id) {
		return userDetailsFacade.getUser(id);
	}

	// @GetMapping("/customerDetails")
	// public List<User> customerDetails(){
	// return customerService.getUsers();
	// }
	//
	// @GetMapping("/getProducts")
	// public List<Products> getProducts(){
	//
	// return customerService.getproducts();
	//
	// }

	@GetMapping("/getProducts")
	public List<Products> getProducts() {

		return customerService.getproducts();

	}

	@GetMapping("/searchingProducts")
	public List<Products> searchingProducts(@RequestParam(value = "text", required = false) String search) {
		return customerService.searchForProduct(search);
	}

	// @PutMapping("/UpdateCustomer/{id}")
	// public void deliveryDataPerson(@RequestBody User user,
	// @PathVariable("id") int id, Model model) {
	//
	//
	//
	// customerService.updateUser(user);
	// }

	@GetMapping("/PreviousOrders/{id}")
	public List<Orders> previousOrders(@PathVariable("id") int id, Model model) {
		model.addAttribute("orders", customerService.getPreviousOrders(id));
		model.addAttribute("id", id);
		return customerService.getPreviousOrders(id);
	}

	@GetMapping("/SpecificProduct/{productName}")
	public List<Products> specificProduct(@PathVariable("productName") String pName, Model model) {

		return customerService.getProductDetailsWithSameProductName(pName);
	}

	@GetMapping("/vendorDetailsForSpecificProduct/{productName}")
	public List<User> vendorDetailsForSpecificProduct(@PathVariable("productName") String pName, Model model) {
		return productsFacade.getVendorDetailsForProduct(pName);
	}

	@PostMapping("/AddToCart/{id}/{productId}/{Qauntity}")
	public String addItemToCart(@PathVariable("id") int id, @PathVariable("productId") int productId,
			@PathVariable("Qauntity") int qauntity) {

		customerService.addToCart(id, productId, qauntity);
		return "af";
	}

	@GetMapping("/CartDetails/{id}")
	public List<CartLine> cartDetails(@PathVariable("id") int customerId, Model model) {

		model.addAttribute("cart", customerService.getCartDetails(customerId));
		return customerService.getCartDetails(customerId);
	}

	@PostMapping("/removeFromCart/{cartId}")
	public String removeFromCart(@PathVariable("cartId") int cartId) {
		customerService.removeItemFromCart(cartId);
		return "delete";
	}

	@PostMapping("/changeQauntity/{cartId}/{qauntity}")
	public String changeQaunity(@PathVariable("cartId") int cartId, @PathVariable("qauntity") int qauntity) {
		customerService.changeQaunity(cartId, qauntity);
		return "update";
	}

	@PostMapping("/paymentSucces/{cId}")
	public String paymentSucces(@PathVariable("cId") int customerId, @RequestBody Payment payment) {
		customerService.paymentSucces(customerId, payment);
		return "orderPlaced and payement successful";
	}

	@GetMapping("/OrdersDetails")
	public List<Orders> getOrders() {
		return customerService.getAllOrders();
	}

	@PostMapping("/decreaseBYOne/{cartId}")
	public String decreaseByOne(@PathVariable("cartId")int cartId) {
		customerService.decreaseByOne(cartId);
		return "decreased";
	}
	@PostMapping("/IncreaseBYOne/{cartId}")
	public String increaseByOne(@PathVariable("cartId")int cartId) {
		customerService.increaseByOne(cartId);
		return "increased";
		}
	@PostMapping("/totalAmount/{id}")
	public String totalAmont(@PathVariable("id")int id) {
//		return customerService.totalAmonut(id);
		return customerService.totalAmonut(id);
		}
}
