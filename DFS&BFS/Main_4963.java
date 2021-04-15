package baekjoon;

import java.io.*;
import java.util.*;

public class Main_4963 {
	static int[][] map;
	static boolean[][] visit;
	static int w, h;
	static int[] dx = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static int[] dy = { 1, -1, 0, 0, 1, -1, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			int cnt = 0;
			w = sc.nextInt();
			h = sc.nextInt();
			if (w == 0 && h == 0)
				break;

			map = new int[h + 1][w + 1];
			visit = new boolean[h + 1][w + 1];
			for (int i = 1; i <= h; i++) {
				for (int j = 1; j <= w; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int i = 1; i <= h; i++) {
				for (int j = 1; j <= w; j++) {
					if (map[i][j] == 1 && !visit[i][j]) {
						cnt += dfs(i, j);
					}
				}
			}
			System.out.println(cnt);
		}
	}

	private static int dfs(int x, int y) {
		visit[x][y] = true;
		for (int i = 0; i < 8; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if (nx > 0 && ny > 0 && nx <= h && ny <= w) {
				if (map[nx][ny] == 1 && !visit[nx][ny])
					dfs(nx, ny);
			}
		}
		return 1;
	}

}