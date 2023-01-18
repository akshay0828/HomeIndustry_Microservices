package com.spiceland.login.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spiceland.login.entity.User;


@Repository
public interface UserReopsitory extends JpaRepository<User, Integer> {

	@Query("SELECT u FROM User u WHERE u.username = :username")
	public User findByUsername(@Param("username") String username);

	User findUsernameById(int id);

	User findRolenameByUsername(String username);

	User findById(int id);

	List<User> findByRole(String role);

	User findUserByUsername(String username);

	User findByEmail(String email);

}
