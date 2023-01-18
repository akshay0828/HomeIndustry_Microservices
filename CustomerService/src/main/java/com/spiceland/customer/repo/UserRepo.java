package com.spiceland.customer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spiceland.customer.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	
	User getById(int id);

}
