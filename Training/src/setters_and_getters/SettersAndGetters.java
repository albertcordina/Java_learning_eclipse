package setters_and_getters;

class U {
	
    int a;
//----------------------
    // the message/function is set within the 'getter'
	public String getA() { return "We have " + a + " elephants.";} 

	public void setA (int a) { this.a = a;}
//---------------------	
	// the message/function is set within the method
	public void B (int a) { System.out.println("There are " + a + " elephants.");} 
}
//-----------------------------------------------------------
class O {
	
}
//-----------------------------------------------------------
public class SettersAndGetters {

	public static void main(String[] args) {
		
		// we create the instance/ access of the class U above
		U u = new U(); 
		
        u.setA(5); // <--- with 'setter' we initialize the variable 
        System.out.println(u.getA()); // <--- with 'getter' we get the set value of the variable
//--------------------------------------------
        
        u.B(8);  // <- with ordinary method      
        System.out.println(u.a); // print out the 
	}
}
