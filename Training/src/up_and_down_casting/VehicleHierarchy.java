package up_and_down_casting;
class Transport {
	
	String brand;
	String model;
	int year;

	public Transport(String brand, String model, int year) {
		this.brand = brand;
		this.model = model;
		this.year = year;    }

	public void startEngine() { System.out.println(brand + " " + model + " (Year: " + year + ") is starting.");}
}
//---------------------------------------------------------------------------
class Bug extends Transport { 
	int numberOfDoors;

	public Bug(String brand, String model, int year, int numberOfDoors) {
		super(brand, model, year);
		this.numberOfDoors = numberOfDoors;}
}
//----------------------------------------------------------------------------
class Motorcycle extends Transport {
	int engineDisplacement;

	public Motorcycle(String brand, String model, int year, int engineDisplacement) {
		super(brand, model, year);
		this.engineDisplacement = engineDisplacement; }
}
//----------------------------------------------------------------------------
public class VehicleHierarchy {

	public static void main(String[] args) {

		// Create a Car and a Motorcycle
		Bug car = new Bug("Toyota", "Camry", 2022, 4);
		Motorcycle motorcycle = new Motorcycle("Honda", "CBR500R", 2021, 500);

		// Upcasting to Vehicle references
		Transport vehicle1 = car;
		Transport vehicle2 = motorcycle;

		// Access common behavior using upcasted references
		vehicle1.startEngine();
		vehicle2.startEngine();

		// Downcasting to access specific attributes
		if (vehicle1 instanceof Bug) {
			Bug downcastedCar = (Bug) vehicle1;
			System.out.println("Car Number of Doors: " + downcastedCar.numberOfDoors);}

		if (vehicle2 instanceof Motorcycle) {
			Motorcycle downcastedMotorcycle = (Motorcycle) vehicle2;
			System.out.println("Motorcycle Engine Displacement: " + downcastedMotorcycle.engineDisplacement + "cc");}
	}
}
