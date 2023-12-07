package enum_eration;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class DeliveryService { // Has the main logic
	
	private List <Customer> customers = new ArrayList <> ();
	private List <Delivery> deliveries = new ArrayList <> ();
	
	public void registerCustomer (String name, String address) { // For registration
		Customer customer = new Customer (name, address); // call the Constructor.
		customers.add(customer);  // add the name and the address of the customer to the List.
		// Inform about it.
		System.out.println("Customer registered. Customer ID: " + customer.getCustomerId());
	}
	
	public void displayCustomers () { // Displays the whole List of the Customers
		System.out.println("The List of the Customers: ");
		for (Customer customer : customers) { // Iterate and print out the whole List 
			System.out.println("ID: " + customer.getCustomerId() + ", Name: "
		+ customer.getName() + ", Address: " + customer.getAddress());
		}
	}
	
	
	private Customer findCustomerById (int customerId) { // Used in the method below, i.e. 'placeDelivery'
		
		for (Customer customer : customers) { // Iterate the whole List of the customers
			if (customer.getCustomerId() == customerId) {
				return customer; // return the customer if found
			} 
		}
		return null; // return null if not found in the List
	}
	
	public void placeDelivery (String itemName, double itemWeight, int customerId) {
		
		Customer customer = findCustomerById (customerId);
		if (customer != null) {
			Delivery delivery = new Delivery (itemName, itemWeight, customer);
			deliveries.add(delivery);
			System.out.println("Delivery placed. Delivery ID: " + delivery.getDeliveryId());
		} else {
			System.out.println("Customer not found with ID: " + customerId);
		}
	}
	
    public void displayDeliveries() {  // Displays the whole List of the Deliveries 	
        System.out.println("List of Deliveries:");
        for (Delivery delivery : deliveries) {  // Iterate and print out the whole List
            System.out.println("ID: " + delivery.getDeliveryId() + ", Item: " + delivery.getItemName() +
                    ", Weight: " + delivery.getItemWeight() + ", Customer: " + delivery.getCustomer().getName() +
                    ", Delivered: " + (delivery.isDelivered() ? "Yes" : "No"));
        }
    }
	
	private Delivery findDeliveryById (int deliveryId) { // Used in the method below, i.e. 'markDeliveryAsDelivered'
		
		for (Delivery delivery : deliveries) { // Iterate the whole List of the delivery
			if (delivery.getDeliveryId() == deliveryId) {
				return delivery; // return the delivery if found
			} 
		}
		return null; // return null if not found in the List
	}
	
	public void markDeliveryAsDelivered (int deliveryId) {
		
		Delivery delivery = findDeliveryById (deliveryId);
		if (delivery != null) {
			delivery.markAsDelivered();
			System.out.println("Delivery marked as delivered. Delivery ID: " + deliveryId);
		} else {
			System.out.println("Delivery not found with ID: " + deliveryId);
		}
	}	
}


class Delivery {
	
	// Create counter of the customer's IDs
	private static int idCounter = 1;
	
	private int deliveryId;
	private String itemName;
	private double itemWeight;
	private Customer customer;
	private boolean delivered;
	
	public Delivery(String itemName, double itemWeight, Customer customer) {
		this.deliveryId = idCounter ++;
		this.itemName = itemName;
		this.itemWeight = itemWeight;
		this.customer = customer;
		this.delivered = false;
	}

	public int getDeliveryId() {
		return deliveryId;
	}

	public String getItemName() {
		return itemName;
	}

	public double getItemWeight() {
		return itemWeight;
	}

	public Customer getCustomer() {
		return customer;
	}

	public boolean isDelivered() {
		return delivered;
	}
	
	public void markAsDelivered () {
		this.delivered = true;
	}	
}


class Customer {
	
	// Create counter of the customer's IDs
	private static int idCounter = 1;
	
	private int customerId;
	private String name;
	private String address;
	
	// Create the constructor for the method 'registerCustomer' in Class 'DeliveryService'
	public Customer(String name, String address) {
		this.customerId = idCounter ++; // incrementation of the customer ID
		this.name = name;
		this.address = address;
	}

    // Create the getters for the parameters
	public int getCustomerId() {
		return customerId;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}	
}



public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner (System.in);
		// Create instance to the main logic class, i.e. DeliveryService
		DeliveryService deliveryService = new DeliveryService ();
		
		 int choice;

	        do {
	            System.out.println("\nDelivery Service System Menu:\n1. Register Customer \n2. Display Customers "
	            		+ "\n3. Place Delivery \n4. Display Deliveries \n5. Mark Delivery as Delivered \n0. Exit");

	            try {
	                System.out.print("Enter your choice: ");
	                
	                choice = scanner.nextInt();

	                switch (choice) {
	                    case 1:
	                        System.out.print("\nEnter customer name: ");
	                        String customerName = scanner.nextLine();
	                        scanner.nextLine();
	                        System.out.print("Enter customer address: ");
	                        String customerAddress = scanner.nextLine();
	                        deliveryService.registerCustomer(customerName, customerAddress);
	                        break;
	                    case 2:
	                        deliveryService.displayCustomers();
	                        break;
	                    case 3:
	                        System.out.print("\nEnter item name: ");
	                        String itemName = scanner.nextLine();
	                        scanner.nextLine();
	                        System.out.print("Enter item weight: ");
	                        double itemWeight = scanner.nextDouble();
	                        System.out.print("Enter customer ID: ");
	                        int customerId = scanner.nextInt();
	                        deliveryService.placeDelivery(itemName, itemWeight, customerId);
	                        break;
	                    case 4:
	                        deliveryService.displayDeliveries();
	                        break;
	                    case 5:
	                        System.out.print("Enter delivery ID to mark as delivered: ");
	                        int deliveryId = scanner.nextInt();
	                        deliveryService.markDeliveryAsDelivered(deliveryId);
	                        break;
	                    case 0:
	                        System.out.println("Exiting the system. Thank you!");
	                        System.exit(0);
	                    default:
	                        System.out.println("Invalid choice. Please enter a valid option.");
	                }
	            } catch (InputMismatchException e) {
	                // Handle the exception when the user enters a non-integer value
	                System.out.println("Invalid input. Please enter a valid option.");
	                // Clear the scanner buffer
	                scanner.next();
	                // Set choice to a value that will loop again
	                choice = -1;
	            }
	        } while (choice != 0);
	        scanner.close();
	    }
	}
