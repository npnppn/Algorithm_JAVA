package bfsdfs;

import java.io.*;
import java.util.*;

public class Main_14923 {

	static int[][] map;
	static boolean[][][] visited;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int n, m, hx, hy, ex, ey;
	static int cnt = Integer.MAX_VALUE;

	static class Point {
		int x, y, dist, wall;

		Point(int x, int y, int dist, int wall) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.wall = wall;
		}
	}

	static Queue<Point> q = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		hx = Integer.parseInt(st.nextToken());
		hy = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		ex = Integer.parseInt(st.nextToken());
		ey = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visited = new boolean[n][m][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();
		if (cnt == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(cnt);
		}
	}

	static void bfs() {
		q.add(new Point(hx - 1, hy - 1, 0, 0));
		visited[hx - 1][hy - 1][0] = true;

		while (!q.isEmpty()) {
			Point tmp = q.poll();

			for (int k = 0; k < 4; k++) {
				int nx = tmp.x + dx[k];
				int ny = tmp.y + dy[k];

				if (nx == ex - 1 && ny == ey - 1) {
					cnt = Math.min(tmp.dist + 1, cnt);
					continue;
				}

				if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
					// 벽이고 아직 부순적 없을 때
					if (tmp.wall == 0 && map[nx][ny] == 1) {
						visited[nx][ny][1] = true;
						q.add(new Point(nx, ny, tmp.dist + 1, 1));
					}

					// 그냥 길일 땐 평소처럼
					else if (map[nx][ny] == 0 && !visited[nx][ny][tmp.wall]) {
						visited[nx][ny][tmp.wall] = true;
						q.add(new Point(nx, ny, tmp.dist + 1, tmp.wall));
					}

				}
			}

		}
	}

}
