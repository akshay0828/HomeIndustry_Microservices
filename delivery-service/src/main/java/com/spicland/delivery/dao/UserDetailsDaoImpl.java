package com.spicland.delivery.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.spicland.delivery.entity.User;

@Component
public class UserDetailsDaoImpl implements UserDetailsDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void updateUserDao(User user) {
		String sql = "UPDATE users SET NAME=?,CONTACT=?,ADDRESS=?,area=? WHERE ID=?";

		jdbcTemplate.update(sql, user.getName(), user.getContact(), user.getAddress(), user.getArea(), user.getId());

	}

}
