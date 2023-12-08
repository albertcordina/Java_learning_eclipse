package functional_interfaces;
//'function' package is for the Interfaces which contain the only one method
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/*
 * Functional interfaces have only the one abstract method. 
 * They are a key component of the functional programming paradigm introduced in Java 8. 
 * Some of the most commonly used functional interfaces from the java.util.function package are:
 * 
 */
public class Functional_rules {

	public static void main(String[] args) {

		/*
		 * 1. Predicate<T>: Represents a predicate (boolean-valued function) of one argument. 
		 *    It is often used for filtering elements.
		 */
		Predicate <String> isNullOrEmpty = s -> s == null || s.isEmpty();

        System.out.println(isNullOrEmpty.test("Hello"));      // false
        System.out.println(isNullOrEmpty.test(""));           // true
        System.out.println(isNullOrEmpty.test(null));         // true
		
        /*
         * 2. Function<T, R>: Represents a function that takes one argument of type T and returns a result of type R.
         */
        Function <Integer, String> intToString = i -> "Number: " + i;

        System.out.println(intToString.apply(42));    // "Number: 42"
        
        /*
         * 3. Consumer<T>: Represents an operation that accepts a single argument of type T 
         *    and returns no result. It is often used for side effects.
         */
        Consumer <String> printUpperCase = s -> System.out.println(s.toUpperCase());

        printUpperCase.accept("hello");    // Prints "HELLO"
        
        /*
         * 4. Supplier<T>: Represents a supplier of results. It does not take any arguments but produces a result.
         */
        Supplier <Double> randomDouble = () -> Math.random();

        System.out.println(randomDouble.get());    // Prints a random double value

        /*
         * 5. UnaryOperator<T>: Represents an operation on a single operand of type T, producing a result of the same type.
         */
        UnaryOperator <Integer> square = x -> x * x;

        System.out.println(square.apply(5));    // 25
        
        /*
         * 6. BinaryOperator<T>: Represents an operation upon two operands of the same type, producing a result of the same type.
         */
        BinaryOperator <Integer> sum = (a, b) -> a + b;

        System.out.println(sum.apply(3, 4));    // 7
        
        /*
         * 7. BiPredicate<T, U>: Represents a predicate (boolean-valued function) of two arguments.
         */
        BiPredicate <String, Integer> isStringLengthEqual = (s, len) -> s.length() == len;

        System.out.println(isStringLengthEqual.test("Java", 4));    // true
        System.out.println(isStringLengthEqual.test("Hello", 3));   // false
        
        /*
         * 8. BiFunction<T, U, R>: Represents a function that takes two arguments and produces a result.
         */
        BiFunction <String, Integer, String> repeatString = (s, n) -> s.repeat(n);

        System.out.println(repeatString.apply("Java ", 4));    // "Java Java Java"
    
        /*
         * These examples showcase the basic usage of each functional interface in different scenarios. 
         * Keep in mind that functional interfaces are often used in conjunction with streams 
         *  and lambda expressions to write more concise and expressive code.
         */        
	}
}
