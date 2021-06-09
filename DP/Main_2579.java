package boj;

import java.io.*;
import java.util.*;

public class Main_2579 {
	static Integer dp[];
	static int arr[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //계단 수

		dp = new Integer[N + 1];
		arr = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine()); //점수
		}

		dp[0] = arr[0]; //  0으로 초기화
		dp[1] = arr[1];

		if (N >= 2) {
			dp[2] = arr[1] + arr[2];
		}

		System.out.println(find(N));

	}

	static int find(int N) {
		// 아직 탐색하지 않는 N번째 계단일 경우
		if (dp[N] == null) {
			dp[N] = Math.max(find(N - 2), find(N - 3) + arr[N - 1]) + arr[N];
		}

		return dp[N];
	}

}