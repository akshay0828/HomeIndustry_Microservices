package com.spiceland.login.service;

import java.util.List;

import com.spiceland.login.entity.Role;



public interface RoleService {

	<S extends Role> S save(S entity);

	List<Role> findAll();

	void delete(Role entity);

	Role getById(Integer id);

	Role getbyName(String name);

}