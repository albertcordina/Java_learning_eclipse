package interface_rules;
import java.util.*;
interface InventoryItem {

    void addToInventory(int quantity);
    void removeFromInventory(int quantity);
    int getAvailableQuantity();

}

class Product implements InventoryItem {

    private String name;
    private double price;
    private int quant;

    public Product (String name, double price) {
        this.name = name;
        this.price = price;
        this.quant = 0;
    }
    @Override
    public void addToInventory(int quantity) {
        if (quantity > 0) {
            quant += quantity;
            System.out.println(quantity + " " + name + "(s) added to inventory.");
        } else {
            System.out.println("Invalid quantity.");
        }
    }
    @Override
    public void removeFromInventory(int quantity) {
        if (quantity > 0 && quantity <= quant) {
            quant -= quantity;
            System.out.println(quantity + " " + name + "(s) removed from inventory.");
        } else {
            System.out.println("Invalid quantity or insufficient stock.");
        }
    }
    @Override
    public int getAvailableQuantity() {
        return quant;
    }
}

class Equipment implements InventoryItem {

    private String name;
    private double price;
    private int quant;

    public Equipment(String name, double price) {
        this.name = name;
        this.price = price;
        this.quant = 0;
    }

    public void addToInventory(int quantity) {
        if (quantity > 0) {
            quant += quantity;
            System.out.println(quantity + " " + name + "(s) added to inventory.");
        } else {
            System.out.println("Invalid quantity.");
        }
    }

    public void removeFromInventory(int quantity) {
        if (quantity > 0 && quantity <= quant) {
            quant -= quantity;
            System.out.println(quantity + " " + name + "(s) removed from inventory.");
        } else {
            System.out.println("Invalid quantity or insufficient stock.");
        }
    }

    public int getAvailableQuantity(){
        return quant;
    }
}

class InventoryManager {
    private List<InventoryItem> items;
    public InventoryManager() {
        items = new ArrayList<>();
    }
    public void addItem(InventoryItem item) {
        items.add(item);
    }
    public void removeItem(InventoryItem item) {
        items.remove(item);
    }
    public void displayInventory() {
        System.out.println("Inventory Contents:");
        for (InventoryItem item : items) {
            System.out.println(item.getAvailableQuantity() + " available - " + item.getClass().getSimpleName());
        }
    }
}


class Interface_InventoryManagement {

    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        
        InventoryItem product = new Product("Laptop", 999.99);
        InventoryItem equipment = new Equipment("Projector", 1499.99);
        
        // Add items to the inventory
        manager.addItem(product);
        manager.addItem(equipment);

        // Add and remove quantities
        product.addToInventory(10);
        equipment.addToInventory(5);
        product.removeFromInventory(2);

        // Display inventory
        manager.displayInventory();
    }
}
