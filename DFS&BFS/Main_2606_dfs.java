package dfs_bfs;

import java.io.*;
import java.util.*;

//dfs bfs둘다 풀리니까 두 방법 모두 해보자!
public class Main_2606_dfs {
	static int n, m;
	static boolean[] visited;
	static int[][] map;
	static int result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		visited = new boolean[n + 1];
		map = new int[n + 1][n + 1];
		result = 0;
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[x][y] = 1;
			map[y][x] = 1;

		}
		System.out.println(dfs(1));

	}

	static int dfs(int i) {
		visited[i] = true;
		for (int k = 1; k <= n; k++) {
			if (map[i][k] == 1 && visited[k] == false) {
				result++;
				dfs(k);
			}
		}
		return result;

	}

}
