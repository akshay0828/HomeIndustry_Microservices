package com.spiceland.login;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spiceland.login.entity.User;
import com.spiceland.login.repo.UserReopsitory;
import com.spiceland.login.service.UserDetailsService;

@SpringBootTest
class LoginServiceApplicationTests {
	
	@Autowired
	private UserDetailsService service;
	@Autowired 
	private UserReopsitory repo;
	
//@Test
	public void userTest() {

	

		User user = new User("akshay_kumar", "a@gmail.com", "akshay_kumar", "#12a", "jayanagara", "banglore",true,"9638562642",
				 "USER");
	
		if (user.getUsername().equals(service.findUser(user.getUsername()))) {
			System.out.println("USER ALREDY EXIST");

		}

		else {
			service.createUser(user);

			System.out.println("NEW USER CREATED");

			User u = service.findentierUser(user.getUsername());

			assertEquals(user.getUsername(), u.getUsername());

			assertEquals(user.getRole(), u.getRole());
		}

	}

	@Test
	public void updateUser() {

		User user = service.findentierUser("akshay_kumar");
		User u = new User("AKSHAY", "ak@gmail.com", "akshay_kumar", "#12a", "Mysore", "banglore",true,"9638777264",
				 "USER");
		service.updateUser(u,
				user.getId());

		assertEquals(user.getName(), "AKSHAY");
	}


}
