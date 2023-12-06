package enum_eration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

enum SeatClass {
	
	FIRST_CLASS, BUSINESS_CLASS, ECONOMY_CLASS;
	
}

class Passenger {
	
	private String passengerName;
	private SeatClass seatClass;
	private double ticketPrice;
	
	// Constructor
	public Passenger (String passengerName, SeatClass seatClass) {
		this.passengerName = passengerName;
		this.seatClass = seatClass;
		
		switch (seatClass) { // Set ticket price based on seat class.
		case FIRST_CLASS -> {this.ticketPrice = 400.00;}
		case BUSINESS_CLASS -> {this.ticketPrice = 250.00;}
		case ECONOMY_CLASS -> {this.ticketPrice = 100.00;}
		}
	}

	public String getPassengerName() {
		return passengerName;
	}

	public SeatClass getSeatClass() {
		return seatClass;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}
}

class Flight { // Manages the reservation system.
	
	// Create the List of the passengers
	private List <Passenger> passengerList = new ArrayList <> ();
	
	// Reserves a seat for a passenger, setting the ticket price based on the seat class.
	public void reserveSeat (String passengerName, SeatClass seatClass)  {
		
		Passenger passenger = new Passenger (passengerName, seatClass); // call Constructor
		passengerList.add(passenger); // add the passenger to the List
		System.out.println("Seat reserved for " + passengerName + " in " + seatClass + " class.");		
	}
	
	
	// Cancels a reservation by passenger name.
	public void cancelReservation (String passengerName) {
		
		/*
		 * Iterator takes the place of Enumeration in the Java Collections Framework. 
		 * Iterators differ from enumerations in two ways: 
		 * 
		 * 1. Iterators allow the caller to remove elements from the underlying collection 
		 *           during the iteration with well-defined semantics.
		 * 2. Method names have been improved.
		 */
		for (Iterator<Passenger> iterator = passengerList.iterator(); iterator.hasNext(); ) {
			Passenger passenger = iterator.next();
			
			if (passenger.getPassengerName().equals(passengerName)) { // Check for the name of the passenger
				iterator.remove();                                   //  and remove it from the List.
				System.out.println("Reservation cancelled for " + passengerName + "."); // inform about it.
				return;
			} 
		}		
	}
	// Displays the list of passengers and their reserved seats.
	public void displayPassengerList () {
		
		System.out.println("The List of the passengers: ");
		for (Passenger passenger : passengerList) { // iterate and print out the List of the passengers.
			System.out.println(passenger.getPassengerName() + " - " + passenger.getSeatClass() + " - $" 
		+ passenger.getTicketPrice());
		}	                                          		
	}	
}

public class Enum_FlightPassengers { // Demonstrates the functionality of your Ticket Reservation System.

	public static void main(String[] args) {

        // Instantiate the Flight class
        Flight flight = new Flight();
        
        // Reserve seats for different passengers
        flight.reserveSeat("John Travolta", SeatClass.FIRST_CLASS);
        flight.reserveSeat("Merry Popins", SeatClass.BUSINESS_CLASS);
        flight.reserveSeat("Bob Dilan", SeatClass.ECONOMY_CLASS);

        // Display the initial passenger list
        flight.displayPassengerList();

        // Cancel a reservation
        flight.cancelReservation("Bob Dilan");

        // Display the updated passenger list
        flight.displayPassengerList();
		
	}
}
