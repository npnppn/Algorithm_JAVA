package ssafy_algo;

import java.io.*;
import java.util.*;

public class Main_2667 {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[] apt;
	static int n;
	static int[][] map;
	static int cnt = 0;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];
		apt = new int[n * n];

		// 입력받음
		for (int i = 0; i < n; i++) {
			String[] tmp = br.readLine().split("");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					cnt++;
					dfs(i, j);
				}

			}
		}

		Arrays.sort(apt);
		System.out.println(Arrays.toString(apt));
		System.out.println(cnt);
		for (int i = 0; i < apt.length; i++) {
			if (apt[i] == 0) {
			} else {
				System.out.println(apt[i]);
			}
		}
	}

	static void dfs(int x, int y) {
		visited[x][y] = true;
		apt[cnt]++;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
				if (map[nx][ny] == 1 && !visited[nx][ny]) {
					dfs(nx, ny);
				}
			}
		}

	}

}
