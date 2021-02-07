package ssafy_algo;

import java.util.*;
import java.io.*;

public class Solution_D4_1861 {

	static int dx[] = { 0, 1, 0, -1 }; // 우 하 좌 상
	static int dy[] = { 1, 0, -1, 0 };
	static int cnt;

	public static void main(String[] args) throws Exception, IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] map = new int[n][n];

			for (int i = 0; i < n; i++) {
				StringTokenizer tk = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(tk.nextToken());
				}
			} //입력받는 부분 끝

			
			int max = 1; // 최대로 이동한 방
			int result = 1000000; // 최대로 이동한 방 중에서 출발방이 가장 작은 방
			int[] count = new int[1000000]; // 각 방의 번호에 해당하는 cnt 넣어줄 배열, 개수 최대 10^3*10^3
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					cnt = 0;
					int number = map[i][j];
					find(map, i, j, n, number); //map은 방 배열, i j는 각 좌표들, n은 크기, number는 방에 적혀 있는 번호
					cnt++;
					count[number] = cnt;
				}
			}
			for (int i = 0; i < n*n; i++) {
				if (max < count[i]) {
					max = count[i];
					result = i; //최대로 이동한 방 중에서 출발방이 가장 작은 방
				}
			}
			System.out.println("#" + tc + " " + result + " " + max);
		}
	}

	// 각각의 시작점에서 완전 탐색하는 부분
	private static void find(int[][] map, int x, int y, int size, int number) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i]; //우 하 좌 상
			int ny = y + dy[i];
			//방안에 존재하고, 이동하려는 번호가 현재 방보다 1 커야함
			if (nx < size && nx >= 0 && ny < size && ny >=0 && map[nx][ny] - number == 1) {
				cnt++;
				find(map, nx, ny, size, map[nx][ny]);
			}
		}
	}
}