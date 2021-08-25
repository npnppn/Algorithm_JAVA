package dfs_bfs;

import java.io.*;
import java.util.*;
//조건 부분에서 좀 안풀렸음. 범위체크
public class Main_1697 {
	static int N, K;
	static int[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 수빈
		K = sc.nextInt(); // 동생

		visited = new int[100001];
		if (N == K) {
			System.out.println(0);
		} else {
			bfs(N);
		}
	}

	static void bfs(int a) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(a);
		visited[a] = 1;

		while (!q.isEmpty()) {
			int tmp = q.poll();
			for (int i = 0; i < 3; i++) {
				int next;
				if (i == 0) {
					next = tmp + 1; // 위치 1증가
				} else if (i == 1) {
					next = tmp - 1; // 위치 1감소
				} else {
					next = tmp * 2; // 위치 2배증가
				}

				// 동생 찾았으면 끝내
				if (next == K) {
					System.out.println(visited[tmp]);
					return;
				}

				// 범위 안에 있고 방문하지 않은곳이면 방문
				if (next >= 0 && next < visited.length && visited[next] == 0) {
					q.add(next);
					visited[next] = visited[tmp] + 1;
				}

			}

		}

	}

}
