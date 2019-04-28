package homework;

public class GunTest {
	public static void main(String[] args) {
		Gun gun = new Gun();
        Thread producer = new Thread(new Producer(gun),"�������߳�");
        Thread consumer = new Thread(new Consumer(gun),"�������߳�");
        producer.start();
        consumer.start();
	}
	
	static class Gun{
		private static final int max = 20;
		private int size = 0;
		public synchronized void push() {
			while(size >=max) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			size++;
			System.out.println(Thread.currentThread().getName() + " " + "ѹ��һ���ӵ�,�ӵ���Ϊ�� " + size);
			notify();
		}
		
		public synchronized void pull() {
			while(size<=0) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			size--;
			System.out.println(Thread.currentThread().getName() + " " + "���һ���ӵ�,�ӵ���Ϊ�� " + size);
			notify();
		}
	}
	
	
	
	static class Producer implements Runnable{
		Gun gun;
		

		public Producer(Gun gun) {
			this.gun = gun;
		}


		@Override
		public void run() {
			while(true) {
				gun.push();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
	static class Consumer implements Runnable{
		Gun gun;
		
		public Consumer(Gun gun) {
			this.gun = gun;
		}
		@Override
		public void run() {
			while(true) {
				gun.pull();
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}

}
