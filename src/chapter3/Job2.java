package chapter3;

public class Job2 implements Runnable {
	private PrintQueue2 printQueue;
	
	public Job2(PrintQueue2 printQueue) {
		this.printQueue = printQueue;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " : Going to print a job");
		printQueue.printJob(new Object());
		System.out.println(Thread.currentThread().getName() +" : The document has been printed");
	}

}
