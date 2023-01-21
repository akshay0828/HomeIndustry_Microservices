package com.spiceland.customer.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spiceland.customer.entity.CartLine;

@Repository
public interface CartLineRepo extends JpaRepository<CartLine, Integer>{

	List<CartLine> findByUserid(int customerId);

}
