package Im_ex;

import java.io.*;
import java.util.*;

public class Main_2567 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[101][101];
		int[] dx = { -1, 0, 1, 0 }; // 상 우 하 좌
		int[] dy = { 0, 1, 0, -1 };
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			for (int k = x; k < x + 10; k++) {
				for (int r = y; r < y + 10; r++) {
					map[k][r] = 1;
				}
			}
		}
		int cnt = 0;
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				if (map[i][j] == 1) {

					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];

						if (map[nx][ny] == 0) {
							cnt++;
						}

					}
				}
			}
		}
		System.out.println(cnt);

	}

}
