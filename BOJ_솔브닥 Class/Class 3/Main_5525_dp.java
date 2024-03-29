package class3;

import java.io.*;
import java.util.*;

//OI의 갯수를 파악하여 dp이용
public class Main_5525_dp {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		char[] s = br.readLine().toCharArray();
		int[] dp = new int[M];
		int ans = 0;

		for (int i = 1; i < M - 1; i++) {
			if (s[i] == 'O' && s[i + 1] == 'I') {
				dp[i + 1] = dp[i - 1] + 1;

				if (dp[i + 1] >= N && s[i - 2 * N + 1] == 'I')
					ans++;
			}
		}
		System.out.println(ans);
	}

}
