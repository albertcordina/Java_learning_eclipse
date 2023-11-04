package inheritance;

public class Inheritance_simple_example{
    /*
    Inheritance is one of the key features of OOP that allows us to create a new class from an existing class.
    The new class that is created is known as subclass (child or derived class)
    and the existing class from where the child class is derived is known as superclass (parent or base class).
    
    NOTE: the Inheritance is the relation between the parent and its child class.
          this relation is mostly used by the third party, Main class, according to the Upcasting and Downcasting rules.
  */
	public static void main(String[] args) {
		
		Baby child = new Baby ();
		child.laughing();		
	}	
}
//-----------------------------------------------------------------------------------------

class Mother {
	
	int love = 5;
	String baby = "This is a baby.";
	public static void smiling () {System.out.println("The mother is smiling.");}
	//  NOTE: the method in the parent class must be 'static' to be accessed by its child class
}

class Baby extends Mother  { 

	//   The Baby (extended) class does not need an instance to access his parent class
     public void laughing () {System.out.println("The baby is laughing " + love + " times." + baby); // int love and String baby are accessed
     Mother.smiling();                                                                              // method 'smiling' is accessed
     baby = "Love"; // we can also declare a new value to a variable
     }                                                                    
}
