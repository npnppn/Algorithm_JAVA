package baekjoon;

import java.io.*;
import java.util.*;

public class Main_11728 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		int[] arr2 = new int[m];
		int[] result = new int[n + m];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);

		for (int i = 0; i < m; i++) {
			arr2[i] = sc.nextInt();
		}
		Arrays.sort(arr2);

		// 투 포인터 사용해서 이제 탐색할거임
		int left = 0;
		int right = 0;
		int k = 0;

		while (left < n && right < m) {
			if (arr[left] > arr2[right]) {
				result[k++] = arr2[right++];
			} else {
				result[k++] = arr[left++];
			}
		}

		while (right < m) {
			result[k++] = arr2[right++];
		}
		while (left < n) {
			result[k++] = arr[left++];
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < result.length; i++) {
			sb.append(result[i] + " ");
		}
		System.out.println(sb);

	}

}
