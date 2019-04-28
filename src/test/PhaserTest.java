package test;

import java.util.concurrent.Phaser;

public class PhaserTest {

	public static void main(String[] args) {
		
		Phaser phaser = new Phaser(1);
		Job job =new Job(phaser);
		Thread thread = new Thread(job);
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Terminated : " + phaser.isTerminated());

	}

}

class Job implements Runnable{
	private Phaser phaser;
	
	public Job(Phaser phaser) {
		this.phaser = phaser;
	}

	@Override
	public void run() {
		phaser.arriveAndAwaitAdvance();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("all threads are ready : phaser is " + phaser.getPhase());
		
		phaser.arriveAndAwaitAdvance();
		
		System.out.println("started : phaser is " + phaser.getPhase());
		
		phaser.arriveAndAwaitAdvance();
		
		System.out.println("started : phaser is " + phaser.getPhase());
		
		phaser.arriveAndAwaitAdvance();
		
		System.out.println("started : phaser is " + phaser.getPhase());
		
		phaser.arriveAndDeregister();
		
		
		System.out.println("ended : work completed ");
		
		
	}
	
}
