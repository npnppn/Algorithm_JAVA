package baekjoon;

import java.io.*;
import java.util.*;

public class Main_11660 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 표의 크기
		int M = Integer.parseInt(st.nextToken()); // 합의 횟수
		int[][] map = new int[N + 1][N + 1]; // 맵에 적혀있는 숫자들
		int[][] dp = new int[N + 1][N + 1]; // [0][0]부터 [i][j]까지의 직사각형 안에 들어있는 모든 수를 더한 값
		int[] sum = new int[M]; // 총합 배열
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				// 겹치는 부분인 dp[i-1][j-1]를 빼주고 map[i][j]값 더해줘야 dp[i][j]가 나옴
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + map[i][j];
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			sum[i] += dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1];

			System.out.println(sum[i]);
		}
	}
}
