package com.spiceland.customer.dao;

public interface UserDAO {

	void updateUserDao(String name, String contact, String address, String area, int id);

	void updateQauntity(int qauntity, double price,int id);
	

}