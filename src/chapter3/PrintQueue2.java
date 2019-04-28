package chapter3;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue2 {
	private final Semaphore semaphore;
	private boolean freePrinters[];
	private Lock lockPrinters;
	public PrintQueue2() {
		semaphore = new Semaphore(3);
		freePrinters = new boolean[3];
		for(int i=0;i<3;i++) {
			freePrinters[i] = true;
		}
		lockPrinters = new ReentrantLock();
	}
	
	public void printJob(Object document) {
		try {
			semaphore.acquire();
			int assignedPrinter = gerPrinter();
			long duration = (long) (Math.random() * 10);
			System.out.println(Thread.currentThread().getName() + " : PrintQueue: Printing a Job in Printer " + assignedPrinter + " during " + duration + " seconds");
			TimeUnit.SECONDS.sleep(duration);
			freePrinters[assignedPrinter] = true;
		}catch(InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaphore.release();
		}
	}

	private int gerPrinter() {
		int ret = -1;
		try {
			lockPrinters.lock();
			for(int i=0;i<freePrinters.length;i++) {
				if(freePrinters[i]) {
					ret = i;
					freePrinters[i] = false;
					break;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			lockPrinters.unlock();
		}
		return ret;
	}
}
