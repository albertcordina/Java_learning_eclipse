package com.example.Junitdemo;

public class Grades {
	
	public char grade (int points) {
		if (points >= 90) { return 'A';}
		else if (points >= 80) { return 'B';}
		else if (points >= 70) { return 'C';}
		else if (points >= 60) { return 'D';}
		else {return 'F';}

	}
}


