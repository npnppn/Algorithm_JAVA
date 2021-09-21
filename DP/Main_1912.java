package dp;

import java.util.*;
import java.io.*;

public class Main_1912 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] dp = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int max = arr[0];
		dp[0] = arr[0];

		for (int i = 1; i < n; i++) {
			// 이전 dp값에다가 현재값 더한거 vs 현재값 더한거
			dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
			max = Math.max(dp[i], max);
		}
		System.out.println(max);

	}

}
