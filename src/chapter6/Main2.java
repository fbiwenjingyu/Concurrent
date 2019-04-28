package chapter6;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Main2 {

	public static void main(String[] args) throws Exception {
		LinkedBlockingDeque<String> list = new LinkedBlockingDeque<>(3);
		Client client = new Client(list);
		Thread thread = new Thread(client);
		thread.start();
		
		for(int i=0;i<5;i++) {
			for(int j=0;j<3;j++) {
				String request = list.take();
				System.out.println("Main: Request : " + request + "  at " + new Date() + " size : " + list.size());
				TimeUnit.MILLISECONDS.sleep(300);
			}
		}
		System.out.println("Main: End of the program");
	}

}
