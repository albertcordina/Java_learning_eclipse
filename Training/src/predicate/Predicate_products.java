package predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

class Product {
	
	String name;
	double price;
	String category;

	public Product(String name, double price, String category) {
		this.name = name;
		this.price = price;
		this.category = category;
	}

	@Override
	public String toString() {
		return "\nProduct Name: " + name + "\nPrice: €" + price + "\nCategory: " + category; }
}

public class Predicate_products {
		
		//static method that takes a List of type <Product> called products, a Predicate Interface type <Product> called process and returns a List type <Product> 
		//the method filtered the product up to category
		static List<Product> filterProducts  (List <Product> products, Predicate <Product> process) {
			
			List<Product> filteredProducts = new ArrayList<>(); //create a new list to store the filtered products
			
			products.forEach(p -> { //takes the list of products, iterates through it via the lambda expression		
				if (process.test(p)) { //boolean condition that calls the method test() with the instance of the Predicate Interface process				
					filteredProducts.add(p); //adds to the new filtered list the products that pass the condition
				}
			});	
			return filteredProducts; //return the list
		}
		
		//static method that takes the List of products and a Fuction Interface that takes two variables, Product and String called function
		static List <String> transformNames  (List <Product> products, Function <Product, String> function) {
			
			List<String> upperCaseList = new ArrayList<>(); //create a new list to store the transformed products
				
			products.forEach(p -> { // lambda expression that iterates through each product			
				upperCaseList.add(function.apply(p)); //add to the new list the products where we apply the method, called with function.apply()
			});	
			return upperCaseList; //return list
		}
		
	public static void main(String[] args) {
			
			List<Product> products = new ArrayList<>();//create list of products
			//add products
			products.add(new Product("Iphone 15", 1599.99, "Mobile Phone"));
			products.add(new Product("Samsung P20", 499.99, "Mobile Phone"));
			products.add(new Product("Banana", 1.99, "Food"));
			products.add(new Product("Milk", 2.15, "Food"));
			products.add(new Product("Pants", 19.99, "Clothes"));
			products.add(new Product("T-Shirt", 12.99, "Clothes"));
			
			//print out the original list of the products
			System.out.println("Original List of Products: ");
			products.forEach(System.out::println);
			
			//instance of the Predicate Interface to declare the condition
			Predicate <Product> predicate = p -> p.category.equalsIgnoreCase ("Food");
			
			//we create a list with the filtered products
			//we called the method with the parameters list of the products and the instance of the Predicate interface that contains the condition
			List<Product> filteredList = filterProducts(products, predicate);
			
			System.out.println("\nFiltered List of Products:"); // print out the filtered list with a lambda expression
			filteredList.forEach(System.out::println);
			
			//instance of the Function Interface with the two variables
			//declare the expression to convert the variable f (product) f.name to upper case
			Function<Product, String> function = f -> f.name.toUpperCase();
			
			//create a list with the transformed names method with the two parameters, the list of products and the instance of the Function Inteface that contains the expression
			List<String> upperCaseList = transformNames(products, function);
			
			//print the list of the names in upper case with a lambda expression
			System.out.println("\nNames in Upper Case:\n");
			upperCaseList.forEach(System.out::println);
		}
	}
