package array;

import java.util.ArrayList;

public class Arraylist_of_objects {

	public static void main(String[] args) {
 
		ArrayList<Car> cars = new ArrayList <> ();
		
		cars.add(new Car ("Volkswagen", 5256, "blue")); // we can add the value(s)
		cars.add(new Car ("Volvo", 6953, "red"));
		cars.add(new Car ("BMW", 8635, "black"));
		
		cars.set(2, new Car ("Kia", 2365, "white")); // we can change the value(s) of an element, e.g. '2'
		
		for (Car auto : cars) { System.out.println(auto); } // to print out the whole list
		//System.out.println(cars.remove(2)); // we can remove an element from the list
	}
}

 class Car {
	
	String brandName;
	int serialNumber;
	String color;
	
	public Car (String brandName, int serialNumber, String color) {
		this.brandName = brandName;
		this.serialNumber = serialNumber;
		this.color = color;
	}
	
	public String toString() { return brandName; }
}
