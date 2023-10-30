package method;

public class Method_overloading_Calculator {

	public static void main(String[] args) {
		/*
		 * This is another option of the resolution through another class 'Calculator'
		 * with the all 'static void Area' methods in it and referring it to this 'Main'
		 * class by the created reference word 'calculator' 
		 * 
		 * Calculator calculator = new Calculator();
		 * 
		 * calculator.Area(5); 
		 * calculator.Area(5, 5); 
		 * calculator.Area(5, 5);
		 */

		Area(5);
		Area(5, 5);
		Area(5, 5);

	}

	static void Area(double radius) {
		System.out.println("The area of the circle is " + Math.PI * radius * radius);
	}

	static void Area(double length, double width) {
		System.out.println("The area of the rectangle is " + (length * width));
	}

	static void Area(int base, double height) {
		System.out.println("The area of the triangle is " + 0.5 * base * height);
	}
}
