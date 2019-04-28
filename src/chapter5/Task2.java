package chapter5;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

public class Task2 extends RecursiveTask<Integer> {
	private int[] array;
	private int start,end;
	
	public Task2(int[] array, int start, int end) {
		this.array = array;
		this.start = start;
		this.end = end;
	}
	

	@Override
	protected Integer compute() {
		System.out.println("Task: Start from " + start + " to " + end);
		if(end - start < 10) {
			if((start<3) && (end>3)) {
				throw new RuntimeException("This task throws an Exception:  Task from "+start + " to " + end);
			}
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			int mid = (start + end) / 2;
			Task2 task1 = new Task2(array, start, mid);
			Task2 task2 = new Task2(array, mid, end);
			invokeAll(task1,task2);
		}
		System.out.println("Task: End from " + start + " to " + end);
		return 0;
	}

}
