package thread_miscellaneous;

public class TrafficIntersectionSimulation {
    public static void main(String[] args) {
    	
 // create the objects of class 'TrafficLane' and give them the String 'name' according to the constructor below;
        TrafficLane northSouthLane = new TrafficLane("North-South Lane");
        TrafficLane eastWestLane = new TrafficLane("East-West Lane");
        TrafficLane diagonalLane = new TrafficLane("Diagonal Lane");
        northSouthLane.start();
        eastWestLane.start();
        diagonalLane.start();
    }
}
class TrafficLane extends Thread {
	
    public TrafficLane(String name) { super(name);} // the constructor is for the three objects in the main method above;
    
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + ": Vehicle " + i + " enters the intersection.");
            System.out.println();
            try { sleep(2000); } // Simulate vehicle arrivals at different times
            catch (InterruptedException e) { System.out.println(getName() + " was interrupted.");}
        }
    }
}
