package com.spiceland.admin.dao;

import java.util.List;

import com.spiceland.admin.entity.Payment;
import com.spiceland.admin.entity.User;

public interface AdminDAO {
	

	 List<Payment> findAllPayment();

	void updateUser(User user);
}