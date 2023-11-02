package com.example.Junitdemo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PaymentProcessorMockTest {
	
	@Test
    public void testMakePaymentWithMock() {
        PaymentGateway paymentGateway = Mockito.mock(PaymentGateway.class);

        // Define mock behavior
        Mockito.when(paymentGateway.processPayment(100.0)).thenReturn(true);

        PaymentProcessor paymentProcessor = new PaymentProcessor(paymentGateway);

        boolean result = paymentProcessor.makePayment(100.0);
        assertTrue(result);
    }
}