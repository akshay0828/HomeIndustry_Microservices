package com.spiceland.login.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spiceland.login.config.WebSecurityConfig;
import com.spiceland.login.dao.UserDetailsDao;
import com.spiceland.login.entity.MyUserDetails;
import com.spiceland.login.entity.Role;
import com.spiceland.login.entity.User;
import com.spiceland.login.repo.UserReopsitory;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserDetailsServiceImpl
		implements UserDetailsService, org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	private UserReopsitory userRepository;

	@Autowired
	private UserDetailsDao userdao;

	@Autowired
	private RoleService roleService;

	@Autowired
	private WebSecurityConfig webSecurityConfig;

	private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	@Override
	public void forgotPassword(String username, String password) throws Exception {

		userdao.forgotPasswordDao(username, password);

	}

	@Override
	public void updateUser(User user, int id) {
		userdao.updateUserDao(user.getName(), user.getEmail(), user.getContact(), user.getArea(), user.getAddress(),
				id);

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("Could not find user");
		}

		return new MyUserDetails(user);
	}

	// To delete details of all users.
	@Override
	public void resetUser() {
		logger.info("Deleting all user");
		userRepository.deleteAll();

	}

	// Create the new user.
	@Override
	public String createUser(User user) {
		String u = findUser(user.getUsername());
System.out.println(user.getArea());
		if (u == "false") {
			logger.debug("Existence in database is false for " + u);
			if (user.getRole().equals("VENDOR") || user.getRole().equals("DELIVERY")) {
				User u1 = new User(user.getName(), user.getEmail(),
						user.getUsername(),
						webSecurityConfig.passwordEncoder().encode(user.getPass()),
						user.getAddress(), user.getArea(), false,
						user.getContact(), user.getRole());
				Role role1 = roleService.getbyName(user.getRole());

				Set<Role> roles = new HashSet<Role>();
				roles.add(role1);
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>vendorrrr" + roles);
				u1.setRoles(roles);
				logger.debug("Creating the user with details " + user);
				// service.createUser(user);
				logger.info("Creating New User");
				userRepository.save(user);
				// MyUserDetails use = new MyUserDetails(user);
				return "success";
			} else {
				User u1 = new User(user.getName(), user.getEmail(),
						user.getUsername(),
						webSecurityConfig.passwordEncoder().encode(user.getPass()),
						user.getAddress(), user.getArea(), true,
						user.getContact(), user.getRole());

				Role role1 = roleService.getbyName(user.getRole());

				Set<Role> roles = new HashSet<Role>();
				roles.add(role1);
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>" + roles);
				u1.setRoles(roles);
				logger.debug("Creating the user with details " + user);
				logger.info("Creating New User");
				userRepository.save(user);
				// MyUserDetails use = new MyUserDetails(user);
				return "success";
			}

		}

		return "Username Already Exists";

	}

	// To find whether user of that username is already register or not.
	@Override
	public int LoginValidator(String username) {
		logger.info("Checking the username is already registered");
		if (userRepository.findByUsername(username) != null) {
			return 1;
		}
		return 0;
	}

	@Override
	public String login(User user) throws Exception{
		String s1 = "VENDOR";
		String s2 = "USER";
		String s3 = "DELIVERY";
		System.out.println("==========" + user.getUsername());
		 User u=userRepository.findByUsername(user.getUsername());
		//String role1 = service.getrole(user.getUsername());
		//System.out.println(role1);
		try {
			if ((user.getUsername().equals("admin")&&user.getPass().equals("admin"))){
				return "ADMIN";
			}

			String role = getrole(user.getUsername());
			System.out.println(role);
			logger.debug("Logging with the role as " + role);
			
			 if (role.equals(s1)) {
				
				 if(u.isEnabled()){

				if (webSecurityConfig.passwordEncoder().matches((user.getPass()),
						findUserPass(user.getUsername()))
						&& user.getUsername().equals(findUser(user.getUsername()))) {

					logger.debug(user.getUsername() + findUser(user.getUsername()));

					

					logger.debug(user.getUsername() + "has successfully logged-in as " + role);
					// return url = "redirect:/admin/adminhome/" + id;
					return "VENDOR";
				}
				

				 }
				 return "Vendor Not Approved";
			} else if (role.equals(s2)) {

				if (webSecurityConfig.passwordEncoder().matches((user.getPass()),
						findUserPass(user.getUsername()))
						&& user.getUsername().equals(findUser(user.getUsername()))) {

					logger.debug(user.getUsername() + findUser(user.getUsername()));

					logger.debug("Successful");

//					int id = service.getId(user.getUsername());
					logger.debug(user.getUsername() + "has successfully logged-in as " + role);

					// return url = "redirect:/user/userhome/" + id;
					return "USER";
				}


			}

			else if (role.equals(s3)) {
//				System.out.println(user.isEnabled());
				
				
				if (webSecurityConfig.passwordEncoder().matches((user.getPass()),
						findUserPass(user.getUsername()))
						&& user.getUsername().equals(findUser(user.getUsername()))) {
					if(u.isEnabled()){

					logger.debug(user.getUsername() + findUser(user.getUsername()));

					logger.debug(user.getUsername() + "has successfully logged-in as " + role);
					// return url = "redirect:/delivery/deliverhome/" + id;
					return "DELIVERY";
				}
				
			else {
					return "Delivery Person Not Approved";

				}
				
				}
				return "Invalid Username and Password";
			}
		}
			catch (Exception n) {
			logger.error("Invalid credentials");
			System.out.println(n);
			return "Invalid Username and Password";
		}
		return "ADMIN";
	}

	// To get the roles of the user(admin,user,delivery person).
	@Override
	public String getrole(String username) {
		logger.info("Fetching the role through username" + username);
		User u = userRepository.findByUsername(username);
		System.out.println(u);
		logger.debug("The role of " + username + "is" + u.getRole());
		return u.getRole();
	}

	public String getrolebymail(String email) {

		User e = userRepository.findByEmail(email);

		return e.getRole();
	}

	// To get the id of that username.
	@Override
	public int getId(String username) {
		logger.info("Fetching the ID through username");
		User u = userRepository.findByUsername(username);
		logger.debug("The id of" + username + "is" + u.getId());
		return u.getId();
	}

	// To get username by the id.
	@Override
	public User getUsername(int id) {
		logger.info("Fetching details of the user through Id");
		User u = userRepository.findUsernameById(id);
		logger.debug("user details of id" + id + "is" + u);
		return u;
	}

	// Find whether user of that username is already register or not.
	@Override
	public String findUser(String username) {

		if (userRepository.findByUsername(username) != null) {

			return userRepository.findByUsername(username).getUsername();
		}

		return "false";

	}

	// To get the details of the user by username.
	@Override
	public User findentierUser(String username) {
		logger.info("Finding the user by username");
		return userRepository.findUserByUsername(username);
	}

	// Find password of the user by username.
	@Override
	public String findUserPass(String username) {
		logger.info("Finding the password by username");

		if (userRepository.findByUsername(username) != null) {

			return userRepository.findByUsername(username).getPass();
		}

		return "false";

	}

	// Details of the user by id.
	@Override
	public User getuser(int id) {
		logger.info("Fetching user with id" + id);
		User u = userRepository.findById(id);
		logger.debug("User with id=" + id + "is" + u);
		return u;
	}

	// List of the user by role.
	@Override
	public List<User> getAlluser() {
		return userRepository.findByRole("ADMIN");
	}

	// Details of the user by id.
	@Override
	public User getByid(int id) {
		logger.info("Fetching user with id" + id);
		User u = userRepository.findById(id);
		logger.debug("User with id=" + id + "is" + u);
		return u;
	}

	@Override
	public List<User> findAll() {
		logger.info("Loading all the user");
		List<User> users = userRepository.findAll();
		logger.info("Loaded" + users.size() + "Users");
		logger.debug("Users are " + users);
		return users;

	}
	@Override
	public List<User> getAllByVendorFalse(){
		return userRepository.findAllByRoleAndEnabledFalse("VENDOR");
	}
	@Override
	public List<User> getAllByDeliveryFalse(){
		return userRepository.findAllByRoleAndEnabledFalse("DELIVERY");
		
	}
	@Override
	public List<User>  enable(String role) {
//		User u= userRepository.findByRole(role);
		return userRepository.findByRole(role);
		
	}
	
	@Override
	public void deleteUser(int id) {
		User u=userRepository.deleteById(id);
		System.out.println(u);
	}

	

}
