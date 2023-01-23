package com.spiceland.admin.service;

import java.util.List;

import com.spiceland.admin.entity.Payment;
import com.spiceland.admin.entity.User;

public interface AdminService {

	List<User> getAllByVendorFalse();

	List<User> getAllByDeliveryFalse();

	List<Payment> getAllPayment();

	User enable(String role);

	void deleteUser(int id);

	void updateUser(int id);






}