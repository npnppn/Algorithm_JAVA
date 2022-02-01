package shortest;

import java.io.*;
import java.util.*;

public class Main_11404 {

	static int INF = 987654321;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int map[][] = new int[n + 1][n + 1];

		// 맵 초기화
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				map[i][j] = INF;
				if (i == j) {
					map[i][j] = 0;
				}
			}
		}

		// 맵 채워넣기
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt(); // 시작도시
			int b = sc.nextInt(); // 도착 도시
			int cost = sc.nextInt(); // 비용
			map[a][b] = Math.min(cost, map[a][b]); // 입력 값으로 중복된 것들 들올수 있으니까 최단비용으로만 넣기
		}

		// 플로이드
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				// 갈 수 없으면 0으로
				if (map[i][j] == INF) {
					map[i][j] = 0;
				}

				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}

}
