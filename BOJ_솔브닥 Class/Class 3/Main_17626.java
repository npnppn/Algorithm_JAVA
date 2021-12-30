package class3;

import java.io.*;
import java.util.*;

public class Main_17626 {
	static int n;
	static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new int[n + 1];

		System.out.println(check(n));
	}

	static int check(int n) {
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			int min = Integer.MAX_VALUE;

			for (int j = 1; j * j <= i; j++) {
				min = Math.min(min, dp[i - j * j]);
			}
			dp[i] = min + 1;

		}

		return dp[n];
	}
}
