package chapter5;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Main4 {

	public static void main(String[] args) {
		int array[] = new int[100];
		Task2 task = new Task2(array, 0, 100);
		ForkJoinPool pool = new ForkJoinPool();
		pool.execute(task);
		pool.shutdown();
		try {
			pool.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(task.isCompletedAbnormally()) {
			System.out.println("Main: An exception has ocurred");
			System.out.println("Main: " + task.getException());
		}
		System.out.println("Main : Result: " + task.join());

	}

}
