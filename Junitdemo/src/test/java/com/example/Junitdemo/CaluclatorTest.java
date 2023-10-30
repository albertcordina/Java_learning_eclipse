package com.example.Junitdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CaluclatorTest {

	@Test
	void addTest() {
		Calculator calculate = new Calculator();
		assertEquals (4, calculate.add (2, 2));	
	}
	@Test
	void subtractTest() {
		Calculator calculate = new Calculator();
		assertEquals (0, calculate.subtract (2, 2));	
	}
	@Test
	void multiplyTest() {
		Calculator calculate = new Calculator();
		assertEquals (4, calculate.multiply (2, 2));	
	}
	@Test
	void divisionTest() {
		Calculator calculate = new Calculator();
		assertEquals (1, calculate.divide (2, 2));	
	}
}
