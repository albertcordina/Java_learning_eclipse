package testing;

public class StudentData {

	static String name;
	static int age;
	static String contactAddress;
	static String nameOfTheCourse;

	public StudentData(String name, int age, String contactAddress, String nameOfTheCourse) {

		this.name = name;
		this.age = age;
		this.contactAddress = contactAddress;
		this.nameOfTheCourse = nameOfTheCourse;
	}

	public StudentData() {
	}

	public String toString() { // toString method for the printing out the personal info
		return "\n\nYour current personal info:\nName: " + name + "\nAge: " + age + "\nAddress: " + contactAddress
				+ "\nCourse: " + nameOfTheCourse;
	}
}