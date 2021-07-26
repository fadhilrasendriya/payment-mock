package com.gdplabs.payment.controller;

import com.gdplabs.payment.model.Payment;
import com.gdplabs.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @RequestMapping(path = "/newPayment", produces = "application/json", method = RequestMethod.POST)
    public ResponseEntity<Payment> newPayment(@RequestBody Map<String,Object> body) {
        String orderId = body.get("orderid").toString();
        Payment payment = paymentService.requestPayment(orderId);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

    @RequestMapping(path = "/getPaymentStatus", produces = "application/json", method = RequestMethod.GET)
    public ResponseEntity<Payment> getPaymentStatus(@RequestParam(name = "orderid") String orderId) {
        Payment payment = paymentService.getPayment(orderId);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

    @RequestMapping(path = "/verify", produces = "application/json", method = RequestMethod.POST)
    public ResponseEntity<Payment> verifyPayment(@RequestBody Map<String,Object> body) {
        String orderId = body.get("orderid").toString();
        Payment payment = paymentService.verifyPayment(orderId);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

}
