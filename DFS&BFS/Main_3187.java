package bfsdfs;

import java.io.*;
import java.util.*;

// 영역에 양과 늑대 수를 센다음에 양>늑대면 늑대를 없애버려
public class Main_3187 {

	static int R, C;
	static char[][] map;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static boolean[][] visited;
	static int wolf = 0;
	static int sheep = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			char[] ch = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = ch[j];
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!visited[i][j] && map[i][j] != '#') {
					bfs(new Point(i, j));
				}
			}
		}
		System.out.println(sheep + " " + wolf);

	}

	static void bfs(Point point) {
		Queue<Point> q = new LinkedList<>();
		q.offer(point);
		visited[point.x][point.y] = true;

		int wolfCnt = 0;
		int sheepCnt = 0;

		while (!q.isEmpty()) {
			Point tmp = q.poll();
			int x = tmp.x;
			int y = tmp.y;
			if (map[x][y] == 'k') {
				sheepCnt++;
			} else if (map[x][y] == 'v') {
				wolfCnt++;
			}
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if (nx > 0 && ny > 0 && nx < R && ny < C && !visited[nx][ny] && map[nx][ny] != '#') {
					visited[nx][ny] = true;
					q.offer(new Point(nx, ny));
				}
			}
		}
		if (sheepCnt > wolfCnt) {
			sheep += sheepCnt;
		} else {
			wolf += wolfCnt;
		}
	}

	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

}
