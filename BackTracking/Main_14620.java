package backt;

import java.io.*;
import java.util.*;

public class Main_14620 {
	static int map[][];
	static int n;
	static int ans = Integer.MAX_VALUE;
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };
	static boolean visited[][];

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n + 1][n + 1];
		visited = new boolean[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			String[] map_input = br.readLine().split(" ");
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(map_input[j - 1]);
			}
		}
		dfs(0, 0);
		System.out.println(ans);
	}

	static void dfs(int level, int sum) {
		if (level == 3) {
			ans = Math.min(ans, sum);
			return;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (isPossible(i, j)) {
					int tmp_sum = get_sum(i, j);
					setting_visited(i, j, true);
					dfs(level + 1, sum + tmp_sum);
					setting_visited(i, j, false);
				}
			}
		}

	}

	static int get_sum(int x, int y) {
		int sum = map[x][y];
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			sum += map[nx][ny];
		}
		return sum;
	}

	static void setting_visited(int x, int y, boolean flag) {
		if (flag) {
			visited[x][y] = true;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				visited[nx][ny] = true;
			}
		} else {
			visited[x][y] = false;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				visited[nx][ny] = false;
			}
		}
	}

	static boolean isPossible(int x, int y) {
		if (visited[x][y]) {
			return false;
		}
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (!isRange(nx, ny)) {
				return false;
			}
			if (visited[nx][ny]) {
				return false;
			}
		}
		return true;
	}

	static boolean isRange(int x, int y) {
		if (x >= 1 && y >= 1 && x <= n && y <= n) {
			return true;
		}
		return false;
	}
}