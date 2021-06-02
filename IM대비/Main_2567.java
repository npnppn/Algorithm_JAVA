import java.io.*;
import java.util.*;

public class Main_2567 {
	static int[] dx = { -1, 0, 1, 0 }; // 상 우 하 좌
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] map = new int[101][101];
		int cnt = 0;
		for (int k = 0; k < n; k++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			for (int i = x; i < x + 10; i++) {
				for (int j = y; j < y + 10; j++) {
					map[i][j] = 1;
				}
			}

		}

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] == 1) {
					
					for (int dir = 0; dir < 4; dir++) {
						int nx = i + dx[dir];
						int ny = j + dy[dir];

						if (map[nx][ny] == 0)
							cnt++;
					}

				}
			}
		}
		System.out.println(cnt);

	}

}
