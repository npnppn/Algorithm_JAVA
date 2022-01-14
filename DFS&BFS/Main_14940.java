package bfsdfs;

import java.io.*;
import java.util.*;

//bfs로 거리값으로 새로운 맵에 박아넣으면 될 듯
public class Main_14940 {

	static int map[][];
	static int result[][];
	static int r, c;
	static Queue<Point> q = new LinkedList<>();
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };
	static StringBuilder sb = new StringBuilder();

	static class Point {
		int x, y, cnt;

		Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();

		map = new int[r][c];
		result = new int[r][c];

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 2) {
					map[i][j] = 0;
					q.add(new Point(i, j, 0));
				}
			}
		}
		bfs();

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] == 1) {
					result[i][j] = -1;
				}
				sb.append(result[i][j] + " ");
			}
			sb.append('\n');
		}
		System.out.println(sb);

	}

	static void bfs() {
		while (!q.isEmpty()) {
			Point tmp = q.poll();
			result[tmp.x][tmp.y] = tmp.cnt;

			if (tmp.x == r && tmp.y == c)
				return;

			for (int k = 0; k < 4; k++) {
				int nx = tmp.x + dx[k];
				int ny = tmp.y + dy[k];

				if (nx >= 0 && ny >= 0 && nx < r && ny < c && map[nx][ny] == 1) {
					map[nx][ny] = 0;
					q.add(new Point(nx, ny, tmp.cnt + 1));

				}
			}

		}
	}

}
