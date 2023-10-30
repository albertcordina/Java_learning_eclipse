package array;

import java.util.ArrayList;

public class Arraylist_of_objects {

	public static void main(String[] args) {
 
		ArrayList<Car> cars = new ArrayList <> ();
		
		cars.add(new Car ("Volkswagen", 5256, "blue"));
		cars.add(new Car ("Volvo", 6953, "red"));
		cars.add(new Car ("BMW", 8635, "black"));
		
		cars.set(2, new Car ("Kia", 2365, "white")); // we can change the value of an element;
		
		for (Car auto : cars) {
			System.out.println(auto);
		}
		System.out.println();
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
	
	public String toString() {
		return brandName; 

	}
	
}
