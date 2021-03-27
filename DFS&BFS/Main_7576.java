package ssafy_algo;

import java.io.*;
import java.util.*;

public class Main_7576 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int arr[][], m, n;
	static Queue<Dot> queue = new LinkedList<>();
	// 상하좌우를 나타내기 위한 배열
	static int xArr[] = { -1, 0, 1, 0 };
	static int yArr[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				// bfs를 시작하는 노드를 큐에 추가
				if (arr[i][j] == 1)
					queue.add(new Dot(i, j));
			}
		}
		System.out.println(bfs());
	}

	private static int bfs() {

		while (!queue.isEmpty()) {
			Dot point = queue.poll();
			int row = point.row;
			int col = point.col;

			for (int i = 0; i < 4; i++) {
				// 상하좌우로 토마토가 익을 수 있는지 여부 확인
				if (checkLocation(row + xArr[i], col + yArr[i])) {
					// 익은 토마토를 큐에 추가
					queue.add(new Dot(row + xArr[i], col + yArr[i]));
					// 익은 토마토의 값 = 이전에 익은 토마토의 값 + 1
					arr[row + xArr[i]][col + yArr[i]] = arr[row][col] + 1;
				}
			}
		}
		// 최대 값을 구하기 위한 변수
		int result = Integer.MIN_VALUE;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				// 하나라도 익지 않은 토마토가 있다면 -1을 반환
				if (arr[i][j] == 0)
					return -1;
				// 토마토가 익는데 걸리는 시간을 구함
				result = Math.max(result, arr[i][j]);
			}
		}
		// 최대 값이 1이라면 원래부터 모두 익어있었다는 것
		if (result == 1)
			return 0;
		// 최대 값 - 1 --> 걸린 일수
		return (result - 1);
	}

	private static boolean checkLocation(int row, int col) {
		// 주어진 범위 밖인지 검사
		if (row < 1 || row > n || col < 1 || col > m)
			return false;
		// 아직 익지 않은 토마토라면 true 반환
		if (arr[row][col] == 0)
			return true;
		// 이미 익어있거나 빈 자리라면 false 반한
		return false;
	}
}

class Dot {
	int row, col;

	public Dot(int row, int col) {
		this.row = row;
		this.col = col;
	}
}


/*
 * 1. 토마토가 익은 점들을 큐에 넣어준다. 2. 익은 토마토 상하좌우를 탐색하며 익지 않은 토마토가 있으면 그 위치를 큐에 넣어준다. (그
 * 위치의 값은 최대 일수를 계산하기 위해 전 위치 +1 을 해준다.) 3. 큐가 빌때까지 계속해준다. 4. 전체 토마토들을 탐색하여 익지않은
 * 토마토(0 값) 하나라도 있으면 -1를 출력한다. 5. 그 외는 최대 일수를 출력한다.
 * 
 * 
 * public class Main_7576 { static int[] dx = { -1, 1, 0, 0 }; static int[] dy =
 * { 0, 0, -1, 1 };
 * 
 * public static void main(String args[]) throws Exception { BufferedReader br =
 * new BufferedReader(new InputStreamReader(System.in)); String[] str =
 * br.readLine().split(" "); int M = Integer.parseInt(str[0]); int N =
 * Integer.parseInt(str[1]);
 * 
 * int[][] arr = new int[N][M];
 * 
 * for (int i = 0; i < N; i++) { str = br.readLine().split(" "); for (int j = 0;
 * j < M; j++) { arr[i][j] = Integer.parseInt(str[j]);
 * 
 * } } // ----------------- 입력 부 ------------------ BFS(arr, N, M); }
 * 
 * public static void BFS(int[][] arr, int N, int M) { Queue<DOT> q = new
 * LinkedList<DOT>();
 * 
 * for (int i = 0; i < N; i++) { for (int j = 0; j < M; j++) { if (arr[i][j] ==
 * 1) // 익은 토마토가 있는 모든 위치를 큐에 담는다. q.add(new DOT(i, j)); } }
 * 
 * while (!q.isEmpty()) { // 익은 토마토의 상하좌우는 다음에 익기 때문에 큐에 담아야한다. DOT dot =
 * q.poll(); for (int i = 0; i < 4; i++) { int nextX = dot.x + dx[i]; int nextY
 * = dot.y + dy[i];
 * 
 * // 범위 밖 패스 if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
 * continue; } // 다음 위치가 익지 않은 토마토가 아니면 패스 if (arr[nextX][nextY] != 0) {
 * continue; } // 최대 일수를 구하기 때문에 1로 바꾸는 것이 아니라 현재 일수 +1 을 해줘야한다.
 * arr[nextX][nextY] = arr[dot.x][dot.y] + 1; q.add(new DOT(nextX, nextY)); } //
 * print(arr, N, M); // 농장 전체 출력 // System.out.println(); } int max = 0; for
 * (int i = 0; i < N; i++) { for (int j = 0; j < M; j++) { if (arr[i][j] == 0) {
 * // 토마토가 모두 익지 못한 상황이라면 -1 을 출력한다. System.out.println(-1); return; } max =
 * Math.max(max, arr[i][j]); } } // 그렇지 않다면 최대값을 출력한다. System.out.println(max -
 * 1);
 * 
 * }
 * 
 * // 농장을 전체 보여주는 함수 public static void print(int[][] arr, int N, int M) { for
 * (int i = 0; i < N; i++) { for (int j = 0; j < M; j++) {
 * System.out.print(arr[i][j] + " "); } System.out.println(); } } }
 * 
 * class DOT { int x; int y;
 * 
 * DOT(int x, int y) { this.x = x; this.y = y; } }
 */