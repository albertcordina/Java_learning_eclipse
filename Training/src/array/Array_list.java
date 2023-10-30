package array;
import java.util.ArrayList;
public class Array_list {
    public static void main(String[] args) {
        // ArrayList = a resizable array. 2:06;
        //             Elements can be added and removed after compilation phase
        //             store reference data types

        ArrayList<String> food = new ArrayList<>();

        food.add("pizza"); //  'add' method is to add a value;
        food.add("hamburger");
        food.add("hot_dog");

        food.set(0, "sushi"); // 'set' method is to replace a value;
        food.remove(2); // 'remove' method is to remove a value;
        food.clear();         // 'clear' method is to remove all the values;

        for (int i=0; i<food.size(); i++) {  // to print out the all ArrayList;
            System.out.println(food.get(i));
        }

        //      Training:
        ArrayList<Integer> list = new ArrayList<>();

        list.add(9);
        list.add(52);
        list.add(121);

        System.out.println(list.get(0)); // get the '9' to print out;

        // via 'for loop': printing all the elements of the Array;
        for (Integer n : list) {
            System.out.println(n);
        }

        for (int i = 0; i < list.size(); i++){
            Integer n = list.get(i);
            System.out.println(i + ": " + n);
        }
    }
}