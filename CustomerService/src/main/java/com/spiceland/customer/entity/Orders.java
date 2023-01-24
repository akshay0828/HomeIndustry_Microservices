package com.spiceland.customer.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;// unique constraint of the Order .
	private ArrayList<String> cart;// List of the id's of cartitems.
	private String orderDate;// Date on which order is placed.
	private int userId;// user id ,who placed the order.
	private String area;
	private String status;
	@OneToOne(targetEntity=Payment.class)
	@JoinColumn(name="paymentId",referencedColumnName="id")
	private Payment payment;	

	public Orders() {
		super();
	}

	
	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public List<String> getCart() {
		return cart;
	}


	public void setCart(ArrayList<String> cart) {
		this.cart = cart;
	}


	public String getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getUserId() {
		return userId;
	}

	public void setUserId(int user_id) {
		this.userId = user_id;
	}

	

	public Payment getPayment() {
		return payment;
	}


	public void setPayment(Payment payment) {
		this.payment = payment;
	}


	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", cartIds=" + cart + ", date=" + orderDate + ", user_id=" + userId + ", area="
				+ area + "]";
	}


	public Orders(int id, ArrayList<String> cart, String orderDate, int userId, String area, String status,
			Payment payment) {
		super();
		this.id = id;
		this.cart = cart;
		this.orderDate = orderDate;
		this.userId = userId;
		this.area = area;
		this.status = status;
		this.payment = payment;
	}


	public Orders(ArrayList<String> cart, String orderDate, int userId, String area, String status, Payment payment) {
		super();
		this.cart = cart;
		this.orderDate = orderDate;
		this.userId = userId;
		this.area = area;
		this.status = status;
		this.payment = payment;
	}
	

}

