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
	@Override
	public void updateUserDaoLogin(String name, String email, String contact,  String area, 
			String address, int id) {
		//logger.info("Updating User with id" + id);
		String sql = "update users set name = ? ,email= ?, contact=?, address= ?, area= ? where id = ?";

		jdbcTemplate.update(sql, name, email, contact,  area,  address, id);
		//logger.debug("User updated with id=" + id);

	}
	

}
