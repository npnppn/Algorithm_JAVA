package algo;

import java.io.*;
import java.util.*;

public class Main_15900 {
	static LinkedList<Integer>[] adjList;
	static boolean[] visited;
	public static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;

		adjList = new LinkedList[N + 1];

		for (int i = 1; i <= N; i++) {
			adjList[i] = new LinkedList<Integer>();
		}

		// 양방향 인접리스트 만들어주고
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			adjList[a].add(b);
			adjList[b].add(a);
		}

		visited = new boolean[N + 1];
		dfs(1, 0, visited); // 트리 끝까지 탐색해

		if (answer % 2 == 0) {// 루프 노드에서 리프 노드까지의 깊이의 합이 짝수면 성원이 짐
			System.out.println("No");
		} else { // 홀수면 성원이가 승리
			System.out.println("Yes");
		}

	}

	//dfs
	public static void dfs(int cur, int cnt, boolean[] visited) {
		visited[cur] = true;
		
		for (int next : adjList[cur]) {
			if (!visited[next]) {
				dfs(next, cnt + 1, visited);
			}
		}

		//사이즈가 1이면 리프노드라는 거니까
		if (adjList[cur].size() == 1) {
			answer += cnt;
		}
	}

}