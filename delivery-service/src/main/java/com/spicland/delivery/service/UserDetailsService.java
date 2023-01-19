package com.spicland.delivery.service;

import java.util.List;

import com.spicland.delivery.entity.User;

public interface UserDetailsService {

	// Details of the user by id.
	User getuser(int id);

	// List of the user by role.
	List<User> getAlluser();

	// Details of the user by id.
	User getByid(int id);

	List<User> findAll();

	// To update the details of the user.

	void updateUser(User user);

}