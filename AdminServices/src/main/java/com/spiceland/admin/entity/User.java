package com.spiceland.admin.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id; // unique constraint of the user.
	private String name; // Name of the user.
	private String email; // Email of the user.
	private String username;// Username of the user.
	private String pass;// Password of the use.

	private String address;// Address of the user.
	private String area;// Address of the user.
//	private String city;// Address of the user.
//	private String pincode;// Address of the user.
	private String contact;// Contact information of the user.
	private boolean enabled;
	private String role;// Role of the user

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))

	private Set<Role> roles = new HashSet<Role>();

	@OneToMany(targetEntity = Products.class, cascade = { CascadeType.MERGE,
			CascadeType.PERSIST }, fetch = FetchType.EAGER, mappedBy = "user")
	private Set<Products> products;

	/*
	 * public User() {
	 * 
	 * roles = new ArrayList<>(); }
	 */

	public Set<Products> getProducts() {
		return null;
	}

	public void setProducts(Set<Products> products) {
		this.products = products;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public User(String name, String email, String username, String pass, String address, String area, String contact, boolean enabled, String role, Set<Role> roles) {
		super();
		this.name = name;
		this.email = email;
		this.username = username;
		this.pass = pass;
		this.address = address;
		this.area = area;
		this.contact = contact;
		this.enabled = enabled;
		this.role = role;
		this.roles = roles;
	}

	public User(String name, String email, String username, String pass, String address, String area,  String contact, String role) {
		super();
		this.name = name;
		this.email = email;
		this.username = username;
		this.pass = pass;
		this.address = address;
		this.area = area;
		this.enabled = true;
		this.role = role;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getStreet() {
		return address;
	}

	public void setStreet(String street) {
		this.address = street;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", username=" + username + ", pass=" + pass
				+ ", addresst=" + address + ", area=" + area + ", contact="
				+ contact + ", enabled=" + enabled + ", role=" + role + ", roles=" + roles + ", products=" + products
				+ "]";
	}

}
