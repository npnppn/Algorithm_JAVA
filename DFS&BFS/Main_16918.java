package dfs_bfs;

import java.io.*;
import java.util.*;

public class Main_16918 {
	static int R, C, N;
	static int map[][];
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };
	static Queue<Point> q = new LinkedList<Point>();

	// x, y��ǥ ���� ����
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

		// 0 -> 1 -> 2-> 3 -> 4��.....
		// ó������ -> �ϰ͵� ���� -> ��ź ��� ��ġ -> ó�������Ѱ͵� ���� -> �ٽ� ��ź ��� ��ġ -> ��ź ����
		// �׷� �Լ��� �����ϴ� �Լ�, ��ź�ִ� ���� ã�� �Լ�, ��ź���� ��Ʈ���� �Լ� �������� ����� �ǰڴ�.

		// ¦���ð��̸� �����ϴ� �ð�, Ȧ���� ��ź ã�Ƽ� ���߽���
		for (int i = 0; i <= N; i++) {
			if (i % 2 == 0) {
				boomSetting(i);
			} else {
				boomSearch(i);
				boomExplode();
			}
		}

		// �� ��ü ���
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
				// ����ð�-2���� ���� ��ź�� �����ϱ�
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
