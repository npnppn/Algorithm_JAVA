package baekjoon;

//LIS를 떠올리면 좀 더 쉽게 빠르게 뿦었을듯.. 아직 이부분이 익숙하지않다.
import java.io.*;
import java.util.*;

public class Main_2631 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];
		int[] dp = new int[n + 1];
		int max = 0;

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < n; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]); // 최장거리 중 가장 긴 값
		}
		System.out.println(n - max); // 전체 친구에서 순서어긴 놈들 빼면 됨

	}
}