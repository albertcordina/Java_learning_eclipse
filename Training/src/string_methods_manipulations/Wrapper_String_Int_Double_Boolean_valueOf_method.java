package string_methods_manipulations;

/*
 * the valueOf method is a static method that belongs to certain classes, 
 * such as wrapper classes (e.g., Integer, Double, Boolean) and some other classes like String. 
 * This method is used to CREATE AN OBJECT of the corresponding class FROM GIVEN PRIMITIVE TYPE or STRING.
 * 
 */
public class Wrapper_String_Int_Double_Boolean_valueOf_method {

	public static void main(String[] args) {

		// Using valueOf to convert int to Integer
		int intValue = 42;
		Integer integerValue = Integer.valueOf(intValue);

		System.out.println("Integer Value: " + integerValue);
		
		// Using valueOf to convert double to Double
		double doubleValue = 3.14;
		Double doubleObject = Double.valueOf(doubleValue);

		System.out.println("Double Value: " + doubleObject);

		// Using valueOf to convert boolean to Boolean
		boolean boolValue = true;
		Boolean booleanObject = Boolean.valueOf(boolValue);

		System.out.println("Boolean Value: " + booleanObject);

		
		// Using valueOf to convert various types to String (the variables are already above)
		
		//int intValue = 42;      
		//double doubleValue = 3.14;
		//boolean boolValue = true;

		String intString = String.valueOf(intValue);
		String doubleString = String.valueOf(doubleValue);
		String boolString = String.valueOf(boolValue);

		System.out.println("Integer String: " + intString);
		System.out.println("Double String: " + doubleString);
		System.out.println("Boolean String: " + boolString);

	}
}
