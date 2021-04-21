package baekjoon;

import java.io.*;
import java.util.*;

public class Main_2458 {

	static int N, M, adj[][], radj[][];
	static int cnt;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 학생 수 : 정점 수
		M = Integer.parseInt(st.nextToken()); // 관계 수 : 간선 수
		adj = new int[N + 1][N + 1]; // 자신보다 큰 관계
		radj = new int[N + 1][N + 1]; // 자신보다 작은 관계

		int i, j;
		for (int m = 1; m <= M; m++) {
			st = new StringTokenizer(br.readLine(), " ");

			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());

			radj[j][i] = adj[i][j] = 1;
		}

		int res = 0;
		for (int k = 1; k <= N; k++) {
			// 자신보다 크거나 작은 친구의 수
			cnt = 0;
			// 자신보다 큰 친구를 찾으러
			dfs(k, adj, new boolean[N + 1]);
			// 자신보다 작은 친구를 찾으러
			dfs(k, radj, new boolean[N + 1]);
			// 자신보다 크거나 작은 친구들이 N - 1 명이라면 자신이 몇 번째인지 알 수 있음
			if (cnt == N - 1) // 자신보다 작은 친구의 수 + 자신보다 큰 친구의 수 = N - 1
				res++;
		}

		System.out.println(res);

	}

	/**
	 * 자신보다 크거나/작은 학생을 따라 탐색
	 * 
	 * @param n       현재 기준이 되는 학생번호
	 * @param visited 현재까지 확인한 친구 체크
	 */
	private static void dfs(int n, int[][] adj, boolean[] visited) {

		visited[n] = true;

		for (int i = 1; i <= N; i++) {
			// 나보다 크고 확인하지 않은 치구
			if (adj[n][i] == 1 && !visited[i]) {
				cnt++;
				dfs(i, adj, visited);
			}
		}

	}

}