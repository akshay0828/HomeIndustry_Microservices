package com.spiceland.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spiceland.admin.entity.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}
