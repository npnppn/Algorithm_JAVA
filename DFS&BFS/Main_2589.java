package bfsdfs;

import java.io.*;
import java.util.*;

public class Main_2589 {
	static int n, m, val, result;
	static char[][] map;
	static boolean[][] visited;
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };

	static class Point {
		int x, y, cnt;

		Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][m];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j);
			}
		}

		result = 0; // 최단거리 변수

		// L 있는 모든곳에서 bfs 돌려서 최단거리를 찾아야함
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'L') {
					visited = new boolean[n][m];
					bfs(i, j, 0);
					result = Math.max(result, val);
				}
			}
		}
		System.out.println(result);

	}

	static void bfs(int x, int y, int cnt) {
		Queue<Point> q = new LinkedList<>();
		val = 0;// 보물 가장 긴 시간
		Point p = new Point(x, y, 0);
		q.add(p);

		while (!q.isEmpty()) {
			Point tmp = q.poll();
			visited[tmp.x][tmp.y] = true;

			for (int k = 0; k < 4; k++) {
				int nx = tmp.x + dx[k];
				int ny = tmp.y + dy[k];

				if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] == 'L' && !visited[nx][ny]) {
					visited[nx][ny] = true;
					Point tmp2 = new Point(nx, ny, tmp.cnt + 1);
					q.add(tmp2);
					val = Math.max(val, tmp.cnt + 1);
				}
			}
		}

	}

}
