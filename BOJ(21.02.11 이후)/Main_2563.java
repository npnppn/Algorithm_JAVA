package ssafy_algo;

import java.io.*;
import java.util.*;

public class Main_2563 {

	public static void main(String[] args) {
		int[] dx = { -1, 0, 1, 0 };// 상 우 하 좌
		int[] dy = { 0, 1, 0, -1 };

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[101][101];
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					map[j][k] = 1;
				}
			}
		}
		int cnt = 0;
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				if (map[i][j] == 1) {
					cnt++;
				}

			}

		}

		System.out.println(cnt);

	}

}
