package bfsdfs;

import java.io.*;
import java.util.*;
//이제 dfs로는 확실하게 잘 풀린다!! 
public class Main_11123 {
	static int t, h, w, cnt;
	static char[][] map;
	static boolean[][] visited;
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			map = new char[h][w];
			visited = new boolean[h][w];

			for (int i = 0; i < h; i++) {
				String s = br.readLine();
				for (int j = 0; j < w; j++) {
					map[i][j] = s.charAt(j);
				}
			}

			cnt = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == '#' && !visited[i][j]) {
						dfs(i, j);
						cnt++;

					}
				}
			}
			System.out.println(cnt);

		}

	}

	static void dfs(int x, int y) {
		visited[x][y] = true;
		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if (nx >= 0 && ny >= 0 && nx < h && ny < w && map[nx][ny] == '#' && !visited[nx][ny]) {
				visited[nx][ny] = true;
				dfs(nx, ny);

			}
		}
	}

}
