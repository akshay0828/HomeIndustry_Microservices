package com.spicland.delivery.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spicland.delivery.dao.UserDetailsDao;
import com.spicland.delivery.entity.User;
import com.spicland.delivery.repo.UserReopsitory;

@Service
public class UserDetailsServiceImpl
		implements UserDetailsService {

	@Autowired
	private UserReopsitory userRepository;

	@Autowired
	private UserDetailsDao userdao;

	private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	@Override
	public void updateUser(User user) {
		userdao.updateUserDao(user.getName(), user.getContact(), user.getAddress(), user.getArea(), user.getId());

	}


	// To get the id of that username.

	// Details of the user by id.
	@Override
	public User getuser(int id) {
		logger.info("Fetching user with id" + id);
		User u = userRepository.findById(id);
		logger.debug("User with id=" + id + "is" + u);
		return u;
	}

	// List of the user by role.
	@Override
	public List<User> getAlluser() {
		return userRepository.findByRole("ADMIN");
	}

	// Details of the user by id.
	@Override
	public User getByid(int id) {
		logger.info("Fetching user with id" + id);
		User u = userRepository.findById(id);
		logger.debug("User with id=" + id + "is" + u);
		return u;
	}

	@Override
	public List<User> findAll() {
		logger.info("Loading all the user");
		List<User> users = userRepository.findAll();
		logger.info("Loaded" + users.size() + "Users");
		logger.debug("Users are " + users);
		return users;

	}


	

}
