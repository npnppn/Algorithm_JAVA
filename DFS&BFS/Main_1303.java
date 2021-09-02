package dfs_bfs;

import java.io.*;
import java.util.*;

//우리팀 흰색 상대팀 파란색
public class Main_1303 {
	static char[][] map;
	static boolean[][] visited;
	static int n, m, ourCnt, yourCnt, cnt;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new char[m + 1][n + 1];
		visited = new boolean[m + 1][n + 1];

		for (int i = 0; i < m; i++) {
			String s = sc.next();
			for (int j = 0; j < n; j++) {
				map[i][j] = s.charAt(j);
			}
		}

		// 0,0부터 시작해서 같은색깔 아군들을 세어보자
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					cnt = 1;
					dfs(map[i][j], i, j);
					// System.out.println(cnt);

					if (map[i][j] == 'W') {
						ourCnt += (cnt * cnt);
					} else {
						yourCnt += (cnt * cnt);
					}

				}
			}
		}
		System.out.println(ourCnt + " " + yourCnt);

	}

	static void dfs(char ch, int i, int j) {
		visited[i][j] = true;

		for (int k = 0; k < 4; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];

			if (nx >= 0 && ny >= 0 && nx <= m && ny <= n && !visited[nx][ny]) {
				if (map[nx][ny] == ch) {
					cnt++;
					dfs(map[nx][ny], nx, ny);
				}
			}

		}

	}

}
