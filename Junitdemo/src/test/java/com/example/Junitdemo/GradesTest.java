package com.example.Junitdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class GradesTest {
	
	@Test
	void edgeTestGradeA() {
		Grades grade = new Grades();
		assertEquals('A', grade.grade(94));		
	}
	@Test
	void edgeTestGradeB() {
		Grades grade = new Grades();
		assertEquals('B', grade.grade(80));
	}
	@Test
	void edgeTestGradeC() {
		Grades grade = new Grades();
		assertEquals('C', grade.grade(78));
	}
	@Test
	void edgeTestGradeD() {
		Grades grade = new Grades();
		assertEquals('D', grade.grade(65));
	}
	@Test
	void edgeTestGradeF() {
		Grades grade = new Grades();
		assertEquals('F', grade.grade(50));
	}
	
	// for the double check;
	@Test
	void gradeA() {
		Grades grade = new Grades();
		assertEquals('A', grade.grade(90));		
	}
	@Test
	void gradeB() {
		Grades grade = new Grades();
		assertEquals('B', grade.grade(80));
	}
	@Test
	void gradeC() {
		Grades grade = new Grades();
		assertEquals('C', grade.grade(70));
	}
	@Test
	void gradeD() {
		Grades grade = new Grades();
		assertEquals('D', grade.grade(60));
	}
	@Test
	void gradeF() {
		Grades grade = new Grades();
		assertEquals('F', grade.grade(59));
	}
}
