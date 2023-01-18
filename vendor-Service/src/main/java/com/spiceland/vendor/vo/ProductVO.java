package com.spiceland.vendor.vo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.spiceland.vendor.entity.User;

public class ProductVO {
	private int id;// Unique Constraint of the product.
	private String productName;// Name of the product.
	private double price;// Price of the product.
	private float weight;// Weight of the product.
	private String productDescription;// Description of the product.
	private int quantity;// Quantity of the product avaliable.

	@Lob
	// @Column(columnDefinition = "MEDIUMBLOB")
	private String image;

	@Lob
	
	private String eimage;

	private User user;

	public ProductVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductVO(int id, String productName, double price, float weight, String productDescription, int quantity,
			String image, String eimage, User user) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.weight = weight;
		this.productDescription = productDescription;
		this.quantity = quantity;
		this.image = image;
		this.eimage = eimage;
		this.user = user;
	}

	public ProductVO(String productName, double price, float weight, String productDescription, int quantity,
			String image, String eimage, User user) {
		super();
		this.productName = productName;
		this.price = price;
		this.weight = weight;
		this.productDescription = productDescription;
		this.quantity = quantity;
		this.image = image;
		this.eimage = eimage;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getEimage() {
		return eimage;
	}

	public void setEimage(String eimage) {
		this.eimage = eimage;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}
