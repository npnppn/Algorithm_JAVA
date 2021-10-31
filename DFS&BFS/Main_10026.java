package brute_force;

import java.io.*;
import java.util.*;

public class Main_10026 {

	static int N;
	static char[][] map;
	static boolean visited[][];
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j);
			}

		}

		// 적록색약 아닐 때
		int cnt1 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(i, j);
					cnt1++;
				}
			}
		}

		// 다시 초기화시켜놓고, 적록색약일 때 R=G로 두고 계산
		int cnt2 = 0;
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'R')
					map[i][j] = 'G';
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(i, j);
					cnt2++;
				}
			}
		}

		System.out.println(cnt1 + " " + cnt2);

	}

	static void dfs(int x, int y) {
		visited[x][y] = true;
		char tmp = map[x][y];
		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			if ((nx >= 0 && ny >= 0 && nx < N && ny < N) && !visited[nx][ny] && map[nx][ny] == tmp) {
				dfs(nx, ny);
			}

		}

	}

}
