package shortest;

import java.io.*;
import java.util.*;

public class Main_11562 {

	static int[][] map;
	static int INF = 987654321;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		map = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i != j) {
					map[i][j] = INF;
				}
			}
		}

		for (int i = 1; i <= m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int b = sc.nextInt();

			map[u][v] = 0;
			// 일방통행
			if (b == 0) {
				map[v][u] = 1;
			} else {// 양방향
				map[v][u] = 0;
			}
		}

		for (int t = 1; t <= n; t++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (map[i][j] > map[i][t] + map[t][j]) {
						map[i][j] = map[i][t] + map[t][j];
					}
				}
			}
		}

		int k = sc.nextInt();
		for (int tc = 0; tc < k; tc++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			System.out.println(map[s][e]);
		}
	}

}
