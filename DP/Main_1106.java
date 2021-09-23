package dp;

import java.io.*;
import java.util.*;

public class Main_1106 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[] dp = new int[C + 101]; // ¥ﬁº∫∞Ì∞¥ + √÷¥Î µµΩ√∞Ì∞¥
		Arrays.fill(dp, 987654321);
		dp[0] = 0;

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			int cost = Integer.parseInt(st.nextToken()); // ∫ÒøÎ
			int num = Integer.parseInt(st.nextToken()); // ∞Ì∞¥
			for (int i = num; i < C + 101; i++) {
				dp[i] = Math.min(dp[i], cost + dp[i - num]);
			}
		}

		int ans = 987654321; // √÷º⁄∞™
		for (int i = C; i < C + 101; i++) {
			ans = Math.min(ans, dp[i]);
		}
		System.out.println(ans);
	}

}
