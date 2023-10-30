package hashMap;
import java.util.*;
public class HashMap_ShoppingCart {

		public static void main(String[] args) {
	        HashMap<String, Integer> cart = new HashMap<>();
	        HashMap<String, Double> itemPrices = new HashMap<>();
	        Scanner scanner = new Scanner(System.in);
	        int choice;
	        do {
	            System.out.println("Shopping Cart Menu:");
	            System.out.println("1. Add item to cart");
	            System.out.println("2. Display cart contents");
	            System.out.println("3. Calculate total price");
	            System.out.println("4. Exit");
	            System.out.print("Enter your choice: ");
	            choice = scanner.nextInt();
	            scanner.nextLine(); // Consume the newline
	            switch (choice) {
	                case 1:
	                    System.out.print("Enter item name: ");
	                    String itemName = scanner.nextLine();
	                    System.out.print("Enter item quantity: ");
	                    int itemQuantity = scanner.nextInt();
	                    cart.put(itemName, cart.getOrDefault(itemName, 0) +
	                            itemQuantity);
	                    System.out.println("Item added to the cart.");
	                    break;
	                case 2:
	                    if (!cart.isEmpty()) {
	                        System.out.println("Cart Contents:");
	                        for (String item : cart.keySet()) {
	                            System.out.println(item + " - Quantity: " +
	                                    cart.get(item));
	                        }
	                    } else {
	                        System.out.println("The cart is empty.");
	                    }
	                    break;
	                case 3:
	                    double totalPrice = 0;
	                    if (!cart.isEmpty()) {
	                        for (String item : cart.keySet()) {
	                            if (itemPrices.containsKey(item)) {
	                                totalPrice += cart.get(item) *
	                                        itemPrices.get(item);
	                            }
	                        }
	                        System.out.println("Total Price: $" + totalPrice);
	                    } else {
	                        System.out.println("The cart is empty.");
	                    }
	                    break;
	                case 4:
	                    System.out.println("Exiting the program.");
	                    break;
	                default:
	                    System.out.println("Invalid choice.");
	            }
	        } while (choice != 4);
	        scanner.close();
	        }
	    }