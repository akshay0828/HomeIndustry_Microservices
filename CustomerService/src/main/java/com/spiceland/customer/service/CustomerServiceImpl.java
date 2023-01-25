package com.spiceland.customer.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spiceland.customer.dao.UserDAO;
import com.spiceland.customer.entity.CartLine;
import com.spiceland.customer.entity.Orders;
import com.spiceland.customer.entity.Payment;
import com.spiceland.customer.entity.Products;
import com.spiceland.customer.entity.User;
import com.spiceland.customer.repo.CartLineRepo;
import com.spiceland.customer.repo.OrdersRepo;
import com.spiceland.customer.repo.PaymentRepo;
import com.spiceland.customer.repo.ProductsRepo;
import com.spiceland.customer.repo.UserRepo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private UserDAO userdao;

	@Autowired
	private ProductsRepo productsRepo;

	@Autowired
	private OrdersRepo ordersRepo;

	@Autowired
	private CartLineRepo cartLineRepo;

	@Autowired
	private PaymentRepo paymentRepo;

	@Override
	public User getUser(int id) {
		User u = userRepo.getById(id);
		return u;
	}

	@Override
	public void updateUser(User user) {
		userdao.updateUserDao(user.getName(), user.getContact(), user.getAddress(), user.getArea(), user.getId());

	}

	@Override
	public List<Orders> getPreviousOrders(int id) {
		return ordersRepo.findByUserId(id);

	}

	@Override
	public List<Products> getproducts() {
		List<Products> pro = new ArrayList<>();
		List<Products> allPro = productsRepo.findAll();

		for (Products products : allPro) {
			int i = 1;
			for (Products products2 : pro) {
				if (products2.getProductName().equals(products.getProductName())) {
					i = 0;
				}
			}
			if (i == 1) {
				pro.add(products);
			}

		}
		System.out.println("==========" + pro);
//		return productsRepo.findAll();
		return pro;
	}

	@Override
	public List<Products> searchForProduct(String search) {
		List<Products> prod = new ArrayList<>();
		List<Products> pro = getproducts();
		String serach1 = search.toUpperCase();
		for (Products products : pro) {
			if (products.getProductName().equals(serach1)) {
				prod.add(products);
			}
		}
//		,BeanPropertyRowMapper.newInstance(Products.class)
		return prod;
	}

	@Override
	public List<Products> getProductDetailsWithSameProductName(String pName) {
		return productsRepo.findByProductName(pName);
	}

	@Override
	public List<User> getVendorDetailsForProduct(String pName) {
		List<Products> productDetails = getProductDetailsWithSameProductName(pName);
		List<User> vendorDetails = new ArrayList<>();
		for (Products products : productDetails) {
			vendorDetails.add(products.getUser());
		}

		return vendorDetails;
	}

	@Override
	public List<CartLine> getCartDetails(int customerId) {
		List<CartLine> cart = cartLineRepo.findAllByUserid(customerId);
		return cart;
	}

	@Override
	public List<User> getUsers() {
		return userRepo.findAll();
	}

	@Override
	public void addToCart(int id, int productId, int qauntity) {
		Products product = productsRepo.findById(productId);
		CartLine cartItem = new CartLine();
		int qaunt, i = 0, cartId;
		double price;
		List<CartLine> allCart = cartLineRepo.findAll();
		for (CartLine cartLine : allCart) {
			i = 0;
			System.out.println("for   " + cartLine);
			if ((cartLine.getUserid() == id) && (cartLine.getProdid() == productId)) {
				qaunt = qauntity + cartLine.getQuantity();
				price = qaunt * product.getPrice();
				cartId = cartLine.getId();
				System.out.println("if    ");
				i = 1;
				userdao.updateQauntity(qaunt, price, cartId);
				
				break;
			} else {
				cartItem = new CartLine(productId, product.getProductName(), product.getPrice() * qauntity, qauntity,
						product.getUser().getId(), id);
				
//				break;
			}
		}
		if (i == 0) {
			
			cartLineRepo.save(cartItem);
		}
		product.setQuantity(product.getQuantity()-qauntity);
		productsRepo.save(product);
	}

	@Override
	public void removeItemFromCart(int cartId) {
		int productId=cartLineRepo.findById(cartId).getProdid();
		Products product=productsRepo.findById(productId);
		int qauntity=cartLineRepo.findById(cartId).getQuantity();
		product.setQuantity(product.getQuantity()+qauntity);
		cartLineRepo.deleteById(cartId);
		productsRepo.save(product);
	}

	@Override
	public void changeQaunity(int cartId, int qauntity) {
		CartLine cart = cartLineRepo.findById(cartId);
		Products pro = productsRepo.findById(cart.getProdid());
		pro.setQuantity(pro.getQuantity()+cart.getQuantity()-qauntity);
//		pro.setQuantity(qauntity);
		double price = qauntity * pro.getPrice();
		userdao.updateQauntity(qauntity, price, cartId);
		productsRepo.save(pro);
	}

	@Override
	public void paymentSucces(int customerId, Payment payment) {
		Payment pay = paymentRepo.save(payment);
		User u = getUser(customerId);
		ArrayList<String> cart = new ArrayList<>();
		List<CartLine> customerCart = getCartDetails(customerId);
		for (CartLine cartLine : customerCart) {
			if (cartLine.getUserid() == customerId) {
				String cartL = "Id : " + cartLine.getId() + "   Product Id  :  " + cartLine.getProdid()
						+ "   Product Name  :  " + cartLine.getProductName() + "  Qauntity  : " + cartLine.getQuantity()
						+ "   Price : " + cartLine.getPrice() + " Vendor Id :  " + cartLine.getAdminIds();
				cart.add(cartL);
				
			}
		}
		String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMMM-yyyy / hh:mm"));
		Orders ord = new Orders(cart, date, customerId, u.getArea(), "PLACED", pay);
		ordersRepo.save(ord);
		
		for (CartLine cartLine : customerCart) {
			if (cartLine.getUserid() == customerId) {
				cartLineRepo.delete(cartLine);
		
			}
		
			}

	}

	@Override
	public List<Orders> getAllOrders() {
		return ordersRepo.findAll();
	}
	
	
}
