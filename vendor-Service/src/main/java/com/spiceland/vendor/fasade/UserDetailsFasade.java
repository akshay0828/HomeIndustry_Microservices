package com.spiceland.vendor.fasade;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.spiceland.vendor.entity.Role;
import com.spiceland.vendor.entity.User;



@Component
@Transactional(propagation=Propagation.REQUIRED)
public class UserDetailsFasade {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private static final String PRODUCT_URL="http://localhost:9001/api/loginservice";
	
	//http://localhost:8080/username/73
	public User getUsername(int id){
		return restTemplate.getForObject(PRODUCT_URL+"/username/"+id, User.class);
		
	}
	
	public List<User> vendorList(){
		return Arrays.asList(restTemplate.getForObject(PRODUCT_URL+"/vendorList", User[].class));
		
	}
	
	public User updateUser(User user,int id){
		restTemplate.put(PRODUCT_URL+"/update/"+id, user);
		
		return getUsername(user.getId());
	}
	
	public User getByid(int id){
		return restTemplate.getForObject(PRODUCT_URL+"/"+id, User.class);
		
	}
	
	public List<Role> role(){
		return Arrays.asList( restTemplate.getForObject(PRODUCT_URL+"/role", Role[].class));
	}

}
