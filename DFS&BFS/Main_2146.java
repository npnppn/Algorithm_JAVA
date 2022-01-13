package bfsdfs;

import java.io.*;
import java.util.*;

//접근법? 같은 섬들끼리 dfs로 묶고나서 각 섬에서 bfs로 최소거리를 찾으면 될 듯?
public class Main_2146 {

	static int map[][];
	static boolean[][] visited;
	static int n;
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };
	static Queue<Point> q = new LinkedList<>(); // 좌표들 저장할 곳
	static int ans = Integer.MAX_VALUE;

	static class Point {
		int x, y, cnt;

		Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		visited = new boolean[n][n];
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					q.add(new Point(i, j, 0));
				}
			}
		}

		// 섬들 라벨링해주면서 같은것들은 같은숫자로 바꿀거임
		int value = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					visited[i][j] = true;
					map[i][j] = value;
					dfs(i, j, value);
					value++;

				}
			}
		}

		// 저장한 모든 좌표에 대해서 bfs탐색
		while (!q.isEmpty()) {
			Point tmp = q.poll();
			bfs(tmp.x, tmp.y);
		}

		System.out.println(ans - 1);
	}

	// 섬 라벨링하기
	static void dfs(int x, int y, int value) {
		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny] && map[nx][ny] == 1) {
				map[nx][ny] = value;
				visited[nx][ny] = true;
				dfs(nx, ny, value);
			}

		}

	}

	// 최소 거리 구하기
	static void bfs(int x, int y) {
		Queue<Point> bridge = new LinkedList<>();
		bridge.add(new Point(x, y, 0));
		int value = map[x][y];
		visited = new boolean[n][n];
		visited[x][y] = true;

		while (!bridge.isEmpty()) {
			Point tmp = bridge.poll();

			if (tmp.cnt >= ans)
				return;
			if (map[tmp.x][tmp.y] != 0 && map[tmp.x][tmp.y] != value) {
				ans = Math.min(ans, tmp.cnt);
				return;
			}

			for (int k = 0; k < 4; k++) {
				int nx = tmp.x + dx[k];
				int ny = tmp.y + dy[k];

				if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny] && map[nx][ny] != value) {
					visited[nx][ny] = true;
					bridge.add(new Point(nx, ny, tmp.cnt + 1));

				}
			}
		}
	}

}
