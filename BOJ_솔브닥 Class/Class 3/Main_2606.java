package class3;

import java.io.*;
import java.util.*;

public class Main_2606 {
	static int[][] map;
	static boolean[] visited;
	static int n, m, cnt;

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		map = new int[n + 1][n + 1];
		visited = new boolean[n + 1];
		cnt = 0;

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 1;
			map[y][x] = 1;
		}

		dfs(1);
		System.out.println(cnt);

	}

	static void dfs(int num) {
		visited[num] = true;
		for (int i = 1; i <= n; i++) {
			if (map[num][i] == 1 && !visited[i]) {
				cnt++;
				dfs(i);
			}
		}

	}
}
