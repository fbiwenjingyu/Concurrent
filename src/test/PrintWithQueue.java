package test;

import java.util.concurrent.ArrayBlockingQueue;

public class PrintWithQueue {

	public static void main(String[] args) throws Exception{
		ArrayBlockingQueue<String> queueA = new ArrayBlockingQueue<>(1);
		ArrayBlockingQueue<String> queueB = new ArrayBlockingQueue<>(1);
		ArrayBlockingQueue<String> queueC = new ArrayBlockingQueue<>(1);
		queueB.put("B");
		queueC.put("C");
		
		Thread thread1 = new Thread(new PrintJob("Thread A", queueA, queueB, queueC));
		Thread thread2 = new Thread(new PrintJob("Thread B", queueA, queueB, queueC));
		Thread thread3 = new Thread(new PrintJob("Thread C", queueA, queueB, queueC));
		thread1.start();
		thread2.start();
		thread3.start();
	}
	
	public static void doPrintJobA() {
		
	}

}

class PrintJob implements Runnable{
	private String jobName;
	ArrayBlockingQueue queueA;
	ArrayBlockingQueue queueB;
	ArrayBlockingQueue queueC;
	
	
	
	public PrintJob(String jobName, ArrayBlockingQueue queueA, ArrayBlockingQueue queueB, ArrayBlockingQueue queueC) {
		this.jobName = jobName;
		this.queueA = queueA;
		this.queueB = queueB;
		this.queueC = queueC;
	}



	@Override
	public void run() {
		
		
	}
	
}

