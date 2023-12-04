package singleton;

class SingletonExample {

    // The single instance of the class
    private static SingletonExample instance;

    // Private constructor to prevent instantiation from outside the class
    private SingletonExample() { }

    // Public method to provide the access to the instance
    public static SingletonExample getInstance() {
        if (instance == null) {
            instance = new SingletonExample();
        }
        return instance;
    }

    // Example method to demonstrate the usage of the Singleton instance
    public void displayMessage() {
        System.out.println("Hello, I am the SingletonInstance!");
    }
}

public class SingletonClient {

    public static void main(String[] args) {
    	
        // Obtain and display the message using the Singleton instance
        SingletonExample singletonInstance1 = SingletonExample.getInstance();
        singletonInstance1.displayMessage();

        // Try to create another instance (it should still refer to the same instance)
        SingletonExample singletonInstance2 = SingletonExample.getInstance();
        singletonInstance2.displayMessage();

        // Check if both instances refer to the same instance
        if (singletonInstance1 == singletonInstance2) {
            System.out.println("Both instances refer to the same Singleton instance.");
        } else {
            System.out.println("Error: Instances do not refer to the same Singleton instance.");
        }
    }
}

