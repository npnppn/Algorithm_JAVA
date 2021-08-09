package dp;

import java.io.*;
import java.util.*;

public class Main_9461 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			long[] dp = new long[101];

			// ¾Õ¿¡ µ¢¾î¸® 5°³·Î ¹­¾î¼­ ´ÙÀ½°Å·Î ÂßÂß
			dp[1] = dp[2] = dp[3] = 1;
			dp[4] = dp[5] = 2;
			for (int i = 6; i < 101; i++) {
				dp[i] = dp[i - 1] + dp[i - 5];
			}
			System.out.println(dp[n]);

		}

	}

}
