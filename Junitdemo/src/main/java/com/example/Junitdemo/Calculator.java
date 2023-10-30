package com.example.Junitdemo;

public class Calculator {
	
	public static int add(int a, int b) {return a + b;} // for addition.
	public static int subtract(int a, int b) {return a - b;} // for subtraction.
	public static int multiply(int a, int b) {return a * b;} // for multiplication.
	public static int divide(int a, int b) { if (b == 0) {return 0;}return a / b;} // for integer division.

}
