
import java.util.*;
public class WeightConverter {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		System.out.print("\t- Weight Converter - \n\nEnter '1' if you would like to convert from kilos to pounds"
				+ "\nEnter '2' to convert pounds to ounces\n\nEnter your option here: ");
		byte option = scanner.nextByte();
		
		if (option == 1) {
			System.out.print("Please enter the kilos: ");
			double kilo = scanner.nextDouble();
			System.out.println("The " + kilo + " kilo(s) = " + (kilo * 2.205) + " pound(s)");
		}
		if (option == 2) {
			System.out.print("Please enter the pounds: ");
			int pound = scanner.nextInt();
			System.out.println("The " + pound + " pound(s) = " + (pound * 16) + " ounce(s)");
		}

		if (option < 1 || option > 2){
			System.out.println("Invalid option");
		}
		scanner.close();
	}
}
