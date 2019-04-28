package chapter1;

import java.util.Date;

public class Main5 {
	public static void main(String[] args) {
		Object lock = new Object();
		DataSourceLoader dsloader = new DataSourceLoader(lock);
		NetworkConnectionLoader ncLoader = new NetworkConnectionLoader(lock);
		
		Thread thread1 = new Thread(dsloader);
		Thread thread2 = new Thread(ncLoader);
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Main : Configuration has been loaded " + new Date());
	}
}
