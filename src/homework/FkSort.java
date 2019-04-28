package homework;

import java.util.concurrent.ForkJoinPool;

public class FkSort {
	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool();
		MergeTask mergeTask = new MergeTask();
		pool.execute(mergeTask);
	}
}
