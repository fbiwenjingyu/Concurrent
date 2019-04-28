package chapter1;

import java.util.concurrent.TimeUnit;

public class Main9 {
	public static void main(String[] args) {
		ThreadGroup threadGroup = new ThreadGroup("Searcher");
		Result result = new Result();
		SearchTask searchTask = new SearchTask(result);
		for(int i=0;i<5;i++) {
			Thread thread = new Thread(threadGroup, searchTask);
			thread.start();
			
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Number of threads : " + threadGroup.activeCount());
		System.out.println("Information about the Thread Group");
		threadGroup.list();
		
		Thread threads[] = new Thread[threadGroup.activeCount()];
		threadGroup.enumerate(threads);
		for(int i=0;i<threadGroup.activeCount();i++) {
			System.out.println("Thread " + threads[i].getName() + " : " + threads[i].getState());
		}
		waitFinish(threadGroup);
		threadGroup.interrupt();
	}

	private static void waitFinish(ThreadGroup threadGroup) {
		while(threadGroup.activeCount() > 9) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
