package dfs_bfs;

import java.io.*;
import java.util.*;

public class Main_7562 {
	static int l;
	static int map[][];
	static boolean visited[][];
	static int dx[] = { 1, 2, 1, 2, -1, -2, -1, -2 }; // 나이트 거리 나타내기
	static int dy[] = { -2, -1, 2, 1, 2, 1, -2, -1 };

	// 좌표 담을 객체
	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {

			l = sc.nextInt();
			map = new int[l][l];
			visited = new boolean[l][l];

			int startX = sc.nextInt();
			int startY = sc.nextInt();
			int endX = sc.nextInt();
			int endY = sc.nextInt();

			Point start = new Point(startX, startY); // 시작점
			Point target = new Point(endX, endY); // 가려고 하는 곳
			bfs(start, target, map);

		}

	}

	static void bfs(Point start, Point target, int[][] map) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(start);
		visited[start.y][start.x] = true;
		while (!q.isEmpty()) {
			Point tmp = q.poll();

			// 이동해서 가려고하는 타겟점과 같아지면 출력
			if (tmp.y == target.y && tmp.x == target.x) {
				System.out.println(map[tmp.y][tmp.x]);
				return;
			}

			for (int i = 0; i < 8; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < map.length && ny < map.length && !visited[ny][nx]) {
					visited[ny][nx] = true;
					map[ny][nx] = map[tmp.y][tmp.x] + 1;
					Point p2 = new Point(nx, ny);
					q.add(p2);
				}

			}

		}
	}

}
