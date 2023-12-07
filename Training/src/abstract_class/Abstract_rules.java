package abstract_class;

abstract class A { // abstract class can not be instantiated (called in another class); It must be inherited from another class; It is similar to 'interface';

    /*
     * Abstract class: is a restricted class that cannot be used to create objects (NOTE: to access it, it must be inherited from another class).
     * Abstract method: can only be used in an abstract class, and it does not have a body. The body is provided by the subclass (inherited from).
     * It can have static methods and constructors as well.
     * It can have 'final' methods which forces the subclass not to change the body of the method;
     */

    abstract void greet(); // abstract method does not have a body;
    // abstract method can not be created in a non-abstract class;

    public final void run () {
        System.out.println("running...");
    }

}
public class Abstract_rules  {
    public static void main(String[] args) {

    	
    }
}
