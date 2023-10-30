package method;
public class Method_exersice {

	public static void main(String[] args) {
		
		Exersice person = new Exersice(); 
		ReturnValues value = new ReturnValues();
		
		person.name = "Joe";
		person.age = 40;
	
		System.out.println (person.name);
		System.out.println (person.age);
	
		person.sayHello();
		String animal = value.getAnimal();
		System.out.println (animal);
	}
}
class Exersice {
	
	String name;
	int age;

	void sayHello() { System.out.println("Hello!");} // 'void' 'string' not to print out, but to use for when it needs;
}
class ReturnValues {

	String getAnimal () {System.out.println("Returning an animal ... ");
	return "Elephant";
	}
}
