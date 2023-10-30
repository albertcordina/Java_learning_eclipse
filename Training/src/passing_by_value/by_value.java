package passing_by_value;

public class by_value {

	public static void main(String[] args) {
		
		by_value app = new by_value(); // -> constructor: opens an access to all other methods within the whole class;
		                              

		int value = 8; // this 'int value' exist only within this method;
		System.out.println("1. Value is: " + value);

		app.display(value); // importing 'int value' of '2.' and '3.' (with the changed value from 8 to 9) from the method 'display' below;

		System.out.println("4. Value is: " + value);

	}

	public void display(int value) { // this 'int value' exists only within this 'display' method;
// public static void display(int value) { // 'static' method is added, then the 'App app = new App();' -> is not needed; 

		System.out.println("2. Value is: " + value); // this 'value' is taken from 'int value' of the method above;
		value = 9;
		System.out.println("3. Value is: " + value); // this 'value' is taken from the assigned value above;

	}
}
