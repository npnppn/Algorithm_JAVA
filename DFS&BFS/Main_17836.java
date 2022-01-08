package bfsdfs;

import java.io.*;
import java.util.*;

//검을 찾고 벽을 부수고 가는것 vs 검 안찾고 그냥 가는것 비교해서 최솟값으로.
//벽 부수는건 제한 없으므로 검찾고나면 그냥 맵 전체에 벽이 아예 없다고 생각하면 될듯?
public class Main_17836 {

	static int[][] map;
	static boolean[][][] visited;
	static int n, m, t;
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };
	static int min = Integer.MAX_VALUE;

	static class Point {
		int x, y, time;
		boolean sword;

		Point(int x, int y, int time, boolean sword) {
			this.x = x;
			this.y = y;
			this.time = time;
			this.sword = sword;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		t = sc.nextInt();

		map = new int[n][m];
		visited = new boolean[n][m][2];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int result = bfs();
		if (result == -1) {
			System.out.println("Fail");
		} else {
			System.out.println(result);
		}

	}

	// 검 안찾고 그냥 탐색할때 vs 검 찾고 탐색할 떄 비교
	static int bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0, 0, false));

		while (!q.isEmpty()) {
			Point tmp = q.poll();
			visited[tmp.x][tmp.y][0] = true;

			if (tmp.x == n - 1 && tmp.y == m - 1) {
				min = Math.min(min, tmp.time);
				return min;
			}

			if (tmp.time > t)
				break;

			for (int k = 0; k < 4; k++) {
				int nx = tmp.x + dx[k];
				int ny = tmp.y + dy[k];

				if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
					// 검 있을 떄
					if (!tmp.sword) {
						if (!visited[nx][ny][0] && map[nx][ny] == 0) {
							visited[nx][ny][0] = true;
							q.offer(new Point(nx, ny, tmp.time + 1, tmp.sword));

						} else if (!visited[nx][ny][0] && map[nx][ny] == 2) {
							visited[nx][ny][0] = true;
							q.offer(new Point(nx, ny, tmp.time + 1, true));
						}
					}

					// 검 없을 때
					else {
						if (!visited[nx][ny][1]) {
							visited[nx][ny][1] = true;
							q.offer(new Point(nx, ny, tmp.time + 1, tmp.sword));

						}

					}
				}

			}
		}
		return -1;

	}

}
