package linked_list;
import java.util.*;//     to import all the 'utilities' of Java;

public class LinkedList_rules {
	       
	        /*  the common area is the List Interface;
	            the main difference between the 'ArrayList' and 'LinkedList' is the way they store the data.
	            LinkedList has its elements in a doubly-linked-list and used more for data addition or deletion (does not contain Arrays).
	            ArrayList is used more in data reading scenarios;
	            LinkedList consists of the 'Nodes'. And the 'Nodes' contain the 3 objects: 1.Previous reference(address/link), 2. Value and the 3. Next reference(address/link);
	            Therefore, the first and the last references are always 'Null';
	         */

	        public static void main(String[] args) {
	            LinkedList<String> listItems = new LinkedList<>();
	            listItems.add("Item 1"); // add(element);
	            listItems.add("Item 2");
	            listItems.add("Item 3");

	            for (String x : listItems) {
	                System.out.println(x);
	            } // iterate all the elements of the LinkedList;

	            for (int i = 0; i < listItems.size(); i++) {        // print out all the elements of the LinkedList;
	                String s = listItems.get(i);
	                System.out.println(i + ": " + s);
	            }
	            List<Integer> numbers = new ArrayList<>();  // 'List<Integer>' is a super
	            numbers.add(3);
	            numbers.add(53);
	            numbers.add(125);

	            /*  Most common mehtods of the LinkedList:

	             * get(index);
	             * getFirs(index);
	             * getLast(index);
	             * add(element);
	             * add(index, element);
	             * addFirst(element) and addLast(element);
	             * remove(index);
	             * removeFirs() and removeLast();
	             * clear();
	             */

	        }
	        public static void showList(List<Integer> list) {  // 'List<Ineger> list' is an access to the all 'Integer 'LinkedList' or Arrya Lists'
	            // of the class. It is a part of the polymorphism;
	            for (Integer num : list) {
	                System.out.println(num);
	            }
	        }
	    }