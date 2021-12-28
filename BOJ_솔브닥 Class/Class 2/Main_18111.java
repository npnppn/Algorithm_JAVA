package class2;

import java.io.*;
import java.util.*;

//방법이 딱히 생각나지않아서 전체를 다 탐색해보기로

public class Main_18111 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int map[][] = new int[N][M];
		long sum = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				sum += map[i][j];
			}
		}

		long avg = (sum + B) / (N * M);
		int maxHeight = (int) avg;
		if (avg > 256) {
			maxHeight = 256;
		}

		int minTime = Integer.MAX_VALUE;
		int height = 0;

		for (int k = 0; k <= maxHeight; k++) {
			int time = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] > k) {
						time = time + (map[i][j] - k) * 2;
					} else if (map[i][j] < k) {
						time = time + k - map[i][j];
					}
				}
			}
			if (minTime >= time) {
				minTime = time;
				height = k;
			}
		}
		System.out.println(minTime + " " + height);
	}
}