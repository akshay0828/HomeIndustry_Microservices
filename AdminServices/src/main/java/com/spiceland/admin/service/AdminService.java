package com.spiceland.admin.service;

import java.util.List;

import com.spiceland.admin.entity.Orders;
import com.spiceland.admin.entity.Payment;

public interface AdminService {

	void updateUser(int id);

	List<Orders> getAllOrdersAndPayment();

}