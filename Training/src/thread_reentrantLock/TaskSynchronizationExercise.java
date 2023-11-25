package thread_reentrantLock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
public class TaskSynchronizationExercise {
	
    private int taskCount = 0;  // integer variable that keeps track of the number of completed tasks.
    private final int requiredTasks = 10;//integer constant that specifies the total number of tasks that need to be completed (set to 10).
    private final ReentrantLock taskLock = new ReentrantLock();//ReentrantLock instance used for synchronization.
    
    //Condition instance associated with the taskLock. It will be used to signal and await task completion.
    private final Condition taskCompleted = taskLock.newCondition();
    
    public static void main(String[] args) {
    	
        TaskSynchronizationExercise task = new TaskSynchronizationExercise();
        TaskExecutor taskExecutor = task.new TaskExecutor();
        TaskMonitor taskMonitor = task.new TaskMonitor();
        
        taskExecutor.start(); //These lines start the TaskExecutor and TaskMonitor threads
        taskMonitor.start();
    }
    class TaskExecutor extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < requiredTasks; i++) {
                taskLock.lock(); //The taskLock is locked by this thread.
                try {
                    taskCount++; //The taskCount is incremented to represent the completion of a task.
                    System.out.println("Task " + taskCount + " is completed.");
                            taskCompleted.signal();} //The signal method is called on the taskCompleted condition
                finally { taskLock.unlock();} // the taskLock is unlocked to release the lock whether or not an exception occurs.
            }
        }
    }
    class TaskMonitor extends Thread {
        @Override
        public void run() {
            taskLock.lock(); //The taskLock is locked to ensure exclusive access to the shared variables and conditions.
            try {  
                while (taskCount < requiredTasks) { //A while loop is used to check if the number of completed tasks is less than the total required tasks.
                	
                    try {taskCompleted.await();} //The await method is called on the taskCompleted condition, which makes the TaskMonitor thread   
                    catch (InterruptedException e) { e.printStackTrace();} // wait until it is signaled by the TaskExecutor thread. 
                }
                System.out.println("Required tasks are completed!");
            } finally { taskLock.unlock();} //the taskLock is unlocked to release the lock
        }
    }
}
