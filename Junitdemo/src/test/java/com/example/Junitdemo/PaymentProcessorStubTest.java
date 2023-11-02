package com.example.Junitdemo;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class PaymentProcessorStubTest {
	
    @Test
    public void testMakePaymentWithStub() {
        PaymentProcessor paymentProcessor = new PaymentProcessor(new PaymentGateway() {
        	
            @Override
            public boolean processPayment(double amount) {
                return true; // Simulate a successful payment
            }
        });

        boolean result = paymentProcessor.makePayment(100.0);
        assertTrue(result);
    }
}
