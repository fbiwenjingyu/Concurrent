package test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueCommunicati {
	public static void main(String[] args) {
		final Business b=new Business();
		
			new Thread(new Runnable() {
				@Override
				public void run() {
					for(int i=0;i<50;i++){
						b.sun2();
					}
				}
			}).start();
			for(int i=0;i<50;i++){
				b.sun();
			}
//			BlockingQueue<Integer> queue1=new ArrayBlockingQueue<>(4);
//			new Thread(){
//				@Override
//				public void run() {
//					for(int i=0;true;i++) {
//						
//						try {
//							Thread.sleep(2000);
//							queue1.put(i);
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					}
//				}
//			}.start();
//			new Thread(){
//				@Override
//				public void run() {
//					for(int i=0;true;i--) {
//						try {
//							Thread.sleep(1000);
//							queue1.put(i);
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					}
//
//				}
//			}.start();
//			new Thread(){
//				@Override
//				public void run() {
//					while(true) {
//						try {
//							System.out.println("size:"+queue1.size());
//							Thread.sleep(3000);
//							Integer i =queue1.take();
//							System.out.println(i);
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					}
//				}
//			}.start();
	}
	static class Business{
		BlockingQueue<Integer> queue1=new ArrayBlockingQueue<>(1);
		BlockingQueue<Integer> queue2=new ArrayBlockingQueue<>(1);
		{
			try {
				queue2.put(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public  void sun() {
			try {
				queue1.put(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				//for(int i=0;i<30;i++){
					System.out.println(Thread.currentThread().getName()+"from to sun "+1+"A");
				//}
				try {
					queue2.take();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		public  void sun2(){
			try {
				queue2.put(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				//for(int i=0;i<20;i++){
					System.out.println(Thread.currentThread().getName()+"from to sun2 "+2+"B");
				//}
				try {
					queue1.take();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
