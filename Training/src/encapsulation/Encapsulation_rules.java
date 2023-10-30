package encapsulation;

public class Encapsulation_rules {        
	
	/*
	 * Encapsulation in Java is a mechanism of wrapping the data (variables) and code acting on the data (methods) together as a single unit. 
	 * In encapsulation, the variables of a class will be hidden from other classes (i.e. private), and can be accessed only through the methods of their current class.
	 * Encapsulation in Java refers to integrating data (variables) and code (methods) into a single unit.
	 */

	public static void main(String[] args) {

    Student student = new Student();  // -> an instance of the 'Student' class; 
    student.setName("John");
    student.setEmail("aaaaa@com.de");
    
    System.out.println(student.getName() + "  \n" +  student.getEmail());
    
	}
}
    class Student {
    	
    	private String name; // 'private' access modifier is only within the class; Instance variable can be assigned or not, a local variable must be assigned;
//    	private String name = "John";  // if we set a value to Instance variable, the method 'setName' below is not valid; 
    	
    	private String email;
    	

    	//                                GETTERS AND SETTERS are used by the Main class within its subclasses;
    	
    	public void setName(String name) {  // method 'set...' is for setting the name from the Main class;
    		this.name = name;
    	}
    	
    	public String getName() {           // method 'get...' is for colling it by the Main class;
    		return ("Your name is " + name);
    	}
    	
    	public void setEmail(String email) {
    		this.email = email;
    	}
    	
    	public String getEmail() {
    		return ("Your email is " + email);
    	}
    }
