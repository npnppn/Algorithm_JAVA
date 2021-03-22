package ssafy_algo;

import java.io.*;
import java.util.*;

public class Main_1681_Jungol {

	static int[][] arr;
	static boolean[] visited;
	static int min, sum, N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		for (int x = 0; x < N; x++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			for (int y = 0; y < N; y++) {
				arr[x][y] = Integer.parseInt(st.nextToken());
			}
		}
		min = 123415098;
		for (int j = 1; j < N; j++) {
			visited = new boolean[N];
			sum = 0;
			if (arr[0][j] != 0) {
				dfs(0, j, 1);
			}
		}
		System.out.println(min);
	}

	public static void dfs(int x, int y, int cnt) {
		sum = sum + arr[x][y]; // 일단 들어오면 sum 값에 더한다.
		visited[x] = true; // 방문한것으로 기억
		if (cnt == (N - 1)) {
			sum = sum + arr[y][0]; // 가장 마지막 회사로 다시 가는경우를 더하자
			if (arr[y][0] == 0) { // 이때 회사로 돌아가는 값을 알수 없다면 이길은 못간다!
				return;
			}
			min = Math.min(min, sum);
			sum = sum - arr[y][0]; // 최소값만 구하고 다음 계산을 위해 회사로 가는길은 다시 빼주자.
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i] && arr[y][i] != 0) { // 배송장소가 방문하지 않았고 갈수 있는방법이 있는경우 dfs 탐색
				dfs(y, i, cnt + 1);
				sum = sum - arr[y][i]; // 탐색이 종료 되었을때는 다시 값을 빼주고 다음 경우의수 준비
				visited[i] = false; // 방문하지 않은것으로 변경(백트래킹)
			}
		}
	}
}