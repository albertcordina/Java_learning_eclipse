package static_rules;
class B {

	public final static String NAME = "John"; // 'static' keyword of a variable lets it bo be used in any field of the class; 
	                                          //  NOTE:  Use the capital letters for the instant variables IF THEY ARE 'final';
	public final static void love () {        //  as also, the 'static' keyword in a method lets this method to be used by another classes via only the name of the class;
		                                      //  can be used with 'final' or without it (as required);
		System.out.println("I am in live with " + NAME);
	}
}

public class Static_rules {

	public static void main(String[] args) {

		B.love();
	}
}
