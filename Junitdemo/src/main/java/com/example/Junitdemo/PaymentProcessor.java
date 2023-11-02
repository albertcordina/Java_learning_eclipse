package com.example.Junitdemo;

public class PaymentProcessor {
	
    private PaymentGateway paymentGateway;

    public PaymentProcessor(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public boolean makePayment(double amount) {
        return paymentGateway.processPayment(amount);
    }
}
