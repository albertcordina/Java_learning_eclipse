package lambda_expressions;

//---------------------- Return void version ------------------------------------------------------------------

@FunctionalInterface
interface Interface1 {
	void start1 (String name1, String lastName1, int age1); // return void
}
//---------------
public class Lambdas_with_multiple_parameters {
	
	public static void person1 (Interface1 a) {
		a.start1("Bob", "Smith", 40); //  not inside a String
	}
//---------------
	public static void main(String[] args) {
		 
    // creating the instance of the Interface with any available letters to represent the actual parameters of the Interface above
		Interface1 lambda1 = (n, l, a) -> System.out.println("Name: " + n + " Surname: " + l + " Age: " + a);
		
		lambda1.start1("Bob", "Smith", 40);
		
		// calling the method 'person1' above with the Interface lambda as a parameter
		person1 (lambda1); 
		
//----------------------- Return String version (longer)  -------------------------------------------------------
		
	// creating the instance of the Interface with any available letters to represent the actual parameters of the Interface below
		Interface2 lambda2 = (t, d, p) -> { 
			String concatenated = "Name: " + t + " Surname: " + d + " Age: " + p;
			return concatenated;};	
			
			System.out.println(lambda2.start2("John", "Travolta", 65));
			
		// calling the method 'person2' below with the Interface lambda as a parameter	
		person2 (lambda2);		
	}
//---------------	
	public static void person2 (Interface2 b ) {
		System.out.println(b.start2 ("John", "Travolta", 65)); // should be inside the String	
	}
}
//---------------
@FunctionalInterface
interface Interface2 {
	String start2 (String name2, String lastName2, int age2); // return String
}
