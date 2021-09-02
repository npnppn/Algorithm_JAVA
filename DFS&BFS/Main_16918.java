package dfs_bfs;

import java.io.*;
import java.util.*;

public class Main_16918 {
	static int R, C, N;
	static int map[][];
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };
	static Queue<Point> q = new LinkedList<Point>();

	// x, y좌표 담을 공간
	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (tmp[j] == '.') {
					map[i][j] = 0;
				} else {
					map[i][j] = 1;
				}
			}
		}

		// 0 -> 1 -> 2-> 3 -> 4초.....
		// 처음세팅 -> 암것도 안해 -> 폭탄 모두 설치 -> 처음세팅한것들 터져 -> 다시 폭탄 모두 설치 -> 폭탄 터져
		// 그럼 함수를 세팅하는 함수, 폭탄있는 곳을 찾는 함수, 폭탄들을 터트리는 함수 세가지로 만들면 되겠다.

		// 짝수시간이면 세팅하는 시간, 홀수면 폭탄 찾아서 폭발시켜
		for (int i = 0; i <= N; i++) {
			if (i % 2 == 0) {
				boomSetting(i);
			} else {
				boomSearch(i);
				boomExplode();
			}
		}

		// 맵 전체 출력
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 0) {
					map[i][j] = '.';
				} else {
					map[i][j] = 'O';
				}
				System.out.print((char) map[i][j]);
			}

			System.out.println();
		}

	}

	static void boomSetting(int time) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 0) {
					map[i][j] = time;
				}
			}
		}
	}

	static void boomSearch(int time) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				// 현재시간-2보다 작은 폭탄은 터지니까
				if (map[i][j] <= time - 2) {
					Point p = new Point(i, j);
					q.add(p);
				}
			}
		}

	}

	static void boomExplode() {
		while (!q.isEmpty()) {
			Point tmp = q.poll();
			map[tmp.x][tmp.y] = 0;

			for (int k = 0; k < 4; k++) {
				int nx = tmp.x + dx[k];
				int ny = tmp.y + dy[k];
				if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
					map[nx][ny] = 0;
				}
			}
		}

	}

}
