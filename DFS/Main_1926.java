package ssafy_algo;

import java.io.*;
import java.util.*;
//bfs로 탐색

public class Main_1926 {
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int max = 0;
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 1) {
					cnt++;
					max = Math.max(max, bfs(i, j)); // 가장 큰 그림 크기로 초기화
				}
			}
		}
		System.out.println(cnt);
		System.out.println(max);
	}

	static int bfs(int x, int y) {
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y });
		arr[x][y] = 0; // 방문 체크를 위한 초기화
		int cnt = 1; // 그림개수 계산을 위한 변수

		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = pos[0] + dx[i];
				int ny = pos[1] + dy[i];
				if (0 <= nx && nx < arr.length && 0 <= ny && ny < arr[0].length && arr[nx][ny] == 1) {
					arr[nx][ny] = ++cnt; // 그림 누적개수 계산하여 변수에 삽입
					queue.add(new int[] { nx, ny });
				}
			}
		}
		return cnt;
	}
}