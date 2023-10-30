package array;

import java.util.ArrayList;
import java.util.Scanner;

public class Array_shopping_list {

	public static void main(String[] args) {

		int n;

		ArrayList<String> shopping = new ArrayList<>();    // creating the String ArrayList;

		System.out.print("Manage your shopping list:");

		do {
			System.out.print("\n\nPlease, enter '1' if you want to add an item\n"
					+ "\tEnter '2' if you would like to remove an item from the list\n"
					+ "\tEnter '3' if you want to display the whole list\n"
					+ "\tEnter '4' for Exit\n\nPlease, enter your option: ");

			Scanner scanner = new Scanner(System.in);
			n = scanner.nextInt();

			if (n == 1) {
				System.out.print("Please, add an item here: ");
				String item = scanner.nextLine();
				item = scanner.nextLine();
				shopping.add(item);                       // adding an element to the String ArrayList;
			}
			if (n == 2) {
				System.out.print("Please, enter the item you would like to remove: ");
				String itemForRemove = scanner.nextLine();
				itemForRemove = scanner.nextLine();
				if (!itemForRemove.equals(shopping)) {
					shopping.remove(itemForRemove);      // removing an element from the String ArrayList;
					System.out.println(itemForRemove + " has been removed from the list");
				} else {
					System.out.println("Sorry, your list does not contain " + itemForRemove);
				}
			}

			if (n == 3) {
				for (String i : shopping) {              // printing out the String ArrayList;
					System.out.println("\n" + i);
				}
			}
		}

		while (n != 4);
	}
}
