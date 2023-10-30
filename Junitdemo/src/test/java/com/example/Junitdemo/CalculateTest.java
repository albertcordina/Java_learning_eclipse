package com.example.Junitdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class CalculateTest {

	@Test
	void addTest1() {
		Calculate calculate = new Calculate();
		assertEquals (4, calculate.add (2, 2));	// the 'assertEquals' method is the most used in Java
		assertTrue(calculate.add(2, 3) == 5); // ---> another method ;
	}
	@Test
	void addTest2() {
		Calculate calculate = new Calculate();
		assertEquals (10, calculate.add(8, 2));
	}
}