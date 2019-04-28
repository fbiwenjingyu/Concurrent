package chapter1;

public class Main {

	public static void main(String[] args) throws Exception {
		for(int i=1;i<=10;i++) {
			Calculator calculator = new Calculator(i);
			Thread t = new Thread(calculator);
			t.start();
			System.out.println(t.getName() + " " + t.getId() + " "+ t.getPriority());
			t.join();
		}

	}

}
