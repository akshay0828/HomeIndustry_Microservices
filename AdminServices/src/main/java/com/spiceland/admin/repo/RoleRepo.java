package com.spiceland.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spiceland.admin.entity.Role;
@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {

}
