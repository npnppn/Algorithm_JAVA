package samsungtest;

import java.io.*;
import java.util.*;

public class Main_17135 {
	static int n, m, d;
	static int map[][];
	static int copy[][];
	static boolean[][] visited;
	static int cnt = 0;
	static ArrayList<Integer> attack; // 궁수들

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		d = sc.nextInt();
		map = new int[n + 1][m + 1];
		copy = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				map[i][j] = sc.nextInt();
				copy[i][j] = map[i][j];
			}
		}

		attack = new ArrayList<>();
		comb(1, m, 3, attack);
		System.out.println(cnt);
	}

	// 궁수 서는곳 조합으로 배치
	static void comb(int start, int n, int select, ArrayList<Integer> attack) {
		if (select == 0) {
			clear();
			go(attack);
			return;
		}

		for (int i = start; i <= n; i++) {
			attack.add(i);
			comb(i + 1, n, select - 1, attack);
			attack.remove(attack.size() - 1);
		}
	}

	// 맵 초기화
	static void clear() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				map[i][j] = copy[i][j];
			}
		}
	}

	// 디펜스게임 시작
	static void go(ArrayList<Integer> attack) {
		int res = 0;

		for (int t = 0; t < n; t++) {
			visited = new boolean[n + 1][m + 1];
			for (int k = 0; k < attack.size(); k++) {
				int tmp = attack.get(k);
				int minDistance = Integer.MAX_VALUE;
				int minX = Integer.MAX_VALUE;
				int minY = Integer.MAX_VALUE;

				for (int i = 1; i <= n; i++) {
					for (int j = 1; j <= m; j++) {
						if (map[i][j] == 1) {
							if (minDistance >= dist(i, n + 1, j, tmp)) {
								if (minDistance > dist(i, n + 1, j, tmp)) {
									minDistance = dist(i, n + 1, j, tmp);
									minX = i;
									minY = j;
								} else {
									if (minY > j) {
										minX = i;
										minY = j;
									}
								}
							}
						}
					}
				}

				if (minDistance <= d) {
					visited[minX][minY] = true;
				}

			}

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					if (visited[i][j]) {
						map[i][j] = 0;
						res++;
					}
				}
			}

			for (int i = 1; i <= m; i++) {
				map[n][i] = 0;
			}

			for (int i = n; i >= 1; i--) {
				for (int j = 1; j <= m; j++) {
					map[i][j] = map[i - 1][j];
				}
			}
		}
		cnt = Math.max(cnt, res);
	}

	static int dist(int a, int b, int c, int d) {
		return Math.abs(a - b) + Math.abs(c - d);
	}
}