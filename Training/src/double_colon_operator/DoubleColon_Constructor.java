package double_colon_operator;

@FunctionalInterface
interface CarFactory {
    Car create(String brand, String model, int year);
}

class Car {
    private String brand;
    private String model;
    private int year;

    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
    public String getDetails() { return year + " " + brand + " " + model;}
}

public class DoubleColon_Constructor {

    // Task 3: Create a method to create a car using CarFactory
    static Car createCar(CarFactory carFactory, String brand, String model, int year) {
        return carFactory.create(brand, model, year); }

    public static void main(String[] args) {
        // Task 4: Use constructor reference with CarFactory

        // Create a car using the constructor reference
        Car myCar = createCar(Car::new, "Mazda", "CX-3", 2023);

        // Print the details of the created car
        System.out.println("Car Details: " + myCar.getDetails());
    }
}
