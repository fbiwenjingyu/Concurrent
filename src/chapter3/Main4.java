package chapter3;

import java.util.concurrent.Phaser;

public class Main4 {

	public static void main(String[] args) {
		Phaser phaser = new Phaser(2);
		FileSearch system = new FileSearch("C:\\Windows", "log", phaser);
		FileSearch apps = new FileSearch("C:\\Program Files", "log", phaser);
		//FileSearch documents = new FileSearch("C:\\Users", "log", phaser);
		
		Thread systemThread = new Thread(system,"System");
		systemThread.start();
		
		Thread appThread = new Thread(apps,"Apps");
		appThread.start();
		
		//Thread documentsThread = new Thread(documents,"Documents");
		//documentsThread.start();
		
		try {
			systemThread.join();
			appThread.join();
			//documentsThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Terminated : " + phaser.isTerminated());
	}

}
