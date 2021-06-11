package a0608;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main_ProblemSolve {
	private static int full, N, INF = 320, T, min;
	private static Object[] ans;
	private static Point[] people;
	private static int[][] map, dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		T = Integer.parseInt(br.readLine()); // Test Case 개수

		for (int tc = 1; tc <= T; tc++) {
			input(br); // input 읽어와 저장

			map = new int[N + 1][N + 1]; // 모든 사람 사이의 거리 정보를 저장할 인접 행렬
			full = (1 << (N + 1)) - 1; // 모든 남성을 만나고 난 후의 bitMasking 상태
			dp = new int[N + 1][full + 1]; // 민지가 현재 남성을 만난 시점 이후 모든 남성을 만났을 때까지 걸린 최단 거리 값이 저장됨
			min = INF; // INF 값으로 초기화

			makeMatrix(); // 거리 정보를 갖고 있는 인접 행렬 생성

			min = dfs(0, 1, 0, new Stack<Integer>()); // dfs 함수를 호출하여 min에 최단거리 값을 반환받아 저장함

			print(tc, bw); // 결과 출력
		}
		br.close();
		bw.close();
	}

	private static void input(BufferedReader br) throws IOException {
		N = Integer.parseInt(br.readLine()); // 사람 수
		people = new Point[N + 1]; // 사람들의 위치 저장

		String input[];
		// 남성 위치 저장
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			people[i + 1] = new Point(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
		}
		// 민지 위치 저장
		input = br.readLine().split(" ");
		people[0] = new Point(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
	}

	private static void print(int tc, BufferedWriter bw) throws IOException {
		bw.write("#" + String.valueOf(tc) + " " + min + " "); // 최단 거리 값 출력
		for (int i = 0; i < N - 1; i++) // 최단 거리 값을 가질 때 오름차순에서 가장 앞에 오는 경로 출력
			bw.write(ans[i] + " ");
		bw.write(ans[N - 1] + "\n");
	}

	private static void makeMatrix() { // 각 사람 사이 거리를 유클리드 거리로 계산하여 인접 행렬에 저장
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j < i; j++) {
				int dist = Math.abs(people[i].x - people[j].x) + Math.abs(people[i].y - people[j].y);
				map[j][i] = map[i][j] = dist;
			}
		}
	}

	private static int dfs(int curr, int visited, int dist, Stack<Integer> stack) { // curr : 현재 데이트하고 있는 남성, visited :
																					// 현재까지 만난 남성 bitMasking으로 방문 처리,
																					// dist : 현재까지 이동거리, stack : 현재까지 만난
																					// 남성의 순서
		if (dp[curr][visited] != 0) // 이미 연산된 경우 dp에 저장된 값을 return
			return dp[curr][visited];
		if (visited == full) { // 모든 남성을 만났을 때
			dist += map[curr][0]; // 마지막 방문한 남성에서 다시 민지까지 거리를 더해줌
			if (dist < min) { // 현재 이동한 거리가 min보다 작다면
				min = dist; // min에 dist를 저장
				ans = stack.toArray(); // ans 경로에 현재 경로값 저장
			}
			return map[curr][0]; // 마지막 방문한 남성에서 다시 민지까지 거리 return
		}
		int res = INF; // 민지가 현재 남성을 만난 시점 이후 모든 남성을 만났을 때까지 걸린 최단 거리 값이 저장됨
		for (int i = 0; i <= N; i++) {
			if ((visited & (1 << i)) != 0) // 이미 데이트한 남성이라면 continue
				continue;
			stack.push(i); // 데이트할 남성 stack에 넣어줌
			res = Math.min(res, dfs(i, visited | (1 << i), dist + map[curr][i], stack) + map[curr][i]); // 기존 res 값과
																										// dfs함수 return
																										// 값 중 최소값으로
																										// update
			stack.pop(); // 데이트 취소한 남성 stack에서 빼줌
		}
		return dp[curr][visited] = res; // 민지가 현재 남성(curr)을 만난 시점 이후 모든 남성을 만났을 때까지 걸린 최단 거리 값 return
	}
}
