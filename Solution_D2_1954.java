package ssafy_algo;

import java.util.*;
import java.io.*;

public class Solution_D2_1954 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int dx[] = { 0, 1, 0, -1 }; // 우 하 좌 상
		int dy[] = { 1, 0, -1, 0 };

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			// 입력값 N 이 1인 경우는 2차원 배열 안 만들어져서 따로 처리
			if (N == 1) {
				System.out.println("#" + tc);
				System.out.println(1);
				continue;
			}

			int[][] snail = new int[N][N];
			int x = 0;
			int y = 0;
			int dir = 0;

			for (int i = 0; i < N * N; i++) {
				snail[x][y] = i + 1; // 오른쪽으로 가면서 값 저장
				x = x + dx[dir];
				y = y + dy[dir];

				// 인덱스를 벗어나거나 0보다 작아지면 방향 전환
				if (x >= N || y >= N || x < 0 || y < 0) {
					// 원래 위치로 돌려줘야지
					x = x - dx[dir];
					y = y - dy[dir];
					// 방향 전환 (0->1 우에서 하/ 1->2 하에서 좌/ 2->3 좌에서 상/ 3->0 상에서 우)
					dir = (dir + 1) % 4;

					// 전환한 방향으로 이동
					x = x + dx[dir];
					y = y + dy[dir];
				}

				// 이동할 곳에 값이 있는 경우에도 방향 전환
				if (snail[x][y] != 0) {
					x = x - dx[dir];
					y = y - dy[dir];
					// 방향 전환 (0->1 우에서 하/ 1->2 하에서 좌/ 2->3 좌에서 상/ 3->0 상에서 우)
					dir = (dir + 1) % 4;

					// 전환한 방향으로 이동
					x = x + dx[dir];
					y = y + dy[dir];
				}

			}

			System.out.println("#" + tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

}