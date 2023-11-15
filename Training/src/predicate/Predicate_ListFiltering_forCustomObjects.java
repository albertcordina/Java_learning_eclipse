package predicate;
//Java program to demonstrate working of predicates 
//on collection. The program finds all admins in an arrayList of users. 
import java.util.function.Predicate;
import java.util.*;

public class Predicate_ListFiltering_forCustomObjects extends Objects {

    Predicate_ListFiltering_forCustomObjects(String a, String b) { // Constructor
        super(a, b);
    }
    public static void main(String[] args) {

        Objects.function();
    }
}
//----------------------------------------------------------------------

 class Objects {

    String name, role;

    Objects (String a, String b) {
        name = a;
        role = b; }

    String getRole() { return role;} // get method: to get the result of the parameter 'Role'
    String getName() { return name;} //             to get the result of the parameter 'name'

    public String toString() { return "User Name : " + name + ", Role :" + role;} // to create a String

    public static void function () {

        List <Objects> users = new ArrayList <Objects> (); // Objects is the name of the class

        users.add(new Objects("John", "admin"));
        users.add(new Objects("Peter", "member"));

        // calling the method 'filterAndSave' below and setting the filter requirements 
        List admins = filterAndSave (users, (Objects u) -> u.getRole().equals("admin"));
        System.out.println(admins); // print out the filtered List

        List member = filterAndSave (users, (Objects u) -> u.getRole().equals("member"));
        System.out.println(member);

    }

    public static List <Objects> filterAndSave (List <Objects> a, Predicate <Objects> predicate) {

        List <Objects> result = new ArrayList<Objects>();

        for (Objects b : a)         // iterate through the list of objects 'b'
            if (predicate.test(b)) //  filter the objects 'b' according to the conditions via 'predicate'
                result.add(b);    //   add the filtered List of objects 'b' to the List 'result'
        return result;           //    return the result
    }
}
