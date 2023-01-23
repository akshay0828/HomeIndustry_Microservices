package com.spicland.delivery.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.spicland.delivery.entity.Orders;

@Service
public class OrderDaoImpl implements OrderDao {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Override
	public void updateOrderStatus(Orders order) {
	
		String sql = "UPDATE orders SET status = ? WHERE id = ?";
		jdbcTemplate.update(sql, order.getStatus(), order.getId());
	}
	

}
