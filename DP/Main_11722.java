package dp;

import java.io.*;
import java.util.*;

public class Main_11722 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n + 1];
		int[] dp = new int[n + 1];
		for (int i = 1; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		dp[1] = 1;
		int res = 1;

		for (int i = 2; i <= n; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[i] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
				}
			}
			res = Math.max(res, dp[i]);

		}
		System.out.println(res);

	}

}
