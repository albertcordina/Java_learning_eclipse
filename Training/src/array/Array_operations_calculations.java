package array;
import java.util. *;
public class Array_operations_calculations {

    public static void main(String[] args) {

        int [] arr = {3,2,1,4,5,6};
        for (int x : arr) {System.out.println(x);} // the number of the elements in the Array (no need a method);

        Arrays.sort(arr);                          // the method 'sort()' for printing out
        for (int x : arr) {System.out.println(x);} // all the elements in their uprising values (import java.util.*; is needed);

        Integer [] array = {3,2,1,4,5,6};               // the method 'sort(... , Collections.reverseOrder()) is for
        Arrays.sort(array, Collections.reverseOrder()); // printing out in counting down all the values of the Array (the variable should be 'reference' type);
        for (int x : array) {System.out.println(x);}

        System.out.println(sum(arr));
        System.out.println(average(arr));
        double ave = average(arr);
        System.out.println(maximum(arr));
        System.out.println(aboveAverage(arr,ave));


        int [] [] arr2 = {{1,2,3},{1,2,3}};
        printOut(arr2);                       // the number of the elements in the 2D Array (needs a method, see below);

        System.out.println(sum2d(arr2));
        System.out.println(max2d(arr2));
        System.out.println(average2d(arr2));
        System.out.println(even(arr2));

    }

    // the method for calculating the sum of the Array
    public static int sum (int [] arr) {
        int x = 0;
        for (int y : arr) { x += y;}
        return x;}

    //  the method for finding the maximum or minimum element of the Array
    // NOTE: always save the calculation of the current result in a variable
    public static int maximum (int [] numbers) {
        int maxSoFar = numbers [0];
        for (int num : numbers) { if (num > maxSoFar) {	maxSoFar = num;}}
        return (maxSoFar);}

    public static int minimum (int [] numbers) {
        int minSoFar = numbers [0];
        for (int num : numbers) { if (num < minSoFar) {	minSoFar = num;}}
        return (minSoFar);}

    // the method for finding the average of the Array
    public static double average (int [] arr) {
        int x = 0;
        for (int y : arr) { x += y;}
        return x/arr.length; }

    // the method of calculating the number of elements above the average of the Array
    public static int aboveAverage (int [] arr, double ave) {
        int x = 0;
        for (int y : arr) { if (y < ave) { x++;}}
        return x; }

    //------------------------- THE 2D ARRAYS -----------------------------------

    public static void printOut (int [] [] arr2) {

        for (int [] x : arr2) {
            for (int y : x) {
                System.out.print(y); // print out the 2D Array in one line;
            }
            //System.out.println(); // print out the 2D Array in the two lines;
        }
    }

    //  the method of calculating the sum of the 2D Array
    public static int sum2d (int [] [] arr2) {

        int x = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                x += arr2 [i] [j]; }
        }
        return x;
    }

    //  the method of calculating the maximum/ minimum of the 2D Array
    public static int max2d (int [] [] arr2) {
        int x = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                if (arr2 [i] [j] > x) {
                    //  (arr2d [i] [j] < x) -> for minimum of the 2D Array;
                    x = arr2 [i] [j]; }
            }
        }
        return x;
    }

    //  the method of calculating the average of the 2D Array
    public static int average2d (int [] [] arr2) {

        int x = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                x += arr2 [i] [j]; }
        }
        return x/ arr2.length;
    }

    // the method of calculating the even numbers of the 2D Array
    public static int even (int [] [] arr2) {
        int x = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                if (arr2[i] [j] % 2 == 0) {
                    x ++; }
            }
        }
        return x;
    }
}