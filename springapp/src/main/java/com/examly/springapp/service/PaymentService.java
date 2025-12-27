package com.examly.springapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.Payment;

@Service
public class PaymentService {

    private final List<Payment> payments = new ArrayList<>();
    private int id = 1;

    public Payment addPayment(Payment payment) {
        payment.setPaymentId((long) id++);
        payments.add(payment);
        return payment;
    }

    public List<Payment> getAllPayments() {
        return payments;
    }
}
