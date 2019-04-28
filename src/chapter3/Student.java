package chapter3;

import java.util.Date;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class Student implements Runnable {
	private Phaser phaser;
	
	public Student(Phaser phaser) {
		this.phaser = phaser;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + ": has arrived to do the exam." + new Date());
		phaser.arriveAndAwaitAdvance();
		System.out.println(Thread.currentThread().getName() + ": Is going to do the first exercise."+ new Date());
		doExercise1();
		System.out.println(Thread.currentThread().getName() +": has done the first exercise." + new Date());
		phaser.arriveAndAwaitAdvance();
		System.out.println(Thread.currentThread().getName() + ": Is going to do the second exercise."+ new Date());
		doExercise2();
		System.out.println(Thread.currentThread().getName() +": has done the second exercise." + new Date());
		phaser.arriveAndAwaitAdvance();
		System.out.println(Thread.currentThread().getName() + ": Is going to do the third exercise."+ new Date());
		doExercise3();
		System.out.println(Thread.currentThread().getName() +": has finished the exam." + new Date());
		phaser.arriveAndAwaitAdvance();
	}

	private void doExercise1() {
		long duration = (long) (Math.random() * 10);
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void doExercise2() {
		long duration = (long) (Math.random() * 10);
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void doExercise3() {
		long duration = (long) (Math.random() * 10);
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
