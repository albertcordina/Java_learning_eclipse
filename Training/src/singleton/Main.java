package singleton;
/*
 * Singleton class - means a class can have only one instance.
 * Spring helps to deal with singleton
 * 
 */

class Car {
	
	static Car car = new Car();                                 // Step 1 (Instance)
	private Car() {System.out.println("Instance created.");}   //  Step 2 (Constractor)
	public static Car getInstance () { return car;}           //   Step 3 (Method)
	
}

public class Main {

	public static void main(String[] args) {
		

		Car car1 = Car.getInstance();
		Car car2 = Car.getInstance();
		
	}

}
