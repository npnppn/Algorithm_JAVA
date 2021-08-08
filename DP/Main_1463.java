package dp;

import java.io.*;
import java.util.*;

public class Main_1463 {
	static int dp[];
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		dp = new int[n + 1];
		dp[0] = dp[1] = 0;

		// 1)n/2했을 때 2)n/3했을 때 3)n-1 했을 때 가장 최소값인 것을 찾아서 dp배열에 넣어주자
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + 1;
			// 2로 나눠떨어질때
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			}

			// 3으로 나눠떨어질때
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			}
		}
		System.out.println(dp[n]);
	}
}