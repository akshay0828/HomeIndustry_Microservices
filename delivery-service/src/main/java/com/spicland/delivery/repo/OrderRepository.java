package com.spicland.delivery.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spicland.delivery.entity.Orders;


@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer>{

	List<Orders> findByArea(String area);
	
}
