package recursion;

import java.io.*;
import java.util.*;

public class Main_1780 {
	static int[][] map;
	static int[] cnt; // 정답 담을 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		map = new int[n][n];
		cnt = new int[3];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		divide(0, 0, n);
		for (int i = 0; i < 3; i++) {
			System.out.println(cnt[i]);
		}
	}

	static void divide(int x, int y, int n) {
		if (check(x, y, n)) {
			cnt[map[x][y] + 1] += 1;
			return;
		}
		int m = n / 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				divide(x + i * m, y + j * m, m);
			}
		}
	}

	static boolean check(int x, int y, int n) {
		for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {
				if (map[x][y] != map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}