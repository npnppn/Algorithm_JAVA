package dp;

import java.io.*;
import java.util.*;

public class Main_10844 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		long dp[][] = new long[n + 1][10];

		for (int i = 1; i <= 9; i++) { // dp �ϴ� �� 1�� ä���־�
			dp[1][i] = 1;
		}

		for (int i = 2; i <= n; i++) { // 2�� ������ N���� �ݺ�
			for (int j = 0; j < 10; j++) {
				if (j == 0)
					dp[i][j] = (dp[i - 1][j + 1]) % 1000000000; // ���ڸ��� 0�� ���� ���� �ڸ� 1
				else if (j == 9)
					dp[i][j] = dp[i - 1][j - 1] % 1000000000; // ���ڸ��� 9�� ���� ���� �ڸ� 8
				else
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000; // �������� -1, +1 ��� ���
			}
		}
		
		long sum = 0;
		// ������ �ڸ��� 1~9���� �� ������
		for (int i = 0; i < 10; i++) {
			sum += dp[n][i];
		}
		
		System.out.println(sum % 1000000000);
	}
}
