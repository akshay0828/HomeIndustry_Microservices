package com.spiceland.admin.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.spiceland.admin.entity.Payment;
import com.spiceland.admin.entity.User;

@Component
public class AdminDAOImpl implements AdminDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
//	public List<User> findAllVendor(){
//		String sql="SELECT * FROM USERS where ROLE= 'VENDOR' AND ENABLED='FALSE' ";
//		List<User> users =jdbcTemplate.query(sql,new BeanPropertyRowMapper<User>(User.class) );
//		return users;
//		
//	}
	
	
	@Override
	public List<Payment> findAllPayment() {
		String sql="SELECT * FROM PAYMENT" ;
		List<Payment> payment =jdbcTemplate.query(sql, new BeanPropertyRowMapper(Payment.class) );
		return  payment;
	}
	@Override
	public void updateUser(User user){
		String sql="UPDATE USERS SET enabled=? WHERE ID=?";
		jdbcTemplate.update(sql, "TRUE",user.getId());
		
	}

}
