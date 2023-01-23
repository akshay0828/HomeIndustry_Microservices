package com.spiceland.admin.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spiceland.admin.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	
	List<User> findAllByRole(String role);
	
	User findByRole(String role);
	

}
