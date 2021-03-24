package ssafy_algo;

import java.io.*;
import java.util.*;

public class Main_2636 {
	public static int N, M, cheeze, cnt, time;
	public static int[][] map;
	public static boolean[][] visited;
	public static int[] dx = { -1, 0, 1, 0 };
	public static int[] dy = { 0, 1, -0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 가로길이
		M = Integer.parseInt(st.nextToken()); // 세로길이
		map = new int[N][M]; // 치즈판

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					cheeze++; // 1이 있으면 치즈갯수 증가
			}
		}

		while (cheeze != 0) {
			time++;
			cnt = cheeze;
			bfs();
		}
		System.out.println(time); // 치즈가 모두 녹아서 없어지는 데 걸리는 시간
		System.out.println(cnt); // 모두 녹기 한 시간 전에 남아있는 치즈조각이 놓여 있는 칸의 개수
	}

	public static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { 0, 0 }); // bfs를 (0,0)에서 시작
		visited = new boolean[N][M];
		visited[0][0] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny])
					continue;

				// 치즈를 만나면 0으로 변경하고 치즈의 개수를 줄여야지.
				if (map[nx][ny] == 1) {
					cheeze--;
					map[nx][ny] = 0;
				}

				// 공기를 만나면 Queue에 삽입
				else if (map[nx][ny] == 0) {
					q.offer(new int[] { nx, ny });
				}
				
				// 치즈와 공기 상관없이 방문처리 필수!
				visited[nx][ny] = true;
			}
		}
		
	}
	
}