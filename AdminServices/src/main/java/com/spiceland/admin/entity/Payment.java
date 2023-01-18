package com.spiceland.admin.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="payments")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	private String tranzactinId;
	

	
	private String paymentMethod;
	
	private float totalAmount;
	
	private String cardNo;
	
	private String paymentType;

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(int id, String tranzactinId, Orders orders, String paymentMethod, float totalAmount, String cardNo,
			String paymentType) {
		super();
		this.id = id;
		this.tranzactinId = tranzactinId;
//		this.orders = orders;
		this.paymentMethod = paymentMethod;
		this.totalAmount = totalAmount;
		this.cardNo = cardNo;
		this.paymentType = paymentType;
	}

	public Payment(String tranzactinId, Orders orders, String paymentMethod, float totalAmount, String cardNo,
			String paymentType) {
		super();
		this.tranzactinId = tranzactinId;
//		this.orders = orders;
		this.paymentMethod = paymentMethod;
		this.totalAmount = totalAmount;
		this.cardNo = cardNo;
		this.paymentType = paymentType;
	}

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

//	public Orders getOrders() {
//		return orders;
//	}
//
//	public void setOrders(Orders orders) {
//		this.orders = orders;
//	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
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

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	
	
	
	
	
	
	
	
	
	

}

