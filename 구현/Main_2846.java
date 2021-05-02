package baekjoon;

import java.io.*;
import java.util.*;

public class Main_2846 {

	public static void main(String[] args) throws Exception, IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] arr = new int[n];
		int sum = 0;
		int result = 0;

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < n - 1; i++) {
			if (arr[i] < arr[i + 1]) {
				sum += (arr[i + 1] - arr[i]);
			} else {
				sum = 0;
			}

			result = Math.max(result, sum);

		}

		System.out.println(result);
	}
}
