package dp;

import java.util.*;
import java.io.*;

public class Main_11055 {
	static int dp[], cost[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		dp = new int[N + 1];
		cost = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			cost[i] = sc.nextInt();
		}

		dp[1] = cost[1]; // �ʱ�ȭ

		for (int i = 2; i <= N; i++) {
			dp[i] = cost[i];
			for (int j = 1; j < i; j++) { // ù ��° ���� i���� ���� ��
				if (cost[i] > cost[j]) { // ���ذ��� �� ũ�� ��������!
					dp[i] = Math.max(dp[j] + cost[i], dp[i]);
				}
			}
		}

		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			if (dp[i] > max) {
				max = dp[i];
			}
		}
		System.out.println(max);
	}

}
