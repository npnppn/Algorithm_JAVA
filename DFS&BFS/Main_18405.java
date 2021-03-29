package ssafy_algo;

import java.io.*;
import java.util.*;

public class Main_18405 {

	static int N;

	static int[][] map;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken())-1;
		int Y = Integer.parseInt(st.nextToken())-1;

		// 루프 처리안해주니 시간초과나옴.. x,y 위치 값이 0이 아니면 루프 탈출하도록 설정하면될듯?
		loop: for (int i = 0; i < S; i++) {
			for (int j = 0; j < K; j++) {
				bfs(j + 1);

				if (map[X][Y] != 0)
					break loop;
			}
		}

		System.out.println(map[X][Y]);

	}

	// 맵 돌아다니면서 전이할 바이러스 번호와 일치하면 큐에 다 넣음
	static void bfs(int virus) {
		Queue<Dot> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == virus) {
					q.add(new Dot(i, j));
				}
			}
		}

		while (!q.isEmpty()) {
			Dot qq = q.poll();
			for (int k = 0; k < 4; k++) {
				int nx = qq.x + dx[k];
				int ny = qq.y + dy[k];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;
				if (map[nx][ny] != 0)
					continue;

				map[nx][ny] = virus;

			}

		}

	}

	static class Dot {
		int x, y;

		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

}
