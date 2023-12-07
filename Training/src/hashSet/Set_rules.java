package hashSet;
import java.util.*;
public class Set_rules { 	

    public static void main(String[] args) {
//                                                               HASH SET:
    	
        /* Java 'HashSet' class implements the Set interface
         * It stores unique objects. It will not store duplicates.
         * You do not get an error, simply nothing happens.
         * 'Hashset' doesn't store elements in particular order.
         * There is not 'get' method to access a particular index.
         */

        HashSet<String> fruits = new HashSet<>(); // 'Set' is a supertype of 'HashSet';

        fruits.add("apple");      // 'HashSet' does not have 'Indexes' like 'ArrayList' or 'Nodes' like 'LinkedList',
        fruits.add("kiwi");       //  therefore, we can only use 'for-each' loop, not 'for' loop
        fruits.add("blueberry");
        fruits.add("watermelon");
        System.out.println(fruits.contains("kiwi")); // method 'contains' checks if the element is already in the list,i.e. 'true' or 'false'

        for (String x : fruits) {System.out.println(x);} // the 'for-each' loop to print out the whole 'HashSet'


   //                                                         LINKED HASH SET:
        
   // Java 'LinkedHashSet' class also does not have 'Indexes' and it stores the unique objects, however, it keeps them in the particular order;

		LinkedHashSet<String> colors = new LinkedHashSet<>(); 
		
		
		colors.add("white");
		colors.add("red");
		colors.add("blue");
		colors.add("green");
		System.out.println(colors.contains("green")); // to check if the element is within the 'LinkedHashSet', i.e. 'true' or 'false'
	    
		for (String color : colors) {System.out.println(color);}// to iterate/ print out the whole 'LinkedHashSet';
		
	 
		//                                                        TREE SET:
	    
	// Java 'TreeSet' class also does not have 'Indexes', however, it keeps the elements in the 'alphabetical' or 'numerical' order; 
 // example: displaying the list of the people according to their 'scores', etc.therefore, 'TreeSet' is very useful to avoid of using any loop.
	    
	    TreeSet<String> colors2 = new TreeSet <>(); //  'TreeSet' with String;
		colors2.add("White");                       
		colors2.add("Red");
		colors2.add("Blue");
		colors2.add("Green");
		
		System.out.println(colors2.contains("gray"));  // to check if the element is within the 'TreeSet';
		
		for (String color: colors2) {     // to iterate/ print out the whole 'TreeSet';
			System.out.println(color);
		}
		
		TreeSet<Integer> number = new TreeSet <>(); // 'TreeSet' with Integer;
		
		number.add(5);
		number.add(9);
		number.add(2);
		number.add(1);
		
		for (Integer num : number) {
			System.out.println(num);
		}   	
    }
}
/*
 * The main difference between them is that HashSet stores unique elements without any associated values, 
 * while HashMap stores key-value pairs where the keys are unique identifiers and the values are associated data. 
 * Developers need to choose the appropriate data structure based on the specific needs of their program.
 * 
 */
 