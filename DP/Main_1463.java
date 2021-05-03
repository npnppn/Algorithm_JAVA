package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1463 {
	static int n;
	static Integer[] dp;

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new Integer[n + 1];
		dp[0] = dp[1] = 0;
		
		System.out.println(again(n));

	}

	static int again(int n) {
//각 부분에 이전 재귀호출 중 최솟값에 1을 더한 값이 현재 N에 대한 최소연산 횟수가 된다.
		if (dp[n] == null) {
			// 6으로 나눠지는 경우
			if (n % 6 == 0) {
				dp[n] = Math.min(again(n - 1), Math.min(again(n / 3), again(n / 2))) + 1;
			}
			// 3으로만 나눠지는 경우
			else if (n % 3 == 0) {
				dp[n] = Math.min(again(n / 3), again(n - 1)) + 1;
			}
			// 2로만 나눠지는 경우
			else if (n % 2 == 0) {
				dp[n] = Math.min(again(n / 2), again(n - 1)) + 1;
			}
			// 2와 3으로 나누어지지 않는 경우
			else {
				dp[n] = again(n - 1) + 1;
			}
		}
		return dp[n];
	}
}
