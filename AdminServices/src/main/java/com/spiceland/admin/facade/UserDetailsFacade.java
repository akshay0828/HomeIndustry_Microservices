package com.spiceland.admin.facade;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.spiceland.admin.entity.User;




@Component
@Transactional(propagation=Propagation.REQUIRED)
public class UserDetailsFacade {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private static final String PRODUCT_URL="http://localhost:9001/api/loginservice";
   
	public List<User> getAllByVendorFalse(){
		return Arrays.asList( restTemplate.getForObject(PRODUCT_URL+"/vendorApproval", User[].class));
	}
	public List<User> getAllByDeliveryFalse(){
		return Arrays.asList( restTemplate.getForObject(PRODUCT_URL+"/deliveryApproval", User[].class));
	}
	public void deleteUser(int id){
		 restTemplate.delete(PRODUCT_URL+"/disapproval/"+id, id);
	}
}
