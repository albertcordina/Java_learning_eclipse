package hashSet;
import java.util.*;
public class HashSet_Unique_numbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        Set <Integer> number = new HashSet <>();
        int option;

        do { System.out.print("\nPress:  '1' to enter your number\n\t\t'2' to see the amount of your numbers"
                + "\n\t\t'3' to see the whole list of your numbers\n\t\t'4' to Exit\n\nPlease, enter here: ");
            option = scanner.nextInt();

            if (option == 1) {
                System.out.print("Please, enter your number: ");
                int enter = scanner.nextInt();
                number.add(enter);
            }

            if (option == 2) {
                System.out.println("See the number of your numbers: " + number.size());

            }

            if (option == 3) {
                System.out.println("See the whole list: \n");
                for (int x : number) {
                    System.out.println(x);
                }
            }
        }
        while (option != 4);
        System.out.println("\nThank you!");
        scanner.close();
    }
}





/*

Guidelines:
Create a Set to store unique numbers.
Implement a loop that displays a menu with the following options:

Input numbers
Count unique numbers
Display unique number count
Exit

Depending on the selected option, perform the following tasks:

To input numbers, take input from the user and add them to the Set.
To count unique numbers, retrieve the size of the Set.
To display the unique number count, print the count.
To exit, terminate the program.
Handle input validation to prevent errors when handling menu options. */