package com.spiceland.admin.entity;

import java.util.ArrayList;

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
	private int id;
	
	private ArrayList<String> cart;
	
	private String orderDate;
	
	private int userId;
	 
	private String area;
	
	private String status;
	
	@OneToOne(targetEntity=Payment.class)
	@JoinColumn(name="paymentId",referencedColumnName="id")
	private Payment payment;

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<String> getCart() {
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	
	
	

	@Override
	public String toString() {
		return "Orders [id=" + id + ", cart=" + cart + ", orderDate=" + orderDate + ", userId=" + userId + ", area="
				+ area + ", status=" + status + ", payment=" + payment + "]";
	}
	


}

