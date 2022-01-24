package bfsdfs;

import java.io.*;
import java.util.*;

//불 부터 움직이고 나서 상근이가 움직여야함
public class Main_5427 {

	static int t, w, h;
	static char[][] map;
	static boolean[][] visited;
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };
	static int result;

	static class Point {
		int x, y, time;

		Point(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static Queue<Point> fire;
	static Queue<Point> person;

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			// 테케마다 초기화해주기
			map = new char[h][w];
			visited = new boolean[h][w];
			fire = new LinkedList<>();
			person = new LinkedList<>();

			for (int i = 0; i < h; i++) {
				String s = br.readLine();
				for (int j = 0; j < w; j++) {
					map[i][j] = s.charAt(j);
					// 불 좌표 저장
					if (map[i][j] == '*') {
						fire.add(new Point(i, j));
					}
					// 상근이 위치 저장
					if (map[i][j] == '@') {
						person.add(new Point(i, j, 0));
					}
				}
			}

			result = 0;
			bfs();
			if (result == 0) {
				System.out.println("IMPOSSIBLE");
			} else {
				System.out.println(result);
			}

		}
	}

	static void bfs() {
		while (!person.isEmpty()) {
			// 불부터 퍼트려
			int len = fire.size();
			for (int a = 0; a < len; a++) {
				Point tmp = fire.poll();

				for (int k = 0; k < 4; k++) {
					int nx = tmp.x + dx[k];
					int ny = tmp.y + dy[k];

					if (nx >= 0 && ny >= 0 && nx < h && ny < w && map[nx][ny] != '#' ) {
						map[nx][ny] = '*';
						fire.add(new Point(nx, ny));
					}
				}
			}

			// 그 다음 상근이 움직여
			len = person.size();
			for (int a = 0; a < len; a++) {
				Point tmp = person.poll();

				for (int k = 0; k < 4; k++) {
					int nx = tmp.x + dx[k];
					int ny = tmp.y + dy[k];

					if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
						result = tmp.time + 1;
						return;
					}

					if (map[nx][ny] == '.') {
						map[nx][ny] = '@';
						person.add(new Point(nx, ny, tmp.time + 1));
					}
				}

			}

		}

	}

}
