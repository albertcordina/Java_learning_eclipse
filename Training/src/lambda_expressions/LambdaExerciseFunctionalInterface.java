package lambda_expressions;

import java.util.ArrayList;
import java.util.List;

public class LambdaExerciseFunctionalInterface {
    
    @FunctionalInterface
    interface StringOperation { String operate(String str);} // Custom functional interface for string operations
    
    @FunctionalInterface
    interface DataProcessor { void process(String data);}  // Custom functional interface for data processing
    
    public static void processData(List<String> data, DataProcessor processor) {
        for (String item : data) { processor.process(item);}
    }
    
    public static void main(String[] args) {
        // Create a list of data strings
        List<String> data = new ArrayList<>();
        data.add("apple");
        data.add("banana");
        data.add("cherry");
        data.add("date");
        
        // Define a lambda expression to convert each data string to uppercase
        StringOperation toUppercase = str -> str.toUpperCase();
        
        // Call the processData method to apply the conversion operation using a Consumer
        processData (data, item -> {
            String result = toUppercase.operate(item);
            System.out.println(result); });
    }
}

