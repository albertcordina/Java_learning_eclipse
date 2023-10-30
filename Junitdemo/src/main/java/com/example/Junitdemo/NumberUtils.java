package com.example.Junitdemo;

public class NumberUtils {
	
	public static boolean isEven(int number) { // that checks whether a given integer is even.
		if (number % 2 == 0) {return true;}
		else {return false;}
		
	} 
	public static int calculateFactorial(int n) { // that calculates the factorial of a non-negative integer.
	 
		int fact = 1;
             for (int i = 1; i <= n; i++) {
                 fact = fact * i;}
            return fact;           
	} 
}
