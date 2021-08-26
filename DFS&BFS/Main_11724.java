package dfs_bfs;

import java.io.*;
import java.util.*;

public class Main_11724 {
	static int N, M, cnt;
	static boolean[] visited;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N+1][N+1];
		visited = new boolean[N+1];
		cnt = 0;

		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[x][y] = 1;
			map[y][x] = 1;
		}

		//방문하지 않은 점 있으면 dfs 탐색 후 cnt값 1 증가
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				dfs(i);
				cnt++;
			}

		}
		System.out.println(cnt);

	}

	static void dfs(int start) {
		visited[start] = true;
		for (int i = 1; i <= N; i++) {
			if (map[start][i] == 1 && !visited[i])
				dfs(i);
		}
	}
}
