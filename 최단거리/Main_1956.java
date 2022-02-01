package shortest;

import java.io.*;
import java.util.*;

public class Main_1956 {

	static int INF = 987654321;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();

		int[][] map = new int[v + 1][v + 1];

		// 초기 설정
		for (int i = 1; i <= v; i++) {
			for (int j = 1; j <= v; j++) {
				map[i][j] = INF;
				if (i == j) {
					map[i][j] = 0;
				}
			}
		}

		// 맵 입력
		for (int i = 0; i < e; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int cost = sc.nextInt();
			map[a][b] = cost;
		}

		// 플로이드
		for (int k = 1; k <= v; k++) {
			for (int i = 1; i <= v; i++) {
				for (int j = 1; j <= v; j++) {
					if (map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}

		int res = INF;
		for (int i = 1; i <= v; i++) {
			for (int j = 1; j <= v; j++) {
				if (i == j)
					continue;
				// 둘다 inf가 아니면 사이클이라는거니까
				if (map[i][j] != INF && map[j][i] != INF) {
					res = Math.min(res, map[i][j] + map[j][i]);
				}

			}
		}

		if (res == INF) {
			System.out.println("-1");
		} else {
			System.out.println(res);
		}

	}

}
