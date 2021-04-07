package dp;

import java.io.*;
import java.util.*;

public class Main_17610 {

	static int n, x;
	static int[] weight;
	static int answer, sum;
	static boolean[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		weight = new int[14];
		for (int i = 0; i < n; i++) {
			weight[i] = sc.nextInt();
			sum += weight[i];
		}

		dp = new boolean[14][2600000];
		check(0, 0);
		for (int i = 1; i <= sum; i++) {
			if (dp[n][i] == false)
				answer++;

		}
		System.out.println(answer);

	}

	static void check(int a, int b) {
		if (a > n || dp[a][b])
			return;
		dp[a][b] = true;
		check(a + 1, b + weight[a]); // 그릇쪽 저울에 추 올려놓은 경우
		check(a + 1, Math.abs(b - weight[a])); // 그릇 반대쪽 저울에 추 올려놓은 경우
		check(a + 1, b); // 해당 추 안올렸을 경우
	}

}
