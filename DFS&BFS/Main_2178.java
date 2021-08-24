package dfs_bfs;

import java.io.*;
import java.util.*;

//좌표 담을 객체
class Pos {
	int x;
	int y;

	Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}

}

public class Main_2178 {

	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1];
		cnt = 0;
		
		// 맵 채워넣고 탐색을 시작하자
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				map[i + 1][j + 1] = str.charAt(j) - '0';
			}
		}

		bfs(1, 1); // 좌표 1,1부터 시작
		System.out.println(map[N][M]); //맨 끝에 도착했을떄 출력

	}

	static void bfs(int a, int b) {
		Queue<Pos> q = new LinkedList<Pos>();
		Pos p = new Pos(a, b);
		q.add(p);
		//방문처리를 이때 해도되나?
		//visited[a][b] = true;

		while (!q.isEmpty()) {
			Pos tmp = q.poll();
			visited[tmp.x][tmp.y] = true;
			for (int i = 0; i < 4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if (nx >= 0 && ny >= 0 && nx <= N && ny <= M) {
					//맵안에 있고 1인데 방문하지않았으면 글로 가고 방문처리
					if (map[nx][ny] == 1 && !visited[nx][ny]) {
						visited[nx][ny] = true;
						Pos tmp2 = new Pos(nx, ny);
						q.offer(tmp2);
						//다음 방문할 곳은 현재 방문한 곳보다 1칸 더 가야하므로 1더해
						map[nx][ny] = map[tmp.x][tmp.y] + 1;
					}
				}
			}
		}

	}

}
