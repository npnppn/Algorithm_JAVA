package dp;

import java.io.*;
import java.util.*;

public class Main_9095 {
	static int[] dp = new int[11];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		dp[1] = 1; // 1
		dp[2] = 2; // 1+1 2
		dp[3] = 4;// 1+1+1 1+2 2+1 3

		for (int tc = 0; tc < t; tc++) {
			int num = sc.nextInt();
			for (int i = 4; i < 11; i++) {
				dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];

			}
			System.out.println(dp[num]);

		}

	}

}
