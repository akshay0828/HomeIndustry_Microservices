package com.spiceland.customer.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spiceland.customer.entity.Orders;

@Repository
public interface OrdersRepo extends JpaRepository<Orders, Integer> {
	
	List<Orders> findByUserId(int id);

}
