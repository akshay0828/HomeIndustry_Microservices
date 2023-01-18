package com.spiceland.admin.service;

import java.util.List;

import com.spiceland.admin.entity.Orders;
import com.spiceland.admin.entity.Payment;

public interface AdminService {

	List<Orders> getAllOrders();

	List<Payment> getAllPayments();

}