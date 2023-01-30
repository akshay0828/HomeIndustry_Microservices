package com.spiceland.login;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spiceland.login.entity.User;
import com.spiceland.login.model.RegisterUserModel;
import com.spiceland.login.repo.UserReopsitory;
import com.spiceland.login.service.UserDetailsService;

@SpringBootTest
class LoginServiceApplicationTests {
	
	@Autowired
	private UserDetailsService service;
	@Autowired 
	private UserReopsitory repo;
	
//	@Test
//	public void createDoctor() {
//
//		RegisterUserModel user = new RegisterUserModel("akshay_kumar", "a@gmail.com", "akshay_kumar", "#12a","#12a", "jayanagara", "banglore",
//				 "9638562642", true, "USER");
//		User u = new User("akshay_kumar", "a@gmail.com", "akshay_kumar", "#12a", "jayanagara", "banglore",
//				 "9638562642", true, "USER",null);
//		when(repo.save(u)).thenReturn(u);
//		assertEquals(u, service.createUser(user));
//	}
//
//	@Test
//	public void userTest() {
//
//		RegisterUserModel user = new RegisterUserModel("akshay_kumar", "a@gmail.com", "akshay_kumar", "#12a","#12a", "jayanagara", "banglore",
//				 "9638562642", true, "USER");
//
//		if (user.getUsername().equals(service.findUser(user.getUsername()))) {
//			System.out.println("USER ALREDY EXIST");
//
//		}
//
//		else {
//			service.createUser(user);
//
//			System.out.println("NEW USER CREATED");
//
//			User u = service.findentierUser(user.getUsername());
//
//			assertEquals(user.getUsername(), u.getUsername());
//
//			assertEquals(user.getRole(), u.getRole());
//		}
//
//	}
	
//	@Test
//	public void loginTest() throws Exception{
//		RegisterUserModel user = new RegisterUserModel("akshay_kumar","#12a");
//		service.login(user);
//	}


}
