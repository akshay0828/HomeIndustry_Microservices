package com.spiceland.login.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spiceland.login.config.WebSecurityConfig;
import com.spiceland.login.entity.Role;
import com.spiceland.login.entity.User;
import com.spiceland.login.model.RegisterUserModel;
import com.spiceland.login.service.RoleService;
import com.spiceland.login.service.UserDetailsService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/loginservice")
public class loginController {

	@Autowired
	private UserDetailsService service;

	int uid;

	@Autowired
	private WebSecurityConfig webSecurityConfig;

	@Autowired
	private RoleService roleService;

	private static final Logger logger = LoggerFactory.getLogger(loginController.class);

	/*
	 * If the seller/admin is new user Navigate to the registration page .
	 */

	/*
	 * Seller/Admin should enter the details
	 * (name,username,email,password,confirmpassword,contact,address). username
	 * should not be repititive if so it displays error message. password and
	 * confirmpassword should be same else error message is displayed.
	 */

	@PostMapping("/register")
	public String registerUser(@RequestBody RegisterUserModel registerUserModel) {
			return service.createUser(registerUserModel);
	}

	/*
	 * Seller/Admin should provide the username and password . If username and
	 * password of the registered seller matches it will navigate to
	 * seller/admin dashboard else it will display the error message.
	 */
	@PostMapping("/login")
	public String loginUser(@RequestBody RegisterUserModel user) throws Exception{
		return service.login(user);
		
	}

	@GetMapping("/login/{username}")
	public int getIDByUsername(@PathVariable("username") String username) {
		int id = service.getId(username);
		return id;
	}

	/*
	 * If seller/admin forgets password,will have an option to change the
	 * password
	 * 
	 */

	/*
	 * Seller/Admin should enter the username If the username exists it wil
	 * navigate to changepassword page else it will display the error message
	 */
	@PostMapping("/forgotpassword")

	public String adminpostForgotPassword(@RequestBody User user) {

		String u;
		u = service.findUser(user.getUsername());

		if (u == "false") {
			// model.addAttribute("error", "User Does Not Exists");
			return "forgotpassword";
		} else {

			// model.addAttribute("add", username);
			return "changepassword";
		}
	}

	/*
	 * If the username entered in the forgot password page, it will navigate to
	 * changepassword page.
	 */

	/*
	 * Seller/admin can enter the new password If the password and confirm
	 * password doesn't match it will again ask to enter the username and then
	 * can change the password,password will change successfully.
	 */

	@PostMapping("/changepassword")
	public String adminupdatechangePassword(@RequestBody User user) throws Exception {

		service.forgotPassword(user.getUsername(), webSecurityConfig.passwordEncoder().encode(user.getPass()));
		user.setPass(webSecurityConfig.passwordEncoder().encode(user.getPass()));
		return "password changed";

	}

	@GetMapping("/role")
	public List<Role> all() {

		return roleService.findAll();
	}

	@GetMapping("/username/{id}")
	public User findUsername(@PathVariable int id) {

		return service.getUsername(id);

	}

	@GetMapping("/getuser/{id}")
	public User findUser(@PathVariable int id) {

		return service.getuser(id);

	}

	@PutMapping("/update/{id}")
	public void update(@PathVariable int id, @RequestBody User user) {

		service.updateUser(user, id);

	}

	/*
	 * @PutMapping("/update/{id}") public void update(@PathVariable int
	 * id,@RequestBody String name,@RequestBody String email,@RequestBody String
	 * contact,@RequestBody String street,@RequestBody String area ,@RequestBody
	 * String city,@RequestBody String pincode){
	 * 
	 * service.updateUser(name, email,contact,street,area, city, pincode, id);
	 * 
	 * }
	 */

}
