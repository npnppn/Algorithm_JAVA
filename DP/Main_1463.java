package dp;

import java.io.*;
import java.util.*;

public class Main_1463 {
	static int dp[];
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		dp = new int[n + 1];
		dp[0] = dp[1] = 0;

		// 1)n/2���� �� 2)n/3���� �� 3)n-1 ���� �� ���� �ּҰ��� ���� ã�Ƽ� dp�迭�� �־�����
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + 1;
			// 2�� ������������
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			}

			// 3���� ������������
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			}
		}
		System.out.println(dp[n]);
	}
}