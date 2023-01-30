package com.spiceland.customer.facade;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.spiceland.customer.entity.User;

@Component
@Transactional(propagation=Propagation.REQUIRED)
public class ProductsFacade {
	@Autowired
	private RestTemplate restTemplate;
	
	private static final String PRODUCT_URL="http://localhost:9002/api/vendor";
	
	public List<User> getVendorDetailsForProduct(String pName){
		return Arrays.asList( restTemplate.getForObject(PRODUCT_URL+"/vendorDetailsForSpecificProduct/"+pName, User[].class));
	}
}
