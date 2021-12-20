package bfsdfs;

import java.io.*;
import java.util.*;

public class Main_14716 {
	static int n, m;
	static int[][] map;
	static boolean[][] visited;
	static int cnt;
	static int dx[] = { 0, 1, 0, -1, 1, -1, 1, -1 };
	static int dy[] = { 1, 0, -1, 0, 1, -1, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					cnt++;
					dfs(i, j);
				}
			}
		}
		System.out.println(cnt);

	}

	static void dfs(int x, int y) {
		visited[x][y] = true;
		for (int k = 0; k < 8; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] == 1 && !visited[nx][ny]) {
				visited[nx][ny] = true;
				dfs(nx, ny);
			}
		}

	}

}
