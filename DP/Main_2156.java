package dp;

import java.io.*;
import java.util.*;

public class Main_2156 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n + 1];
		int[] dp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}

		// 경우가 oox, oxo, xoo가 있으니까 여기서 가장 큰거를 고르면 되겠네
		// oox : dp[i-1], oxo : dp[i-2] + arr[i-1], xoo : dp[i-3] + arr[i-1] + arr[i]
		dp[1] = arr[1];
		// 1일때 계속 터짐..
		if (n > 1) {
			dp[2] = arr[1] + arr[2];
			for (int i = 3; i <= n; i++) {
				dp[i] = Math.max(Math.max(dp[i - 1], dp[i - 2] + arr[i]), dp[i - 3] + arr[i - 1] + arr[i]);
			}
		}
		System.out.println(dp[n]);

	}

}
