package binary_search;

import java.io.*;
import java.util.*;

public class Main_1920 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);

		int M = sc.nextInt();

		for (int i = 0; i < M; i++) {
			int target = sc.nextInt();
			int start = 0;
			int end = arr.length - 1;
			boolean check = false;
			while (start <= end) {
				int mid = (start + end) / 2;
				if (arr[mid] > target) {
					end = mid - 1;
				} else if (arr[mid] < target) {
					start = mid + 1;
				} else {
					check = true;
					System.out.println(1);
					break;

				}
			}
			if (!check) {
				System.out.println(0);
			}
		}
	}
}