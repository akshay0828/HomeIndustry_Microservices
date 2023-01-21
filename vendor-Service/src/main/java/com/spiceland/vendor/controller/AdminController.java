
package com.spiceland.vendor.controller;

import java.util.Base64;
import java.util.List;

import javax.ws.rs.Consumes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spiceland.vendor.entity.Products;
import com.spiceland.vendor.entity.Role;
import com.spiceland.vendor.entity.User;
import com.spiceland.vendor.fasade.UserDetailsFasade;
import com.spiceland.vendor.service.ProductService;



@RestController
@RequestMapping("/api/vendor")
@CrossOrigin("http://localhost:3000")
public class AdminController {

	@Autowired
	private UserDetailsFasade fasade;

	@Autowired
	private ProductService productservice;

	
	
	

	int uid;
	int flag = 0;

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);


	@PostMapping("/admin/adminhome/{id}")
	public String adminhomepost(@PathVariable("id") int id) {

		ModelAndView view = new ModelAndView("admin/adminhome");
		// System.out.println(id);

		return "admin/adminhome";
	}

	/*
	 * If seller/admin wants to add new products, It will navigate to the
	 * addproducts page.
	 */

	

	/*
	 * Seller/Admin enter the details of the products along with the image of
	 * the product.
	 */

	@PostMapping("/addProducts/{id}")

	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public String adminadd(@RequestParam(name = "productName") String productName,
			@RequestParam(name = "price") double price,
			@RequestParam(name = "weight") float weight,
			@RequestParam(name = "productDescription") String productDescription,
			@RequestParam(name = "quantity") int quantity, @PathVariable("id") int user_id, Model model)
			throws Exception {

		try {

			logger.info("Working towards logic of image upload");
			//byte[] byteArr = file.getBytes();
		//	int size = byteArr.length;

			//logger.debug("The file size " + size + " +bytes");

			// System.out.println("The file size is " + size + " bytes");
			String base64Encoded = "image";
					//new String(Base64.getEncoder().encode(byteArr));

			List<Products> pro = productservice.getProductsbyproductname(productName);

			User u1 = fasade.getUsername(user_id);

			if (pro != null) {
				logger.info("Checking whether the product added is new/existing one");
				for (Products produ : pro) {
					User n = produ.getUser();
					String p = produ.getProductName();

					if (p.equalsIgnoreCase(productName)) {
						if (user_id == n.getId()) {

							flag = 1; // showing status that user has addded the
						} // product already

					}
				}
			}
			if (flag == 1) {

				logger.error(
						"the product " + productName + " is already added to the list by the seller " + u1.getName());
				model.addAttribute("perror", "Product is already added");
				flag = 0;
				return "Product is already added";
			}
			Products p = new Products(productName, price, weight, productDescription, quantity, base64Encoded);

			User u = fasade.getUsername(user_id);
			p.setUser(u);
			productservice.createProduct(p);
			// p.setUser(u);
			logger.debug("Adding the " + productName + "from the seller " + u1.getName());

			logger.debug("Displaying products " + productservice.getAllproductsbyuser(u) + "added by the seller "
					+ u1.getName());

			// System.out.println(productservice.getAllProducts());
		}

		catch (MaxUploadSizeExceededException e) {

			logger.debug("FILE ERROR");

			// System.out.println("FILE ERROR");
		}

		return "redirect:/admin/adminhome/{id}";
	}

	/*
	 * Seller/Admin can view the existing products added by that particular
	 * seller/admin.
	 */

	@GetMapping("/productsList/{id}")
	public List<Products> listpro(Model model, @PathVariable("id") int user_id) {

		User user = fasade.getUsername(user_id);

		logger.info("Displaying the entire product list added by the seller " + user.getName());

		logger.debug("Displaying products " + productservice.getAllproductsbyuser(user) + "added by the seller "
				+ user.getName());

		return productservice.getAllproductsbyuser(user);

	}

	/*
	 * Seller/Admin can delete the existing product.
	 */

	@DeleteMapping("/deleteProduct/{id}/{userid}")
	public String DeleteProduct(Model model, @PathVariable("id") int id, @PathVariable("userid") int user_id) {

		logger.info("Deleting the product");
		Products p = productservice.getProduct(id);
		p.setUser(null);
		productservice.deleteProduct(id);
		
		return "redirect:/products/prolist/" + user_id;

	}

	
	/*
	 * Seller/Admin can Update the details of the existing products.
	 */

	@PutMapping("/updateProduct/{id}")
	public String updateProduct(@PathVariable("id") int id, @RequestBody Products pro) throws Exception {

		Products products = productservice.getProduct(id);

		try {
			logger.info("Updating the fields required for the existing product_id " + id);

			logger.debug("Existing product details  " + productservice.getProduct(id));

			productservice.productUpdate(pro,id);
			
			logger.debug("Updated details " + productservice.getProduct(id));
		} 
		catch (NullPointerException e) {
			return "CATCHE";
		}
		return "Success" + products.getUser().getId();
	}

	

	/*
	 * Seller/Admin can Update the profile.
	 */

	@PutMapping("/admin/updateProfile/{id}")
	public String adminUpdateInsert(@PathVariable("id") int id, @RequestBody User user, Model model) {

		logger.info("Updating the profile details of the seller " + id);

		

		fasade.updateUser(user);

		logger.debug("Successful updation for the seller " + id);

		return "redirect:/admin/adminhome/{id}";
	}

	@GetMapping("/prod/{id}")
	
	public Products getproduct(@PathVariable int id){
	  return productservice.getProduct(id);
	}
	
	@GetMapping("/username/{id}")
	
	public User user(@PathVariable int id){
		return fasade.getUsername(id);
	}
@GetMapping("/role")
	
	public List<Role> role(){
		return fasade.role();
	}

@PutMapping("/update/{id}")

/*@RequestMapping(value = "/update/{id}", method =    RequestMethod.PUT, consumes= MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)*/
public void update(@PathVariable int id, @RequestBody(required=false) User user){
	fasade.updateUser(user);
}
	
}