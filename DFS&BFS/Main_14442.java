package bfsdfs;

import java.io.*;
import java.util.*;

//벽부수기 1이랑 다른 점은 벽을 1개가 아닌 k개 부술 수 있다는것!
public class Main_14442 {
	static int n, m, k;
	static int map[][];
	static boolean visited[][][];
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };
	static int res = Integer.MAX_VALUE;

	static class Point {
		int x, y, cnt, wall;

		Point(int x, int y, int cnt, int wall) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.wall = wall;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m][11];

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
		q.add(new Point(0, 0, 1, 0));
		visited = new boolean[n][m][11];
		visited[0][0][0] = true;

		while (!q.isEmpty()) {
			Point tmp = q.poll();
			if (tmp.x == n - 1 && tmp.y == m - 1) {
				res = Math.min(res, tmp.cnt);
				return;
			}

			// 여기 방향탐색 변수랑 k랑 겹쳐서 계속 틀렸었음
			for (int t = 0; t < 4; t++) {
				int nx = tmp.x + dx[t];
				int ny = tmp.y + dy[t];

				if (nx >= 0 && ny >= 0 && nx < n && ny < m) {

					// 벽
					if (tmp.wall < k && !visited[nx][ny][tmp.wall + 1] && map[nx][ny] == 1) {
						visited[nx][ny][tmp.wall + 1] = true;
						q.add(new Point(nx, ny, tmp.cnt + 1, tmp.wall + 1));
					}

					// 일반적인 길
					if (map[nx][ny] == 0 && !visited[nx][ny][tmp.wall]) {
						visited[nx][ny][tmp.wall] = true;
						q.add(new Point(nx, ny, tmp.cnt + 1, tmp.wall));
					}

				}

			}
		}

	}

}
