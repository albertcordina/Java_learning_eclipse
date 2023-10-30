package com.example.Junitdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class NumberUtilsTest {
	
	@Test
	public void evenTest1 () {
		NumberUtils numberUtils = new NumberUtils();
		assertEquals (true, numberUtils.isEven (6));
	}
	@Test
	public void evenTest2 () {
		NumberUtils numberUtils = new NumberUtils();
		assertEquals (true, numberUtils.isEven (10));
	}
	
	
	@Test
	public void calculateFactorialTest1 () {
		NumberUtils numberUtils = new NumberUtils();
		assertEquals (1, numberUtils.calculateFactorial (0));
	}
	@Test
	public void calculateFactorialTest2 () {
		NumberUtils numberUtils = new NumberUtils();
		assertEquals (120, numberUtils.calculateFactorial (5));
	}

}
