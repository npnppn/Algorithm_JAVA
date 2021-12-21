package bfsdfs;

import java.io.*;
import java.util.*;

public class Main_2468 {
	static int[][] map;
	static boolean visited[][];
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };
	static int n, cnt, maxheight;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		maxheight = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
				maxheight = Math.max(map[i][j], maxheight);
			}
		}
		int max = 0;

		for (int t = 0; t < maxheight + 1; t++) {
			cnt = 0;
			visited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] > t && !visited[i][j]) {
						dfs(i, j, t);
						cnt++;
					}
				}

			}
			max = Math.max(cnt, max);
		}
		System.out.println(max);

	}

	static void dfs(int x, int y, int t) {
		visited[x][y] = true;
		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if (nx >= 0 && ny >= 0 && nx <= n - 1 && ny <= n - 1 && !visited[nx][ny] && map[nx][ny] > t) {
				dfs(nx, ny, t);
			}
		}
	}

}
