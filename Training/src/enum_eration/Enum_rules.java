package enum_eration;

/*
 *  In Java, an ENUM is a special data type that is used to define a FIXED SET OF CONSTANCE OR VALUES. 
 *  An enum (short for enumeration) provides a way to represent a group of related 
 *   constants in a more structured and type-safe manner.
 *   
 *   https://docs.oracle.com/javase%2F7%2Fdocs%2Fapi%2F%2F/java/lang/Enum.html
 */
enum Color {
	// Everithing in 'enum' class is defined as OBJECT with a certain VALUE
	RED("Love"), GREEN("Health"), BLUE("Calm");
	
	private String meaning;
	Color (String meaning) {this.meaning = meaning;} // Constructor
	public String getMeaning () {return meaning;}   //  getMeaning
	public String toString () {return "This color's meaning is: " + meaning;}

}

public class Enum_rules {

	/*
	 * public static final int RED = 1; 
	 * public static final int GREEN = 2; public
	 * static final int BLUE = 3;
	 */

	public static void main(String[] args) {

		/*
		 * int color = GREEN;
		 * 
		 * switch(color) { case GREEN: System.out.println("GREEN"); break;
		 * 
		 * case RED: System.out.println("RED"); break; }
		 */

	/*	Color color = Color.GREEN;

		switch (color) {
		case BLUE:
			break;
		case GREEN:
			break;
		case RED:
			break;
		default:
			break;
		} */

		System.out.println(Color.RED);
		for (Color colors : Color.values()) {
			System.out.println("The Color is: " + colors.name());
			/*
			 * name(): Returns the name of this enum constant, exactly as declared in its enum declaration. 
			 * Most programmers should use the toString method in preference to this one, 
			 * as the toString method may return a more user-friendly name.
			 */
		}
		
		System.out.println(Color.GREEN.getClass());
		System.out.println(Color.GREEN instanceof Enum);
		
		Color color1 = Color.valueOf("GREEN"); 
		System.out.println(color1); //  prints out the value of GREEN, i.e. Health
		
		for (Color colors : Color.values()) {
			System.out.println("The Color is: " + colors.name() + " and the value is " + colors.getMeaning());
		}	
	}
}
