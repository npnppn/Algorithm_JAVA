package dp;

import java.io.*;
import java.util.*;

public class Main_12852 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int dp[] = new int[n + 1]; // 최소 횟수
		int before[] = new int[n + 1]; // 경로 저장

		StringBuilder sb = new StringBuilder();

		dp[0] = 0;
		dp[1] = 0;

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + 1;
			before[i] = i - 1; // 전에 갔던곳의 인덱스

			if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
				dp[i] = dp[i / 3] + 1;
				before[i] = i / 3;
			}
			if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
				dp[i] = dp[i / 2] + 1;
				before[i] = i / 2;
			}
		}
		System.out.println(dp[n]);

		while (n > 0) {
			sb.append(n + " ");
			n = before[n];
		}

		System.out.print(sb);

	}
}
