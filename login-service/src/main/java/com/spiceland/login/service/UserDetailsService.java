package com.spiceland.login.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.spiceland.login.entity.User;



public interface UserDetailsService {

	// To delete details of all users.
	void resetUser();

//	// Create the new user.
	String createUser(User user);

	// To find whether user of that username is already register or not.
	int LoginValidator(String username);

	// To get the roles of the user(admin,user,delivery person).
	String getrole(String username);

	// To get the id of that username.
	int getId(String username);

	// To get username by the id.
	User getUsername(int id);

	// Find whether user of that username is already register or not.
	String findUser(String username);

	// To get the details of the user by username.
	User findentierUser(String username);

	// Find password of the user by username.
	String findUserPass(String username);

	// Details of the user by id.
	User getuser(int id);

	// List of the user by role.
	List<User> getAlluser();

	// Details of the user by id.
	User getByid(int id);

	List<User> findAll();

	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
	void forgotPassword(String username, String password) throws Exception;

	// To update the details of the user.

	void updateUser(User user, int id);






	List<User> getAllByVendorFalse();

	List<User> getAllByDeliveryFalse();

	List<User>  enable(String role);
	


	void deleteUser(int id);

	String login(User user) throws Exception;


	

}