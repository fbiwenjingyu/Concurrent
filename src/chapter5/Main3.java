package chapter5;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Main3 {

	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool();
		FolderProcessor system = new FolderProcessor("C:\\Windows", "log");
		FolderProcessor apps = new FolderProcessor("C:\\Program Files", "log");
		FolderProcessor documents = new FolderProcessor("C:\\Users", "log");
		pool.execute(system);
		pool.execute(apps);
		pool.execute(documents);
		
		do {
			System.out.println("*************************************");
			System.out.println("Main: Parallelism : " + pool.getParallelism());
			System.out.println("Main: Active threads : " + pool.getActiveThreadCount());
			System.out.println("Main: Task count : " + pool.getQueuedTaskCount());
			System.out.println("Main: Steal count : " + pool.getStealCount());
		}while((!system.isDone()) || (!apps.isDone()) || (!documents.isDone()));
		
		pool.shutdown();
		List<String> results;
		results = system.join();
		print(results);
		System.out.println("System: " + results.size() + " files found");
		results = apps.join();
		print(results);
		System.out.println("Apps: " + results.size() + " files found");
		results = documents.join();
		print(results);
		System.out.println("Documents: " + results.size() + " files found");
		
	}

	private static void print(List<String> results) {
		System.out.println("*****************************************************");
		for(String s : results) {
			System.out.println(s);
		}
		System.out.println("*****************************************************");
	}
	

}
