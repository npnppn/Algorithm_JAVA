package dp;

import java.io.*;
import java.util.*;

public class Main_14002 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n + 1];
		int[] dp = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}

		dp[1] = 1;
		int res = 1;

		for (int i = 2; i <= n; i++) {
			dp[i] = 1;

			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
				res = Math.max(dp[i], res);
			}
		}

		// dp에 맞는 값을 출력해보자
		ArrayList<Integer> al = new ArrayList<>();
		int len = res;
		for (int i = n; i >= 1; i--) {
			if (len == dp[i]) {
				al.add(arr[i]);
				len--;
			}
		}

		System.out.println(res);
		Collections.reverse(al);
		for (int i : al) {
			System.out.print(i + " ");
		}

	}

}
