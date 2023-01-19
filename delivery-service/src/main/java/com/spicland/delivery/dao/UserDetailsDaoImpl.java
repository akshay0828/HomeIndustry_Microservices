package com.spicland.delivery.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsDaoImpl implements UserDetailsDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(UserDetailsDaoImpl.class);
	
	
	
//	@Override
//	public void updateUserDao(String name, String email, String contact, String street, String area, String city,
//			String pincode, int id) {
//		logger.info("Updating User with id" + id);
//		String sql = "update users set name = ? ,email= ?, contact=?, street= ?, area= ?, city=?, pincode=? where id = ?";
//
//		jdbcTemplate.update(sql, name, email, contact, street, area, city, pincode, id);
//		logger.debug("User updated with id=" + id);
//
//	}
	@Override
	public void updateUserDao(String name, String contact, String address, String area,  int id) {
		String sql = "update users set name = ?, contact=?, address= ?, area= ?, where id = ?";

		jdbcTemplate.update(sql, name,  contact, address, area, id);
		

	}
	
	
	

}
