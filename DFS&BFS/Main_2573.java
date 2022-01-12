package bfsdfs;

import java.io.*;
import java.util.*;

public class Main_2573 {

	static int[][] map;
	static boolean[][] visited;
	static int n, m;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int ans = 0;
		int count = 0;
		while (true) {
			count = check();
			// 2개 이상으로 되면 끝내
			if (count >= 2)
				break;

			if (count == 0) {
				ans = 0;
				break;
			}
			bfs();
			ans++;

		}
		sb.append(ans);
		System.out.println(sb);

	}

	// 빙산의 갯수 확인
	static int check() {
		visited = new boolean[n][m];
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != 0 && !visited[i][j]) {
					dfs(i, j, visited);
					cnt++;
				}
			}
		}
		return cnt;

	}

	// 빙산갯수 확인 dfs돌기
	static void dfs(int x, int y, boolean[][] visited) {
		visited[x][y] = true;

		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && map[nx][ny] != 0) {
				visited[nx][ny] = true;
				dfs(nx, ny, visited);
			}
		}

	}

	// 0의 갯수 확인하기위해 bfs
	static void bfs() {
		Queue<Point> q = new LinkedList<>();
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != 0) {
					q.offer(new Point(i, j));
					visited[i][j] = true;
				}
			}
		}

		while (!q.isEmpty()) {
			int cnt = 0;
			Point tmp = q.poll();
			visited[tmp.x][tmp.y] = true;

			for (int k = 0; k < 4; k++) {
				int nx = tmp.x + dx[k];
				int ny = tmp.y + dy[k];

				if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] == 0 && !visited[nx][ny]) {
					cnt++;

				}
			}

			if (map[tmp.x][tmp.y] - cnt < 0) {
				map[tmp.x][tmp.y] = 0;
			} else {
				map[tmp.x][tmp.y] -= cnt;
			}

		}

	}

}
