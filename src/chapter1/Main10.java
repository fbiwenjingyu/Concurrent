package chapter1;

public class Main10 {

	public static void main(String[] args) {
		MyThreadGroup threadGroup = new MyThreadGroup("MyThreadGroup");
		Task2 task = new Task2();
		for(int i=0;i<2;i++) {
			Thread t = new Thread(threadGroup, task);
			t.start();
		}

	}

}
