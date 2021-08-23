package dfs_bfs;

import java.io.*;
import java.util.*;

public class Main_2606_bfs {
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
		System.out.println(bfs(1));

	}

	static int bfs(int i) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(i);
		visited[i] = true;
		while (!q.isEmpty()) {
			int tmp = q.poll();
			for (int k = 1; k <= n; k++) {
				if (map[tmp][k] == 1 && visited[k] == false) {
					q.offer(k);
					visited[k] = true;
					result++;
				}
			}

		}

		return result;

	}
	
	

}
