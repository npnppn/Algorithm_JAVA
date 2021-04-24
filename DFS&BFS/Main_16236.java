package baekjoon;

/* 고민해야하는 부분
 1) 최단 경로
어떻게 물고기 까지의 최단 거리를 구할 것인지? -> bfs로 최단경로

2) 자료구조
어떻게 지도와 위치정보를 저장할 것인지? -> info 2차원 배열

3) 이동
어떻게 상하좌우로 1칸씩 움질인 것인지? -> dx dy

4) 가장 거리가 짧은 물고기가 여러마리일 경우
어떻게 제일 위쪽, 제일 왼쪽 물고기를 찾을 것인지? -> if else로
 */


import java.util.*;
import java.io.*;

public class Main_16236 {

	public static final int max_val = 401, max_int = 21;
	public static int n, shark_x, shark_y, min_dist, min_x, min_y, result, eat_cnt = 0, shark_size = 2;
	public static int[][] a, check;
	public static int[] dx = { 0, 0, 1, -1 }, dy = { -1, 1, 0, 0 };

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine()); // 공간크기
		a = new int[n + 1][n + 1]; // 공간 상태
		check = new int[n + 1][n + 1]; // 체크

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());

				if (a[i][j] == 9) { // 아기 상어의 x좌표 y좌표를 저장
					shark_x = i;
					shark_y = j;
					a[i][j] = 0;
				}
			}
		}

		while (true) {
			init_check();

			bfs(shark_x, shark_y);

			if (min_x != max_int && min_y != max_int) {
				result += check[min_x][min_y];

				eat_cnt++;

				if (eat_cnt == shark_size) {
					shark_size++;
					eat_cnt = 0;
				}

				a[min_x][min_y] = 0;

				shark_x = min_x;
				shark_y = min_y;
			}

			else {
				break;
			}
		}

		System.out.println(result);
	}

	public static void init_check() {
		min_dist = max_val;
		min_x = max_int;
		min_y = max_int;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				check[i][j] = -1;
			}
		}
	}

	public static void bfs(int x, int y) {
		Queue<info> q = new LinkedList<info>();
		check[x][y] = 0;
		q.add(new info(x, y));

		while (!q.isEmpty()) {
			info cur = q.poll();
			x = cur.x;
			y = cur.y;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 1 || nx > n || ny < 1 || ny > n)
					continue;
				if (check[nx][ny] != -1 || a[nx][ny] > shark_size)
					continue;

				check[nx][ny] = check[x][y] + 1;

				if (a[nx][ny] != 0 && a[nx][ny] < shark_size) {

					if (min_dist > check[nx][ny]) {
						min_x = nx;
						min_y = ny;
						min_dist = check[nx][ny];
					} else if (min_dist == check[nx][ny]) {
						if (min_x == nx) {
							if (min_y > ny) {
								min_x = nx;
								min_y = ny;
							}
						} else if (min_x > nx) {
							min_x = nx;
							min_y = ny;
						}
					}
				}

				q.add(new info(nx, ny));
			}
		}

	}
}

class info {
	int x, y;

	info(int x, int y) {
		this.x = x;
		this.y = y;
	}
};