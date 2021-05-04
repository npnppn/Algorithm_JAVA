package baekjoon;

import java.io.*;
import java.util.*;
//식이 잘 안떠올라서 어려웠음..
public class Main_17626 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[N + 1];
		dp[1] = 1;

		int min = 0;
		for (int i = 2; i <= N; i++) {
			min = Integer.MAX_VALUE;

			// i에서 i보다 작은 제곱수에서 뺀 dp[i - j * j] 중
			// 최소를 택한다.
			for (int j = 1; j * j <= i; j++) {
				int temp = i - j * j;
				min = Math.min(min, dp[temp]);
			}

			dp[i] = min + 1; // 그리고 1을 더해준다.
		}
		System.out.println(dp[N]);
	}
}