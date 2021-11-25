/**
* 메모리: 14640 KB, 시간: 164 ms
* 2021.11.25
* by Alub
*/
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] soldiers = new int[N];
		int[] dp = new int[N + 1];
		Arrays.fill(dp, 1);

		String tmp = br.readLine();
		StringTokenizer st = new StringTokenizer(tmp);
		int k = 0;

		while (st.hasMoreTokens()) {
			soldiers[k++] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				if (soldiers[i] < soldiers[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		Arrays.sort(dp);

		System.out.println(Integer.toString(N - dp[N]));

	}

}
