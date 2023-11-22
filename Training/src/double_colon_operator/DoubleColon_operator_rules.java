package double_colon_operator;

/*
 * The double colon operator (::) in Java is used in method references. 
 * It provides a shorthand notation for referring to methods, constructors, 
 * or fields using lambda expressions. There are four types of method references in Java:
 */

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

//Before Java 8
interface MyInterface { void myMethod();}

public class DoubleColon_operator_rules {
	
	
     void instanceMethod() {
        System.out.println("Instance method called");
    }
	
    static void staticMethod() {
        System.out.println("Static method called");
    }

	public static void main(String[] args) {

// Static Method Reference:	
		// Before Java 8
		MyInterface obj = () -> DoubleColon_operator_rules.staticMethod();
        obj.myMethod();

        // Using double colon operator
        MyInterface obj1 = DoubleColon_operator_rules::staticMethod;
        obj1.myMethod();
       
        
 // Instance Method Reference on a Particular Instance:       
        DoubleColon_operator_rules dcolon = new DoubleColon_operator_rules();
        // Before Java 8
        MyInterface obj2 = () -> dcolon.instanceMethod();
        obj2.myMethod();

        // Using double colon operator
        MyInterface obj3 = dcolon::instanceMethod;
        obj3.myMethod();

// Instance Method Reference on a Particular Instance:        
        // Before Java 8
        MyInterface obj4 = () -> dcolon.instanceMethod();
        obj4.myMethod();

        // Using double colon operator
        MyInterface obj5 = dcolon::instanceMethod;
        obj5.myMethod();
        
        
// Instance Method Reference on an Arbitrary Instance:
        List <String> names = Arrays.asList("John", "Jane", "Doe");

        // Before Java 8
        names.forEach(s -> System.out.println(s));

        // Using double colon operator
        names.forEach(System.out::println);

        
// Constructor Reference:
        // Before Java 8
        Supplier<MyClass> supplier = () -> new MyClass();
        supplier.get();

        // Using double colon operator
        Supplier<MyClass> supplier2 = MyClass::new;
        supplier2.get();		
	}
}
class MyClass {
    MyClass() { System.out.println("Constructor called...");}
}
