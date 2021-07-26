package com.gdplabs.payment.service;


import com.gdplabs.payment.model.Payment;
import com.gdplabs.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment getPayment(String orderId) {
        return paymentRepository.findPaymentByOrderId(orderId);
    }

    public Payment requestPayment(String orderId) {
        Payment payment;
        if(paymentRepository.existsByOrderId(orderId)) {
            payment = paymentRepository.findPaymentByOrderId(orderId);
        } else {
            payment = new Payment(orderId, "not verified");
            paymentRepository.save(payment);
        }
        return payment;
    }

    public Payment verifyPayment(String orderId) {
        Payment payment = paymentRepository.findPaymentByOrderId(orderId);
        payment.status = "verified";
        paymentRepository.save(payment);
        return payment;
    }

}
