package com.spiceland.customer.entity;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;// unique constraint of the Order .
	private ArrayList<String> cart;// List of the id's of cartitems.
	private String orderDate;// Date on which order is placed.
	private int userId;// user id ,who placed the order.
	private String area;
	private ArrayList<Integer> adminIds;

	public Orders() {
		super();
	}

	public Orders(int id, ArrayList<String> cart, String orderDate, int user_id, ArrayList<Integer> adminIds,
			String area) {
		super();
		this.id = id;
		this.cart = cart;
		this.orderDate = orderDate;
		this.userId = user_id;
		this.adminIds = adminIds;
		this.area = area;
	}

	public Orders(ArrayList<String> cart, String orderDate, int user_id, ArrayList<Integer> adminIds, String area) {
		super();
		this.cart = cart;
		this.orderDate = orderDate;
		this.userId = user_id;
		this.adminIds = adminIds;
		this.area = area;
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<String> getCartIds() {
		return cart;
	}

	public void setCartIds(ArrayList<String> cart) {
		this.cart = cart;
	}

	public String getDate() {
		return orderDate;
	}

	public void setDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int user_id) {
		this.userId = user_id;
	}

	public ArrayList<Integer> getAdminIds() {
		return adminIds;
	}

	public void setAdminIds(ArrayList<Integer> adminIds) {
		this.adminIds = adminIds;
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
				+ area + ", adminIds=" + adminIds + "]";
	}

}

