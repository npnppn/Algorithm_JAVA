package bfsdfs;

import java.io.*;
import java.util.*;

public class Main_18404 {
	static int[][] map;
	static boolean[][] visited;
	static int n, m;
	static Queue<Point> q = new LinkedList<>(); // 좌표담을 큐
	static ArrayList<Point> list = new ArrayList<>(); // 갯수 저장할 곳
	static StringBuilder sb = new StringBuilder();
	static int[] dx = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int[] dy = { -1, 1, -2, 2, -2, 2, -1, 1 };

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

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n + 1][n + 1];
		visited = new boolean[n + 1][n + 1];

		int a = sc.nextInt();
		int b = sc.nextInt();
		q.add(new Point(a, b, 0));
		visited[a][b] = true;

		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			list.add(new Point(x, y, 0));
		}

		bfs();
		for (int i = 0; i < list.size(); i++) {
			Point p = list.get(i);
			sb.append(map[p.x][p.y] + " ");
		}
		System.out.println(sb);

	}

	static void bfs() {
		while (!q.isEmpty()) {
			Point tmp = q.poll();

			for (int k = 0; k < 8; k++) {
				int nx = tmp.x + dx[k];
				int ny = tmp.y + dy[k];
				if (nx >= 1 && ny >= 1 && nx <= n && ny <= n && !visited[nx][ny]) {
					map[nx][ny] = tmp.cnt + 1;
					visited[nx][ny] = true;
					Point tmp2 = new Point(nx, ny, tmp.cnt + 1);
					q.add(tmp2);

				}
			}
		}
	}

}
