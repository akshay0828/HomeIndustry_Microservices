package com.spiceland.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spiceland.admin.entity.Orders;
@Repository
public interface OrdersRepo extends JpaRepository<Orders, Integer>{

}
