package im;

import java.io.*;
import java.util.*;

public class Robot {
	static int[] dx = { 0, 0, -1, 1 }; // 우 좌 상 하
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			char[][] map = new char[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.next().charAt(0);
				}
			}

			int cnt = 0;
			int nx, ny;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// A
					if (map[i][j] == 'A') {
						for (int k = 0; k < 1; k++) {
							nx = i;
							ny = j;

							while (true) {
								nx += dx[k];
								ny += dy[k];

								if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 'S') {
									cnt++;
								} else
									break;
							}
						}

					}

					// B
					else if (map[i][j] == 'B') {
						for (int k = 0; k < 2; k++) {
							nx = i;
							ny = j;

							while (true) {
								nx += dx[k];
								ny += dy[k];

								if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 'S') {
									cnt++;
								} else
									break;
							}
						}

					}

					// C
					else if (map[i][j] == 'C') {
						for (int k = 0; k < 4; k++) {
							nx = i;
							ny = j;

							while (true) {
								nx += dx[k];
								ny += dy[k];

								if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 'S') {
									cnt++;
								} else
									break;
							}
						}

					}
				}
			}

			System.out.println("#" + tc + " " + cnt);
		}

	}

}
