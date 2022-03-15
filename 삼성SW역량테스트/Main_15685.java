package samsungtest;

import java.io.*;
import java.util.*;

public class Main_15685 {
	static int n;
	static int cnt = 0;
	static boolean map[][] = new boolean[101][101];
	static int[] dx = { 1, 0, -1, 0 }; // 0: 우, 1: 상, 2:좌 , 3:하
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int d = sc.nextInt();// 시작방향
			int g = sc.nextInt();// 세대

			move(x, y, d, g);
		}

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1]) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

	static void move(int x, int y, int d, int g) {
		ArrayList<Integer> al = new ArrayList<>();
		al.add(d);

		for (int i = 0; i < g; i++) {
			for (int j = al.size() - 1; j >= 0; j--) {
				al.add((al.get(j) + 1) % 4);
			}
		}

		map[y][x] = true;
		for (Integer k : al) {
			x += dx[k];
			y += dy[k];
			map[y][x] = true;
		}

	}

}
