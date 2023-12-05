package array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Array_list {
	
    public static void main(String[] args) {
        // ArrayList = a resizable array. 2:06;
        //             Elements can be added and removed after compilation phase
        //             store reference data types

        List<String> food = new ArrayList<>();
       // List<String> food = Arrays.asList("milk", "butter"); // with 'asList' only 'set' works

        food.add("pizza"); //  'add' method is to add a value;
        food.add("hamburger");
        food.add("hot_dog");
       
        food.set(0, "sushi"); // 'set' method is to replace a value;
       // food.remove(2); // 'remove' method is to remove a value;
      //  food.clear();         // 'clear' method is to remove all the values;

        for (int i=0; i<food.size(); i++) {  // to print out the all ArrayList
            System.out.println(food.get(i));}
        food.forEach(System.out :: println); // to print out the all ArrayList (shorter way)
        System.out.println(food);           // even shorter way
        System.out.println(food.get(0));   // print out the 'value' of the List
        

        //      Training:
        List<Integer> list = new ArrayList<>();

        list.add(9);
        list.add(52);
        list.add(121);

        System.out.println(list.get(0)); // get the '9' to print out;

        // via 'for loop': printing all the elements of the Array;
        for (Integer n : list) { System.out.println(n);}

        for (int i = 0; i < list.size(); i++){
            Integer n = list.get(i);
            System.out.println(i + ": " + n);
        }
    }
}