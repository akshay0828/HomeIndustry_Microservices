package com.spicland.delivery.service;

import java.util.List;

import com.spicland.delivery.entity.Orders; 


public interface OrderService {

	void saveOrder(Orders orders);

	List<Orders> findAll();

	boolean existsById(Integer id);

	void delete(Orders entity);

	Orders getById(Integer id);

	void deletebyId(int id);

	List<Orders> FindByArea(String area);

}
