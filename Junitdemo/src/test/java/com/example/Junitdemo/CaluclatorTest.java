package com.example.Junitdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CaluclatorTest {

	@Test
	public void addTest1() {
		Calculator calculate = new Calculator();
		assertEquals (4, calculate.add (2, 2));	
	}
	@Test
	public void addTest2() {
		Calculator calculate = new Calculator();
		assertEquals (6, calculate.add (3, 3));	
	}
	
	@Test
	public void subtractTest1() {
		Calculator calculate = new Calculator();
		assertEquals (0, calculate.subtract (2, 2));	
	}
	@Test
	public void subtractTest2() {
		Calculator calculate = new Calculator();
		assertEquals (3, calculate.subtract (5, 2));	
	}
	
	@Test
	public void multiplyTest1() {
		Calculator calculate = new Calculator();
		assertEquals (4, calculate.multiply (2, 2));	
	}
	@Test
	public void multiplyTest2() {
		Calculator calculate = new Calculator();
		assertEquals (12, calculate.multiply (3, 4));		
	}	
	
	@Test
	public void divisionTest1() {
		Calculator calculate = new Calculator();
		assertEquals (1, calculate.divide (2, 2));	
	}
	@Test
	public void divisionTest2() {
		Calculator calculate = new Calculator();
		assertEquals (2, calculate.divide (4, 2));	
	}
}
