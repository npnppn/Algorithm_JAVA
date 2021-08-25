package dfs_bfs;

import java.io.*;
import java.util.*;


public class Main_2206 {
	
	static class Point {
		int x, y; // x, y좌표
		int dis, explode; // 거리, 벽 부순횟수

		Point(int x, int y, int dis, int explode) {
			this.x = x;
			this.y = y;
			this.dis = dis;
			this.explode = explode;
		}
	}
	
	static int n, m;
	static int[][] map;
	static int[][] visited;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		map = new int[n + 1][m + 1];
		visited = new int[n + 1][m + 1];

		for (int i = 0; i < n; i++) {
			String str = sc.next();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
				visited[i][j] = 1000;
			}

		}
		System.out.println(bfs(0, 0));

	}

	static int bfs(int x, int y) {
		Queue<Point> q = new LinkedList<Point>();
		Point p1 = new Point(x, y, 1, 0);
		q.add(p1);
		visited[y][x] = 0; // 처음 공사횟수

		while (!q.isEmpty()) {
			Point point = q.poll();
			
			//끝 지점까지 갔으면 종료
			if ((point.x == m - 1) && (point.y == n - 1))
				return point.dis;

			for (int i = 0; i < 4; i++) {
				int nx = point.x + dx[i];
				int ny = point.y + dy[i];

				//방문여부와 벽 무순 횟수를 계속 확인하며 들어가야함
				//범위 안에 있고
				if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
					// 벽 아닐때
					if (visited[ny][nx] > point.explode) {
						if (map[ny][nx] == 0) {
							Point p2 = new Point(nx, ny, point.dis + 1, point.explode);
							q.add(p2);
							visited[ny][nx] = point.explode;
						}
						// 벽일 때
						else {
							if (point.explode == 0) {
								Point p3 = new Point(nx, ny, point.dis + 1, point.explode + 1);
								q.add(p3);
								visited[ny][nx] = point.explode + 1;
							}

						}
					}

				}
			}

		}
		return -1;

	}

}
