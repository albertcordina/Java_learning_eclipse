
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//  Done by Gabriele, Jacques, Albert
class Product {

	private String name;
	private double price;
	private int quantity;

	public Product(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void updatePrice(double newPrice) {
		this.price = newPrice;
	}
}

class Inventory {

	private List<Product> products;

	public Inventory() {
		this.products = new ArrayList<>();
	}

	public void addProduct(Product product) {
		products.add(product);
	}

	/*
	 * public void displayProducts() {
	 * 
	 * System.out.println("Inventory:"); for (Product product : products) {
	 * System.out.println( product.getName() + " - Price: " + product.getPrice() +
	 * " - Quantity: " + product.getQuantity()); } }
	 */

	public void displayProducts() {
		System.out.println("\nInventory:");
		products.forEach(product -> System.out.println(
				product.getName() + " - Price: " + product.getPrice() + " - Quantity: " + product.getQuantity()));
	}

	/*
	 * public void updatePrices(double percentageIncrease) {
	 * 
	 * for (Product product : products) { double newPrice = product.getPrice() * (1
	 * + percentageIncrease / 100); product.updatePrice(newPrice); } }
	 */

	public void updatePrices(double percentageIncrease) {
		
		products.forEach(product -> product.updatePrice(product.getPrice() * (1 + percentageIncrease / 100)));
		System.out.println("Prices updated.");
	}

	/*
	 * public List<Product> findProductsByPriceRange(double minPrice, double
	 * maxPrice) {
	 * 
	 * List<Product> result = new ArrayList<>();
	 * 
	 * for (Product product : products) { if (product.getPrice() >= minPrice &&
	 * product.getPrice() <= maxPrice) { result.add(product); } } return result; }
	 */

	public List<Product> findProductsByPriceRange(double minPrice, double maxPrice) {
		
		return products.stream().filter(product -> product.getPrice() >= minPrice && product.getPrice() <= maxPrice)
				.collect(Collectors.toList());
	}
}

public class InventoryApp {

	public static void main(String[] args) {

		Inventory inventory = new Inventory();
		inventory.addProduct(new Product("Laptop", 1000.0, 5));
		inventory.addProduct(new Product("Smartphone", 500.0, 10));
		inventory.addProduct(new Product("Tablet", 300.0, 8));

		Scanner scanner = new Scanner(System.in);

		while (true) {
			
			/*
			System.out.println("1. Display Products");
            System.out.println("2. Update Prices");
            System.out.println("3. Find Products by Price Range");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            */
			System.out.println("\n1. Display Products\n2. Update Prices\n3. Find Products by Price Range\n4. Exit");

			/*
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
			 * 
			 */
			
			int choice = 0;
			do {       // in case of entering String instead of int
				try {
					System.out.print("Enter your choice: ");
					choice = scanner.nextInt();
				} 
				catch (InputMismatchException e) {
					System.out.println("There should be a number, not the character(s).");
					scanner.nextLine();
				}
			} while (choice < 0 && choice > 4); // and also restricting to a number within the Menu
			
			
			
			switch (choice) {
			case 1:
				inventory.displayProducts();
				break;
			case 2:
				updatePrices(inventory, scanner);
				break;
			case 3:
				findProductsByPriceRange(inventory, scanner);
				break;
			case 4:
				// System.out.println("Exiting the inventory management system. Goodbye!");
				// scanner.close();

				System.out.println("Exiting the inventory management system. Goodbye!");
				scanner.close();
				System.exit(0);
				break;

			default:
				System.out.println("Invalid choice. Please enter a valid option.\n");
			}
		}
	}

	private static void updatePrices(Inventory inventory, Scanner scanner) {

		System.out.print("Enter the percentage increase: ");
		double percentageIncrease = scanner.nextDouble();
		inventory.updatePrices(percentageIncrease);
		System.out.println("Prices updated.");
	}

	private static void findProductsByPriceRange(Inventory inventory, Scanner scanner) {

		System.out.print("\nEnter the minimum price: ");
		double minPrice = scanner.nextDouble();
		System.out.print("Enter the maximum price: ");
		double maxPrice = scanner.nextDouble();

		List<Product> productsInRange = inventory.findProductsByPriceRange(minPrice, maxPrice);
		System.out.println("\nProducts in the specified price range:");

		for (Product product : productsInRange) {
	    System.out.println(product.getName() + " - Price: " + product.getPrice());
			
		}
	}
}
