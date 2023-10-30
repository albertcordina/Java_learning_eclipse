package constructor;
class I {

	int a;

	public String pol(int a) {
		return "Love " + a + " times.";
	}
}

class J extends I {

	public void out() {
		System.out.println(a + " elefants.");
	}
}

public class Constractors_withOutSameNamedMethod {

	public static void main(String[] args) {
		
		I i = new J (); // <- access to all the methods of parent class;	
		System.out.println(i.pol(3));
		
		J j = (J) i; // <- access to all the methods of child and parent classes;	
		System.out.println(j.pol(5));
		j.out(); 

	}
}
