package dfs_bfs;

import java.io.*;
import java.util.*;

public class Main_18428 {

	static char[][] map;
	static int N;
	static ArrayList<Point> list = new ArrayList<>();

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st;
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);

				if (map[i][j] == 'T') {
					list.add(new Point(i, j));
				}
			}
		}

		dfs(0, 0, 0);
		System.out.println("NO");

	}

	// а╤гу
	public static void dfs(int cnt, int x, int y) {
		if (cnt == 3) {
			if (check()) {
				System.out.println("YES");
				System.exit(0);
			}
			return;
		}
		for (int i = x; i < N; i++) {
			for (int j = y; j < N; j++) {
				if (map[i][j] == 'X') {
					map[i][j] = 'O';
					dfs(cnt + 1, i, j + 1);
					map[i][j] = 'X';
				}
			}
			y = 0;
		}
	}

	public static boolean check() {
		for (int i = 0; i < list.size(); i++) {
			Point tc = list.get(i);
			for (int d = 0; d < dx.length; d++) {
				int ni = tc.x;
				int nj = tc.y;

				while (true) {
					ni = ni + dx[d];
					nj = nj + dy[d];
					if (ni < 0 || nj < 0 || ni >= N || nj >= N)
						break;

					if (map[ni][nj] == 'O')
						break;

					if (map[ni][nj] == 'S')
						return false;

				}
			}
		}

		return true;
	}
}