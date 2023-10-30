package generics;
import java.io.Serializable;
public class GenericsExample { // 'Genrics' has been created for sefty reason to have the only specific type of object;

	public static void main(String[] args) { // https://www.youtube.com/channel/UC42pOSNg804f1wCcj7qL0mA

	/*	Printer <Integer> printer = new Printer <> (23); // give a value to the object from the constructor below;
		printer.print();
		Printer <Double> doublePrinter = new Printer <> (33.5);
		doublePrinter.print();
	*/	
		
		Printer <Cat> printer = new Printer <> (new Cat()); // give a value to the object from the constructor below;
		printer.print();
		Printer <Dog> doublePrinter = new Printer <> (new Dog());
		doublePrinter.print();
		
		
	}
}

//class Printer <T> { // we create generic class with the 'T' type for any type of printing;
class Printer <T extends Animal> {  // it can be also extended to a parent class. It's called a 'BOUND GENERIC';
//class Printer <T extends Animal & Serializable> { // it is always first a class, then interface;	
	
	T thingToPrint;
	
	public Printer (T thingToPrint) {this.thingToPrint = thingToPrint;} // the constructor;
	
	//public void print () {System.out.println(thingToPrint);}
	public void print () { thingToPrint.eat(); System.out.println(thingToPrint);} // with 'T extends Animal' we can call the 'eat' method as well;

}

class Animal {
	
	String name;
	int age;
	
	public void eat () { System.out.println("Munch, munch, munch...");}
}

class Cat extends Animal {
	
	private String litterPreference;
	
	public Cat (String name) {this.name = name;}
	public Cat () {}
	public String getLitterPreference () {return litterPreference;}
	public void setLitterPreference (String litterPreference) {
		
		try { this.litterPreference = litterPreference;}
		catch (Exception e) {}
		
	}
}

class Dog extends Animal {int walkDistancePreference;}








