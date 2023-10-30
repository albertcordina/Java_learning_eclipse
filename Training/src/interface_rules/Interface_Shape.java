package interface_rules;

interface Shape {

	void draw();

	default void msg() {
		System.out.println("Default Method.");
	}

}

class Circle implements Shape {

	public void draw() {
		System.out.println("Drawing a circle.");
	}
}

public class Interface_Shape {
	public static void main(String[] args) {

		Shape shape = new Circle();
		shape.draw();
		shape.msg();
	}
}
