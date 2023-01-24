package com.spiceland.customer.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void updateUserDao(String name, String contact, String address, String area,  int id) {
		String sql = "UPDATE users SET NAME=?,CONTACT=?,ADDRESS=?,area=? WHERE ID=?";

		jdbcTemplate.update(sql, name,  contact, address, area, id);
		

	}

	@Override
	public void updateQauntity(int qauntity,double price, int id) {
		String sql = "UPDATE CART_LINE SET QUANTITY=?,PRICE=? WHERE ID=?";
		System.out.println("dao    ");
		jdbcTemplate.update(sql, qauntity,price, id);
		
	}

}
