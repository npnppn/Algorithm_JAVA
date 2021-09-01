package dfs_bfs;

import java.util.*;
import java.io.*;

//dfs bfs 둘다 풀리겠군
public class Main_1743 {
	static int n, m, k, cnt, res;
	static int[][] map;
	static boolean[][] visited;
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		map = new int[n + 1][m + 1];
		visited = new boolean[n + 1][m + 1];
		res = Integer.MIN_VALUE;

		for (int i = 0; i < k; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			map[r][c] = 1;
		}

		// 맵 돌아다니면서 1 있으면 dfs 탐색
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					cnt = 1;
					visited[i][j] = true;
					dfs(i, j);
					res = Math.max(cnt, res);
				}
			}
		}

		System.out.println(res);

	}

	// 4방탐색하면서 돌아다녀
	static void dfs(int r, int c) {
		for (int k = 0; k < 4; k++) {
			int nx = r + dx[k];
			int ny = c + dy[k];

			if (nx >= 1 && ny >= 1 && nx <= n && ny <= m && !visited[nx][ny]) {
				if (map[nx][ny] != 0) {
					visited[nx][ny] = true;
					cnt++;
					dfs(nx, ny);
				}
			}

		}
	}

}
