package interface_rules;
	/*
	 *  'Interface' with its variables and methods are used as a template/ design for other classes. 
	 *  Interface was created after the abstract class (Java 8) and it has similar functions to abstract 
	 *   class (only different variables, Interface has only unchangable variables).
	 *   
	 *  'Interface' is a completely "abstract class" that is used to group related methods with empty bodies:
	 *  all the variables within the 'Interface' are authomatically set as    'public static final',
	 *                                          all the methods are set as    'public abstract void'.
	 *  'Interface' can not have children classes, however, 'Interface' can have another 'Interface' as a child. 
	 *  
	 *  'Interfaces' provide to us with many implementations:
	 *   An interface can inherit multiple interfaces but cannot inherit a class. 
	 *   An abstract class can inherit a class and multiple interfaces. 
	 *   An interface cannot declare constructors or destructors.
	 *  
	 *   the 'extends' keyword is used for extending a class or interface
	 *   the 'implements' keyword is used for implementing the 'interfaces' into a 'class'. 
	 *   It is the main difference between extends and implements. Note that extends and implements 
	 *    are reserved keywords in Java and cannot be used as identifiers.
	 *   
	 *   IMPORTANT: With interfaces, all fields are automatically public, static, and final, 
	 *   and all methods that you declare or define (as default methods) are public.
	 *   
	 *   In summary, abstract classes are used to provide a base class for concrete subclasses to inherit from, 
	 *    while interfaces are used to define a set of methods that a class must implement. 
	 *   Abstract classes can have implemented and abstract methods, while interfaces can only have abstract methods.
	 */
interface Interfaces_example {  
	void play ();

}
public class Interfaces_rules implements Interfaces_example { 
	
	public static void main(String[] args) {
		Interfaces_rules rules = new Interfaces_rules ();
		rules.play();
	}

	@Override
	public void play() {
 
		System.out.println("You are playing!");
	}
}
