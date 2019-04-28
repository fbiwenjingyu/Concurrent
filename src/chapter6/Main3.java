package chapter6;

import java.util.concurrent.PriorityBlockingQueue;

public class Main3 {

	public static void main(String[] args) {
		PriorityBlockingQueue<Event> queue = new PriorityBlockingQueue<>();
		Thread taskThreads[] = new Thread[5];
		for(int i=0;i<taskThreads.length;i++) {
			Task task = new Task(i, queue);
			taskThreads[i] = new Thread(task);
		}
		for(int i=0;i<taskThreads.length;i++) {
			taskThreads[i].start();
		}
		
		for(int i=0;i<taskThreads.length;i++) {
			try {
				taskThreads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Main: Queue size : " + queue.size());
		for(int i=0;i<taskThreads.length * 1000;i++) {
			Event event = queue.poll();
			System.out.println("Thread " + event.getThread() + ":Priority " + event.getPriority());
		}
		System.out.println("Main: Queue size " + queue.size());
		System.out.println("Main: end of program");
	}

}
