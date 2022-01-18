package binarysearch;

import java.io.*;
import java.util.*;

public class Main_2295 {

	// a[i]+b[j]+c[z] = k에서 k가 최소가 되려면?
	// m[x]+c[y] = k 이형태로 바꿔서 이분탐색하면 될듯?
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);

		TreeSet<Integer> hs = new TreeSet<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int sum = arr[i] + arr[j];
				hs.add(sum);
			}
		}
		// a[i]- a[j]의 값이 안에 있는원소인지 확인

		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < n; j++) {
				int value = arr[i] - arr[j];
				if (hs.contains(value)) {
					System.out.println(arr[i]);
					System.exit(0);
				}
			}
		}

	}

}
