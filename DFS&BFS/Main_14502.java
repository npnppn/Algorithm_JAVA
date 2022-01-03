package bfsdfs;

import java.io.*;
import java.util.*;

//3개의 벽 세우는건 dfs로! 바이러스 퍼지는건 bfs로!
public class Main_14502 {
	static int[][] map;
	static int[][] newmap;
	static int n, m, cnt;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int max = Integer.MIN_VALUE;

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
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
			}
		}

		// 벽 세우기 시작
		dfs(0);
		System.out.println(max);

	}

	// 벽 세우는거
	static void dfs(int depth) {
		if (depth == 3) {
			bfs();// 3개 벽 다 세웠으면 바이러스 돌기
			return;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					dfs(depth + 1);
					map[i][j] = 0;

				}
			}
		}

	}

	// 바이러스 퍼지는거
	static void bfs() {
		int[][] virus = new int[n][m];
		Queue<Point> q = new LinkedList<>();

		// 새로 벽 세운거로 맵 채우고 탐색
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				virus[i][j] = map[i][j];
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (virus[i][j] == 2) {
					q.add(new Point(i, j));
				}
			}
		}

		while (!q.isEmpty()) {
			Point tmp = q.poll();
			for (int k = 0; k < 4; k++) {
				int nx = tmp.x + dx[k];
				int ny = tmp.y + dy[k];

				if (nx >= 0 && ny >= 0 && nx < n && ny < m && virus[nx][ny] == 0) {
					virus[nx][ny] = 2;
					Point tmp2 = new Point(nx, ny);
					q.add(tmp2);
				}
			}

		}

		cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (virus[i][j] == 0)
					cnt++;
			}
		}

		max = Math.max(cnt, max);

	}

}
