package constructor;
class T {

	String a;
	int b;

	public T(String a, int b) {
		this.a = a;
		this.b = b;
	}

	public T() {}

	public void O (String a, int b) {
		System.out.println("His name is " + a + ", and he is " + b + " years old.");
	}
	public void P (String a, int b) {
		System.out.println(a + " has " + b + " US dollars.");
	}
}
//-----------------------------
class t extends T {
	
	String an;
	int ab;

	public t(String an, int ab) {
		this.an = an;
		this.ab = ab;
	}
	
	public t() {}

	public void O(String a, int b) {
		//super.report(a, b); // <- if we want also to call the 'O' method of parent class;
		System.out.println(a + " was there and saw there the " + b + " elefants.");
	}
	public void V (String a, int b) {
		System.out.println(a + " won the lottery " + b + " times.");
	}
}
//----------------------------------------------------------------------------
public class Constractors_withCasting {

	public static void main(String[] args) {

		T a = new T("John", 50); // via constractor of the parent class;
		System.out.println(a.a + " is " + a.b + " years old.");
//---------------------------
		T b = new T();          // via constractor of the parent class linking to a method;
		b.O("Michael", 45);
//--------------------------------------------------------
		t l = new t("Lolly", 8); //  via constractor of the child class;
		System.out.println(l.an + " is " + l.ab);
//--------------------------	
		
		
		T c = new t ();   //   via up-casting constractor linking to the methods:
		c.O("Sandra", 6); // <-  method 'O' in a child class
		c.P("Lucas", 20); // <-  method 'P' in a parent class
//--------------------------------------------
		t d = (t) c;      //   via down-casting constractor linking to the methods:
		
		d.O("Lee", 25);   // <-  method 'O' in the child class
		d.V("Bob", 3);    // <-  method 'V' in the child class
		d.P("Val", 100);  // <-  method 'P' in the parent class
	}
}
