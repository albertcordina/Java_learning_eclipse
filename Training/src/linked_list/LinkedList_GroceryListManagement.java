package linked_list;
import java.util.*;
class Grocery {
	
    String name;
    double price;
    
    public Grocery(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
class GroceryList {
    List<Grocery> itemList = new LinkedList<>();
    
    public void addItem(String name, double price) {// the method enters the 'NAME' and the 'PRICE' into the 'itemList';
        Grocery item = new Grocery(name, price);
        itemList.add(item);
    }
    public void displayList() {
        System.out.println("Grocery List:");
        for (int i = 0; i < itemList.size(); i++) {
            Grocery item = itemList.get(i);
            System.out.println((i + 1) + ". " + item.name +
                    " - $" + item.price);
        }
    }
}
public class LinkedList_GroceryListManagement {
    public static void main(String[] args) {
        GroceryList groceryList = new GroceryList();
        groceryList.addItem("Apples", 1.99);
        groceryList.addItem("Milk", 2.49);
        groceryList.addItem("Bread", 2.05);
        groceryList.addItem("Glass", 3.16);
        System.out.println("Initial Grocery List:");
        groceryList.displayList();
    }
}

