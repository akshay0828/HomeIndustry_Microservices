package com.spiceland.admin.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTranzactinId() {
		return tranzactinId;
	}

	public void setTranzactinId(String tranzactinId) {
		this.tranzactinId = tranzactinId;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	private String tranzactinId;
	
	private String paymentMethod;
	
	private String paymentType;
	
	private float totalAmount;
	
	private String cardNo;

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(int id, String tranzactinId, String paymentMethod, String paymentType, float totalAmount,
			String cardNo) {
		super();
		this.id = id;
		this.tranzactinId = tranzactinId;
		this.paymentMethod = paymentMethod;
		this.paymentType = paymentType;
		this.totalAmount = totalAmount;
		this.cardNo = cardNo;
	}

	public Payment(String tranzactinId, String paymentMethod, String paymentType, float totalAmount, String cardNo) {
		super();
		this.tranzactinId = tranzactinId;
		this.paymentMethod = paymentMethod;
		this.paymentType = paymentType;
		this.totalAmount = totalAmount;
		this.cardNo = cardNo;
	}

	

}
