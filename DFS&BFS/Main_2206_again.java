package bfsdfs;

import java.io.*;
import java.util.*;

public class Main_2206 {
	static int[][] map;
	static boolean[][][] visited;
	static int n, m;
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };
	static int res = Integer.MAX_VALUE;

	static class Point {
		int x, y, wall, cnt;

		Point(int x, int y, int cnt, int wall) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.wall = wall;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		bfs();
		if (res == Integer.MAX_VALUE) {
			System.out.println("-1");
		} else {
			System.out.println(res);
		}
	}

	static void bfs() {
		visited = new boolean[n][m][2];
		visited[0][0][0] = true; // 벽 안부셨을때
		visited[0][0][1] = true; // 벽 부셨을때
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0, 1, 0));

		while (!q.isEmpty()) {
			Point tmp = q.poll();

			if (tmp.x == n - 1 && tmp.y == m - 1) {
				res = Math.min(res, tmp.cnt);
				return;
			}

			for (int k = 0; k < 4; k++) {
				int nx = tmp.x + dx[k];
				int ny = tmp.y + dy[k];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;

				if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
					// 벽 안부셨을떄
					if (tmp.wall == 0 && !visited[nx][ny][0]) {
						if (map[nx][ny] == 1) { // 벽일 때
							visited[nx][ny][1] = true;
							q.add(new Point(nx, ny, tmp.cnt + 1, tmp.wall + 1));
						} else { // 벽 아닐때
							visited[nx][ny][0] = true;
							q.add(new Point(nx, ny, tmp.cnt + 1, tmp.wall));
						}
					}
					// 벽 부셨을 때
					else if (tmp.wall == 1 && !visited[nx][ny][1]) {
						if (map[nx][ny] == 0) {
							visited[nx][ny][1] = true;
							q.add(new Point(nx, ny, tmp.cnt + 1, tmp.wall));
						}
					}

				}
			}

		}

	}

}
