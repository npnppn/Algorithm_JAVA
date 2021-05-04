package baekjoon;

import java.io.*;
import java.util.*;

public class Main_9095 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[12];
		dp[1] = 1; // 1
		dp[2] = 2; // 1+1, 2
		dp[3] = 4; // 1+1+1, 2+1, 1+2, 3
		for (int i = 0; i < n; i++) {
			int k = Integer.parseInt(br.readLine());
			for (int j = 4; j <= 10; j++) {
				dp[j] = dp[j - 3] + dp[j - 2] + dp[j - 1]; //1, 2, 3 세가지만 이용해서 문제를 풀어야함
			}
			System.out.println(dp[k]);
		}

	}

}
