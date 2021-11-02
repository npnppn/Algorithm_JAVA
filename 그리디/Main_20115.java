package greedy;

import java.io.*;
import java.util.*;

public class Main_20115 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);

		double sum = 0;
		for (int i = 0; i < n - 1; i++) {
			sum += arr[i];
		}
		sum = sum / 2 + arr[n-1];
		System.out.println(sum);

	}

}
