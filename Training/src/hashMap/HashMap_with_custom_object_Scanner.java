package hashMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMap_with_custom_object_Scanner {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Map<Integer, Help> list = new HashMap<>();

        System.out.print("Enter you name: ");
        String name = scan.nextLine();

        System.out.print("Enter you surname: ");
        String surname = scan.nextLine();

        System.out.print("Enter your age: ");
        int age = scan.nextInt();

        System.out.print("Enter your phone number: ");
        int phoneNumber = scan.nextInt();

        System.out.print("Enter the password: ");
        String password = scan.nextLine();
        password = scan.nextLine();

        list.put(phoneNumber, new Help(name, surname, age, password ));

        System.out.println("\n\n" + list.get(phoneNumber).getName());
        System.out.println(list.get(phoneNumber).getSurname());
        System.out.println(list.get(phoneNumber).getAge());
        System.out.println(list.get(phoneNumber).getPassword());

        for (Map.Entry<Integer, Help> map : list.entrySet()) {   //  TO ITERATE THE WHOLE 'HashMap' (used mainly only for a review);
            System.out.println("\n\nThe phone number is " + map.getKey() + map.getValue());}
//---------------------------------------------------------------------------------------------------
        //    changing one of the parameters of the object/value;
        System.out.print("Enter your new name: "); // e.g. collect a new name;
        String newName = scan.nextLine();

        list.put(phoneNumber, new Help(newName, surname, age, password)); // placing a new name;

//---------------------------------------------------------------------------------------------------
        for (Map.Entry<Integer, Help> map : list.entrySet()) {   //  TO ITERATE THE WHOLE 'HashMap' (used mainly only for a review);
            System.out.println("\n\nThe phone number is " + map.getKey() + map.getValue());}

        scan.close();
    }
}

class Help {

    private int phoneNumber;
    private int age;
    private String name;
    private String surname;
    private String password;

    public Help(String name, String surname, int age, String password) { // constructor;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.password = password;
    }
    public String toString () { return "\nYour name is " + name + "\nYour surname is " + surname + "\nYour age is: " +
            age + "\nThe password is " + password;}   // toString method;


    //  get methods:
    public String getName () { return  "Your name is " + name;}
    public String getPassword () { return  "Your password is " + password;}
    public String getSurname () { return  "Your surname is " + surname;}
    public String getAge () { return  "Your age is " + age;}
}
