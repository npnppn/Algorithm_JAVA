package dfs_bfs;

import java.io.*;
import java.util.*;

public class Main_12851 {
	static int N, K;
	static int[] visited;
	static int minTime = Integer.MAX_VALUE; // 최소시간 저장해두는 변수
	static int cnt = 0; // 최소시간 동안 가는 경우의 수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		
		visited = new int[100001];
		if (N == K) {
			System.out.println(0);
			System.out.println(1);
			return;
		}
		bfs(N);

		System.out.println(minTime);
		System.out.println(cnt);
	}

	static void bfs(int a) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(a); // 맨처음 입력받은걸 큐에 담고 탐색
		visited[a] = 1;

		while (!q.isEmpty()) {
			int tmp = q.poll();

			if (minTime < visited[tmp]) // 방문한 시간이 최소시간보다 크면 종료
				return;

			for (int i = 0; i < 3; i++) {
				int next;
				// x-1 이거나 x+1 이거나 2x이거나..
				if (i == 0) {
					next = tmp + 1; // +1

				} else if (i == 1) {
					next = tmp - 1; // -1

				} else {
					next = tmp * 2; // x2

				}

				
				if (next == K) {
					// System.out.println(visited[tmp]);
					minTime = visited[tmp]; // 그 방문시간이 최소시간이니까 이걸 일단 저장
					cnt++;

				}

				if (next >= 0 && next <= 100000) {
					if (visited[next] == 0 || visited[next] == visited[tmp] + 1) {
						q.add(next);
						visited[next] = visited[tmp] + 1;
					}
				}

			}
		}
	}
}