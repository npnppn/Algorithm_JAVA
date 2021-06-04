package im;

import java.io.*;
import java.util.*;

public class Main_2567 {
	static int[] dx = { -1, 0, 1, 0 }; // 상 우 하 좌
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[101][101];
		int n = sc.nextInt();
		for (int tc = 0; tc < n; tc++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			for (int i = x; i < x + 10; i++) {
				for (int j = y; j < y + 10; j++) {
					map[i][j] = 1;
				}
			}

		}

		int cnt = 0;
		int nx, ny;

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				// 1을 만나면 조건 확인하고 갈지 정해야지
				if (map[i][j] == 1) {
					for (int k = 0; k < 4; k++) {
						nx = i + dx[k];
						ny = j + dy[k];
						if (nx >= 0 && nx < 101 && ny >= 0 && ny < 101 && map[nx][ny] == 0)
							cnt++;
					}

				}
			}
		}
		System.out.println(cnt);

	}

}
