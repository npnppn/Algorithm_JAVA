package bfsdfs;

import java.io.*;
import java.util.*;

public class Main_16948 {

	static class Point {
		int x;
		int y;
		int cnt;

		Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

	}

	static int[][] map;
	static boolean[][] visited;
	static int n, r1, c1, r2, c2;
	static int[] dx = { -2, -2, 0, 0, 2, 2 }; // 나이트 이동가능 구간
	static int[] dy = { -1, 1, -2, 2, -1, 1 };
	static int res = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		map = new int[n][n];
		visited = new boolean[n][n];
		r1 = sc.nextInt();
		c1 = sc.nextInt();
		r2 = sc.nextInt();
		c2 = sc.nextInt();
		bfs();

	}

	static void bfs() {
		Queue<Point> q = new LinkedList<>();
		Point point = new Point(r1, c1, 0);
		q.add(point);
		visited[r1][c1] = true;
		while (!q.isEmpty()) {
			Point tmp = q.poll();

			for (int k = 0; k < 6; k++) {
				int nx = tmp.x + dx[k];
				int ny = tmp.y + dy[k];

				if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
					visited[nx][ny] = true;
					q.add(new Point(nx, ny, tmp.cnt + 1));
					
					if (nx == r2 && ny == c2) {
						System.out.println(tmp.cnt + 1);
						System.exit(0);
					}

				}

			}

		}
		System.out.println(-1);
	}

}
