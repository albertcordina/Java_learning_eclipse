package localization;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocalDemo { 
/*
 * Locale - is heping to choose a language/ contry for the users. Absence of 'Locate' limits the number of users
 * ResourceBundle - fetches the files to the Local object.
 * 
 * Constructors:
 * Locate (String language)
 * Locate (String language, String country)
 * Locate (String language, String country, String variant)
 * 
 */
	public static void main(String[] args) {

		//String language = "en";
		//String country = "US";
		
		//String language = "es";
		//String country = "ES";
		
		String language = "en"; // the language is the most important
		String country = "GER"; // the country is optional
		
		Locale locale = new Locale (language, country);
		ResourceBundle rb = ResourceBundle.getBundle("localization/config", locale);
		// ResourceBundle takes care for building and directing the files
		
		String s = rb.getString("BirthdayMSG"); // 'BirthdayMSG' is the key of the message
		
		System.out.println(s);
		
	}
}
