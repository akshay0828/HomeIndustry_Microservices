package com.spiceland.login.model;

public class RegisterUserModel {
	private String name; // Name of the user.
	private String email; // Email of the user.
	private String username;// Username of the user.
	private String pass;// Password of the use.
	
	
	private String cnfmpass;// Confirm the password .
	
	private String area;// Address of the user.
	
	private String address;
	private String contact;// Contact information of the user.
	private boolean enabled;
	private String role;
	
	
	
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
	public String getCnfmpass() {
		return cnfmpass;
	}
	public void setCnfmpass(String cnfmpass) {
		this.cnfmpass = cnfmpass;
	}
	
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	
	
	

}
