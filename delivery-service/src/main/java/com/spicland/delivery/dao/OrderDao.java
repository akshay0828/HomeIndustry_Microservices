package com.spicland.delivery.dao;

import com.spicland.delivery.entity.Orders;

public interface OrderDao {

	void updateOrderStatus(Orders order);
}
