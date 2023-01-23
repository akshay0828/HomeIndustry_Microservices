package com.spicland.delivery.entity;

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
	private ArrayList<Integer> cartIds;// List of the id's of cartitems.
	private String orderDate;// Date on which order is placed.
	private int user_id;// user id ,who placed the order.
	private String area;
	private String status="Waiting For Delivery Person To Accept Order";
	private ArrayList<Integer> adminIds;

	public Orders() {
		super();
	}



	public Orders(int id, ArrayList<Integer> cartIds, String orderDate, int user_id, String area, String status,
			 ArrayList<Integer> adminIds) {
		super();
		this.id = id;
		this.cartIds = cartIds;
		this.orderDate = orderDate;
		this.user_id = user_id;
		this.area = area;
		this.status = status;
		this.adminIds = adminIds;
	}



	


	

	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public Orders(ArrayList<Integer> cartIds, String orderDate, int user_id, String area, String status,
			ArrayList<Integer> adminIds) {
		super();
		this.cartIds = cartIds;
		this.orderDate = orderDate;
		this.user_id = user_id;
		this.area = area;
		this.status = status;
		this.adminIds = adminIds;
	}



	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Integer> getCartIds() {
		return cartIds;
	}

	public void setCartIds(ArrayList<Integer> cartIds) {
		this.cartIds = cartIds;
	}

	public String getDate() {
		return orderDate;
	}

	public void setDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
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
		return "Orders [id=" + id + ", cartIds=" + cartIds + ", orderDate=" + orderDate + ", user_id=" + user_id
				+ ", area=" + area + ", status=" + status + ", adminIds=" + adminIds + "]";
	}

	

}
