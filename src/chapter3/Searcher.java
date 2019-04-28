package chapter3;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Searcher implements Runnable {
	private int firstRow;
	private int lastRow;
	private MatrixMock mock;
	private Result result;
	private int number;
	private final CyclicBarrier barrier;
	
	
	public Searcher(int firstRow, int lastRow, MatrixMock mock, Result result, int number, CyclicBarrier barrier) {
		this.firstRow = firstRow;
		this.lastRow = lastRow;
		this.mock = mock;
		this.result = result;
		this.number = number;
		this.barrier = barrier;
	}
	
	


	@Override
	public void run() {
		int counter;
		System.out.println(" :Processing lines from " + firstRow + " to " + lastRow);
		for(int i=firstRow;i<lastRow;i++) {
			int row[] = mock.getRow(i);
			counter =0;
			for(int j=0;j<row.length;j++) {
				if(row[j] == number) {
					counter++;
				}
			}
			result.setData(i, counter);
		}
		System.out.println(Thread.currentThread().getName() + " : Lines processed ");
		
		try {
			barrier.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
