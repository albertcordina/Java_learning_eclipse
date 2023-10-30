package inheritance;

public class Inheritance_rules {                 // the parent/ super class;

    public static void main(String[] args) {

    	String make;
        String color;
        int speed;
        Car.Values("BMW", "blue", 160);          // the three parameters;
        Car.Values("Audi", "green", 140);


        Trucks1 volvo = new Trucks1("red", 80);  // the two parameters;
        System.out.println("The color of 'Volvo' truck is " + volvo.color + " and the speed is " + volvo.speed);

        Trucks1 ford = new Trucks1("yellow", 100);
        System.out.println("The color of 'Ford' truck is " + ford.color + " and the speed is " + ford.speed);
    }
}

class Car extends Inheritance_rules {            // the inherited/ children classes 'extended' are not affecting the superiour/ parent classes;

    public static void Values (String make, String color, int speed) {
        System.out.println("The color of the car make '" + make + "' is " + color + " and the speed is " + speed);

    }
}
class Trucks1 extends Inheritance_rules {
	
	String color;
	int speed;

    public Trucks1(String color, int speed) {
    	this.color = color;
    	this.speed = speed;

    }
}
