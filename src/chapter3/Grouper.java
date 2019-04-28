package chapter3;

public class Grouper implements Runnable {
	private Result result;
	
	public Grouper(Result result) {
		this.result = result;
	}


	@Override
	public void run() {
		int finalResult = 0;
		System.out.println("Grouper: Processing results");
		int data[] = result.getData();
		for(int number : data) {
			finalResult += number;
		}
		System.out.println("Grouper: Total result: " + finalResult);
	}

}
