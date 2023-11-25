package thread_miscellaneous;

import java.util.*;

public class Thread_Sleep {
    public static void main(String[] args) {

        Love love = new Love ();
        love.start(); // method 'start' activates the method 'run' below;
    }
}

class Love extends Thread {

    public void run () {                                                     // method 'run' belongs to the class 'Thread';
        for (int i = 1; i <= 10; i++) {                                     // select the number of printouts;
            System.out.println("The player number " + i + " is starting.");
            try { sleep(500); }                                     // method 'sleep' pauses the printouts;
            catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}
