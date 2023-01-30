package com.spiceland.customer.facade;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.spiceland.customer.entity.User;


@Component
@Transactional(propagation=Propagation.REQUIRED)
public class UserDetailsFacade {
	@Autowired
	private RestTemplate restTemplate;
	
	private static final String PRODUCT_URL="http://localhost:9001/api/loginservice";
	
	public User getUser(int id){
		return restTemplate.getForObject(PRODUCT_URL+"/customerDetails/"+id, User.class);
		
	}

}

	