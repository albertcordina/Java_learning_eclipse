package thread_miscellaneous;
class ProductionLine {
	
	public void producePart(String partName, String workerName) {
		
		synchronized (this) {
			System.out.println(workerName + " produced part: " + partName);
			try { Thread.sleep(1000);} 
			catch (InterruptedException e) { System.out.println(e);}
		}
	}

	public void assembleProduct(String productName, String workerName) {
		
		synchronized (this) {
			System.out.println(workerName + " assembled product: " + productName);
			try { Thread.sleep(1000);} // Sleep for 1 second
			catch (InterruptedException e) { System.out.println(e);}
			}
		}
	}
//---------------------------------------------------------------------------
public class ThreadArray_ProductionLineExample {
	
	public static void main(String[] args) {
		
		ProductionLine productionLine = new ProductionLine();
		
		int numberOfWorkers = 6;
		Thread[] workerThreads = new Thread[numberOfWorkers];
		
		for (int i = 0; i < numberOfWorkers; i++) {
			final String workerName = "Worker" + i;
			workerThreads[i] = new WorkerThread(productionLine, workerName);
			workerThreads[i].start(); }
		
		// Allow the program to run for 10 seconds
		try { Thread.sleep(10000);} 
		catch (InterruptedException e) { e.printStackTrace();}
	}
}
//---------------------------------------------------------------------------
class WorkerThread extends Thread {
	
	private ProductionLine productionLine;
	private String workerName;

	public WorkerThread(ProductionLine productionLine, String workerName) {
		this.productionLine = productionLine;
		this.workerName = workerName;}

	@Override
	public void run() {
		for (int j = 0; j < 3; j++) {
			String partName = "Part" + j;
			productionLine.producePart(partName, workerName);
			String productName = "Product" + j;
			productionLine.assembleProduct(productName, workerName); }
	}
}