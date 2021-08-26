package dfs_bfs;

import java.io.*;
import java.util.*;

public class Main_17086 {
	static int[][] map; // ó�� ������ ��
	static int[][] dis; // �Ÿ��� ä������ ��
	static int N, M, ans;
	static int dx[] = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static int dy[] = { 1, 1, 1, 0, -1, -1, -1, 0 };

	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];
		dis = new int[N][M];
		Queue<Point> q = new LinkedList<Point>();
		ans = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				dis[i][j] = Integer.MAX_VALUE;
				
				//��� �ִ� �������� bfs�����ϱ� ���� ť�� ����ְ�, dis �迭�� �Ÿ��� ��� �����س�������
				if (map[i][j] == 1) {
					Point p = new Point(i, j);
					q.add(p);
					dis[i][j] = 0; // �����Ÿ� ó���� 0���� ����				
				}
			}
		}
		
		while (!q.isEmpty()) {
			Point tmp = q.poll();

			// 8�� Ž�� ����
			for (int i = 0; i < 8; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];

				// �� �ȿ� �ְ�
				if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
					// �����Ÿ� �ִ����� dis �迭�� ä������
					if (dis[nx][ny] > dis[tmp.x][tmp.y] + 1) {
						dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
						Point p2 = new Point(nx, ny);
						q.offer(p2);
						ans = Math.max(dis[nx][ny], ans);
					}
				}
			}

		}
		System.out.println(ans);

	}

}
