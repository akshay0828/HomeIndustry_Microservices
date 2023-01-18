package com.spiceland.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spiceland.admin.entity.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Integer> {

}
