package bfsdfs;

import java.io.*;
import java.util.*;

public class Main_16933 {

	static int[][] map;
	static boolean[][][] visited;
	static int n, m, k;
	static int res = Integer.MAX_VALUE;
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };

	static class Point {
		int x, y, cnt, wall, day;

		Point(int x, int y, int cnt, int wall, int day) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.wall = wall;
			this.day = day; // 낮이면 1, 밤이면 -1로?
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

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
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0, 1, 0, 1));
		visited = new boolean[n][m][11];
		visited[0][0][0] = true;

		while (!q.isEmpty()) {
			Point tmp = q.poll();

			if (tmp.x == n - 1 && tmp.y == m - 1) {
				res = Math.min(res, tmp.cnt);
				return;
			}

			for (int t = 0; t < 4; t++) {
				int nx = tmp.x + dx[t];
				int ny = tmp.y + dy[t];

				if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
					// 벽
					if (tmp.wall < k && !visited[nx][ny][tmp.wall + 1] && map[nx][ny] == 1) {
						// 현재 낮일 때는 바로 벽부수고 감
						if (tmp.day == 1) {
							visited[nx][ny][tmp.wall + 1] = true;
							q.add(new Point(nx, ny, tmp.cnt + 1, tmp.wall + 1, tmp.day * (-1)));
						}
						// 현재 밤일 때는 부수지않고 낮이 되길 기다려 -> 현재 위치를 낮에 방문해야하니까 nx가 아니라 tmp.x
						if (tmp.day == -1) {
							// visited[tmp.x][tmp.y][tmp.wall + 1] = true; //벽을 부순것도 지나간것도 아니니까 방문처리x
							q.add(new Point(tmp.x, tmp.y, tmp.cnt + 1, tmp.wall, tmp.day * (-1)));
						}
					}

					// 일반적인 길
					else if (map[nx][ny] == 0 && !visited[nx][ny][tmp.wall]) {
						visited[nx][ny][tmp.wall] = true;
						q.add(new Point(nx, ny, tmp.cnt + 1, tmp.wall, tmp.day * (-1)));
					}
				}

			}

		}

	}

}
