package dfs_bfs;

import java.io.*;
import java.util.*;

public class Main_2583 {
	static int[][] map;
	static int M, N, K;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static boolean[][] visited;
	static ArrayList<Integer> total = new ArrayList<>();

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
		M = sc.nextInt();
		N = sc.nextInt();
		K = sc.nextInt();
		map = new int[M][N];
		visited = new boolean[M][N];
		for (int i = 0; i < K; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();

			for (int y = y1; y < y2; y++) {
				for (int x = x1; x < x2; x++) {
					map[y][x] = 1;
				}
			}
		}

		int cnt = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && map[i][j] == 0) {
					bfs(i, j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		Collections.sort(total);
		for (int i = 0; i < total.size(); i++) {
			System.out.print(total.get(i) + " ");
		}

	}

	static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		Point point = new Point(x, y);
		q.add(point);
		visited[x][y] = true;
		int sum = 1;

		while (!q.isEmpty()) {
			Point tmp = q.poll();
			for (int k = 0; k < 4; k++) {
				int nx = tmp.x + dx[k];
				int ny = tmp.y + dy[k];

				if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
					if (!visited[nx][ny] && map[nx][ny] == 0) {
						visited[nx][ny] = true;
						Point tmp2 = new Point(nx, ny);
						q.add(tmp2);
						sum++;
					}

				}
			}

		}
		total.add(sum);
	}

}
