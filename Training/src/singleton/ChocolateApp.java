package singleton;

class ChocolateBoiler {
	
    private static ChocolateBoiler instance;
    private boolean empty;
    private boolean boiled;

    private ChocolateBoiler() {
        empty = true;
        boiled = false;
    }

    public static ChocolateBoiler getInstance() {
        if (instance == null) {
            synchronized (ChocolateBoiler.class) {
                if (instance == null) {
                    instance = new ChocolateBoiler();
                }
            }
        }
        return instance;
    }

    public void fill() {
        if (isEmpty()) {
            empty = false;
            boiled = false;
            System.out.println("Filling the chocolate boiler");
        } else {
            System.out.println("Chocolate boiler is already filled");
        }
    }

    public void boil() {
        if (!isEmpty() && !isBoiled()) {
            boiled = true;
            System.out.println("Boiling the chocolate");
        } else {
            System.out.println("Cannot boil. Chocolate boiler is either empty or already boiled.");
        }
    }

    public void drain() {
        if (!isEmpty() && isBoiled()) {
            empty = true;
            System.out.println("Draining the boiled chocolate");
        } else {
            System.out.println("Cannot drain. Chocolate boiler is either empty or not boiled.");
        }
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }
}

public class ChocolateApp {
	
    public static void main(String[] args) {
    	
        ChocolateBoiler boiler = ChocolateBoiler.getInstance();

        int numThreads = 3;

        for (int i = 0; i < numThreads; i++) {
            Thread thread = new Thread(() -> {
                ChocolateBoiler threadBoiler = ChocolateBoiler.getInstance();
                threadBoiler.fill();
                threadBoiler.boil();
                threadBoiler.drain();
            });
            thread.start();
        }
    }
}