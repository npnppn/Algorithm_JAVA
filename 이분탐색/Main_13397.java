package binarysearch;

import java.io.*;
import java.util.*;

public class Main_13397 {
//구간을 M개 주어졌을 때, 구간 점수의 최댓값의 최솟값을 구해라라는 말은-> 구간의 점수가 주어졌을 때, M개를 만족하는지?
	static int n, k;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		arr = new int[n];
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}

		int start = 0;
		int end = max - min;
		while (start <= end) {
			int mid = (start + end) / 2;

			// 구간 나눌 수 있으면 왼쪽 탐색
			if (check(mid)) {
				end = mid - 1;
			}
			// 아니면 오른쪽 탐색
			else {
				start = mid + 1;
			}

		}
		System.out.println(start);

	}

	static boolean check(int mid) {
		int cnt = 1;
		int min = arr[0];
		int max = arr[0];

		for (int i = 1; i < arr.length; i++) {
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);

			// mid보다 커지면 최소가 될 수 있는 구간이 아니니까 현재값으로 변경하고 다시 늘려서 탐색
			if ((max - min) > mid) {
				min = arr[i];
				max = arr[i];
				cnt++;
				if (cnt > k)
					return false;
			}
		}
		return true;
	}

}
