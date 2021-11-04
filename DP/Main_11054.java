package dp;

import java.io.*;
import java.util.*;

public class Main_11054 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n + 1];
		int[] dpLeft = new int[n + 1];
		int[] dpRight = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}

		dpLeft[1] = arr[1];
		dpRight[1] = arr[n];

		// 왼쪽에서 시작하는 증가수열부터 구해보자
		for (int i = 1; i <= n; i++) {
			dpLeft[i] = 1;
			for (int j = 1; j < i; j++) {
				if (arr[i] > arr[j]) {
					dpLeft[i] = Math.max(dpLeft[j] + 1, dpLeft[i]);
				}

			}
		}

		// 오른쪽에서 시작하는 증가수열 구해보자
		for (int i = n; i > 0; i--) {
			dpRight[i] = 1;
			for (int j = n; j > i; j--) {
				if (arr[i] > arr[j]) {
					dpRight[i] = Math.max(dpRight[j] + 1, dpRight[i]);
				}
			}

		}

		// 두 개 더한다음 -1하면 되겠군
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum = Math.max(sum, dpRight[i] + dpLeft[i]);
		}

		System.out.println(sum-1);

	}

}
