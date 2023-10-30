package setters_and_getters;
class U {
	
    int a;
//----------------------
	public String getA() {
		return "We have " + a + " elefants.";
	}

	public void setA(int a) {
		this.a = a;
	}
//---------------------	
	public void B (int a) {
		System.out.println("There are " + a + " elefants.");
	}
}
//-----------------------------------------------------------
class O {
	
}
//-----------------------------------------------------------
public class SettersAndGetters {

	public static void main(String[] args) {
		
		U u = new U();
		
        u.setA(5); // <- with getters and setters;
        System.out.println(u.getA()); 
//--------------------------------------------
        u.B(8);  // <- with ordinary method;
        
        System.out.println(u.a);
	}
}
