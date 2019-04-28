package test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionCommunicati {
	public static void main(String[] args) {
		final Business b=new Business();
		
			new Thread(new Runnable() {
				@Override
				public void run() {
					for(int i=0;i<50;i++){
						b.sun();
					}
				}
			}).start();
			for(int i=0;i<50;i++){
				b.main();
			}
	}
	static class Business{
		private boolean bShouldSud = true;
		Lock lock=new ReentrantLock();
		Condition condition=lock.newCondition();
		public void sun(){
			lock.lock();
			try {
				while(!bShouldSud){
					try {
						condition.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				for(int i=0;i<10;i++){
					System.out.println("from to sun "+i+"A");
				}
				bShouldSud=false;
				condition.signal();
			}finally {
				lock.unlock();
			}
		}
		public void main(){
			lock.lock();
			try {
				while(bShouldSud){
					try {
						condition.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				for(int i=0;i<50;i++){
					System.out.println("from to main "+i+"B");
				}
				bShouldSud=true;
				condition.signal();
			}finally {
				lock.unlock();
			}
		}
	}
}
