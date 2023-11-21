

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoffeeShopOrderProcessor_switch_case_method {
	
    private static double processCost(String coffeeChoice, String size) {
        return switch (coffeeChoice) {
            case "espresso" -> switch (size) {
                case "small" -> 2.50;
                case "medium" -> 3.00;
                case "large" -> 3.50;
                default -> 0.0; // Default cost for invalid size
            };
            case "latte", "cappuccino" -> switch (size) {
                case "small" -> 3.00;
                case "medium" -> 3.50;
                case "large" -> 4.00;
                default -> 0.0; // Default cost for invalid size
            };
            default -> 0.0; // Default cost for invalid coffee choice
        };
    }

    private static String processCoffeeOrder(String coffeeChoice, String size) {
        double cost = processCost(coffeeChoice, size);

        return cost != 0.0 ?
                "Order Details:\nCoffee: " + coffeeChoice + "\nSize: " + size + "\nCost: $" + cost + "\nThank you for your order!" :
                "Error: Invalid coffee choice or size.";
    }

    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        List<String> orders = new ArrayList<>();
        double totalCost = 0.0;
        String orderAgain;

        do {
            // Input: Read the coffee choice and size
            System.out.print("Enter your coffee choice (espresso, latte, cappuccino): ");
            String coffeeChoice = scanner.nextLine().toLowerCase();

            System.out.print("Enter the size (small, medium, large): ");
            String size = scanner.nextLine().toLowerCase();

            // Output: Display the order details, cost, and add to the total cost
            String result = processCoffeeOrder(coffeeChoice, size);
            System.out.println(result);

            // If the order is valid, add it to the orders list and update the total cost
            if (!result.equals("Error: Invalid coffee choice or size.")) {
                orders.add("Coffee: " + coffeeChoice + ", Size: " + size + ", Cost: $" + processCost(coffeeChoice, size));
                totalCost += processCost(coffeeChoice, size);
            }

            // Ask if the user wants to order something else
            System.out.print("Would you like to order something else? (yes/no): ");
            orderAgain = scanner.nextLine().toLowerCase();

        } while (orderAgain.equals("yes"));

        // Display the summary of ordered items and the total cost
        if (!orders.isEmpty()) {
            System.out.println("Ordered Items:");
            for (String order : orders) {
                System.out.println(order);
            }
            System.out.println("Total Cost: $" + totalCost);
        } else {
            System.out.println("No items ordered.");
        }

        System.out.println("Thank you for visiting!");
        scanner.close();
    }
}