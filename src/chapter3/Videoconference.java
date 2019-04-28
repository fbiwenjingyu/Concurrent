package chapter3;

import java.util.concurrent.CountDownLatch;

public class Videoconference implements Runnable {
	private final CountDownLatch controller;
	
	public Videoconference(int number) {
		this.controller = new CountDownLatch(number);
	}
	
	public void arrive(String name) {
		System.out.println(name + " has arrived");
		controller.countDown();
		System.out.println("Videoconference: Waiting for " + controller.getCount() + " participants");
	}

	@Override 
	public void run() {
		System.out.println("Videoconference: Initialization:  " + controller.getCount() + " participants");
		try {
			controller.await();
			System.out.println("Videoconference: All the participants have come");
			System.out.println("Videoconference: Let's start...");
		}catch(InterruptedException e) {
			e.printStackTrace();
		}

	}

}
