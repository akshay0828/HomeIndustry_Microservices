package com.spicland.delivery.Facade;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.spicland.delivery.entity.Orders;
import com.spicland.delivery.entity.User;

@Component
@Transactional(propagation=Propagation.REQUIRED)
public class UserFacade {

	@Autowired
	private RestTemplate restTemplate;
	
	private static final String USER_URL="http://localhost:9001/api/loginservice";
	private static final String CUSTOMER_URL="http://localhost:9003/api/customer";
	
	public User getuser(int id){
		return restTemplate.getForObject(USER_URL+"/getuser/"+id, User.class);
		
	}

	public void updateUser(User user,int id){
		  restTemplate.put(USER_URL+"/update/"+id, user);
		 
	}
	public List<Orders> getAllOrders() {
		return Arrays.asList(restTemplate.getForObject(CUSTOMER_URL+"/OrdersDetails", Orders[].class));
	}

}
