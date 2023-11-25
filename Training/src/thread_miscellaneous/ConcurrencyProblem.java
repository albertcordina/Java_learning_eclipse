package thread_miscellaneous;

 class Sender {
	
	public void sendMessage (String message) {
		System.out.println("Sending" + message);
		System.out.println(message + " sent");
	}

}
//-----------------------------------------------------------
class ThreadSafetyExample extends Thread {
	
	private String message;
	private Sender sender;
	
	ThreadSafetyExample (String message, Sender sender) {
		this.message = message;
		this.sender = sender;
	}
	
	public void run () { sender.sendMessage(message); } // method 'run' belongs to the class 'Thread';
	
}
//-----------------------------------------------------------
public class ConcurrencyProblem {
	
	public static void main(String[] args) {

		Sender sender = new Sender();
		
		ThreadSafetyExample thread1 = new ThreadSafetyExample("Hi",sender);
		ThreadSafetyExample thread2 = new ThreadSafetyExample("Bye",sender);

		thread1.start(); // method 'start' gets always run in the main method and it activates 
		thread2.start(); // the objest 'thread1/2' and the method 'run' inside the extended to 'Thread' class above;
	}
	
}
