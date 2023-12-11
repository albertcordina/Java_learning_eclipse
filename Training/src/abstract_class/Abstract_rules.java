package abstract_class;
/*
 * abstract class can not be called in another class,
 * It must be inherited from another class. 
 * It is similar to 'interface'.
 */
abstract class A { 

    /*
     * Abstract class: is a restricted class that cannot be used to create objects (NOTE: to access it, it must be inherited from another class).
     * Abstract method: can only be used in an abstract class, and it does not have a body. The body is provided by the subclass (inherited from).
     * It can have static methods and constructors as well.
     * It can have 'final' methods which forces the subclass not to change the body of the method;
     */

    abstract void greet(); // abstract method does not have a body.
    // abstract method can not be created in a non-abstract class.

    public final void run () { // abstract class can also have an ordinary methods
        System.out.println("running...");
    }
}

/*
 * NOTE:  when we 'extends' the abstract class, the abstract method must be implemented !
 */
class B extends A  { 
/*
 * you cannot create an instance of an abstract class directly because it may have abstract methods 
 * that need to be implemented by its subclasses. However, you can call a non-abstract method of 
 * an abstract class by creating an instance of a concrete subclass and then invoking the method, i.e. 'run'. 
 */
	
    @Override
	public void greet() {
 	System.out.println("Hallo !");	
 	
	}
}	
/*
 * Here we call a non-abstract method of an abstract class by creating an instance 
 * of a concrete subclass, i.e. Class 'B' and then invoking also the method 'run' (see below): 
 */
public class Abstract_rules   { 

	public static void main(String[] args) {
           
		B b = new B();
		
    	b.greet();
    	b.run();
 	
    }
}
