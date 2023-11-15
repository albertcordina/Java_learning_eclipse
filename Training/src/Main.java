import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
    	
    	List<String> names = List.of("Alice", "Bob", "Charlie");
    	names.stream().filter(s ->  s == "Bob").forEach(System.out :: println);
    	
    	List <Integer> numbers = List.of(5, 8, 12, 25);
    	numbers.stream().filter(n ->   n > 6).forEach(System.out :: println);
    	
    	//names.sort((s1, s2) -> s1.compareTo(s2));

    }
}