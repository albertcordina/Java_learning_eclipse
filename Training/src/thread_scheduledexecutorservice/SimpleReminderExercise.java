package thread_scheduledexecutorservice;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SimpleReminderExercise {
	
    public static void main(String[] args) {
    	
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the reminder message: ");
        String reminderMessage = scanner.nextLine();
        
        System.out.print("Enter the time delay (in seconds): ");
        long timeDelay = scanner.nextLong();
        
        Runnable reminderTask = new Runnable() {
            @Override
            public void run() {
                System.out.println("Reminder: " + reminderMessage);
                executor.shutdown();
            }
        };
        executor.schedule(reminderTask, timeDelay, TimeUnit.SECONDS);
        
        scanner.close();
    }
}