package chapter3;

public class Main5 {

	public static void main(String[] args) {
		MyPhaser phaser = new MyPhaser();
		Student[] students = new Student[5];
		for(int i=0;i<students.length;i++) {
			students[i] = new Student(phaser);
			phaser.register();
		}
		
		Thread[] threads = new Thread[students.length];
		for(int i=0;i<students.length;i++) {
			threads[i] = new Thread(students[i],"Student " + i);
			threads[i].start();
		}
		
		for(int i=0;i<threads.length;i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Main: The phaser has finished: " + phaser.isTerminated());
	}

}
