package math;

import java.io.*;
import java.util.*;

public class Main_11051 {
	static int n, k;
	static int[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		dp = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= i; j++) {
				if (i == j || j == 0) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % 10007;
				}
			}
		}

		System.out.println(dp[n][k]);

	}
}
