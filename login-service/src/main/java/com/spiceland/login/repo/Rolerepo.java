package com.spiceland.login.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spiceland.login.entity.Role;

public interface Rolerepo extends JpaRepository<Role, Integer> {

	
	Role findByName(String name);
}
