package chapter1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class UnsafeTask implements Runnable {
	private Date startDate;
	@Override
	public void run() {
		startDate = new Date();
		System.out.println("Starting thread : " + Thread.currentThread().getId() + " : " +startDate);
		try {
			TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread finished : " + Thread.currentThread().getId() + " : " + startDate);
	}

}
