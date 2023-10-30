package exceptions;
import java.util.*;

class Product {

	int productId;
	String productName;
	double productPrice;

	public Product(int productId, String productName, double productPrice) {

		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
	}

	public String toString() {
		return "The product Id: " + productId + "\nThe name of the product: " + productName + "\nThe price of the product: " + productPrice;
	}
}

class Inventory {

	Map<Integer, Product> storage = new HashMap<>(); // productId is the 'key';

	public void addProduct(Product product) {
		storage.put(product.productId, product);
	}

	public String getProductDetails(int productId) {
//-------------------------------------------------
//              Exception:		
		try {Product product = storage.get(productId);
			if (product != null) {return product.toString();}              // we print out 'toString' if product is not 'null';
			else {throw new NullPointerException("Product not found.");}} // if it is 'null', we throw 'Axception' and inform 'Product is not found';
		    catch (NullPointerException e) {return e.getMessage();}
	}
}
//-------------------------------------------------
public class Exceptions_scanner {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Inventory inventory = new Inventory();

		System.out.println(" - Product Inventory System -\n");

		while (true) {
			System.out.print("\n1. Add Product\n2. Get Product Details\n3. Exit\n\nEnter your choice: ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.print("Enter Product ID: ");
				int productId = scanner.nextInt();
				scanner.nextLine();

				System.out.print("Product Name: ");
				String productName = scanner.nextLine();
				
				System.out.print("Product Price: ");
				double productPrice = scanner.nextDouble();

				Product product = new Product(productId, productName, productPrice);
				inventory.addProduct(product);  // calling the method 'addProduct'
				break;

			case 2:
				System.out.print("Enter Product ID: ");
				int id = scanner.nextInt();
				String productDetails = inventory.getProductDetails(id);
				System.out.println("\nProduct Details:\n" + productDetails + "\n");
				break;

			case 3:
				System.out.println("Exiting the program");
				System.exit(0);

			default:
				System.out.println("Invalid choice. Please, try again");
				break;
			}
		}
	}
}
