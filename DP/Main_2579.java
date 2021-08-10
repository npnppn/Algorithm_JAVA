package dp;

import java.io.*;
import java.util.*;

public class Main_2579 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int dp[] = new int[301];
		int arr[] = new int[301];

		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}

		//n-3밟고 n-1밟는 경우  or n-2만 밟는 경우 중 최대인값+현재값을 하면 된다!!
		dp[1] = arr[1];
		dp[2] = arr[1] + arr[2];
		dp[3] = Math.max(arr[1], arr[2]) + arr[3];
		// 4번째부터 이제 계속 달라지니까 비교를 해
		for (int i = 4; i <= n; i++) {
			dp[i] = Math.max(dp[i - 3] + arr[i - 1], dp[i - 2]) + arr[i];
		}
		System.out.println(dp[n]);
	}
}
