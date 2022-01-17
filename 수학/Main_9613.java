package math;

import java.io.*;
import java.util.*;

public class Main_9613 {
	static long sum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int n = sc.nextInt();
			sum = 0;
			int[] arr = new int[n];

			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			calculate(arr);
			System.out.println(sum);

		}

	}

	static void calculate(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				if (i != j) {
					sum += gcd(arr[i], arr[j]);
				}
			}
		}
	}

	static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

}
