package shortest;

import java.io.*;
import java.util.*;

public class Main_2660 {
	static int INF = 987654321;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int map[][] = new int[n + 1][n + 1];

		// 맵 초기화
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				map[i][j] = INF;
				if (i == j)
					map[i][j] = 0;
			}
		}

		// 입력받고
		while (true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if (a == -1 && b == -1)
				break;

			map[a][b] = 1;
			map[b][a] = 1;
		}

		// 모든 친구관계를 확인해야하니까 플로이드로
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}

		// 회원들 점수 확인
		int score = INF; // 회장 후보 점수
		int[] arr = new int[n + 1]; // 각 회원들 점수 저장할 배열
		for (int i = 1; i <= n; i++) {
			int cnt = 0;
			for (int j = 1; j <= n; j++) {
				if (map[i][j] != INF) {
					cnt = Math.max(cnt, map[i][j]);
				}
			}
			arr[i] = cnt;
			score = Math.min(score, cnt);
		}

		int num = 0; // 후보의 수
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			if (score == arr[i]) {
				num++;
				sb.append(i + " ");
			}
		}

		System.out.println(score + " " + num);
		System.out.println(sb);

	}

}
