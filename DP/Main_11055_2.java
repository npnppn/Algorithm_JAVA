package dp;

import java.io.*;
import java.util.*;

public class Main_11055_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] arr = new int[n + 1];
		int[] dp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}

		dp[1] = arr[1];
		int res = dp[1];
		for (int i = 2; i <= n; i++) {
			dp[i] = arr[i];
			for (int j = 1; j < i; j++) {
				if (arr[j] < arr[i]) {
					dp[i] = Math.max(dp[j] + arr[i], dp[i]);
				}
			}
			res = Math.max(res, dp[i]);

		}
		System.out.println(res);

	}

}
