package array;

import java.util.ArrayList;

public class Arraylist_of_objects {

	public static void main(String[] args) {
 
		ArrayList<Car> cars = new ArrayList <> ();
		
		cars.add(new Car ("Volkswagen", 5256, "blue")); // we can add the value(s)
		cars.add(new Car ("Volvo", 6953, "red"));
		cars.add(new Car ("BMW", 8635, "black"));
		
		cars.set(2, new Car ("Kia", 2365, "white")); // we can change the value(s) of an element, e.g. '2'
		//System.out.println(cars.remove(2)); // we can also remove the object '2' from the list
		
		Car element = cars.get(2); // we can get only the first element of the object '2'
		System.out.println(element);
		
		for (Car auto : cars) { System.out.println(auto); } // to print out only the first elements of the whole list of objects
		
//---------------------------- getting a certain element from a certain object ----------------------------------------		
		System.out.println(cars.get(2).getSerialNumber()); // to print out the element int 'serialNumber' of the object '2'
		System.out.println(cars.get(0).getColor()); // to print out the element String 'color' of the object '0'
		
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

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
