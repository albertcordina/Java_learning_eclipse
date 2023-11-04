package up_and_down_casting;

public class Up_and_Down_casting {

	public static void main(String[] args) {
		
		Baby child = new Baby (); // example of Inheritance (the relation between the parent and its child class)
		child.laughing();
		
//                   Up and Down casting is the way to call the parent and child classes:
		
		/* Upcasting - gives us the convenience to use only one 'keyword' to access
		 *             the same named method(s) of the child class and also all other methods of its parent class
		 *             NOTE:  It excludes of use all the same named method(s) of the parent class!
		 */
		
		Mother upcasting = new Baby ();
		
		upcasting.smiling();     //  calling the method in Mother class	
		System.out.println("Mother kissed the baby " + upcasting.love + " times."); // calling the int love from Mother class
		upcasting.kiss();      //  however, the same named method 'kiss' called from the Baby class
		
		
		/* Downcasting - is addition to Upcasting, and it gives us also the additional access to
		 *                all other method(s) of the child class
		 */
		
		Baby downcasting = (Baby) upcasting;
		
		downcasting.smiling();
		System.out.println("Mother kissed the baby " + downcasting.love + " times.");
		downcasting.kiss();
		
		System.out.println(downcasting.numkiss + " times."); // the int numkiss from the child class can be called
		downcasting.laughing();                        // also the method 'laughing' from the child class can be called
			
	}	
}
//------------------------------------------------------------------------
class Mother {
	
	int love = 5;
	public static void smiling () {System.out.println("The mother is smiling.");}
	//  NOTE: the method in the parent class must be 'static' to be accessed by its child class
	
	public void kiss () {System.out.println("Mother kisses the baby.");}
}
//--------------------------------------------------------------------------
class Baby extends Mother  { 

	int numkiss = 8;
	//   The Baby (extended) class does not need an instance to access his parent class
     public void laughing () {System.out.println("The baby is laughing " + love + " times."); // int love is accessed
     Mother.smiling();}                                                                      // method 'fly' is accessed
  
  	public void kiss () {System.out.println("Baby kisses the mother.");}
}