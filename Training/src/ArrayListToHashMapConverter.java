import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ArrayListToHashMapConverter {

    public static <K, V> Map<K, V> convertToHashMap (List<Map.Entry<K, V>> entryList) {
    	
        return entryList.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static void main(String[] args) {
        // Example usage:
        ArrayList<Map.Entry<String, Integer>> arrayList = new ArrayList<>();
        arrayList.add(Map.entry("One", 1));
        arrayList.add(Map.entry("Two", 2));
        arrayList.add(Map.entry("Three", 3));

        Map<String, Integer> hashMap = convertToHashMap(arrayList);

        System.out.println("ArrayList: " + arrayList);
        System.out.println("HashMap: " + hashMap);
    }
}

