package hashSet;
import java.util.*;
public class Hashset_with_sustom_objects {

	public static void main(String[] args) {
		
		HashSet<Vehicle> vehicles = new HashSet<>();		
		
vehicles.add (new Vehicle(1000, "Car"));
vehicles.add (new Vehicle(5500, "Truch"));
vehicles.add (new Vehicle(5000, "Bus"));
vehicles.add (new Vehicle(1000, "Motocycle"));

for (Vehicle vehicle: vehicles) {System.out.println(vehicle);}	
		
	}
}

class Vehicle {
	int serialNumber;
	String type;
	
	public Vehicle (int serialNumber, String type) {
		this.serialNumber = serialNumber;
		this.type = type;
	}
	
	public String toString () {   // 'toString' is an overwritten method, which has the same NAME and PARAMENTERS;
		return serialNumber + ": " + type;
	}
}
