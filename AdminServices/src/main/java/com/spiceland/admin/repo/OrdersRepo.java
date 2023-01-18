package com.spiceland.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spiceland.admin.entity.Orders;

public interface OrdersRepo extends JpaRepository<Orders, Integer>{

}
