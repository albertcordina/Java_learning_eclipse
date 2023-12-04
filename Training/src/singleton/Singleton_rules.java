package singleton;
/*
 * Singleton is a design pattern that ensures a class has only one instance 
 * and provides a global point of access to that instance. 
 * This pattern is useful when exactly one object is needed to coordinate actions across the system.

Here's a simple example of a Singleton in Java:
 * 
 */
class Singleton {
/*
 * In this example:
 * 
 * 1. The class has a private static instance variable, instance, 
 *         which holds the single instance of the class.
   2. The constructor of the class is private to prevent external instantiation.
   3. The getInstance() method is the only way to get an instance of the class. 
      It creates the instance if it doesn't exist yet and returns the existing instance otherwise.
   4. The showMessage() method is an example of a method that can be called on the singleton instance.
 * 
 */
    // Create the single instance of the class, NOTE: must be 'private'
    private static Singleton instance;

    // Create the 'private' constructor to prevent instantiation from outside the class
    private Singleton() {
        // Initialization code, if needed
    }  //  Note: must be 'private'

    /*
     * Public method to provide the global point of access to the instance,
     * i.e. the only way to get an instance of this class is via this method.
     *  Must be 'public' and 'static'.
     *  Therefore, this method is the only 'key' to get an access for other classes!
     *   see below the class 'Singleton_rules'.
     */
    //  
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // Other methods and fields of the class can be added as needed

    public void showMessage() {
        System.out.println("Hello, I am a Singleton!");
    }
    /*
     * Using the Singleton pattern ensures that there is only one instance of the class in the system, 
     * and it provides a global point of access to that instance. This can be useful in scenarios 
     * where you want to control access to a shared resource or maintain a single point 
     * of control for certain functionalities.
     * 
     */
}
class Singleton_rules {
	/*
	 * In the direct way singleton1 and singleton2 are references to two separate instances of 
	 * the Singleton class. Such code doesn't implement the Singleton pattern, as it allows 
	 * the creation of multiple instances directly using the new keyword:
	 * 
	 * Syngletone singletone1 = new Singleton ();
	 * Syngletone singletone2 = new Singleton ();
	 * 
	 * With Singletone the both singleton1 and singleton2 are references 
	 *   to the same instance of the Singleton class:
	 */
	public static void main(String[] args) {
		
		Singleton singletone1 = Singleton.getInstance();
		singletone1.showMessage();
		
		Singleton singletone2 = Singleton.getInstance();
		singletone2.showMessage();
		
		
	}
}


