package com.spiceland.customer.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	private String tranzactinId;
	
	private String paymentMethod;

	private String paymentType;
	
	private float totalAmount;
	
	private String cardNo;
	

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	 	
	

	public Payment(String tranzactinId, String paymentMethod, float totalAmount, String cardNo, String paymentType) {
		super();
		this.tranzactinId = tranzactinId;
		this.paymentMethod = paymentMethod;
		this.totalAmount = totalAmount;
		this.cardNo = cardNo;
		this.paymentType = paymentType;
	}




	public Payment(int id, String tranzactinId, String paymentMethod, float totalAmount, String cardNo,
			String paymentType) {
		super();
		this.id = id;
		this.tranzactinId = tranzactinId;
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

