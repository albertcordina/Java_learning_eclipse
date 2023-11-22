package string_methods_manipulations;

public class StringBuilder {
/*
        The StringBuilder class in Java is used for creating and manipulating mutable sequences of characters.
        It is used for dynamic string manipulation, such as building strings from many smaller strings or appending new characters to an existing string.
        It is more efficient than String when it comes to concatenating or modifying strings frequently. Here's a simple example:
 */
    public static void main(String[] args) {

        // Creating a StringBuilder object
        java.lang.StringBuilder stringBuilder = new java.lang.StringBuilder();

        // Appending strings
        stringBuilder.append("Hello");
        stringBuilder.append(" ");
        stringBuilder.append("World");

        // Converting StringBuilder to String
        String result = stringBuilder.toString();
        System.out.println(result); // Displaying the result: 'Hello World'

        
        // Inserting at a specific position
        stringBuilder.insert(6, "Awesome ");
        System.out.println(stringBuilder.toString()); // Displaying the modified result: 'Hello Awesome World'

        // Deleting a portion of the StringBuilder
        stringBuilder.delete(0, 5);                    // Deleting 'Hello'
        System.out.println(stringBuilder.toString()); //  Displaying the final result: 'Awesome World'

        
        // Mutable StringBuilder- prints out the WHOLE LENGTH of the text;
        java.lang.StringBuilder str = new java.lang.StringBuilder("Oh my God! It's started to rain!");
        str.append("");
        System.out.println(str.length()); // prints out: '32'

    }
}
