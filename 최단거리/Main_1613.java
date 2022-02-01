package shortest;

import java.io.*;
import java.util.*;

public class Main_1613 {

	static int INF = 987654321;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		boolean[][] map = new boolean[n + 1][n + 1];

		// 관계 설정
		for (int i = 0; i < k; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = true;
		}

		// 플로이드
		for (int t = 1; t <= n; t++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (map[i][t] && map[t][j]) {
						map[i][j] = true;
					}
				}
			}
		}

		int s = sc.nextInt();
		for (int tc = 0; tc < s; tc++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			// 앞에꺼가 먼저 일어났을때
			if (map[a][b]) {
				System.out.println("-1");
			} else if (map[b][a]) {
				System.out.println("1");
			} else {
				System.out.println("0");
			}
		}

	}

}
