package lambda_expressions;

import java.util.ArrayList;
import java.util.List;

class Student {
	private String name;
	private int score;

	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	@Override
	public String toString() {  // toString method to return a String with the values of a student
		return "Student{" + "name='" + name + '\'' + ", score=" + score + '}';
	}
}

public class LambdaExercise1 {

	public static List<String> gradeStudents(List<Student> inputList) {

		List<String> result = new ArrayList<>();
		inputList.forEach(student -> { // forEach to iterate over the collection 
			String grade;
			int score = student.getScore();
			if (score >= 90) {
				grade = "A";
			} else if (score >= 80) {
				grade = "B";
			} else if (score >= 70) {
				grade = "C";
			} else if (score >= 60) {
				grade = "D";
			} else {
				grade = "F";
			}
			result.add("Student: " + student.getName() + ", Grade: " + grade);
		});
		return result;
	}

	public static void main(String[] args) {

		// Create a list of Student objects
		List<Student> students = new ArrayList<>();
		
		students.add(new Student("Mary", 93));
		students.add(new Student("Bob", 79));
		students.add(new Student("Travis", 67));
		students.add(new Student("David", 89));
		students.add(new Student("Maya", 75));

		// Call the gradeStudents method to determine student grades
		List<String> studentGrades = gradeStudents(students);

		// Print the original list of students
		System.out.println("Original List of Students:");
		students.forEach(System.out::println);

		System.out.println();

		// Print the assigned grades for each student
		System.out.println("Assigned Student Grades:");
		studentGrades.forEach(System.out::println);
	}
}
