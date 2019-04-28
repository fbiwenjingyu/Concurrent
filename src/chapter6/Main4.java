package chapter6;

import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

public class Main4 {

	public static void main(String[] args) {
		DelayQueue<Event2> queue = new DelayQueue<>();
		Thread threads[] = new Thread[5];
		for(int i=0;i<threads.length;i++) {
			Task2 task = new Task2(i + 1, queue);
			threads[i] = new Thread(task);
		}
		for(int i=0;i<threads.length;i++) {
			threads[i].start();
		}
		for(int i=0;i<threads.length;i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		do {
			int counter = 0;
			Event2 event;
			do {
				event = queue.poll();
				if(event != null) {
					counter++;
				}
			}while(event != null);
			System.out.println("At " + new Date() + " you have read " + counter + " events");
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(queue.size() > 0);
	}

}
