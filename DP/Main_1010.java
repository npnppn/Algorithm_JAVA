package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1010 {
	static int[][] dp = new int[30][30];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			// M개중 N개를 뽑는 경우이므로 nCr 에서 n = M, r = N이다.
			int N = Integer.parseInt(st.nextToken()); // N = r
			int M = Integer.parseInt(st.nextToken()); // M = n

			sb.append(combi(M, N)).append('\n');
		}

		System.out.println(sb);

	}

	static int combi(int n, int r) {

		// 이미 풀린 경우 바로 반환
		if (dp[n][r] > 0) {
			return dp[n][r];
		}

		// nCn이랑 nCn 은 1이므로 1출력
		if (n == r || r == 0) {
			return dp[n][r] = 1;
		}

		// n+1 C r+1 = nCr + nCr+1
		return dp[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
	}
}