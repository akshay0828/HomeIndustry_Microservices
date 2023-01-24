package com.spicland.delivery.dao;

import java.util.List;

import com.spicland.delivery.entity.Orders;

public interface OrderDao {

	void updateOrderStatus(Orders order);
	
	List<Orders> getOrdersByAreaAndStatus(String loc,String status);
}
