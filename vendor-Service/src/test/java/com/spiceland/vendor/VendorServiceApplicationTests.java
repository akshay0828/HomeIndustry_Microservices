package com.spiceland.vendor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spiceland.vendor.entity.Products;
import com.spiceland.vendor.entity.User;
import com.spiceland.vendor.fasade.UserDetailsFasade;
import com.spiceland.vendor.service.ProductService;



@SpringBootTest
class VendorServiceApplicationTests {
	
	
	@Autowired
	private ProductService product;

	@Autowired
	private UserDetailsFasade fasade;

	@Test
	public void TestAddProducts() {
		 
		List<User> vendor =fasade.vendorList();
		if (!vendor.isEmpty()) {
		    User firstVendor = vendor.get(0);
		     Products products = new Products("Dairymilk", 10, 100, "choclate", 100,firstVendor);
		
		

		System.out.println("NEW PRODUCT ADDED");
		// product.createProduct(products);

		List<Products> p = product.getAllproductsbyuser(products.getUser());

		System.out.println(p.size());

		for (Products prod : p) {
			System.out.println("USER_ID CHECKED");
			System.out.println(prod.getUser());

			assertEquals(products.getUser(), prod.getUser());
		}

	}
	}
}
