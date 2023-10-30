package up_and_down_casting;

class Parent {
	
	public static void greet() { System.out.println("Greetings from Parent class.");}
}
//--------------------------------------------------------------------
class Child extends Parent {
	
	public static void greet() { System.out.println("Greetings from Child class.");}
}
//--------------------------------------------------------------------
public class GetClass_example {

	public static void main(String[] args) {
		
		Object o = new Parent();
		Child c = new Child();
		
		Object a = Parent.class.cast(c); // 'c' is a reference to a Child class;
		System.out.println(o.getClass());
		System.out.println(c.getClass());
		System.out.println(a.getClass());
	}
}

/*
 * class Mercedes extends Car {
 * 
 * public static void method (Car c) { if (c instanceof Mercedes) { Mercedes m =
 * (Mercedes) c; // Downcasting; System.out.println("Downcasting performed!"); }
 * else { System.out.println("Downcasting not performed!"); }
 * 
 * if (Mercedes.class.isInstance(c)) { Mercedes m = (Mercedes) c; //
 * Downcasting; System.out.println("Downcasting performed!"); } else {
 * System.out.println("Downcasting not performed!"); } }
 * 
 */
