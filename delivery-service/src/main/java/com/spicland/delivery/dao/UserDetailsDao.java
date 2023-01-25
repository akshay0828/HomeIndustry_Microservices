package com.spicland.delivery.dao;

import com.spicland.delivery.entity.User;

public interface UserDetailsDao {


	void updateUserDao(User user);

	void updateUserDaoLogin(String name, String email, String contact, String area, String address, int id);
	

}