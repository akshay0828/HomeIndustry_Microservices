package com.spiceland.admin.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spiceland.admin.entity.Payment;
@Repository
public interface PaymentRepo extends JpaRepository<Payment, Integer> {
	
}
