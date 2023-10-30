package inheritance;
public class Animals {
	
	String name;
	int age;

	public static void main(String[] args) {
		
		Mammal mammal = new Mammal ();
		Bird bird = new Bird ();
		
		mammal.makeSound();
	    mammal.displayInfo("mammal", 5, "gray");
 
	    bird.makeSound();
		bird.displayInfo("bird", 2, "blue");
	}
	
	public void setName(String name) {
		this.name = name;
		System.out.println("The name of the animal: " + name);}
	
	public void setAge(int age) {
		this.age = age;
		System.out.println("The age: " + age);}
	
	public void makeSound() { System.out.println("The animal makes a sound");}
	
	public void displayInfo(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("The " + name + " is " + age + " years old");}
}
//---------------------------------------------------------------------------
class Bird extends Animals {

	String featherColor;

	public void makeSound() { System.out.println("The bird whistles");}

	public void displayInfo(String name, int age, String featherColor) {
		this.name = name;
		this.age = age;
		this.featherColor = featherColor;
		System.out.println("The " + name + " is " + age + " years old, and it has the " + featherColor + " color of feathers");}
}
//--------------------------------------------------------------------------------------------------------------------
class Mammal extends Animals {

	String furColor;

	public void makeSound() { System.out.println("The mammal roars");}

	public void displayInfo(String name, int age, String furColor) {
		this.name = name;
		this.age = age;
		this.furColor = furColor;
		System.out.println("The " + name + " is " + age + " years old, and it has the " + furColor + " color of fur");}
}
