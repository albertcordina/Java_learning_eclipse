package toString;

public class toString_rules {
    public static void main(String[] args) {  // toString() = special method that all objects inherit,
                                              //              that returns a string that "textually represents" an object.
                                              //              can be used both implicitly and explicitly; 3:23; 
    	
    	Cars car = new Cars();
    	
    	System.out.println(car.make);
    	System.out.println(car.model);
    	System.out.println(car.color);
    	System.out.println(car.year);
    	
    	System.out.println(car);  //  -> it prints out the 'Up_And_Downcasting_rules.Cars@251a69d7' which is the address in the memory;
    	System.out.println(car.toString()); // it prints out the same as the above, however, with the implementation of 
    	                                    //the 'toString' method below it prints out the all elements; Explicitly. and Implicitly with the only (car) as above;
    }
}

class Cars {
    String make = "Ford";
    String model = "Mustang";
    String color = "red";
    int year = 2021;
    
    public String toString() {   // this method overwrites the 'toString' method;
    	   return make + "\n" + model + "\n" + color + "\n" + year; // this 'return' represents the all elements in the method;
    	
    }
}