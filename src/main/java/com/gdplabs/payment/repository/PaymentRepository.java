package com.gdplabs.payment.repository;

import com.gdplabs.payment.model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface PaymentRepository extends MongoRepository<Payment, String> {
    public Payment findPaymentByOrderId(String orderId);
    public boolean existsByOrderId(String orderId);
}
