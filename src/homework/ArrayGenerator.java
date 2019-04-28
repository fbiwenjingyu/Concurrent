package homework;

import java.util.Random;

public class ArrayGenerator {
	public  static int[] generateArray(int length) {
		int[] arr = new int[length];
		Random r = new Random();
		for(int i=0;i<length;i++) {
			arr[i] = r.nextInt(length);
		}
		return arr;
	}
	
	public static void printArray(int[] arr) {
		for(int a : arr) {
			System.out.print(a + " ");
		}
	}
}
