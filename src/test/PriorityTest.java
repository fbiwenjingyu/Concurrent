package test;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityTest {
	public static void main(String[] args) throws InterruptedException {
		PriorityBlockingQueue<User> queue = new PriorityBlockingQueue<>(10, new Comparator<User>(
				
				) {

					@Override
					public int compare(User o1, User o2) {
						// TODO Auto-generated method stub
						return o1.getAge().compareTo(o2.getAge());
					}
		});
		
		queue.put(new User("ywj", 88));
		queue.put(new User("gwr", 78));
		queue.put(new User("xxx", 98));
		
		while(!queue.isEmpty()) {
			System.out.println(queue.take());
		}
	}
}
