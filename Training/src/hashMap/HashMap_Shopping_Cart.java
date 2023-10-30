package hashMap;

import java.util.*;

public class HashMap_Shopping_Cart {
	public static void main(String[] args) {

		Map<String, Integer> Cart = new HashMap<>();
		Map<String, Double> Price = new HashMap<>();
		Scanner scanner = new Scanner(System.in);
		int option;

		System.out.println("WELCOME TO THE SHOPPING CART!");
		do {
			System.out.print("\n\t  -THE MENU-\n\nPress '1' to add the name and the quantity of your item"
					+ "\nPress '2' to display the cart content\nPress '3' to calculate the total price\nPress '4' to Exit\n\n"
					+ "Please, enter your option here: ");
			option = scanner.nextInt();

			switch (option) {
			case 1:
				System.out.print("Enter the name of your item: ");
				String item = scanner.nextLine();
				item = scanner.nextLine();
				if (Cart.containsKey(item)) {
					System.out.println("This item is already in the cart");
					break;
				}

				System.out.print("Enter the quantity of the '" + item + "': ");
				int quantity = scanner.nextInt();

				Cart.put(item, quantity);
				System.out.println("Your item has been added to the cart!");
				break;

			case 2:
				if (!Cart.isEmpty()) {
					System.out.println("\nCart Content:");
					for (String x : Cart.keySet()) {
						System.out.println(x + " - Quantity: " + Cart.get(x));
					}
				} else {
					System.out.println("The cart is empty");
				}
				break;

			case 3:
				double total = 0;
				if (!Cart.isEmpty()) {
					for (String x : Cart.keySet()) {
						if (Price.containsKey(x)) {
							total += Cart.get(x) * Price.get(x);
						}
					}
					System.out.println("The total price is: " + total);
				} else {
					System.out.println("The cart is empty");
				}

				break;
			case 4:
				System.out.println("Thank you for your session!");
				break;
			default:
				System.out.println("Invalid choice.\n");
			}
		} while (option != 4);
		scanner.close();
	}
}