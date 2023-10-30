package method;

class Person { // althogh all the methods have the same name, they have different parametrs; 

	void greet() { System.out.println("Hello!");}

	void greet(String name) { System.out.println("Hello " + name);}

	void greet(int height) {
		System.out.print("Hello, ");
		if (height > 190) { System.out.println("You are tall!");}
	}

	void greet(String name, int height) {
		System.out.println("Hello, " + name);
		if (height > 190) { System.out.print("You are tall!");}
	}
 }
 
public class Method_overloading {

		public static void main(String[] args) {

			Person person = new Person();
			person.greet();
			person.greet("John");
			person.greet(195);
			person.greet("Bob", 192);

		}
	}
