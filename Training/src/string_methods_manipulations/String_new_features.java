package string_methods_manipulations;

public class String_new_features {
	/*
	 * It is useful when we need to modify a String without altering the original
	 * String
	 */
	public static void main(String[] args) {

		System.out.println(" ".isBlank()); // it returns a boolean value
		System.out.println(" love ".strip()); // removes an empty space on the both sides of the string/text
		System.out.println(" love ".stripLeading()); // removes an empty space only at the beggining
		System.out.println(" love ".stripTrailing());// removes an empty space only at the end

		System.out.println("Hello World!".transform(s -> s.substring(6))); // excluds the first 6 digits
		System.out.println("Name: %s, age: %d".formatted("Lucy", 31)); // %s for String and %d for any Number

		// Text blocks:
		System.out.println(""" 
				love is the "one"
				""");

		String textBlock = """
				Name 1: %s
				Name 2: %s
				Name %d: %s
								""".formatted("Bob", "Mary", 3, "Ema");
		System.out.println(textBlock);

	}
}
