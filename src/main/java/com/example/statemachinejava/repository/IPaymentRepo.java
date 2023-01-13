package com.example.statemachinejava.repository;

import com.example.statemachinejava.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaymentRepo extends JpaRepository<Payment, Long> {
}
