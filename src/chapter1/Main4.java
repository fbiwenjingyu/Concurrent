package chapter1;

import java.util.concurrent.TimeUnit;

public class Main4 {
	public static void main(String[] args) {
		FileSearch fileSearch = new FileSearch("c:\\", "activate.bat");
		Thread t = new Thread(fileSearch);
		t.start();
		
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t.interrupt();
	}
}
