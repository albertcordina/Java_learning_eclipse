package array;

import java.util.ArrayList;
/*
StringBuffer - converter of the list of objects to a String.
The principal operations on a StringBuffer are the 'append' and 'insert' methods, which are overloaded to accept data of any type.
Each effectively converts a given datum to a string and then appends or inserts the characters of that string to the string buffer.

 */
public class ArrayList_toString_Buffer {

    private static ArrayList<String> al = new ArrayList<String>();

    public static void main(String args[]) {

      //  ArrayList<String> al = new ArrayList<String>();

        al.add("Hello");
        al.add("are");
        al.add("you");

        StringBuffer sb1 = new StringBuffer(); // create an object of the class 'StringBuffer'
        for (String s : al) {                 //  iterate through the whole ArrayList
            sb1.append(s);                   //   'append' method is overloaded to accept data of any type
            sb1.append(" "); }              //    to make a space between the objects

        String str1 = sb1.toString(); // String 'str1' contains the converted current info of the ArrayList into the String
        System.out.println(str1);

        al.add("happy?"); //  here we add another String into the ArrayList and repeat the process to save the new data to the new String

        StringBuffer sb2 = new StringBuffer();
        for (String s : al) {
            sb2.append(s);
            sb2.append(" "); }

        String str2 = sb2.toString(); // String 'str2' contains also the additional 'happy!'

        System.out.println(str2);
        System.out.println(str1);
        
        
//------------------------------------------- also via the method below -------------------------------------------------------
        
        System.out.println(info(info)); // calling the method for saving an updated data of ArrayList to String whenever it's needed
    }
    private static String info;
    public static String info (String info) {

        StringBuffer sb = new StringBuffer();
        for (String n : al) {

            sb.append(n);
            sb.append(" ");
            info = sb.toString(); };
        return info;
    }
}