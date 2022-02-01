package shortest;

import java.io.*;
import java.util.*;

//모든 물건들에서 갯수를 구해야하니까 플로이드로! 큰거->작은거랑 작은거->큰거 두개를 만들어서 비교
public class Main_10159 {

	static int INF = 987654321;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		boolean[][] map = new boolean[n + 1][n + 1];
		boolean[][] map2 = new boolean[n + 1][n + 1];

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = true;
			map2[b][a] = true;
		}

		// 플로이드
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (map[i][k] && map[k][j]) {
						map[i][j] = true;
					}

					if (map2[i][k] && map2[k][j]) {
						map2[i][j] = true;
					}
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (map[i][j] != map2[i][j]) {
					map[i][j] = true;
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			int cnt = 0;
			for (int j = 1; j <= n; j++) {
				if (i == j)
					continue;

				if (!map[i][j])
					cnt++;
			}
			System.out.println(cnt);
		}

	}

}
