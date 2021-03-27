package ssafy_algo;

import java.io.*;
import java.util.*;

public class Main_1012 {
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static int t;
	static int[][] map;
	static boolean[][] visited;
	static int cnt;
	static int m, n, k;

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			map = new int[n][m];
			visited = new boolean[n][m];
			cnt = 0;

			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1; // 배추 채워넣기
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						dfs(i, j);
						cnt++;
					}

				}
			}

			System.out.println(cnt);
		}

	}

	static void dfs(int y, int x) {
		visited[y][x] = true;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
				if ( map[ny][nx] == 1 && !visited[ny][nx]) {
					//visited[ny][nx] = true;
					dfs(ny, nx);
				}
			}
		}

	}
}