package swea;

import java.io.*;
import java.util.*;

public class Solution_1238 {
	static int[][] adj; // 인접행렬
	static int ans, maxTime; // 가장 늦게 연락받는 애들 중 숫자 젤 큰놈
	static int N, start; // a->b 세트가 N/2개임.
	static boolean[] visit;
	static int[] times; // 모든 애들이 지 연락받는데 걸린 시간 기록

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = 10;

		for (int tc = 1; tc <= TC; tc++) {
			adj = new int[101][101];
			N = sc.nextInt();
			start = sc.nextInt();
			ans = 0;
			visit = new boolean[101];

			for (int i = 0; i < N / 2; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();

				adj[from][to] = 1;

			}
			times = new int[101];
			Arrays.fill(times, Integer.MAX_VALUE);
			dfs(start, 0);

			int maxTime = 0;
			for (int i = 1; i <= 100; i++) {
				if (times[i] != Integer.MAX_VALUE && maxTime <= times[i]) {
					maxTime = times[i];
					ans = i;
				}
			}

			System.out.println("#" + tc + " " + ans);
		}
	}

	static void dfs(int now, int time) {
		if (times[now] <= time)
			return;

		times[now] = time;
		visit[now] = true;
		for (int next = 1; next <= 100; next++) {
			if (adj[now][next] == 1 && !visit[next]) {
				dfs(next, time + 1);
			}

		}
		visit[now] = false;
	}

}
