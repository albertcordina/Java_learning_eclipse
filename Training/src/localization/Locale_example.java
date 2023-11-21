package localization;

import java.util.Locale;
import java.util.ResourceBundle;

public class Locale_example {

	
	public static void greetInLocalLanguage (Locale locale) {
		ResourceBundle messages = ResourceBundle.getBundle("localization/messages", locale); 
		String greeting = messages.getString("greeting");
		System.out.println(greeting);
	}
	
	
	public static void main(String[] args) {

		Locale english = new Locale ("en", "US");
		Locale german = new Locale ("de", "GER");
		Locale spanish = new Locale ("es", "ES");

		greetInLocalLanguage (english);
		greetInLocalLanguage (german);
		greetInLocalLanguage (spanish);
		
	}
}
