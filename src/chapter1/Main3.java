package chapter1;

public class Main3 {
	public static void main(String[] args) {
		Thread task = new PrimeGenerator();
		task.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		task.interrupt();
	}
}
