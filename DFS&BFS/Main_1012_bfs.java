package dfs_bfs;

//dfs�δ� ���������� bfs�ε� Ǯ���
import java.io.*;
import java.util.*;

//���� ��ġ ����
class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

}

public class Main_1012_bfs {

	static int[][] map;
	static boolean[][] visited;
	static int cnt;
	static int m, n, k;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // ����
		for (int tc = 1; tc <= T; tc++) {
			m = sc.nextInt(); // ���߹� ���α���
			n = sc.nextInt(); // ���߹� ���α���
			k = sc.nextInt(); // ���� �ɾ����ִ� ��ġ ����

			map = new int[51][51];
			visited = new boolean[51][51];
			cnt = 0;

			// map ä������
			for (int i = 0; i < k; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				map[b][a] = 1;
			}

			// map ��ü Ž���ϸ鼭 �湮���ߴµ� 1ä���������� bfs
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);

		}

	}

	static void bfs(int a, int b) {
		Queue<Point> q = new LinkedList<Point>();
		Point p = new Point(a, b);
		q.add(p);

		while (!q.isEmpty()) {
			Point tmp = q.poll();
			visited[tmp.x][tmp.y] = true;
			for (int i = 0; i < 4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
					if (map[nx][ny] == 1 && !visited[nx][ny]) {
						Point tmp2 = new Point(nx,ny);
						q.add(tmp2);
						bfs(tmp2.x, tmp2.y);
					}
				}
			}
		}

	}

}
