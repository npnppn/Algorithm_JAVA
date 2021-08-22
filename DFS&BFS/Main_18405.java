package dfs_bfs;

import java.io.*;
import java.util.*;

public class Main_18405 {
	static class Point {
		int x, y, v;

		public Point(int x, int y, int v) {
			this.x = x;
			this.y = y;
			this.v = v;
		}
	}

	static int n, k;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] map = new int[201][201];
	static Queue<Point> q = new PriorityQueue<>((a, b) -> a.v - b.v);

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				map[i][j] = sc.nextInt();
				
				if (map[i][j] != 0) {
					q.add(new Point(i, j, map[i][j]));

				}
			}
		}

		int s = sc.nextInt();
		int endx = sc.nextInt();
		int endy = sc.nextInt();

		int t = 0;
		while (t++ != s) {
			bfs();
		}
		System.out.println(map[endx][endy]);

	}

	static void bfs() {
		Queue<Point> tmp = new PriorityQueue<>((a, b) -> a.v - b.v);
		while (!q.isEmpty()) {
			Point p = q.poll();
			int x = p.x;
			int y = p.y;
			int v = p.v;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (ny < 1 || nx < 1 || ny > n || nx > n || map[nx][ny] != 0)
					continue;
				map[nx][ny] = v;
				tmp.add(new Point(nx, ny, v));
			}

		}
		q = tmp;

	}

}
