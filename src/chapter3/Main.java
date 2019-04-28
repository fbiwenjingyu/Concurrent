package chapter3;

public class Main {

	public static void main(String[] args) {
		//PrintQueue printQueue = new PrintQueue();
		PrintQueue2 printQueue = new PrintQueue2();
		Thread thread[] = new Thread[10];
		for(int i=0;i<10;i++) {
			thread[i] = new Thread(new Job2(printQueue));
		}
		
		for(int i=0;i<10;i++) {
			thread[i].start();
		}
	}

}
