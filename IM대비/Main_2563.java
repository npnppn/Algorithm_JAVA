package im;

import java.io.*;
import java.util.*;

public class Main_2563 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[100][100];
		int n = sc.nextInt();
		for (int tc = 0; tc < n; tc++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int i = x; i < x + 10; i++) {
				for (int j = y; j < y + 10; j++) {
					map[i][j] = 1;
				}
			}
		}

		int cnt = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] == 1)
					cnt++;
			}
		}
		System.out.println(cnt);

	}

}
