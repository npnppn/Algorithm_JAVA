package ssafy_algo;

import java.util.*;
import java.io.*;

public class Solution_D2_2001 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();

		for (int tc = 1; tc <= t; tc++) {
			int N = s.nextInt();
			int M = s.nextInt();
			int map[][] = new int[N][N];
			int sum = 0;
			int max = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = s.nextInt();
				}
			}

			/*얼마나 파리채 휘두를건지 횟수를 정해야함
			N=5 일때       M=1  25번
					 M=2   16번
			 		 M=3   9번
					 M=4   4번...
			N=4 일때      M=1   16번
			         M=2   9번
			         M=3   4번...
			즉 N-M+1 * N-M+1 만큼 반복해야됨!
			*/
			
			for (int i = 0; i < N - M + 1; i++) {
				for (int j = 0; j < N - M + 1; j++) {
					sum = 0;

					for (int k = 0; k < M; k++) {
						for (int l = 0; l < M; l++) {//각 영역별 합의 크기를 비교
							sum += map[i + k][j + l];
						}
					}

					if (sum > max) {
						max = sum;
					}
				}
			}
			System.out.println("#" + tc + " " + max);
		}

	}
}
