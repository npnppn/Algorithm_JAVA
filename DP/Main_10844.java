package dp;

import java.io.*;
import java.util.*;

public class Main_10844 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		long dp[][] = new long[n + 1][10];

		for (int i = 1; i <= 9; i++) { // dp 일단 다 1로 채워넣어
			dp[1][i] = 1;
		}

		for (int i = 2; i <= n; i++) { // 2인 경우부터 N까지 반복
			for (int j = 0; j < 10; j++) {
				if (j == 0)
					dp[i][j] = (dp[i - 1][j + 1]) % 1000000000; // 끝자리가 0일 경우는 다음 자리 1
				else if (j == 9)
					dp[i][j] = dp[i - 1][j - 1] % 1000000000; // 끝자리가 9일 경우는 다음 자리 8
				else
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000; // 나머지는 -1, +1 모두 고려
			}
		}
		
		long sum = 0;
		// 마지막 자리수 1~9까지 다 더해줘
		for (int i = 0; i < 10; i++) {
			sum += dp[n][i];
		}
		
		System.out.println(sum % 1000000000);
	}
}
