package com.spicland.delivery.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spicland.delivery.entity.Orders;
import com.spicland.delivery.entity.Products;
import com.sun.xml.internal.stream.Entity;


@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer>{

	List<Orders> findByArea(String area);
	//List<Orders> findAllByArea(String area);
	
	 
	 
}
