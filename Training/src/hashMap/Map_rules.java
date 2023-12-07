package hashMap;
import java.util.*;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Map_rules {  

	public static void main(String[] args) {
		
		/*                                                         HASH MAP:
		
           does not accept duplicates and does not support the ordering of the elements; NOTE: never use it if the elements should be in a certain order.
		   It  allows the same values (second element), but does not allow the same keys (the first element);
		   exists in pair, i.e. the two Strings;
		   it uses the LinkedList
		   it does not have a reference to the previous element but has a reference to the next one;
		   not convenient for iteration;
		
		 * NOTE:  'Nested Maps' are hard to scale, making it difficult to read the code (code readability). 
		 * More importantly, Maps in Java tend to consume a lot of memory. Populating a Map with even more Maps will only aggravate the memory consumption issue. 
		 * So we have to be careful while using it and it will be used in special scenarios where it is actually required.
		 * To create a nested map, we will first have to create a normal HashMap, just the value of this map will be another HashMap.
		 */
		
		       //  key     value  
		Map <Integer, String> employeeIDs = new HashMap<>(); // 'Map' is a supertype/ interface;
		
		employeeIDs.put(6589, "John");
		employeeIDs.put(5847, "Susan");
		employeeIDs.put(2541, "Joe");
		employeeIDs.put(3698, "Bob");
		                
		System.out.println(employeeIDs);             // we can print out the whole list; ->  {3698=Bob, 5847=Susan, 6589=John, 2541=Joe}
		System.out.println(employeeIDs.get(6589));   // we can print out the only one pair; -> 'John'
		System.out.println(employeeIDs.containsKey(6589));      // we can see if the value is 'true' via the key;
		System.out.println(employeeIDs.containsValue("John"));  // we can see if the key is 'true' via the value;
		
		employeeIDs.put(3698, "Anna");              // we can create a new or overwrite the already existed value 'Bob' to 'Anna' via the key '3698';
		System.out.println(employeeIDs.get(3698));  // ' employeeIDs.replace ' -> method 'replace' only replaces the alrady existed value;
		
		employeeIDs.putIfAbsent(5896, "Albert");    // the method 'putIfAbsent' helps to put info if it is Absent in the 'HashMap';
		employeeIDs.remove(5896);                 // the method 'remove' removes the pair via the key;
		
		for (Map.Entry<Integer, String> map : employeeIDs.entrySet()) {   //  TO ITERATE THE WHOLE 'HashMap' (used mainly only for a review);
			System.out.println(map.getKey() + ", " + map.getValue());     
		}
		
		
		//                                                       LINKED HASH MAP:
		
		// The 'LinkedHashMap' in compare with 'HashMap' maintans the order (i.e. keeps all the elements in a particular order);
		// it is similar to 'TreeMap';
		// < Node link to the previous element -> Key -> Value -> Node link to the next element >
		
		Map <Integer, String> months1 = new LinkedHashMap<>();   // it sorts the elements according to the 'key' (i.e. the first element) as it was originally entered order;
		
		months1.put(2, "Feb");
		months1.put(9, "Sep");
		months1.put(11, "Nov");
		
		for (Map.Entry<Integer, String> map1 : months1.entrySet()) {    //  TO ITERATE THE WHOLE 'LinkedHashMap' (the same as 'HashMap');
			System.out.println(map1.getKey() + ", " + map1.getValue());
		}
		
		
		//                                                           TREE MAP:
		
		// The 'TreeMap' is a combination of 'HashMap' and 'TreeSet'.
		// It authomatecally sorts the elements according to the 'key' (i.e. the first element) 'numerical' or 'alphabetical' order.
		Map <Integer, String> months2 = new TreeMap<>(); 
		
		months2.put(11, "Nov");
		months2.put(2, "Feb");
		months2.put(9, "Sep");
		
		System.out.println(months2); // -> the print out is: {2=Feb, 9=Sep, 11=Nov}
		
		for (Map.Entry<Integer, String> map2 : months2.entrySet()) {    //  TO ITERATE THE WHOLE 'TreeMap' (the same as 'HashMap');
			System.out.println(map2.getKey() + ", " + map2.getValue());
		
		}
	}
}
/*
 * There are several differences between HashMap and Hashtable in Java:
 * 
 * The Hashtable class in Java is one of the oldest members of the Java Collection Framework. 
 * A hash table is an unordered collection of key-value pairs, with a unique key for each value. 
 * In a hash table, data is stored in an array of list format, with a distinct index value for each data value.
 * 
 *1. Hashtable is synchronized, whereas HashMap is not. This makes HashMap better for non-threaded applications, 
 *             as unsynchronized Objects typically perform better than synchronized ones.
 *2. Hashtable does not allow null keys or values. HashMap allows one null key and any number of null values.
 * */
