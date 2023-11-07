package lambda_expressions;

@FunctionalInterface
interface MyInterface {
	void start (String text); // a classic interface as a String
}

public class Main {

	public static void main(String[] args) {
		
	MyInterface lambda1 = (String text) -> { System.out.println("Hello!");}; // it works with a parameter String	
	lambda1.start(null); // no matter what String text you use instead of 'null' it prints out only the above condition
	
	// the best shorter way to use lambda:
	MyInterface lambda2 = (t) -> { System.out.println(t);};	// it can also work with only a letter, e.g. 't'
	lambda2.start("Hello!");

		
	}
}
