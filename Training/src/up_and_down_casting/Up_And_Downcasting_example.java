package up_and_down_casting;
	/*
	 * Upcasting refers to typecasting a child object to a parent object. 
	 * Downcasting provides casting a parent object to a child object.
	 */
class Animal {

	String name;

  public void makeNoise() { System.out.println("I am just an Animal");}
}
//------------------------------------------------------------------
class Dog extends Animal {  // the subclass of Animal;

	@Override
  public void makeNoise() { System.out.println("Woof woof!");}

  public void growl() { System.out.println("Grrrrrr");} } //  this method exists only in a Dog class;

//-------------------------------------------------------------------
public class Up_And_Downcasting_example {

	public static void main(String[] args) {
//                                                         UPCASTING:
		
		Animal animal = new Dog(); // Upcasting Dog to Animal class; Creating a Child object and casting it to its Parent (easy);
		                           // Java always allows us to treat an Object of a Child type as an Object of its Parent type;
//      animal.growl();            // And yet, we do not have access to the method 'growl' in a Dog subclass; 
		
		doAnimalStuff(animal);     // the print out is 'Woof woof!', because method 'makeNoise' is in the Animal and Dog classes;
		
		
//                                                         DOWNCASTING:	
		
		Dog dog = (Dog) animal;   //  we tell Java that this Animal is a Dog;
		dog.growl();              //  now the method 'growl' in Dog class is working;
		

	}
	
	public static void doAnimalStuff (Animal animal) {
			animal.makeNoise();                         // the method 'makeNoise' is in the Animal and Dog classes;
			if (animal instanceof Dog){                 // with 'if' we also print out 'Grrrrrr', i.e the method 'growl' of Dog class;
				Dog dog = (Dog) animal;
				dog.growl();
			}				
	}
}
