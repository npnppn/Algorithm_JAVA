package bfsdfs;

import java.io.*;
import java.util.*;

public class Main_21938 {

	static int n, m, cnt, t;
	static int[][] map;
	static boolean[][] visited;
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		visited = new boolean[n][m];
		cnt = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int r = sc.nextInt();
				int g = sc.nextInt();
				int b = sc.nextInt();
				int avg = (r + g + b) / 3;
				map[i][j] = avg;
			}
		}
		t = sc.nextInt();

		// 색상 평균낸거랑 경계값 비교해서 최종맵을 만들자
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] >= t) {
					map[i][j] = 255;
				} else {
					map[i][j] = 0;
				}
			}
		}

		// 최종 맵 완성 했으니 이제 탐색시작
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 255 && !visited[i][j]) {
					dfs(i, j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);

	}

	static void dfs(int x, int y) {
		visited[x][y] = true;
		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] == 255 && !visited[nx][ny]) {
				visited[nx][ny] = true;
				dfs(nx, ny);
			}
		}
	}

}
